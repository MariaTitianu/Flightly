package model;

public class Angajati {
    public static final Object[] LABELS = {"idan", "numean", "functie", "salariu"};
    private int idan;
    private String numean;
    private String functie;
    private int salariu;

    public Angajati(int idan, String numean, String functie, int salariu) {
        this.idan = idan;
        this.numean = numean;
        this.functie = functie;
        this.salariu = salariu;
    }

    public Angajati() {
    }

    public int getIdan() {
        return idan;
    }

    public void setIdan(int idan) {
        this.idan = idan;
    }

    public String getNumean() {
        return numean;
    }

    public void setNumean(String numean) {
        this.numean = numean;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }
}
