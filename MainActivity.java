package com.example.konfiguratorzamowieniapizzy;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String dodatki = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void aktualizujCene(View view){
        TextView cenaWynikowa = findViewById(R.id.cenaWynikowa);
        double wynik = obliczCene();
        if(dodatki.equals("")) dodatki = "Brak dodatkow";
        cenaWynikowa.setText("Twoja cena końcowa: "+wynik+" "+dodatki);
    }

    private double obliczCene(){
        dodatki = "";
        double wynik = 0;
        final double CENA_MALA = 20.0;
        final double CENA_SREDNIA = 30.0;
        final double CENA_DUZA = 40.0;
        RadioGroup radioGroupRozmiar = findViewById(R.id.radioGroupRozmiar);
        int wybranyRozmiarId = radioGroupRozmiar.getCheckedRadioButtonId();
        if (wybranyRozmiarId == R.id.radioMala) {
            wynik = CENA_MALA;
            dodatki+="Rozmiar maly ";
        } else if (wybranyRozmiarId == R.id.radioSrednia) {
            wynik = CENA_SREDNIA;
            dodatki+="Rozmiar sredni ";
        } else if (wybranyRozmiarId == R.id.radioDuza) {
            wynik = CENA_DUZA;
            dodatki+="Rozmiar duzy ";
        }
        CheckBox boxSer = findViewById(R.id.ser);
        CheckBox boxSzynka = findViewById(R.id.szynka);
        CheckBox boxPieczarki = findViewById(R.id.pieczarki);
        RadioGroup radioSos = findViewById(R.id.wyborSosu);
        int wybranySos = radioSos.getCheckedRadioButtonId();
        if(boxSer.isChecked()){
            wynik+=2.0;
            dodatki+="dodatkowy ser ";
        }
        if(boxSzynka.isChecked()){
            wynik+=2.0;
            dodatki+="dodatkowa szynka ";
        }
        if(boxPieczarki.isChecked()){
            wynik+=2.0;
            dodatki+="dodatkowe pieczarki ";
        }
        if(wybranySos == R.id.sosCzosnkowy){
            wynik+=2.0;
            dodatki+="dodatkowy sos czosnkowy ";
        }else if(wybranySos == R.id.sosPomidorowy){
            wynik+=2.0;
            dodatki+="dodatkowy sos pomidorowy ";
        }
        return wynik;
    }
}