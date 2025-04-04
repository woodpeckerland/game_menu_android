package de.bfw.mygameprojektspecht;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText log_name_ET, log_password_ET;
    Button log_login_BTN;
    TextView log_reg_LINK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // EditTexts
        log_name_ET = findViewById(R.id.log_name_ET);
        log_password_ET = findViewById(R.id.log_password_ET);

        // Buttons und Links
        log_login_BTN = findViewById(R.id.log_login_BTN);
        log_login_BTN.setOnClickListener(this);
        log_reg_LINK = findViewById(R.id.log_reg_LINK);
        log_reg_LINK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}