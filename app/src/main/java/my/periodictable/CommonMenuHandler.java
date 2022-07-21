package my.periodictable;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import my.periodictable.AboutFragment;
import my.periodictable.R;
import my.periodictable.SettingsActivity;

/**
 * Handles menu items shared by all Activities.
 *
 * @author Steve Guidetti
 */
public class CommonMenuHandler {
    /**
     * Select an action based on a menu selection.
     *
     * @param activity The calling Activity
     * @param id       Menu item ID
     * @return Whether the menu selection was handled
     */
    public static boolean handleSelect(@NonNull FragmentActivity activity, int id) {
        switch(id) {
            case R.id.menu_settings:
                activity.startActivity(new Intent(activity, SettingsActivity.class));
                return true;
            case R.id.menu_about:
                AboutFragment.showDialog(activity.getSupportFragmentManager());
                return true;
        }
        return false;
    }
}