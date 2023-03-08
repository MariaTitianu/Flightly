package model;

import java.sql.Time;

public class Zboruri {
    //enum ('Lu','Ma','Mi','Jo','Vi','Sa','Du')
    public static final Object[] LABELS = {"nrz", "de_la", "la", "distanta", "plecare", "sosire", "zi"};
    private int nrz;
    private String de_la;
    private String la;
    private int distanta;
    private Time plecare;
    private Time sosire;
    private Time durata;
    private String zi;

    public Zboruri(int nrz, String de_la, String la, int distanta, Time plecare, Time sosire, String zi) {
        this.nrz = nrz;
        this.de_la = de_la;
        this.la = la;
        this.distanta = distanta;
        this.plecare = plecare;
        this.sosire = sosire;
        this.zi = zi;
    }

    public Zboruri() {
    }

    public Time getDurata() {
        return durata;
    }

    public void setDurata(Time durata) {
        this.durata = durata;
    }

    public int getNrz() {
        return nrz;
    }

    public void setNrz(int nrz) {
        this.nrz = nrz;
    }

    public String getDe_la() {
        return de_la;
    }

    public void setDe_la(String de_la) {
        this.de_la = de_la;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public int getDistanta() {
        return distanta;
    }

    public void setDistanta(int distanta) {
        this.distanta = distanta;
    }

    public Time getPlecare() {
        return plecare;
    }

    public void setPlecare(Time plecare) {
        this.plecare = plecare;
    }

    public Time getSosire() {
        return sosire;
    }

    public void setSosire(Time sosire) {
        this.sosire = sosire;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }
}
