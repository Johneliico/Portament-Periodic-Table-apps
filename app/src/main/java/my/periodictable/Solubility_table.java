package my.periodictable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Solubility_table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solubility_table);
    }

    public void back(View view) {
        Intent intent=new Intent(Solubility_table.this,HomeActivity.class);
        startActivity(intent);
    }
}