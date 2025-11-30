package com.example.generatorlosowychcytatow;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Cytat> listaCytatow = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Random randomGenerator = new Random();
            Button butt1 = findViewById(R.id.butt1);
            Button butt2 = findViewById(R.id.butt2);
            EditText poleTresc = findViewById(R.id.tresc);
            EditText poleAutor = findViewById(R.id.autor);
            TextView res = findViewById(R.id.res);
            przygotujDaneCytatow();
            butt1.setOnClickListener(v1 -> {
                String tresc = poleTresc.getText().toString();
                String autor = poleAutor.getText().toString();
                if(!tresc.isEmpty() && !autor.isEmpty()){
                    listaCytatow.add(new Cytat(tresc, autor));
                    poleTresc.setText("");
                    poleAutor.setText("");
                    res.setText("Cytat zostal dodany");
                }else{
                    res.setText("Musisz wypelnic wszystkie pola");
                }
            });
            butt2.setOnClickListener(v1 -> {
                if(listaCytatow.size() != 0){
                    int randomCytat = randomGenerator.nextInt(listaCytatow.size());
                    res.setText("Randomowy cytat: "+listaCytatow.get(randomCytat).tresc+" autora: "+listaCytatow.get(randomCytat).autor);
                }else{
                    res.setText("Lista cytatow jest pusta");
                }
            });
            return insets;
        });
    }
    private void przygotujDaneCytatow() {
        listaCytatow.add(new Cytat("Być albo nie być, oto jest pytanie.", "William Szekspir"));
        listaCytatow.add(new Cytat("Wiem, że nic nie wiem.", "Sokrates"));
        listaCytatow.add(new Cytat("Myślę, więc jestem.", "Kartezjusz"));
        listaCytatow.add(new Cytat("Dajcie mi punkt oraz ja porusze Ziemie", "Archmedes"));
    }
}
