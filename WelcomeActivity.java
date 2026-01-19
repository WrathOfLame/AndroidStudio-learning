package com.example.formularzlogowania;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        TextView tekstPowitalny = findViewById(R.id.tekstPowitalny);
        Intent intent = getIntent();
        String przekazanaNazwa = intent.getStringExtra("KLUCZ_NAZWA");
        if (przekazanaNazwa != null && !przekazanaNazwa.isEmpty()) {
            tekstPowitalny.setText("Witaj, " + przekazanaNazwa + "!");
        } else {
            tekstPowitalny.setText("Witaj, gościu!");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
