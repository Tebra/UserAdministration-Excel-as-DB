package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConsolePanel extends JPanel {

	private JTextField msgField;
	
	public ConsolePanel() {
		
		msgField = new JTextField();
		msgField.setEditable(false);
		
		setLayout(new BorderLayout());
		add(msgField, BorderLayout.CENTER);
	}
	
}
