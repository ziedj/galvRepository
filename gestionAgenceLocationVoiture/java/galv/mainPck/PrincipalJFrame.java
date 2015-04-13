package galv.mainPck;

import static galv.utilities.YapsUIConstants.DEFAULT_BG_COLOR;
import static galv.utilities.YapsViewType.CREATE;
import galv.client.ClientFrame;
import galv.client.ClientMenu;
import galv.entities.Client;
import galv.entities.Location;
import galv.entities.Voiture;
import galv.location.LocationFrame;
import galv.location.LocationMenu;
import galv.voiture.VoitureFrame;
import galv.voiture.VoitureMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PrincipalJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int defaultWidth;
	private int defaultHeight;

	public static int width;
	public static int height;

	private JToolBar appToolBar;
	private JMenuBar appMenuBar;
	private ClientMenu clientMenu;
	private VoitureMenu voitureMenu;
	private LocationMenu locationMenu;

	private GridBagLayout applayout = new GridBagLayout();
	GridBagConstraints applayoutConstraints = new GridBagConstraints();

	// toolBar button
	JButton ajoutVoiture;
	JButton ajoutClient;
	JButton ajoutLocation;

	//
	
	///
	private JMenu menuLookAndFeel = new JMenu();
	private JMenuItem menuItemMetal = new JMenuItem();
	private JMenuItem menuItemMotif = new JMenuItem();
	private JMenuItem menuItemWindows = new JMenuItem();
	
	private JMenu menuFile = new JMenu();
	private JMenuItem menuItemExit = new JMenuItem();
	
	///

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
		ImageIcon imgIcon = getIcon(BACKGROUND_IMAGE_NAME);
		final JLabel backgroundLabel = new JLabel(imgIcon, JLabel.CENTER);
		backgroundLabel.setSize(width, height);
		desktopPane.add(backgroundLabel);
		desktopPane.addComponentListener(new ComponentAdapter() {

			public void componentResized(ComponentEvent arg0) {
				width = (int) desktopPane.getSize().getWidth();
				height = (int) desktopPane.getSize().getHeight();

				backgroundLabel.setSize(width, height);
			}

		});
		// getContentPane().add(desktopPane, BorderLayout.CENTER);

		appMenuBar = new JMenuBar();
		clientMenu = new ClientMenu("Client");
		voitureMenu = new VoitureMenu("Voiture");
		locationMenu = new LocationMenu("Location");
		
		////
		/**
		 * Menu File
		 */
		menuFile.setText("File");
		menuItemExit.setText("Exit");
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				menuItemExitActionPerformed();
			}
		});
		menuFile.add(menuItemExit);
		appMenuBar.add(menuFile);
		
		
		/**
		 * Menu Look & Feel
		 */
		menuLookAndFeel.setText("Look&Feel");

		menuItemMetal.setText("Metal");
		menuItemMetal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				menuItemMetalActionPerformed();
			}
		});
		menuLookAndFeel.add(menuItemMetal);
		menuItemMotif.setText("Motif");
		menuItemMotif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				menuItemMotifActionPerformed();
			}
		});
		menuLookAndFeel.add(menuItemMotif);
		menuItemWindows.setText("Windows");
		menuItemWindows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				menuItemWindowsActionPerformed();
			}
		});
		menuLookAndFeel.add(menuItemWindows);

		///
		appMenuBar.add(clientMenu);
		appMenuBar.add(voitureMenu);
		appMenuBar.add(locationMenu);
		appMenuBar.add(menuLookAndFeel);		
		// appMenuBar.setBorder(BorderFactory.createEtchedBorder());

		this.setJMenuBar(appMenuBar);

		setLayout(applayout);

		initToolBar();

		applayoutConstraints.fill = GridBagConstraints.BOTH;
		applayoutConstraints.gridx = 0;
		applayoutConstraints.gridy = 2;
		applayoutConstraints.weightx = 1.0;
		applayoutConstraints.weighty = 1.0;
		getContentPane().add(desktopPane, applayoutConstraints);
	}

	public void initToolBar() {
		JSeparator north = new JSeparator(JSeparator.HORIZONTAL);
		applayoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		applayoutConstraints.gridx = 0;
		applayoutConstraints.gridy = 0;
		applayoutConstraints.weightx = 1.0;
		this.getContentPane().add(north, applayoutConstraints);
		appToolBar = new JToolBar();
		appToolBar.setOpaque(false);
		appToolBar.setFloatable(false);
		// appToolBar.setBorder(BorderFactory.createEtchedBorder());

		ajoutClient = new JButton(getIcon("images/client.jpg"));
		ajoutClient.setBackground(Color.white);
		ajoutVoiture = new JButton(getIcon("images/voiture.jpg"));
		ajoutVoiture.setBackground(Color.white);
		ajoutVoiture.setToolTipText("Ajouter une voiture");
		ajoutLocation = new JButton(getIcon("images/location.png"));
		ajoutLocation.setBackground(Color.white);
		ajoutLocation.setToolTipText("Ajouter une Location");

		appToolBar.add(ajoutVoiture);
		appToolBar.addSeparator();
		appToolBar.add(ajoutClient);
		appToolBar.addSeparator();
		appToolBar.add(ajoutLocation);
		ajoutClient.setToolTipText("Ajouter un Client");

		applayoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		applayoutConstraints.gridx = 0;
		applayoutConstraints.gridy = 1;
		applayoutConstraints.weightx = 1.0;
		this.getContentPane().add(appToolBar, applayoutConstraints);
		
		// action listner
		ajoutVoiture.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Voiture voiture = new Voiture();
				VoitureFrame frame = new VoitureFrame(voiture, CREATE);
				desktopPane.add(frame);
				frame.setLocation((PrincipalJFrame.width - frame.getWidth()) / 2,
						(PrincipalJFrame.height - frame.getHeight()) / 2);
				frame.setVisible(true);
				frame.toFront();
				frame.setParentFrame(null);
				
			}
		});
		ajoutClient.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Client client = new Client();
				ClientFrame frame = new ClientFrame(client, CREATE);
				desktopPane.add(frame);
				frame.setLocation((PrincipalJFrame.width - frame.getWidth()) / 2,
						(PrincipalJFrame.height - frame.getHeight()) / 2);
				frame.setVisible(true);
				frame.toFront();
				frame.setParentFrame(null);				
			}
		});
		ajoutLocation.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Location location = new Location();
				LocationFrame frame = new LocationFrame(location, CREATE);
				desktopPane.add(frame);
				frame.setLocation((PrincipalJFrame.width - frame.getWidth()) / 2,
						(PrincipalJFrame.height - frame.getHeight()) / 2);
				frame.setVisible(true);
				frame.toFront();
				frame.setParentFrame(null);				
			}
		});		
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
		// frame.setVisible(true);
	}

	public static JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public JToolBar getAppToolBar() {
		return appToolBar;
	}

	public void setAppToolBar(JToolBar appToolBar) {
		this.appToolBar = appToolBar;
	}

	public ImageIcon getIcon(String image) {
		URL resource = this.getClass().getClassLoader().getResource(image);
		Image img = null;
		try {
			img = ImageIO.read(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon imgIcon = new ImageIcon(img);
		return imgIcon;
	}
	
	////////////////////
	
	// Clicking on the 'Motif' menu changes the look and feel of the application
	private void menuItemMotifActionPerformed() {
		final String mname = "menuItemMotifActionPerformed";

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			// logger.throwing(className, mname, e);
		}
	}

	// Clicking on the 'Metal' menu changes the look and feel of the application
	private void menuItemMetalActionPerformed() {
		final String mname = "menuItemMetalActionPerformed";

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			// logger.throwing(className, mname, e);
		}
	}

	// Clicking on the 'Windows' menu changes the look and feel of the
	// application
	private void menuItemWindowsActionPerformed() {
		final String mname = "menuItemWindowsActionPerformed";

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			// logger.throwing(className, mname, e);
		}
	}

	/**
	 * This method exits the application
	 */
	private void menuItemExitActionPerformed() {
		dispose();
	}
	
	///////////////////
}
