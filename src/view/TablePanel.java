package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;

public class TablePanel extends JPanel {

	public JTable table;
	private JScrollPane scroller;
	private int tabCounter = 0;

	public TablePanel() {
		setLayout(new BorderLayout());

		// --------------------- Test Teil ------------------------//

		String[] columns = { "Ime", "Prezime", "Član od", "Članarina" };
		Object[][] data = { { "Rijad", "Zuzo", 2009, 30 },
				{ "Zijad", "Zuzo", 2008, 100 } };
		/**
		 * Disable direct editing Table content.
		 */
		table = new JTable(data, columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.setFillsViewportHeight(true);

		scroller = new JScrollPane(table);
		add(scroller, BorderLayout.CENTER);
	}

}
