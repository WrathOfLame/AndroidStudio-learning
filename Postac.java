package com.example.kreatorpostacirpg;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Postac {
    String imie;
    String plec;
    String rasa;
    public ArrayList<String> umiejetnosci;

    public Postac(String imie, String plec, String rasa, ArrayList<String> umiejetnosci){
        this.imie = imie;
        this.plec = plec;
        this.rasa = rasa;
        this.umiejetnosci = umiejetnosci;
    }
}
