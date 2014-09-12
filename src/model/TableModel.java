package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private static List<Member> db;
	
	private String[] colNames = {"Ime", "Prezime", "Clan od", "Clanarina"};
	
	public TableModel(){
		db = new ArrayList<Member>();
	}
	
	public static void setData(List<Member> dbs) {
		db = dbs;
		System.out.println("setData gemacht");
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Member member = db.get(row);

		switch (col) {
		case 0:
			return member.getName();
		case 1:
			return member.getVorname();
		case 2:
			return member.getMemberSince();
		case 3:
			return member.getPayment();
		}

		return null;
	}

}
