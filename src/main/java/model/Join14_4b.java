package model;

public class Join14_4b {
    private Angajati pilot1, pilot2;
    private int idav;

    public Join14_4b(Angajati pilot1, Angajati pilot2, int idav) {
        this.pilot1 = pilot1;
        this.pilot2 = pilot2;
        this.idav = idav;
    }


    public Angajati getPilot1() {
        return pilot1;
    }

    public void setPilot1(Angajati pilot1) {
        this.pilot1 = pilot1;
    }

    public Angajati getPilot2() {
        return pilot2;
    }

    public void setPilot2(Angajati pilot2) {
        this.pilot2 = pilot2;
    }

    public int getIdav() {
        return idav;
    }

    public void setIdav(int idav) {
        this.idav = idav;
    }
}
