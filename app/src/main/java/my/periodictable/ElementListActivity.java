package my.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import my.periodictable.CommonMenuHandler;
import my.periodictable.PreferenceUtils;

/**
 * This Activity displays the list of elements. On large screens, this also shows the details for
 * the selected element in a second pane.
 *
 * @author Steve Guidetti
 */
public class ElementListActivity extends AppCompatActivity {
    /**
     * Whether the Activity has a two-pane layout
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final boolean darkTheme = PreferenceUtils.getPrefDarkTheme();
        setTheme(darkTheme ? R.style.DarkTheme : R.style.LightTheme);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_element_list);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (findViewById(R.id.elementDetails) != null) {
            mTwoPane = true;
            final ElementListFragment fragment = (ElementListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.elementList);
            if (fragment != null) {
                fragment.setActivateOnItemClick(true);
            }
        }
    }

    public void onItemSelected(int id) {
        if(mTwoPane) {
            final Fragment fragment = ElementDetailsFragment.getInstance(id);
            getSupportFragmentManager().beginTransaction().replace(R.id.elementDetails, fragment)
                    .commit();
        } else {
            final Intent intent = new Intent(this, ElementDetailsActivity.class);
            intent.putExtra(ElementDetailsActivity.EXTRA_ATOMIC_NUMBER, id);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.element_list, menu);
        inflater.inflate(R.menu.common, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        switch(id) {
            case android.R.id.home:
            case R.id.menu_table:
                finish();
                return true;
        }
        return CommonMenuHandler.handleSelect(this, id) || super.onOptionsItemSelected(item);
    }
}
