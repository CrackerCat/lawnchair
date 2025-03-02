/*
 * Copyright 2021, Lawnchair
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.lawnchair.ui.preferences.components.colorpreference

import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.lawnchair.preferences.PreferenceAdapter
import app.lawnchair.preferences.getAdapter
import app.lawnchair.theme.color.ColorOption
import app.lawnchair.ui.preferences.LocalNavController
import app.lawnchair.ui.preferences.components.*
import com.patrykmichalik.opto.domain.Preference

/**
 * A a custom implementation of [PreferenceTemplate] for [ColorOption] preferences.
 *
 * @see colorSelectionGraph
 * @see ColorSelection
 */
@Composable
fun ColorPreference(
    preference: Preference<ColorOption, String, *>,
    label: String,
) {
    val adapter: PreferenceAdapter<ColorOption> = preference.getAdapter()
    val navController = LocalNavController.current
    PreferenceTemplate(
        title = { Text(text = label) },
        endWidget = { ColorDot(Color(adapter.state.value.colorPreferenceEntry.lightColor())) },
        description = {
            Text(text = adapter.state.value.colorPreferenceEntry.label())
        },
        modifier = Modifier.clickable { navController.navigate(route = "/colorSelection/${preference.key}/") },
    )
}
