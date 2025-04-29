package de.bfw.mygameprojektspecht;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * zeigt die besten fünf Spieler sortiert in folgender Reihenfolge an: Level, Punkte, Name
 */
public class HighscoresActivity extends AppCompatActivity implements View.OnClickListener {

    Button highscores_start_game_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        SharedPreferences preferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_highscores);

        // Table
        TableLayout tableLayout = findViewById(R.id.highscores_table);
        int btnColor = getResources().getColor(R.color.btn);

        // Rows
        for (int i = 0; i < 5; i++) {

            String user = preferences.getString("name", "Name");
            int position = i + 1;
            int level = preferences.getInt("level", 0);
            int score = preferences.getInt("score", 0);

            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundResource(R.drawable.text_background);
            tableRow.setPadding(30, 30, 30, 30);

            TableLayout.LayoutParams params = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 0, 48);
            tableRow.setLayoutParams(params);

            // Columns
            for (int j = 0; j < 4; j++) {

                TextView textView = new TextView(this);
                textView.setTextSize(16);

                switch (j) {
                    case 0:
                        textView.setTypeface(null, Typeface.BOLD);
                        textView.setText(String.valueOf(position));
                        textView.setTextColor(btnColor);
                        break;

                    case 1:
                        textView.setTypeface(null, Typeface.BOLD);
                        textView.setText(user);
                        break;

                    case 2:
                        textView.setText("Level " + level);
                        break;

                    case 3:
                        textView.setText(score + " Pkte.");
                        break;
                }

                TableRow.LayoutParams textParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                textParams.setMargins(0, 0, 54, 0);
                textView.setLayoutParams(textParams);
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }

        // --> StartGameView
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