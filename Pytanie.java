package com.example.aplikacjaquizowa;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class Pytanie {
    private String trescPytania;
    private ArrayList<String> opcjeOdpowiedzi;
    private int indeksPoprawnej;
    public Pytanie(String tresc, ArrayList<String> opcje, int indeksPoprawnej){
        this.trescPytania = tresc;
        this.opcjeOdpowiedzi = opcje;
        this.indeksPoprawnej = indeksPoprawnej;
    }
    ArrayList<String> getOpcjeOdpowiedzi() {
        return this.opcjeOdpowiedzi;
    }
    int getPoprawnaOdpowiedz(){
        return this.indeksPoprawnej;
    }
    String getTresc(){
        return this.trescPytania;
    }
}

