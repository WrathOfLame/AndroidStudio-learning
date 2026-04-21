package com.example.menedzerwydatkow;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.UncheckedIOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText poleNazwaWydatku;
    private EditText poleKwotaWydatku;
    private Spinner spinnerKategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        poleNazwaWydatku = findViewById(R.id.tekstNazwa);
        poleKwotaWydatku = findViewById(R.id.tekstKwota);
        spinnerKategoria = findViewById(R.id.tekstKategoria);
        Button butt = findViewById(R.id.przyciskUsun);
        butt.setOnClickListener(v -> onClick(v));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public void onClick(View view){
        String nazwaWydatku = poleNazwaWydatku.getText().toString();
        String kwotaWydatku = poleKwotaWydatku.getText().toString();
        String kategoria = spinnerKategoria.getSelectedItem().toString();
        if(nazwaWydatku.isEmpty() || kwotaWydatku.isEmpty()){
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        double kwotaWydatkuInt = Double.parseDouble(kwotaWydatku);
        Wydatek w = new Wydatek(nazwaWydatku, kwotaWydatkuInt, kategoria);
        Toast.makeText(this, "Object created", Toast.LENGTH_SHORT).show();
    }
    
}
