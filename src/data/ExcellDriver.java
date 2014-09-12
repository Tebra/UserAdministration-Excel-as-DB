package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Member;

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

	public static ArrayList<Member> searchDatabase(String user)
			throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Member> db = new ArrayList<Member>();

		conn = getConnection();
		stmt = conn
				.prepareStatement("SELECT * FROM [Sheet1$] WHERE Ime = ? OR Prezime = ?");
		stmt.setString(1, user);
		stmt.setString(2, user);

		rs = stmt.executeQuery();

		if(rs.wasNull())
		{
			db.add(new Member("NA","NA",0,0));
			
			return db;
		}
		
		while (rs.next()) {
			String name = rs.getString("Ime");
			String surname = rs.getString("Prezime");
			int clanko = (int) Double.parseDouble(rs.getString("ClanOd"));
			int clanarina = (int) Double.parseDouble(rs.getString("Clanarina"));

			System.out.println(name +" | "+ surname +" "+ clanko +" "+ clanarina);

			db.add(new Member(surname, name, clanko, clanarina));
		}
		
		conn.close();
		
		return db;
	}

	public void addMember(Member member) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = getConnection();
	}
}
