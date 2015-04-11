package galv.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import galv.mainPck.PrincipalJFrame;
import galv.voiture.ListeVoituresFrame;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ClientMenu extends JMenu {

	private JMenuItem listClients;
	private ListeClientsFrame listeClientsFrame;
	private JDesktopPane desktopPane;

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
		this.desktopPane = PrincipalJFrame.getDesktopPane();
		listClients = new JMenuItem("List Clients");
		this.add(listClients);
		init();
	}

	public void init() {
		listClients.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				listeClientsFrame = new ListeClientsFrame();
				desktopPane.add(listeClientsFrame);
				listeClientsFrame.setLocation(
						(PrincipalJFrame.width - listeClientsFrame.getWidth()) / 2,
						(PrincipalJFrame.height - listeClientsFrame.getHeight()) / 2);
				listeClientsFrame.setVisible(true);
				listeClientsFrame.toFront();
			}
		});
	}

	public JMenuItem getListClients() {
		return listClients;
	}

	public void setListClients(JMenuItem listClients) {
		this.listClients = listClients;
	}

	public ListeClientsFrame getListeClientsFrame() {
		return listeClientsFrame;
	}

	public void setListeClientsFrame(ListeClientsFrame listeClientsFrame) {
		this.listeClientsFrame = listeClientsFrame;
	}

}
