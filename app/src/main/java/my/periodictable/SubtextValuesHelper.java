package my.periodictable;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;

import my.periodictable.R;

import java.util.Arrays;

/**
 * Helper for keeping the list of options for the block subtext value up to date.
 *
 * @author Steve Guidetti
 */
public class SubtextValuesHelper implements SharedPreferences.OnSharedPreferenceChangeListener {
    /**
     * The interface for listeners for changes to the value list.
     */
    public interface OnSubtextValuesChangedListener {
        /**
         * Called when the list of values is changed.
         *
         * @param helper The SubtextValuesHelper
         */
        void onSubtextValuesChanged(@NonNull SubtextValuesHelper helper);
    }

    /**
     * The list of options for the block subtext value
     */
    @NonNull
    private final String[] mList;

    /**
     * The listener for changes to the list of values
     */
    @Nullable
    private final OnSubtextValuesChangedListener mListener;

    /**
     * @param context  The Context
     * @param listener The listener for changes to the list of values
     */
    public SubtextValuesHelper(@NonNull Context context,
                               @Nullable OnSubtextValuesChangedListener listener) {
        mList = context.getResources().getStringArray(R.array.subtextValueNames);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.registerOnSharedPreferenceChangeListener(this);

        updateTempUnit();
        mListener = listener;
    }

    /**
     * Get the list of options for the block subtext value.
     *
     * @return The list of options for the block subtext value
     */
    @NonNull
    public String[] getList() {
        return Arrays.copyOf(mList, mList.length);
    }

    /**
     * Get a single item from the list of options for the block subtext value.
     *
     * @param index The index of the item
     * @return The item
     */
    @Nullable
    public String getItem(int index) {
        if(index >= 0 && index < mList.length) {
            return mList[index];
        }
        return null;
    }

    /**
     * Update the unit for temperatures.
     */
    private void updateTempUnit() {
        final String unit;
        switch(PreferenceUtils.getPrefTempUnit()) {
            case PreferenceUtils.TEMP_C:
                unit = "℃";
                break;
            case PreferenceUtils.TEMP_F:
                unit = "℉";
                break;
            default:
                unit = "K";
        }
        mList[2] = mList[2].substring(0, mList[2].length() - 2) + unit + ")";
        mList[3] = mList[3].substring(0, mList[3].length() - 2) + unit + ")";
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(PreferenceUtils.KEY_TEMP_UNITS.equals(key)) {
            updateTempUnit();
            if(mListener != null) {
                mListener.onSubtextValuesChanged(this);
            }
        }
    }
}