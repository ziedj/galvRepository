package galv.client;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ClientMenu extends JMenu {

	private JMenuItem listClientsItem;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientMenu(String s) {
		super(s);
		listClientsItem = new JMenuItem("List Clients");
		this.add(listClientsItem);
	}

	public JMenuItem getListClientsItem() {
		return listClientsItem;
	}

	public void setListClientsItem(JMenuItem listClientsItem) {
		this.listClientsItem = listClientsItem;
	}

}
