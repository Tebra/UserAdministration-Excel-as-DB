package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Member;
import model.TableModel;

public class TablePanel extends JPanel {

	public JTable table;
	private JScrollPane scroller;
	private TableModel tableModel;

	public TablePanel() {
		setLayout(new BorderLayout());
		
		tableModel = new TableModel();

		//Disabling editing content
		table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table.setFillsViewportHeight(true);
		table.setModel(tableModel);

		scroller = new JScrollPane(table);
		add(scroller, BorderLayout.CENTER);
	}

	public void setData(List<Member> db)
	{
		tableModel.setData(db);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}

}
