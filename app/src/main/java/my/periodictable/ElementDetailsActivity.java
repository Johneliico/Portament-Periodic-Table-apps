package my.periodictable;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import my.periodictable.CommonMenuHandler;
import my.periodictable.PreferenceUtils;

/**
 * This Activity holds the ElementDetailsFragment. It can be launched by an Intent with an extra
 * identifying the element by atomic number.
 *
 * @author Steve Guidetti
 */
public class ElementDetailsActivity extends AppCompatActivity {
    /**
     * The tag to identify the Activity
     */
    private static final String TAG = "ElementDetailsActivity";

    /**
     * Intent extras
     */
    public static final String EXTRA_ATOMIC_NUMBER = "atomic_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final boolean darkTheme = PreferenceUtils.getPrefDarkTheme();
        setTheme(darkTheme ? R.style.DarkTheme : R.style.LightTheme);

        super.onCreate(savedInstanceState);

        if(savedInstanceState == null) {
            final Intent intent = getIntent();
            Fragment fragment = null;
            if(intent.hasExtra(EXTRA_ATOMIC_NUMBER)) {
                fragment = ElementDetailsFragment
                        .getInstance(intent.getIntExtra(EXTRA_ATOMIC_NUMBER, 0));
            } else if(getIntent().getData() != null) {
                final Uri uri = getIntent().getData();
                if("element".equals(uri.getHost())) {
                    final String path = uri.getPathSegments().get(0);
                    if(TextUtils.isDigitsOnly(path)) {
                        try {
                            fragment = ElementDetailsFragment
                                    .getInstance(Integer.parseInt(uri.getPathSegments().get(0)));
                        } catch(NumberFormatException e) {
                            Log.w(TAG, "Invalid atomic number");
                        }
                    } else {
                        fragment = ElementDetailsFragment.getInstance(path);
                    }
                }
            }
            if(fragment != null) {
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, fragment)
                        .commit();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.common, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return CommonMenuHandler.handleSelect(this, id) || super.onOptionsItemSelected(item);
    }
}
