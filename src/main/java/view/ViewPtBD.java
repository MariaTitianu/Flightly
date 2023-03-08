package view;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class ViewPtBD extends JFrame {
    public JTabbedPane tabbedPane1;
    public JTabbedPane tabbedPane3;
    public JTable rezultatAeronave;
    public JTable rezultatZboruri;
    public JTable rezultatPilotiCertificare;
    public JTable pilotiMaxCertificare;
    public JTable tableEx14_4B;
    public JTable tabEx14_5B;
    public JTable table14_6b;
    public JTable table14_6a;
    private JPanel Ex14_5;
    private JPanel Ex14_6;
    private JTabbedPane tabbedPane2;
    private JPanel aeronave_intre_Panel;
    private JTextField minGamaCroaziera;
    private JTextField maxGamaCroaziera;
    private JTextField durataMin;
    private JTextField durataMax;
    private JPanel zboruri_intre_Panel;
    private JTextField AeronNumeTextField;
    private JTabbedPane tabbedPane4;
    private JTabbedPane tabbedPane5;
    private JTextField textFieldEx14_5A;
    private JTextField laTextField;
    private JTextField deLaTextField;
    private JTextField textField14_6b;
    private JPanel panelPrincipal;
    private JButton button14_3A;
    private JButton buttonEx14_3B;
    private JButton buttonEx14_4A;
    private JButton buttonEx14_5A;
    private JButton buttonEx14_5B;
    private JButton buton14_6b;

    public ViewPtBD() {
        this.setContentPane(panelPrincipal);
        this.pack();
        this.setTitle("Colocviu Final BD");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getTextMinGamaCroaziera() {
        return Integer.parseInt(minGamaCroaziera.getText());
    }

    public int getTextMaxGamaCroaziera() {
        return Integer.parseInt(maxGamaCroaziera.getText());
    }

    public int getTextMinDurata() {
        return Integer.parseInt(durataMin.getText());
    }

    public int getTextMaxDurata() {
        return Integer.parseInt(durataMax.getText());
    }

    public void addButton14_3AListener(ActionListener actionListener) {
        button14_3A.addActionListener(actionListener);
    }


    public void addButton14_3BListener(ActionListener actionListener) {
        buttonEx14_3B.addActionListener(actionListener);
    }

    public void addButton14_4aListener(ActionListener actionListener) {
        buttonEx14_4A.addActionListener(actionListener);
    }

    public void addButton14_4bListener(ChangeListener actionListener) {
        tabbedPane3.addChangeListener(actionListener);
    }

    public void addButton14_5aListener(ActionListener actionListener) {
        buttonEx14_5A.addActionListener(actionListener);
    }

    public void addButton14_5bListener(ActionListener actionListener) {
        buttonEx14_5B.addActionListener(actionListener);
    }

    public void addButton14_6aListener(ChangeListener actionListener) {
        tabbedPane5.addChangeListener(actionListener);
        tabbedPane1.addChangeListener(actionListener);
    }

    public void addButton14_6bListener(ActionListener actionListener) {
        buton14_6b.addActionListener(actionListener);
    }

    public String getTextEx14_5A() {
        return textFieldEx14_5A.getText();
    }

    public String getTextLa() {
        return laTextField.getText();
    }

    public String getTextDeLa() {
        return deLaTextField.getText();
    }

    public String getNameEX14_4A() {
        return AeronNumeTextField.getText();
    }

    public String getNameEX14_6b() {
        return textField14_6b.getText();
    }

    public void afisareTabel(JTable dumb_table, Object[][] values, Object[] labels) {
        DefaultTableModel defaultTableModel = new DefaultTableModel(values.length, labels.length);
        defaultTableModel.setDataVector(values, labels);
        dumb_table.setModel(defaultTableModel);
        dumb_table.repaint();

    }

    private void createUIComponents() {
        rezultatAeronave = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        rezultatAeronave.setAutoCreateRowSorter(true);

        rezultatZboruri = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        rezultatZboruri.setAutoCreateRowSorter(true);

        rezultatPilotiCertificare = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        rezultatPilotiCertificare.setAutoCreateRowSorter(true);

        pilotiMaxCertificare = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        pilotiMaxCertificare.setAutoCreateRowSorter(true);

        tableEx14_4B = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tableEx14_4B.setAutoCreateRowSorter(true);

        tabEx14_5B = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tabEx14_5B.setAutoCreateRowSorter(true);

        table14_6b = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        table14_6b.setAutoCreateRowSorter(true);
    }


}
