package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Model {
    Connection connection;

    public Model(Connection connection) {
        this.connection = connection;
    }

    public List<Aeronave> ex14_3a(int minGamaCroaziera, int maxGamaCroaziera) throws SQLException {
        String queryString = "Select * from Aeronave where (gama_croaziera >= ? and gama_croaziera <= ? ) order by gama_croaziera DESC";
        List<Aeronave> aeronaveList = new ArrayList<>();
        PreparedStatement queryEx14_3_A = connection.prepareStatement(queryString);
        queryEx14_3_A.setInt(1, minGamaCroaziera);
        queryEx14_3_A.setInt(2, maxGamaCroaziera);
        ResultSet resultSet = queryEx14_3_A.executeQuery();
        while (resultSet.next()) {
            int idav = resultSet.getInt("idav");
            String numeav = resultSet.getString("numeav");
            int gama_croaziera = resultSet.getInt("gama_croaziera");
            Aeronave a = new Aeronave(idav, numeav, gama_croaziera);
            aeronaveList.add(a);
        }
        return aeronaveList;
    }

    public List<Zboruri> ex14_3b(int minDurata, int maxDurata) throws SQLException {

        List<Zboruri> zboruriList = new ArrayList<>();
        String queryString = "Select nrz, de_la, la, distanta, plecare, sosire, zi, SubTime(sosire,plecare) as durata from Zboruri where SubTime(sosire,plecare) >= ? and SubTime(sosire,plecare) <= ? order by de_la, SubTime(sosire,plecare) DESC";
        PreparedStatement queryEx14_3_A = connection.prepareStatement(queryString);
        queryEx14_3_A.setTime(1, new Time(minDurata, 0, 0));
        queryEx14_3_A.setTime(2, new Time(maxDurata, 0, 0));
        ResultSet resultSet = queryEx14_3_A.executeQuery();
        while (resultSet.next()) {
            int nrz, distanta;
            String de_la, la, zi;
            Time plecare, sosire, durata;
            nrz = resultSet.getInt("nrz");
            distanta = resultSet.getInt("distanta");
            de_la = resultSet.getString("de_la");
            la = resultSet.getString("la");
            zi = resultSet.getString("zi");
            plecare = resultSet.getTime("plecare");
            sosire = resultSet.getTime("sosire");
            durata = resultSet.getTime("durata");
            Zboruri a = new Zboruri(nrz, de_la, la, distanta, plecare, sosire, zi);
            a.setDurata(durata);
            zboruriList.add(a);
        }
        return zboruriList;
    }

    public List<Angajati> ex14_4a(String numeaeronava) throws SQLException {
        String queryString = "SELECT a.numean FROM Angajati a\n JOIN Certificare c ON a.idan = c.idan\n JOIN Aeronave aero ON aero.idav = c.idav\n WHERE aero.numeav LIKE ?";
        List<Angajati> angajatiList = new ArrayList<>();
        PreparedStatement queryEx14_4_A = connection.prepareStatement(queryString);
        queryEx14_4_A.setString(1, numeaeronava + "%");
        ResultSet resultSet = queryEx14_4_A.executeQuery();
        while (resultSet.next()) {
            String numean = resultSet.getString("numean");
            Angajati a = new Angajati();
            a.setNumean(numean);
            angajatiList.add(a);
        }
        return angajatiList;
    }

    public List<Join14_4b> ex14_4b() throws SQLException {
        CallableStatement cs = connection.prepareCall("{call proceduraStocataEx14_4B()}");
        List<Join14_4b> pilotiJoinList = new ArrayList<>();
        ResultSet resultSet = cs.executeQuery();
        while (resultSet.next()) {
            int pilot1_idan = resultSet.getInt("pilot1_idan");
            String pilot1_numean = resultSet.getString("pilot1_numean");
            int pilot1_salariu = resultSet.getInt("pilot1_salariu");
            int pilot2_idan = resultSet.getInt("pilot2_idan");
            String pilot2_numean = resultSet.getString("pilot2_numean");
            int pilot2_salariu = resultSet.getInt("pilot2_salariu");
            int idav = resultSet.getInt("idav");
            Angajati pilot1 = new Angajati();
            pilot1.setNumean(pilot1_numean);
            pilot1.setIdan(pilot1_idan);
            pilot1.setSalariu(pilot1_salariu);
            Angajati pilot2 = new Angajati();
            pilot2.setNumean(pilot2_numean);
            pilot2.setIdan(pilot2_idan);
            pilot2.setSalariu(pilot2_salariu);
            Join14_4b a = new Join14_4b(pilot1, pilot2, idav);
            pilotiJoinList.add(a);
        }
        return pilotiJoinList;
    }

    public List<Angajati> ex14_5a(String numeaeronava) throws SQLException {
        String queryString = "SELECT * FROM Angajati WHERE functie = 'pilot' AND idan in (select idan from Certificare where idav in (select idav from Aeronave where numeav like ?)) ORDER BY salariu DESC limit 1";
        List<Angajati> angajatiList = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement(queryString);
        query.setString(1, numeaeronava + "%");
        ResultSet resultSet = query.executeQuery();
        while (resultSet.next()) {
            int idan = resultSet.getInt("idan");
            String numean = resultSet.getString("numean");
            String functie = resultSet.getString("functie");
            int salariu = resultSet.getInt("salariu");
            Angajati a = new Angajati(idan, numean, functie, salariu);
            angajatiList.add(a);
        }
        return angajatiList;
    }

    public List<Aeronave> ex14_5b(String numeLA, String numeDeLA) throws SQLException {
        String queryString = "select * from Aeronave where gama_croaziera > ANY (select distanta from Zboruri  where DE_LA = ? AND LA = ?)";
        List<Aeronave> aeronaveList = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement(queryString);
        query.setString(1, numeLA);
        query.setString(2, numeDeLA);
        ResultSet resultSet = query.executeQuery();
        while (resultSet.next()) {
            int idav = resultSet.getInt("idav");
            String numeav = resultSet.getString("numeav");
            int gama_croaziera = resultSet.getInt("gama_croaziera");
            Aeronave a = new Aeronave(idav, numeav, gama_croaziera);
            aeronaveList.add(a);
        }
        return aeronaveList;
    }

    public List<Join14_6a> ex14_6a() throws SQLException {
        CallableStatement cs = connection.prepareCall("{call proceduraStocataEx14_6A()}");
        List<Join14_6a> pilotiJoinList = new ArrayList<>();
        ResultSet resultSet = cs.executeQuery();
        while (resultSet.next()) {
            String numeav = resultSet.getString("numeav");
            int maxSalariu = resultSet.getInt("maxSalariu");
            int avgSalariu = resultSet.getInt("avgSalariu");
            int minSalariu = resultSet.getInt("minSalariu");
            Join14_6a a = new Join14_6a(numeav, maxSalariu, avgSalariu, minSalariu);
            pilotiJoinList.add(a);
        }
        return pilotiJoinList;
    }

    public List<Zboruri> ex14_6b(String numeLA) throws SQLException {
        String queryString = "SELECT z.la, max(z.distanta) as distanta FROM Zboruri z where z.de_la = ? GROUP BY z.la";
        List<Zboruri> zboruriList = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement(queryString);
        query.setString(1, numeLA);
        ResultSet resultSet = query.executeQuery();
        while (resultSet.next()) {
            int distanta = resultSet.getInt("distanta");
            String la = resultSet.getString("la");
            Zboruri a = new Zboruri();
            a.setLa(la);
            a.setDistanta(distanta);
            zboruriList.add(a);
        }
        return zboruriList;
    }

}
