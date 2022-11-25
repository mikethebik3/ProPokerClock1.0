package no.michaebr.hiof.propokerclock10.data.model

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import no.michaebr.hiof.propokerclock10.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}