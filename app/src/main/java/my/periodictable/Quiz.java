package my.periodictable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

    }

    public void startGame(View view) {
        Intent intent = new Intent(Quiz.this, GameStart.class);
        startActivity(intent);
    }


//
//    public void startGame(View view) {
//        // In startGame() method, create an Intent to launch StartGame Activity
//        Intent intent = new Intent(Quiz.this, StartGame.class);
//        startActivity(intent);
//
//    }
}