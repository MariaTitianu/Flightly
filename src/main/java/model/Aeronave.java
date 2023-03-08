package model;

public class Aeronave {
    public static final Object[] LABELS = {"idav", "numeav", "gama_croaziera"};
    private int idav;
    private String numeav;
    private int gama_croaziera;

    public Aeronave(int idav, String numeav, int gama_croaziera) {
        this.idav = idav;
        this.numeav = numeav;
        this.gama_croaziera = gama_croaziera;
    }

    public int getIdav() {
        return idav;
    }

    public void setIdav(int idav) {
        this.idav = idav;
    }

    public String getNumeav() {
        return numeav;
    }

    public void setNumeav(String numeav) {
        this.numeav = numeav;
    }

    public int getGama_croaziera() {
        return gama_croaziera;
    }

    public void setGama_croaziera(int gama_croaziera) {
        this.gama_croaziera = gama_croaziera;
    }
}
