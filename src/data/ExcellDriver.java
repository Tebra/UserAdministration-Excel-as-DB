package data;

import java.sql.*;

/**
 * ODBC Driver to access, read and write into the Excell sheet
 * <p/>
 * Created by Rijad on 09.08.2014.
 */
public class ExcellDriver {

    public static Connection getConnection() throws Exception {
        String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String url = "jdbc:odbc:dataBase";

        String username = "";
        String password = "";
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

    public static void writePayment(String name, String data) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        conn = getConnection();
        stmt = conn.createStatement();
        String excelQuery = "insert into [Sheet $1] (";
    }

    public static void displayData(String user) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String person = user;
        conn = getConnection();
        stmt = conn.prepareStatement("SELECT * FROM [Sheet1$] WHERE 'Ime' OR 'Prezime' = ?");
        stmt.setString(1, person);

        rs = stmt.executeQuery();



        /*ArrayList<Object[][]> data = new ArrayList<Object[][]>();

        /*while(rs.next()) {
            String name = rs.getString("Ime");
            String surname = rs.getString("Prezime");
            String clanko = rs.getString("ClanOd");
            String clanarina = rs.getString("Clanarina");

            data.add(new Object[][]{{name, surname, clanko, clanarina}});
        }
        return new Object[][]{data.toArray()};*/
    }
}
