package com.example.kreatorfiszekiquiz;

public class Fiszka {
    private String nazwaPytania;
    private String pytanie;
    private boolean answer;
    public Fiszka(String nazwa, String pytanie, boolean answer){
        this.nazwaPytania = nazwa;
        this.pytanie = pytanie;
        this.answer = answer;
    }
    public String getNazwaPytania(){
        return this.nazwaPytania;
    }
    public String getPytanie(){
        return this.pytanie;
    }
    public boolean getAnswer(){
        return this.answer;
    }
    @Override
    public String toString(){
        return "Pytanie: "+pytanie + " Odpowiedz: "+ answer;
    }

}
