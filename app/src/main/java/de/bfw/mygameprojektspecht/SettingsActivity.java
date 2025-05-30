package de.bfw.mygameprojektspecht;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * zeigt die Einstellungen des Spiels an
 */
public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView settings_user_TV, log_change_LINK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        SharedPreferences preferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_settings);

        String name = preferences.getString("name", "Name");

        // TextView
        settings_user_TV = findViewById(R.id.settings_user_TV);
        settings_user_TV.setText(name);

        // Link: --> ChangeView
        log_change_LINK = findViewById(R.id.log_change_LINK);
        log_change_LINK.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

        // --> ChangeSettingsView
        if (v.getId() == log_change_LINK.getId()) {
            Intent intent = new Intent(this, ChangeSettingsActivity.class);
            startActivity(intent);
        }
    }
}