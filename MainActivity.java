package com.example.kreatorpostacirpg;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText poleImie;
    RadioGroup grupaPlec;
    Spinner spinnerRasa;
    CheckBox chkWlam, chkAlch, chkKowal;
    Button btnStworz, btnReset;
    TextView wynik;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            func();
            return insets;
        });
    }
    void func(){
        poleImie = findViewById(R.id.poleImie);
        grupaPlec = findViewById(R.id.radioGroupPlec);
        spinnerRasa = findViewById(R.id.spinnerRasa);

        chkWlam = findViewById(R.id.chkWlam);
        chkAlch = findViewById(R.id.chkAlch);
        chkKowal = findViewById(R.id.chkKowal);

        btnStworz = findViewById(R.id.btnStworz);
        btnReset = findViewById(R.id.btnReset);

        wynik = findViewById(R.id.wynik);

        btnStworz.setOnClickListener(v -> {
            String imie = poleImie.getText().toString().trim();

            if (imie.isEmpty()) {
                wynik.setText("Błąd: Imię nie może być puste!");
                return;
            }

            int id = grupaPlec.getCheckedRadioButtonId();
            if (id == -1) {
                wynik.setText("Błąd: Wybierz płeć!");
                return;
            }

            RadioButton wybranaPlec = findViewById(id);
            String plec = wybranaPlec.getText().toString();

            String rasa = spinnerRasa.getSelectedItem().toString();

            ArrayList<String> umiej = new ArrayList<>();
            if (chkWlam.isChecked()) umiej.add("Włamywanie");
            if (chkAlch.isChecked()) umiej.add("Alchemia");
            if (chkKowal.isChecked()) umiej.add("Kowalstwo");

            Postac postac = new Postac(imie, plec, rasa, umiej);

            StringBuilder sb = new StringBuilder();
            sb.append("=== Twoja Postać ===\n");
            sb.append("Imię: ").append(postac.imie).append("\n");
            sb.append("Płeć: ").append(postac.plec).append("\n");
            sb.append("Rasa: ").append(postac.rasa).append("\n");
            sb.append("Umiejętności:\n");

            if (postac.umiejetnosci.isEmpty()) {
                sb.append("- brak\n");
            } else {
                for (String s : postac.umiejetnosci) {
                    sb.append("- ").append(s).append("\n");
                }
            }

            wynik.setText(sb.toString());
        });
        btnReset.setOnClickListener(v -> {
            poleImie.setText("");
            grupaPlec.clearCheck();
            spinnerRasa.setSelection(0);

            chkWlam.setChecked(false);
            chkAlch.setChecked(false);
            chkKowal.setChecked(false);

            wynik.setText("");
        });
    }
}
