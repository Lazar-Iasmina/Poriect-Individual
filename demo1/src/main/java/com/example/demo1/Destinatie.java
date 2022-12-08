package com.example.demo1;

import java.io.Serializable;
import java.util.List;

public class Destinatie implements Serializable {
    private String nume;
    private List<String> listaReviewuri;
    private int numarStele;

    public Destinatie(String nume, List<String> listaReviewuri, int numarStele) {
        this.nume = nume;
        this.listaReviewuri = listaReviewuri;
        this.numarStele = numarStele;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<String> getListaReviewuri() {
        return listaReviewuri;
    }

    public void setListaReviewuri(List<String> listaReviewuri) {
        this.listaReviewuri = listaReviewuri;
    }

    public int getNumarStele() {
        return numarStele;
    }

    public void setNumarStele(int numarStele) {
        this.numarStele = numarStele;
    }
}
