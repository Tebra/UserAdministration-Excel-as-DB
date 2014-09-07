package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConsoleThing extends JPanel {

	private JTextField msgField;
	
	public ConsoleThing() {
		
		msgField = new JTextField();
		
		setLayout(new BorderLayout());
		add(msgField, BorderLayout.CENTER);
	}
	
}
