package com.example.kalkulatornapiwku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText kwotaRachunku;
    RadioGroup grupaNapiwku;
    Button oblicz;
    TextView wynikNapiwku, wynikCalkowity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kwotaRachunku = findViewById(R.id.kwotaRachunku);
        grupaNapiwku = findViewById(R.id.grupaNapiwku);
        oblicz = findViewById(R.id.oblicz);
        wynikNapiwku = findViewById(R.id.wynikNapiwku);
        wynikCalkowity = findViewById(R.id.wynikCalkowity);

        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tekst = kwotaRachunku.getText().toString();

                if (tekst.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nie ma kwoty",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                double kwota = Double.parseDouble(tekst);
                int id = grupaNapiwku.getCheckedRadioButtonId();
                double procent = 0;

                if (id == R.id.proc15) procent = 0.15;
                else if (id == R.id.proc20) procent = 0.20;
                else if (id == R.id.proc25) procent = 0.25;
                double napiwek = kwota * procent;
                double suma = kwota + napiwek;
                wynikNapiwku.setText("Napiwek: " + String.format("%.2f zł", napiwek));
                wynikCalkowity.setText("Do zapłaty: " + String.format("%.2f zł", suma));
            }
        });
    }
}
