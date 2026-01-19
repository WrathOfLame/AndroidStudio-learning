package com.example.aplikacjaquizowa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button butt = findViewById(R.id.butt);
        butt.setOnClickListener(v -> {
            RadioGroup radioGroup = findViewById(R.id.RadioGroupOdpowiedzi);
            int zaznaczonaOdpowiedzInt = radioGroup.getCheckedRadioButtonId();
            if(zaznaczonaOdpowiedzInt == -1){
                Toast.makeText(this, "Nie zaznaczyłeś odpowiedzi!", Toast.LENGTH_SHORT).show();
            }else sprawdzOdpowiedz();
        });
        przygotujPytania();
        wyswietlPytanie();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    ArrayList<Pytanie> listaPytan = new ArrayList<>();
    int aktualnyIndeksPytania=0;
    int wynik=0;
    private void sprawdzOdpowiedz() {
        RadioGroup radioGroup = findViewById(R.id.RadioGroupOdpowiedzi);
        int zaznaczonaOdpowiedzInt = radioGroup.getCheckedRadioButtonId();
        int poprawnaOdpowiedz = listaPytan.get(aktualnyIndeksPytania).getPoprawnaOdpowiedz();
        if (zaznaczonaOdpowiedzInt == poprawnaOdpowiedz) {
            wynik++;
            aktualnyIndeksPytania++;
        }else if(zaznaczonaOdpowiedzInt == -1) {
            Toast.makeText(this, "Zaznacz jakąś odpowiedź", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Niepoprawna odpowiedź", Toast.LENGTH_SHORT).show();
            aktualnyIndeksPytania++;
        }
        
        if (aktualnyIndeksPytania < listaPytan.size()) {
            wyswietlPytanie();
        }else{
            wyswietlWynikKoncowy();
        }
    }
    public void przygotujPytania(){
        ArrayList<String> opcje1 = new ArrayList<>();
        opcje1.add("Aby glaskac koty");
        opcje1.add("Aby umrzec");
        opcje1.add("Aby rozwijac sie");
        Pytanie pyt1 = new Pytanie("Jaki sens zycia?", opcje1, 0);
        ArrayList<String> opcje2 = new ArrayList<>();
        opcje2.add("Taki zarcik");
        opcje2.add("Jej nie ma");
        opcje2.add("Jest to zwiazek naszych neuronow");
        Pytanie pyt2 = new Pytanie("Czym jest swiadomość?", opcje2, 0);
        ArrayList<String> opcje3 = new ArrayList<>();
        opcje3.add("To jest uczucie obfitości");
        opcje3.add("Nie wiem");
        opcje3.add("Jest to pojęcie kontrawersyjne dla każdego");
        Pytanie pyt3 = new Pytanie("Czym jest szczęście?", opcje3, 1);
        ArrayList<String> opcje4 = new ArrayList<>();
        opcje4.add("Bo rozumiemy");
        opcje4.add("Bo tak lol");
        opcje4.add("Ponieważ nasz mózg może wchłaniać informacje");
        Pytanie pyt4 = new Pytanie("Jak możemy coś wiedzieć?", opcje4, 1);
        ArrayList<String> opcje5 = new ArrayList<>();
        opcje5.add("Tak");
        opcje5.add("Nie");
        opcje5.add("Okipa");
        Pytanie pyt5 = new Pytanie("Pytanie?", opcje5, 0);
        listaPytan.add(pyt1);
        listaPytan.add(pyt2);
        listaPytan.add(pyt3);
        listaPytan.add(pyt4);
        listaPytan.add(pyt5);
    }
    void wyswietlWynikKoncowy(){
        RadioGroup radioGroup = findViewById(R.id.RadioGroupOdpowiedzi);
        radioGroup.removeAllViews();
        Button butt = findViewById(R.id.butt);
        butt.setText("Zagraj ponownie");
        butt.setOnClickListener(v -> {
            wynik = 0;
            aktualnyIndeksPytania = 0;
            wyswietlPytanie();
        });
        TextView tresc = findViewById(R.id.tresc);
        tresc.setText("Test skończony");
    }
    void wyswietlPytanie(){
        RadioGroup radioGroup = findViewById(R.id.RadioGroupOdpowiedzi);
        radioGroup.removeAllViews();
        radioGroup.clearCheck();
        Button butt = findViewById(R.id.butt);
        TextView tresc = findViewById(R.id.tresc);
        Pytanie aktualnePytanie = listaPytan.get(aktualnyIndeksPytania);
        ArrayList<String> opcje = aktualnePytanie.getOpcjeOdpowiedzi();
        TextView textWynikowy = findViewById(R.id.textWynikowy);
        TextView numerPytania = findViewById(R.id.Numer_pytania);
        int numerPyt = listaPytan.indexOf(aktualnePytanie)+1;
        numerPytania.setText("Pytanie "+ numerPyt+"/5");
        butt.setOnClickListener(v -> sprawdzOdpowiedz());
        butt.setText("Sprawdź");
        textWynikowy.setText("Twoje punkty: "+Integer.toString(wynik));
        for(String pobranaOpcja : opcje){
            RadioButton rb = new RadioButton(this);
            rb.setText(pobranaOpcja);
            rb.setId(opcje.indexOf(pobranaOpcja));
            tresc.setText(aktualnePytanie.getTresc());
            radioGroup.addView(rb);
        }
        if(listaPytan.indexOf(aktualnePytanie) == 4){
            butt.setText("Zakoncz");
        }
    }
}












