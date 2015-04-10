package galv.mainPck;

import static galv.utilities.YapsUIConstants.DEFAULT_BG_COLOR;
import galv.client.ClientMenu;
import galv.location.LocationMenu;
import galv.voiture.VoitureMenu;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

public class PrincipalJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int defaultWidth;
	private int defaultHeight;

	public static int width;
	public static int height;

	private JMenuBar appMenuBar;
	private ClientMenu clientMenu;
	private VoitureMenu voitureMenu;
	private LocationMenu locationMenu;
	
	private static final JDesktopPane desktopPane = new JDesktopPane();
	
	private static final String BACKGROUND_IMAGE_NAME = "images/rent_a_car.jpg";
	
	public static int onglet = JTabbedPane.LEFT;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrincipalJFrame principalJFrame = new PrincipalJFrame();
		principalJFrame.setVisible(true);
	}

	public PrincipalJFrame() throws HeadlessException {
		super();
		this.init();
	}

	/**************************************************************/
	/************************** Methods ***************************/
	/**************************************************************/

	public void init() {
		
		defaultWidth = 640;
		defaultHeight = 480;
		width = defaultWidth;
		height = defaultHeight;
		
		this.setTitle("Gestion Agence Location Voiture");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		desktopPane.setBackground(DEFAULT_BG_COLOR);
		URL resource = this.getClass().getClassLoader().getResource(BACKGROUND_IMAGE_NAME);
		Image img = null;
		try {
			img = ImageIO.read(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon imgIcon = new ImageIcon(img);
		final JLabel backgroundLabel = new JLabel(imgIcon,JLabel.CENTER);
		backgroundLabel.setSize(width, height);
		desktopPane.add(backgroundLabel);
		desktopPane.addComponentListener(new ComponentAdapter() {

			public void componentResized(ComponentEvent arg0) {
				width = (int) desktopPane.getSize().getWidth();
				height = (int) desktopPane.getSize().getHeight();

				backgroundLabel.setSize(width, height);
			}

		});
		getContentPane().add(desktopPane);

		appMenuBar = new JMenuBar();
		clientMenu = new ClientMenu("Client");
		voitureMenu = new VoitureMenu("Voiture");
		locationMenu = new LocationMenu("Location");
		appMenuBar.add(clientMenu);
		appMenuBar.add(voitureMenu);
		appMenuBar.add(locationMenu);

		this.setJMenuBar(appMenuBar);
//		desktopPane.add(voitureMenu.getListVoitures());
//		getContentPane().add(desktopPane);
		

		
	}

	public void addMenus() {

	}

	/**************************************************************/
	/**************** Getters & Setters ***************************/
	/**************************************************************/

	public JMenuBar getAppMenuBar() {
		return appMenuBar;
	}

	public void setAppMenuBar(JMenuBar appMenuBar) {
		this.appMenuBar = appMenuBar;
	}

	public ClientMenu getClientMenu() {
		return clientMenu;
	}

	public void setClientMenu(ClientMenu clientMenu) {
		this.clientMenu = clientMenu;
	}

	public VoitureMenu getVoitureMenu() {
		return voitureMenu;
	}

	public void setVoitureMenu(VoitureMenu voitureMenu) {
		this.voitureMenu = voitureMenu;
	}

	public LocationMenu getLocationMenu() {
		return locationMenu;
	}

	public void setLocationMenu(LocationMenu locationMenu) {
		this.locationMenu = locationMenu;
	}

	
	public void addAndShowFrame(JInternalFrame frame) {
		desktopPane.add(frame);
		frame.setLocation((width - frame.getWidth()) / 2,
				(height - frame.getHeight()) / 2);
		//frame.setVisible(true);
	}

	public static JDesktopPane getDesktopPane() {
		return desktopPane;
	}

}
