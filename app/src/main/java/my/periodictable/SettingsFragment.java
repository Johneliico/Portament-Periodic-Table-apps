package my.periodictable;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import my.periodictable.PreferenceUtils;
import my.periodictable.SubtextValuesHelper;

/**
 * Simple implementation of PreferenceActivity for setting general application settings.
 *
 * @author Steve Guidetti
 */
public class SettingsFragment extends PreferenceFragmentCompat
        implements SubtextValuesHelper.OnSubtextValuesChangedListener {
    /**
     * The Preference for setting the block subtext value
     */
    private ListPreference mSubtextValuePreference;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        mSubtextValuePreference = findPreference(PreferenceUtils.KEY_SUBTEXT_VALUE);

        final Context context = getContext();
        if (context != null) {
            final SubtextValuesHelper subtextValuesHelper = new SubtextValuesHelper(getContext(), this);
            mSubtextValuePreference.setEntries(subtextValuesHelper.getList());
        }
    }

    @Override
    public void onSubtextValuesChanged(@NonNull SubtextValuesHelper helper) {
        mSubtextValuePreference.setEntries(helper.getList());
    }
}