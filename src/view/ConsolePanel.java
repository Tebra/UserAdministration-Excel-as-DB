package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConsolePanel extends JPanel {

	public JTextField msgField;
	
	public ConsolePanel() {
		
		msgField = new JTextField();
		msgField.setEditable(false);
		msgField.setHorizontalAlignment(JTextField.RIGHT);
		
		setLayout(new BorderLayout());
		add(msgField, BorderLayout.CENTER);
	}
	
}
