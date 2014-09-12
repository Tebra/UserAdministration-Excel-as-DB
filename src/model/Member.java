package model;

/**
 * Created by Rijad on 18.08.2014.
 */
public class Member {
    private String name;
    private String vorname;
    private int memberSince;
    private int payment;

    public Member(String name, String vorname, int memberSince, int payment) {
    	this.name = name;
    	this.vorname = vorname;
    	this.memberSince = memberSince;
    	this.payment = payment;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(int memberSince) {
		this.memberSince = memberSince;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
    
    
}