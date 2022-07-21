package my.periodictable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PreferenceUtils.setup(this);
        ElementUtils.setup(this);
    }

    public void PT(View view) {
        Intent intent= new Intent(HomeActivity.this,PeriodicTableActivity.class);
        startActivity(intent);
    }

    public void ST(View view) {
        Intent intent= new Intent(HomeActivity.this,Solubility_table.class);
        startActivity(intent);

    }

    public void Quiz(View view) {
        Intent intent= new Intent(HomeActivity.this, Quiz.class);
        startActivity(intent);
    }

    public void About(View view) {
        Intent intent= new Intent(HomeActivity.this, About.class);
        startActivity(intent);
    }
}