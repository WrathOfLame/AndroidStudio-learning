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
    CheckBox boxSer, boxSzynka, boxPieczarki, rabat;
    RadioGroup radioGroupRozmiar, radioSos;
    Button butt1, butt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        boxSer = findViewById(R.id.ser);
        boxSzynka = findViewById(R.id.szynka);
        boxPieczarki = findViewById(R.id.pieczarki);
        rabat = findViewById(R.id.studentskiRabat);
        radioGroupRozmiar = findViewById(R.id.radioGroupRozmiar);
        radioSos = findViewById(R.id.wyborSosu);
        butt1 = findViewById(R.id.butt);
        butt2 = findViewById(R.id.wyczysc);

        rabat.setOnClickListener(v -> {
            if(rabat.isChecked()){
                Toast.makeText(this, "Znizka zostala wlaczona", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Znizka zostala wylaczona", Toast.LENGTH_SHORT).show();
            }
        });
        butt1.setOnClickListener(v -> {
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
        int wybranyRozmiarId = radioGroupRozmiar.getCheckedRadioButtonId();
        if (wybranyRozmiarId != -1) {
            RadioButton wybranyButton = findViewById(wybranyRozmiarId);
            String tag = wybranyButton.getTag().toString();
            switch (tag) {
                case "mala":
                    wynik = CENA_MALA;
                    dodatki += " Mala pizza";
                    break;
                case "srednia":
                    wynik = CENA_SREDNIA;
                    dodatki += " Srednia pizza";
                    break;
                case "duza":
                    wynik = CENA_DUZA;
                    dodatki += " Duza pizza";
                    break;
            }
        }
        int wybranySosId = radioSos.getCheckedRadioButtonId();
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
        if(wybranySosId != -1) {
            RadioButton wybranySos = findViewById(wybranySosId);
            String tagSos = wybranySos.getTag().toString();
            switch (tagSos) {
                case "czosnkowy":
                    wynik += 2.0;
                    dodatki += " czosnkowy sos";
                    break;
                case "pomidorowy":
                    wynik += 2.0;
                    dodatki += " pomidorowy sos";
                    break;
            }
        }
        return wynik;
    }
    private void clear(){
        boxPieczarki.setChecked(false);
        boxSzynka.setChecked(false);
        boxSer.setChecked(false);
        radioSos.check(R.id.brakSosu);
        aktualizujCene();
    }

}