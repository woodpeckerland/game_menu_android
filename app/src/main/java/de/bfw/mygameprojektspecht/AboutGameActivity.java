package de.bfw.mygameprojektspecht;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutGameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView about_game_user_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        SharedPreferences preferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_about_game);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String user = preferences.getString("user", "Username");

        // TextViews
        about_game_user_TV = findViewById(R.id.about_game_user_TV);
        about_game_user_TV.setText(user);
    }

    @Override
    public void onClick(View v) {

    }
}