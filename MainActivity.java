package com.example.kreatorfiszekiquiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

        Button butt = findViewById(R.id.butt);

        butt.setOnClickListener(v -> createNewQuestion());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void createNewQuestion(){
        ListView list = findViewById(R.id.list);
        EditText pole_nazwa = findViewById(R.id.nazwa);
        String nazwa = pole_nazwa.getText().toString();
        EditText pole_pytanie = findViewById(R.id.pytanie);
        String pytanie = pole_pytanie.getText().toString();
        EditText pole_odpowiedz = findViewById(R.id.odpowiedz);
        String odpowiedz = pole_odpowiedz.getText().toString();


    }
}
