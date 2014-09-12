package view;

import java.util.EventObject;

public class TableEvent extends EventObject {

	String name;
	String vorname; 
	int memberSince;
	int payment;
	
	public TableEvent(Object source) {
		super(source);
	}
	
	public TableEvent(Object source, String name, String vorname, int memberSince, int payment )  {
		super(source);
		
		this.name = name;
		this.vorname = vorname;
		this.memberSince = memberSince;
		this.payment = payment;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public int getMemberSince() {
		return memberSince;
	}

	public int getPayment() {
		return payment;
	}
	

	
	
}
