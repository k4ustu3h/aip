/*
 * Copyright (c) 2018. Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jahirfiquitiva.libs.blueprint.helpers.utils

import android.content.Context
import jahirfiquitiva.libs.blueprint.R
import jahirfiquitiva.libs.kext.extensions.boolean
import jahirfiquitiva.libs.kuper.helpers.utils.KuperKonfigs

class BPKonfigs(private val cntxt: Context) : KuperKonfigs(cntxt) {
    var launcherIconShown: Boolean
        get() = prefs.getBoolean(LAUNCHER_ICON_SHOWN, true)
        set(shown) = prefsEditor.putBoolean(LAUNCHER_ICON_SHOWN, shown).apply()
    
    var wallpaperInIconsPreview: Boolean
        get() = prefs.getBoolean(
            WALLPAPER_IN_ICONS_PREVIEW, !cntxt.boolean(R.bool.static_preview_picture_by_default))
        set(enabled) {
            shouldResetWallpaper = true
            prefsEditor.putBoolean(WALLPAPER_IN_ICONS_PREVIEW, enabled).apply()
        }
    
    internal var shouldResetWallpaper: Boolean
        get() = prefs.getBoolean(RESET_WALLPAPER, false)
        set(should) = prefsEditor.putBoolean(RESET_WALLPAPER, should).apply()
}