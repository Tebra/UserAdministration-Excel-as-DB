package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Handles the New Member creation window.
 * <p/>
 * Created by Rijad on 15.06.2014.
 */

public class NewMember extends JDialog {

	ButtonGroup group;
	private JTextField name, surname, telephone, email, zip, state, payment;
	private JButton acceptButton, declineButton, searchButton;
	private JTextField searchTextField, msgField;
	private JPanel center, east;
	private JMenuBar menuBar;
	private JPanel centerOben, eastOben, eastUnten, emptyPanel;
	private JRadioButton monthly, quartaly, yearly;

	public NewMember(JFrame parent) {
		super(parent, "Novi \u010clan", false);

		emptyPanel = new JPanel();
		menuBar = new JMenuBar();

		name = new JTextField();
		surname = new JTextField();
		telephone = new JTextField();
		zip = new JTextField();
		state = new JTextField();
		payment = new JTextField();
		email = new JTextField();
		searchTextField = new JTextField();
		msgField = new JTextField();

		acceptButton = new JButton("Potvrditi");
		declineButton = new JButton("Resetovati");
		searchButton = new JButton("Tra\u071ei");

		monthly = new JRadioButton("Mjesecno");
		monthly.setSelected(true);
		quartaly = new JRadioButton("Kvartalno");
		yearly = new JRadioButton("Godisnje");

		group = new ButtonGroup();
		group.add(monthly);
		group.add(quartaly);
		group.add(yearly);

		createWindow();
		createItems();
	}

	public void createWindow() {

		Container conPane = getContentPane();
		conPane.setLayout(new BorderLayout());

		JMenu menu = new JMenu("Hilfe");
		menuBar.add(menu);

		JMenuItem hilfe = new JMenuItem("Hilfe");
		menu.add(hilfe);
		// .............................................//

		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBorder(BorderFactory.createTitledBorder("Unos Podataka: "));

		centerOben = new JPanel();
		centerOben.setLayout(new GridLayout(8, 1, 0, 5));

		center.add(centerOben, BorderLayout.NORTH); // Center Fertig
		// .............................................//

		east = new JPanel();
		east.setLayout(new BorderLayout());
		east.setPreferredSize(new Dimension(180, 80));
		east.setBorder(BorderFactory.createTitledBorder("Dodatno: "));

		eastOben = new JPanel();
		eastOben.setLayout(new GridLayout(5, 1, 20, 0));

		eastUnten = new JPanel();
		eastUnten.setLayout(new GridLayout(1, 2, 0, 5));

		east.add(eastOben, BorderLayout.NORTH);
		east.add(eastUnten, BorderLayout.SOUTH); // Osten fertig
		// .............................................//

		conPane.add(center, BorderLayout.CENTER);
		conPane.add(east, BorderLayout.EAST); // Eingabe in Content Pane

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setJMenuBar(menuBar);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(500, 480); // Fenster zeichnen
	}

	public void createItems() {

		ghostTexter();
		JLabel membershipPayment = new JLabel("Mjese\u010dna \u010clanarina:");

		centerOben.add(name);
		centerOben.add(surname);
		centerOben.add(telephone);
		centerOben.add(email);
		centerOben.add(zip);
		centerOben.add(state);

		eastOben.add(membershipPayment);
		eastOben.add(payment);
		eastOben.add(monthly);
		eastOben.add(quartaly);
		eastOben.add(yearly);

		eastUnten.add(acceptButton);
		eastUnten.add(declineButton);

		declineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				name.setText("");
				surname.setText("");
				telephone.setText("");
				email.setText("");
				zip.setText("");
				state.setText("");

				ghostTexter();
			}
		});
	}

	private void ghostTexter() {

		new GhostText(name, "Ime");
		new GhostText(surname, "Prezime");
		new GhostText(telephone, "Telefon/Mobilni");
		new GhostText(email, "E-Mail");
		new GhostText(zip, "PLZ");
		new GhostText(state, "Ort");
		new GhostText(payment, "min. 30.- CHF");
	}
}
