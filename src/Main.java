import view.*;

import javax.swing.*;

/**
 * Created by Rijad on 20.08.2014.
 */
public class Main {

    /**
     * Entry point for the whole Programm
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        final MainWindow mainWindow = new MainWindow();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainWindow.createEverything();
            }
        });
    }
}
