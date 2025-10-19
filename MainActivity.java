package com.example.zad3lekcja12;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button butt1 = findViewById(R.id.butt1);
        Button butt2 = findViewById(R.id.butt2);
        Button butt3 = findViewById(R.id.butt3);

        butt1.setOnClickListener(v -> {
            aktualizujTekst("Klikneto przycisk 1");
        });
        butt2.setOnClickListener(v -> {
            aktualizujTekst("Klikneto przycisk 2");
        });
        butt3.setOnClickListener(v -> {
            aktualizujTekst("Klikneto przycisk 3");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void aktualizujTekst(String wiadomosc){
        TextView text = findViewById(R.id.mainText);
        text.setText(wiadomosc);
    }
}