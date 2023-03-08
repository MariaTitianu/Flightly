package presenter;

import model.*;
import view.ViewPtBD;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Presenter {
    private final ViewPtBD view;
    private final Model model;

    public Presenter(ViewPtBD view, Model model) {
        this.model = model;
        this.view = view;
        this.view.addButton14_3AListener(new Excercitiu14_3_aListener());
        this.view.addButton14_3BListener(new Excercitiu14_3_bListener());
        this.view.addButton14_4aListener(new Excercitiu14_4_aListener());
        this.view.addButton14_4bListener(new Excercitiu14_4_bListener());
        this.view.addButton14_5aListener(new Excercitiu14_5_aListener());
        this.view.addButton14_5bListener(new Excercitiu14_5_bListener());
        this.view.addButton14_6aListener(new Excercitiu14_6_aListener());
        this.view.addButton14_6bListener(new Excercitiu14_6_bListener());
    }

    class Excercitiu14_3_aListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Aeronave> aeronaveList = model.ex14_3a(view.getTextMinGamaCroaziera(), view.getTextMaxGamaCroaziera());
                Object[][] values = new Object[aeronaveList.size()][3];
                for (int i = 0; i < aeronaveList.size(); i++) {
                    values[i][0] = aeronaveList.get(i).getIdav();
                    values[i][1] = aeronaveList.get(i).getNumeav();
                    values[i][2] = aeronaveList.get(i).getGama_croaziera();
                }
                view.afisareTabel(view.rezultatAeronave, values, Aeronave.LABELS);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class Excercitiu14_3_bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] labels = {"nrz", "de_la", "la", "distanta", "plecare", "sosire", "zi", "durata"};
            List<Zboruri> zboruriList;
            try {
                zboruriList = model.ex14_3b(view.getTextMinDurata(), view.getTextMaxDurata());
                Object[][] values = new Object[zboruriList.size()][8];
                for (int i = 0; i < zboruriList.size(); i++) {
                    values[i][0] = zboruriList.get(i).getNrz();
                    values[i][1] = zboruriList.get(i).getDe_la();
                    values[i][2] = zboruriList.get(i).getLa();
                    values[i][3] = zboruriList.get(i).getDistanta();
                    values[i][4] = zboruriList.get(i).getPlecare();
                    values[i][5] = zboruriList.get(i).getSosire();
                    values[i][6] = zboruriList.get(i).getZi();
                    values[i][7] = zboruriList.get(i).getDurata();
                }
                view.afisareTabel(view.rezultatZboruri, values, labels);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    class Excercitiu14_4_aListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[] labels = {"numean"};
                List<Angajati> angajatiList = model.ex14_4a(view.getNameEX14_4A());
                Object[][] values = new Object[angajatiList.size()][1];
                for (int i = 0; i < angajatiList.size(); i++) {
                    values[i][0] = angajatiList.get(i).getNumean();
                }
                view.afisareTabel(view.rezultatPilotiCertificare, values, labels);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class Excercitiu14_4_bListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (view.tabbedPane3.getSelectedIndex() == 1) {
                try {
                    Object[] labels = {"pilot1_idan", "pilot1_numean ", "pilot1_salariu", "pilot2_idan", "pilot2_numean ", "pilot2_salariu", "idav"};
                    List<Join14_4b> pilotiJoin = model.ex14_4b();
                    Object[][] values = new Object[pilotiJoin.size()][7];
                    for (int i = 0; i < pilotiJoin.size(); i++) {
                        values[i][0] = pilotiJoin.get(i).getPilot1().getIdan();
                        values[i][1] = pilotiJoin.get(i).getPilot1().getNumean();
                        values[i][2] = pilotiJoin.get(i).getPilot1().getSalariu();
                        values[i][3] = pilotiJoin.get(i).getPilot2().getIdan();
                        values[i][4] = pilotiJoin.get(i).getPilot2().getNumean();
                        values[i][5] = pilotiJoin.get(i).getPilot2().getSalariu();
                        values[i][6] = pilotiJoin.get(i).getIdav();
                    }
                    view.afisareTabel(view.tableEx14_4B, values, labels);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    class Excercitiu14_5_aListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Angajati> angajatiList = model.ex14_5a(view.getTextEx14_5A());
                Object[][] values = new Object[angajatiList.size()][4];
                for (int i = 0; i < angajatiList.size(); i++) {
                    values[i][0] = angajatiList.get(i).getIdan();
                    values[i][1] = angajatiList.get(i).getNumean();
                    values[i][2] = angajatiList.get(i).getFunctie();
                    values[i][3] = angajatiList.get(i).getSalariu();
                }
                view.afisareTabel(view.pilotiMaxCertificare, values, Angajati.LABELS);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class Excercitiu14_5_bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Aeronave> aeronaveList = model.ex14_5b(view.getTextLa(), view.getTextDeLa());
                Object[][] values = new Object[aeronaveList.size()][3];
                for (int i = 0; i < aeronaveList.size(); i++) {
                    values[i][0] = aeronaveList.get(i).getIdav();
                    values[i][1] = aeronaveList.get(i).getNumeav();
                    values[i][2] = aeronaveList.get(i).getGama_croaziera();
                }
                view.afisareTabel(view.tabEx14_5B, values, Aeronave.LABELS);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class Excercitiu14_6_aListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (view.tabbedPane3.getSelectedIndex() == 0 || view.tabbedPane1.getSelectedIndex() == 3) {
                try {
                    List<Join14_6a> pilotiJoin = model.ex14_6a();
                    Object[][] values = new Object[pilotiJoin.size()][4];
                    for (int i = 0; i < pilotiJoin.size(); i++) {
                        values[i][0] = pilotiJoin.get(i).getNumeav();
                        values[i][1] = pilotiJoin.get(i).getMaxSalariu();
                        values[i][2] = pilotiJoin.get(i).getAvgSalariu();
                        values[i][3] = pilotiJoin.get(i).getMinSalariu();
                    }
                    view.afisareTabel(view.table14_6a, values, Join14_6a.LABELS);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    class Excercitiu14_6_bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[] labels = {"distanta", "la"};
                List<Zboruri> zboruriList = model.ex14_6b(view.getNameEX14_6b());
                Object[][] values = new Object[zboruriList.size()][2];
                for (int i = 0; i < zboruriList.size(); i++) {
                    values[i][0] = zboruriList.get(i).getDistanta();
                    values[i][1] = zboruriList.get(i).getLa();
                }
                view.afisareTabel(view.table14_6b, values, labels);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
