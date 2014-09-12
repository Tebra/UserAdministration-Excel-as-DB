package view;

import java.util.EventListener;

public interface TablePanelListener extends EventListener {
	
	public void tableEventOccured(TableEvent e);

}
