package com.example.menedzerwydatkow;

public class Wydatek {
    private final String nazwa;
    private final double kwota;
    private final String kategoria;

    public Wydatek(String nazwa, double kwota, String kategoria){
        this.nazwa = nazwa;
        this.kwota = kwota;
        this.kategoria = kategoria;
    }
    public String getNazwa(){
        return nazwa;
    }
    public double GetKwota(){
        return kwota;
    }
    public String getKategoria(){
        return kategoria;
    }
}
