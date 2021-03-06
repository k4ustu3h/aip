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
package jahirfiquitiva.libs.blueprint.quest.utils

import android.content.pm.PackageManager
import android.content.pm.ResolveInfo

internal class NameComparator(private val mPM: PackageManager) : Comparator<ResolveInfo> {
    override fun compare(ra: ResolveInfo, rb: ResolveInfo): Int {
        try {
            var sa: CharSequence = ra.loadLabel(mPM) ?: ""
            var sb: CharSequence = rb.loadLabel(mPM) ?: ""
            
            if (!sa.hasContent()) sa = ra.activityInfo.packageName
            if (!sb.hasContent()) sb = rb.activityInfo.packageName
            
            if (!sa.hasContent() && !sb.hasContent()) return 0
            if (!sa.hasContent()) return -1
            if (!sb.hasContent()) return 1
            return sa.toString().compareTo(sb.toString())
        } catch (e: Exception) {
            return 0
        }
    }
}