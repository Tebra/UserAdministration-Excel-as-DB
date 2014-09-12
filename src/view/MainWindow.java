package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.TableModel;
import data.ExcellDriver;

/**
 * Administracioni program za Medzlis Islamske Zajednicde Gazi Husrev-beg
 * <p/>
 * Created by Rijad Zuzo on 15.06.2014.
 */
public class MainWindow {

	public static String user;
	private JFrame frame;
	private JPanel tab2;
	private JTabbedPane tabHolder;
	private JComponent tab1;
	private JButton closer;
	private int tabCounter = 0;
	private TablePanel tablePanel;
	private SearchPanel searchPanel;
	private ConsolePanel consoleMsg;

	public MainWindow() {

		frame = new JFrame("Medzlis Gazi Husrev-beg St. Gallen | Administracija");
		tabHolder = new JTabbedPane();
		tab1 = new JPanel();
		tab2 = new JPanel();
		tablePanel = new TablePanel();
		searchPanel = new SearchPanel();
		consoleMsg = new ConsolePanel();
	}

	public void createEverything() {

		MainWindow mainWindow = new MainWindow();
		mainWindow.createWindow();
		mainWindow.createAndHandleItems();

		try {
			ExcellDriver.getConnection();
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Success");

	}

	public void createWindow() {

		ImageIcon frameIcon;
		frameIcon = new ImageIcon(
				"C:\\Users\\Rijad\\workspace\\projekt.rijad.ch\\trunk\\icon.png");
		frame.setIconImage(frameIcon.getImage());

		Container contentPane;
		contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JPanel west;
		west = new JPanel();
		west.setPreferredSize(new Dimension(150, 450));
		west.setLayout(new FlowLayout(FlowLayout.LEFT));
		west.setBorder(BorderFactory.createTitledBorder("Unos Podataka"));

		tab2.setLayout(new BorderLayout());
		tab1.setLayout(new BorderLayout());
		tabHolder.addTab("Pronadjeno: ", tab1);

		// ----------------------- --------------------------------//

		JPanel center;
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBorder(BorderFactory.createTitledBorder("Podatci:"));
		center.add(tabHolder);

		// ----------------------- --------------------------------//

		contentPane.add(searchPanel, BorderLayout.WEST);
		contentPane.add(center, BorderLayout.CENTER);
		contentPane.add(consoleMsg, BorderLayout.SOUTH);

		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		frame.setJMenuBar(createMenu());
		frame.pack();
		frame.setSize(800, 600);
		frame.setResizable(false);
		// frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createAndHandleItems() {

		tab1.add(tablePanel, BorderLayout.CENTER);

		searchPanel.searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String person = searchPanel.searchTextField.getText();
				try {
					tablePanel.setData(ExcellDriver.searchDatabase(person));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Hallooooo geht nicht");
					e1.printStackTrace();
				}
				tablePanel.refresh();
			}
		});

		searchPanel.searchTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String person = searchPanel.searchTextField.getText();
				try {
					tablePanel.setData(ExcellDriver.searchDatabase(person));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Hallooooo geht nicht");
					e1.printStackTrace();
				}
				tablePanel.refresh();
			}
		}); // Bis hier. TextField ActionListener reagiert nur bei ENTER druck.

		searchPanel.acceptButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NewMember newMember;
				newMember = new NewMember();

				searchPanel.acceptButton.setEnabled(false);
				KeyboardFocusManager.getCurrentKeyboardFocusManager()
						.clearGlobalFocusOwner();
			}
		});

		searchPanel.declineButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				searchPanel.textArea.setText("");
				KeyboardFocusManager.getCurrentKeyboardFocusManager()
						.clearGlobalFocusOwner();
			}
		});

		ImageIcon icon = new ImageIcon(
				"C:\\Users\\Rijad\\workspace\\projekt.rijad.ch\\trunk\\close.png");
		// closer = new JButton("<html><font color='red'>X</font></html>");
		closer = new JButton();
		closer.setIcon(icon);

		closer.setHorizontalAlignment(SwingConstants.CENTER);
		closer.setPreferredSize(new Dimension(18, 20));

		closer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				tab2.removeAll();
				tabHolder.removeTabAt(1);
				// Because there is only one tab allowed, on tab closing the
				// counter is reset.
				tabCounter = 0;
				KeyboardFocusManager.getCurrentKeyboardFocusManager()
						.clearGlobalFocusOwner();
			}
		});

		tablePanel.table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {

						if (!event.getValueIsAdjusting() && tabCounter == 0) {

							user = tablePanel.table.getValueAt(
									tablePanel.table.getSelectedRow(), 0)
									.toString();
							ExcellDriver treiber = new ExcellDriver();

							tab2.add(new MemberInfo(), BorderLayout.CENTER);
							tabHolder.addTab("Informacije:  ", tab2);

							// For the Tab Header - A JPanel Containing a Label
							// and a closing Button.
							// Button behavior coded in createAndHandleItems()*.
							JPanel tabHead = new JPanel();
							tabHead.setLayout(new FlowLayout(FlowLayout.LEFT,
									0, 0));

							JLabel label = new JLabel("Informacije: ");
							label.setBorder(BorderFactory.createEmptyBorder(0,
									0, 0, 7));

							tabHead.add(label);
							tabHead.add(closer);
							tabHolder.setTabComponentAt(1, tabHead);

							// Only one tab can be active.
							tabCounter++;

							tabHolder.setSelectedIndex(tabCounter);
							// System.out.println(table.getValueAt(table.getSelectedRow(),
							// 0).toString());

							KeyboardFocusManager
									.getCurrentKeyboardFocusManager()
									.clearGlobalFocusOwner();
						}
					}

				});
	}

	public JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu menu;
		menu = new JMenu("Hilfe");
		menuBar.add(menu);

		JMenuItem help;
		help = new JMenuItem("Excel uvezati");
		menu.add(help);

		return menuBar;
	}

	// Class End
}
