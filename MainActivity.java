package com.example.konfiguratorzamowieniapizzy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String dodatki = "";
    CheckBox boxSer = findViewById(R.id.ser);
    CheckBox boxSzynka = findViewById(R.id.szynka);
    CheckBox boxPieczarki = findViewById(R.id.pieczarki);
    CheckBox rabat = findViewById(R.id.studentskiRabat);
    RadioGroup radioGroupRozmiar = findViewById(R.id.radioGroupRozmiar);
    Button butt = findViewById(R.id.butt);
    Button butt2 = findViewById(R.id.wyczysc);
    RadioGroup radioSos = findViewById(R.id.wyborSosu);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        rabat.setOnClickListener(v -> {
            if(rabat.isChecked()){
                Toast.makeText(this, "Znizka zostala wlaczona", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Znizka zostala wylaczona", Toast.LENGTH_SHORT).show();
            }
        });
        butt.setOnClickListener(v -> {
            aktualizujCene();
        });
        butt2.setOnClickListener(v -> clear());
        radioGroupRozmiar.setOnCheckedChangeListener((group, checkedId) -> {
            aktualizujCene();
        });
        boxSer.setOnClickListener(v -> {
            aktualizujCene();
        });
        boxPieczarki.setOnClickListener(v -> {
            aktualizujCene();
        });
        boxSzynka.setOnClickListener(v -> {
            aktualizujCene();
        });
        aktualizujCene();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void aktualizujCene(){
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
    private void clear(){
        dodatki = "";
        boxPieczarki.setChecked(false);
        boxSzynka.setChecked(false);
        boxSer.setChecked(false);
        radioSos.check(R.id.bezSosu);
    }

}