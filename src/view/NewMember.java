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

public class NewMember {

    ButtonGroup group;
    private JFrame frame;
    private JTextField vorname, nachname, telefon, email, zip, platz, pare;
    private JButton acceptButton, declineButton, searchButton;
    private JTextField searchTextField, msgField;
    private JPanel center, east;
    private JMenuBar menuBar;
    private JPanel centerOben, centerUnten, eastOben, eastUnten, leerP, p1, p2, p3;
    private JRadioButton monthly, quartaly, yearly;

    public NewMember() {

        frame = new JFrame("Novi Član");
        leerP = new JPanel();
        menuBar = new JMenuBar();

        vorname = new JTextField();
        nachname = new JTextField();
        telefon = new JTextField();
        zip = new JTextField();
        platz = new JTextField();
        pare = new JTextField();
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

        Container conPane = frame.getContentPane();
        conPane.setLayout(new BorderLayout());

        JMenu menu = new JMenu("Hilfe");
        menuBar.add(menu);

        JMenuItem hilfe = new JMenuItem("Hilfe");
        menu.add(hilfe);
        //.............................................//

        center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBorder(BorderFactory.createTitledBorder("Unos Podataka: "));

        centerOben = new JPanel();
        centerOben.setLayout(new GridLayout(8, 1, 0, 5));

        center.add(centerOben, BorderLayout.NORTH);                                    //Center Fertig
        //.............................................//

        east = new JPanel();
        east.setLayout(new BorderLayout());
        east.setPreferredSize(new Dimension(180, 80));
        east.setBorder(BorderFactory.createTitledBorder("Dodatno: "));

        eastOben = new JPanel();
        eastOben.setLayout(new GridLayout(5, 1, 20, 0));

        eastUnten = new JPanel();
        eastUnten.setLayout(new GridLayout(1, 2, 0, 5));

        east.add(eastOben, BorderLayout.NORTH);
        east.add(eastUnten, BorderLayout.SOUTH);                                      //Osten fertig
        //.............................................//

        conPane.add(center, BorderLayout.CENTER);
        conPane.add(east, BorderLayout.EAST);                                       //Eingabe in Content Pane

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500, 480);                                                    //Fenster zeichnen
    }

    public void createItems() {

        ghostTexter();
        JLabel clanarina = new JLabel("Mjese\u010dna \u010clanarina:");

        centerOben.add(vorname);
        centerOben.add(nachname);
        centerOben.add(telefon);
        centerOben.add(email);
        centerOben.add(zip);
        centerOben.add(platz);

        eastOben.add(clanarina);
        eastOben.add(pare);
        eastOben.add(monthly);
        eastOben.add(quartaly);
        eastOben.add(yearly);

        eastUnten.add(acceptButton);
        eastUnten.add(declineButton);

        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vorname.setText("");
                nachname.setText("");
                telefon.setText("");
                email.setText("");
                zip.setText("");
                platz.setText("");

                ghostTexter();
            }
        });
    }

    private void ghostTexter() {

        // Nicht wichtig //
        GhostText ime = new GhostText(vorname, "Ime");
        GhostText prezime = new GhostText(nachname, "Prezime");
        GhostText mobilni = new GhostText(telefon, "Telefon/Mobilni");
        GhostText mail = new GhostText(email, "E-Mail");
        GhostText broj = new GhostText(zip, "PLZ");
        GhostText mjesto = new GhostText(platz, "Ort");
        GhostText clanpare = new GhostText(pare, "min. 30.- CHF");
        //.......................................................//
    }
}

