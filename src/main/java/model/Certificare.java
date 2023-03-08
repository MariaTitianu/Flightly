package model;

public class Certificare {
    private int idan;
    private int idav;

    public Certificare(int idan, int idav) {
        this.idan = idan;
        this.idav = idav;
    }

    public int getIdan() {
        return idan;
    }

    public void setIdan(int idan) {
        this.idan = idan;
    }

    public int getIdav() {
        return idav;
    }

    public void setIdav(int idav) {
        this.idav = idav;
    }
}
