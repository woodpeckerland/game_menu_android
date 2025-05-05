package de.bfw.mygameprojektspecht;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChangeSettingsActivity extends AppCompatActivity implements View.OnClickListener {

    Button change_save_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // SharedPreferences preferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_change_settings);

        // Buttons:
        // --> SettingsActivity
        change_save_BTN = findViewById(R.id.change_save_BTN);
        change_save_BTN.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

        // SharedPreferences preferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);

        // --> SettingsView
        if (v.getId() == change_save_BTN.getId()) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
    }
}