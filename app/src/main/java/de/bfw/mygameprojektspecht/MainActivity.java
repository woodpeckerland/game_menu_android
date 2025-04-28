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

/**
 * zeigt das Menü der App über diverse Buttons an
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button my_game_start_game_BTN, my_game_highscores_BTN, my_game_settings_BTN, my_game_about_game_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Buttons:
        // --> StartGameView
        my_game_start_game_BTN = findViewById(R.id.my_game_start_game_BTN);
        my_game_start_game_BTN.setOnClickListener(this);

        // --> HighscoresView
        my_game_highscores_BTN = findViewById(R.id.my_game_highscores_BTN);
        my_game_highscores_BTN.setOnClickListener(this);

        // --> SettingsView
        my_game_settings_BTN = findViewById(R.id.my_game_settings_BTN);
        my_game_settings_BTN.setOnClickListener(this);

        // --> AboutGameView
        my_game_about_game_BTN = findViewById(R.id.my_game_about_game_BTN);
        my_game_about_game_BTN.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

        // --> StartGameView
        if (v.getId() == my_game_start_game_BTN.getId()) {
            Intent intent = new Intent(this, StartGameActivity.class);
            startActivity(intent);
        }

        // --> HighscoresView
        else if (v.getId() == my_game_highscores_BTN.getId()) {
            Intent intent = new Intent(this, HighscoresActivity.class);
            startActivity(intent);
        }

        // --> SettingsView
        else if (v.getId() == my_game_settings_BTN.getId()) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        // --> AboutGameView
        else if (v.getId() == my_game_about_game_BTN.getId()) {
            Intent intent = new Intent(this, AboutGameActivity.class);
            startActivity(intent);
        }
    }
}