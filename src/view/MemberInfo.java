package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Showing all Personal information with payments etc.
 * <p/>
 * Created by Rijad on 26.07.2014.
 */
public class MemberInfo extends JPanel {

    public JButton acceptButton, closeButton, searchButton;
    private JTextField vorname, nachname, telefon, email, zip, platz, pare;
    private JPanel centerOben, eastOben, eastUnten;
    private JRadioButton monthly, quartaly, yearly;

    public MemberInfo() {

        vorname = new JTextField();
        nachname = new JTextField();
        telefon = new JTextField();
        zip = new JTextField();
        platz = new JTextField();
        pare = new JTextField();
        email = new JTextField();

        acceptButton = new JButton("Potvrditi");
        closeButton = new JButton("Resetovati");
        searchButton = new JButton("Tra\u071ei");

        monthly = new JRadioButton("Mjesecno");
        quartaly = new JRadioButton("Kvartalno");
        yearly = new JRadioButton("Godisnje");

        createWindow();
        createItems();
    }

    public void createWindow() {

        setLayout(new BorderLayout());
        //.............................................//
        JPanel center;
        center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBorder(BorderFactory.createTitledBorder("Unos Podataka: "));

        centerOben = new JPanel();
        centerOben.setLayout(new GridLayout(8, 1, 0, 5));

        center.add(centerOben, BorderLayout.NORTH);                                    //Center Fertig
        //.............................................//

        JPanel east;
        east = new JPanel();
        east.setLayout(new BorderLayout());
        //east.setPreferredSize(new Dimension(180, 80));
        east.setBorder(BorderFactory.createTitledBorder("Dodatno: "));

        eastOben = new JPanel();
        eastOben.setLayout(new GridLayout(5, 1, 20, 0));

        eastUnten = new JPanel();
        eastUnten.setLayout(new GridLayout(1, 2, 0, 5));

        east.add(eastOben, BorderLayout.NORTH);
        east.add(eastUnten, BorderLayout.SOUTH);                                      //Osten fertig
        //.............................................//

        add(center, BorderLayout.CENTER);
        add(east, BorderLayout.EAST);                                         //Eingabe in Content Pane


        /*tabi.setVisible(true);
        tabi.setSize(500, 480); */                                                   //Fenster zeichnen
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
        eastUnten.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*vorname.setText("");
                nachname.setText("");
                telefon.setText("");
                email.setText("");
                zip.setText("");
                platz.setText("");

                ghostTexter();*/

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

