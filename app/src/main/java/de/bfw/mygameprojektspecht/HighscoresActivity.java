package de.bfw.mygameprojektspecht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HighscoresActivity extends AppCompatActivity implements View.OnClickListener {

    Button highscores_start_game_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_highscores);

        // Buttons
        highscores_start_game_BTN = findViewById(R.id.highscores_start_game_BTN);
        highscores_start_game_BTN.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

        // --> StartGameView
        if (v.getId() == highscores_start_game_BTN.getId()) {
            Intent intent = new Intent(this, StartGameActivity.class);
            startActivity(intent);
        }
    }
}