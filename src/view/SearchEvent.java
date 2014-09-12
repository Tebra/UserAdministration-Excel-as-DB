package view;

import java.util.EventObject;

public class SearchEvent extends EventObject{

	String tragati;
	
	public SearchEvent(Object source) {
		super(source);
	}
	
	public SearchEvent(Object source, String tragati) {
		super(source);
		
		this.tragati = tragati;
	}

	public String getTragati() {
		return tragati;
	}

	public void setTragati(String tragati) {
		this.tragati = tragati;
	}

	
	
}
