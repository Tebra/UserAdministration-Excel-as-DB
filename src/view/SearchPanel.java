package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchPanel extends JPanel {

	public JTextArea textArea;
	public JTextField searchTextField, msgField;
	public  JButton acceptButton, declineButton, searchButton;

	public SearchPanel() {
		textArea = new JTextArea();
		acceptButton = new JButton("Pristupnica");
		declineButton = new JButton("Odbiti");
		searchButton = new JButton("Tra\u017ei");
		searchTextField = new JTextField();
		msgField = new JTextField();
		msgField.setEditable(false);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(150, 450));
		setBorder(BorderFactory.createTitledBorder("Unos Podataka"));

		JPanel westSearch = new JPanel();
		JPanel westMember = new JPanel();

		westSearch.setLayout(new GridLayout(3, 0, 200, 0));
		westSearch.setPreferredSize(new Dimension(130, 80));
		westMember.setLayout(new GridLayout(3, 0));
		westMember.setPreferredSize(new Dimension(130, 80));

		// --------------- Leeres Label für Anpassung--------------//
		JLabel leer = new JLabel("                        ");
		// --------------------------------------------------------//
		
		westSearch.add(new JLabel("Pretraga"));
		westSearch.add(searchTextField);
		westSearch.add(searchButton);
		
		westMember.add(new JLabel("Novi Član"));
		westMember.add(acceptButton);
		
		add(westSearch);
		add(leer);
		add(westMember);
		
		
	}
	
}
