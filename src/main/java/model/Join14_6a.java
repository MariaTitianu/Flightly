package model;

public class Join14_6a {
    public static final Object[] LABELS = {"numeav", "maxSalariu", "avgSalariu", "minSalariu"};
    private String numeav;
    private int maxSalariu, avgSalariu, minSalariu;

    public Join14_6a(String numeav, int maxSalariu, int avgSalariu, int minSalariu) {
        this.numeav = numeav;
        this.maxSalariu = maxSalariu;
        this.avgSalariu = avgSalariu;
        this.minSalariu = minSalariu;
    }

    public String getNumeav() {
        return numeav;
    }

    public void setNumeav(String numeav) {
        this.numeav = numeav;
    }

    public int getMaxSalariu() {
        return maxSalariu;
    }

    public void setMaxSalariu(int maxSalariu) {
        this.maxSalariu = maxSalariu;
    }

    public int getAvgSalariu() {
        return avgSalariu;
    }

    public void setAvgSalariu(int avgSalariu) {
        this.avgSalariu = avgSalariu;
    }

    public int getMinSalariu() {
        return minSalariu;
    }

    public void setMinSalariu(int minSalariu) {
        this.minSalariu = minSalariu;
    }
}
