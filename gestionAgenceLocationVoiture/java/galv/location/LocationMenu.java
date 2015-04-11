package galv.location;

import galv.mainPck.PrincipalJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LocationMenu extends JMenu {

	private JMenuItem listLocations;
	private ListeLocationsFrame listeLocationsFrame;
	private JDesktopPane desktopPane;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LocationMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationMenu(String s) {
		super(s);
		this.desktopPane = PrincipalJFrame.getDesktopPane();
		listLocations = new JMenuItem("List Voiture");
		this.add(listLocations);
		init();
	}

	public void init() {
		listLocations.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				listeLocationsFrame = new ListeLocationsFrame();
				desktopPane.add(listeLocationsFrame);
				listeLocationsFrame.setLocation((PrincipalJFrame.width - listeLocationsFrame.getWidth()) / 2,
						(PrincipalJFrame.height - listeLocationsFrame.getHeight()) / 2);				
				listeLocationsFrame.setVisible(true);
				listeLocationsFrame.toFront();
			}
		});
	}


	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

}
