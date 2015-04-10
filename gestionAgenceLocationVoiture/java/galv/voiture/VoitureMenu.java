package galv.voiture;

import galv.mainPck.PrincipalJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VoitureMenu extends JMenu {

	private JMenuItem listVoitures;
	private ListeVoituresFrame listeVoituresFrame;
	private JDesktopPane desktopPane;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VoitureMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoitureMenu(String s) {
		super(s);
		this.desktopPane = PrincipalJFrame.getDesktopPane();
		listVoitures = new JMenuItem("List Voiture");
		this.add(listVoitures);
		init();
	}

	public void init() {
		listVoitures.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				listeVoituresFrame = new ListeVoituresFrame();
				desktopPane.add(listeVoituresFrame);
				listeVoituresFrame.setLocation((PrincipalJFrame.width - listeVoituresFrame.getWidth()) / 2,
						(PrincipalJFrame.height - listeVoituresFrame.getHeight()) / 2);				
				listeVoituresFrame.setVisible(true);
				listeVoituresFrame.toFront();
			}
		});
	}

	public JMenuItem getListVoitures() {
		return listVoitures;
	}

	public void setListVoitures(JMenuItem listVoitures) {
		this.listVoitures = listVoitures;
	}

	public ListeVoituresFrame getListeVoituresFrame() {
		return listeVoituresFrame;
	}

	public void setListeVoituresFrame(ListeVoituresFrame listeVoituresFrame) {
		this.listeVoituresFrame = listeVoituresFrame;
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

}
