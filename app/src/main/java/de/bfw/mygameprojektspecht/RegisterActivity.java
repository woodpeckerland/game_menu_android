package de.bfw.mygameprojektspecht;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

/**
 * zeigt ein Formular zur Registrierung des Users an
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText reg_name_ET, reg_password_ET, reg_confirm_password_ET;
    Button reg_register_BTN, reg_login_BTN;
    private String name, password, confirm_password;
    boolean first_run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        SharedPreferences preferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);

        this.first_run = preferences.getBoolean("firstRunMyEmailClient", true);

        if (first_run) {

            setContentView(R.layout.activity_register);
            name = preferences.getString("name", "Name");

            // EditTexts:
            // Name
            reg_name_ET = findViewById(R.id.reg_name_ET);
            reg_name_ET.setText(name);

            // Passwort
            reg_password_ET = findViewById(R.id.reg_password_ET);
            reg_password_ET.setText(password);

            // Passwortbestätigung
            reg_confirm_password_ET = findViewById(R.id.reg_confirm_password_ET);
            reg_confirm_password_ET.setText(confirm_password);

            // Buttons:
            // --> Registrierung abschließen
            reg_register_BTN = findViewById(R.id.reg_register_BTN);
            reg_register_BTN.setOnClickListener(this);

            // --> Login
            reg_login_BTN = findViewById(R.id.reg_login_BTN);
            reg_login_BTN.setOnClickListener(this);
        }

        else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

        SharedPreferences preferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);

        // --> LoginView mit Registrierung
        if (v.getId() == reg_register_BTN.getId()) {

            name = reg_name_ET.getText().toString();
            password = reg_password_ET.getText().toString();
            confirm_password = reg_confirm_password_ET.getText().toString();

            // Fehlermeldung: leeres Feld
            if (name.isBlank() || password.isBlank() || confirm_password.isBlank()) {
                Toast.makeText(getApplicationContext(), "Alle Felder ausfüllen", Toast.LENGTH_LONG).show();
            }

            else if (Objects.equals(password, confirm_password)) {

                Intent intentLogin = new Intent(this, LoginActivity.class);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putBoolean("firstRunMyEmailClient", false);
                editor.putString("name", name);
                editor.putString("password", password);
                editor.putString("confirm_password", confirm_password);
                editor.putInt("level", 3);
                editor.putInt("score", 143);
                editor.apply();

                // MyGameUser
                MyGameUser user = new MyGameUser(name, password, 0, 0, true);
                startActivity(intentLogin);
            }

            // Fehlermeldung: Eingabefehler bei der Passwortbestätigung
            else {
                Toast.makeText(getApplicationContext(), "Passwörter stimmen nicht überein", Toast.LENGTH_LONG).show();
            }
        }

        // --> LoginView ohne Registrierung
        if (v.getId() == reg_login_BTN.getId()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}