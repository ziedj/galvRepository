package galv.client;

import static galv.utilities.YapsUIConstants.DEFAULT_BG_COLOR;
import static galv.utilities.YapsViewType.CREATE;
import static galv.utilities.YapsViewType.DELETE;
import static galv.utilities.YapsViewType.FIND;
import static galv.utilities.YapsViewType.FIND_OR_CREATE;
import static galv.utilities.YapsViewType.READ;
import static galv.utilities.YapsViewType.UPDATE;
import static galv.utilities.YapsViewType.UPDATE_OR_DELETE;
import galv.crud.ClientCRUD;
import galv.entities.Client;
import galv.utilities.YapsViewType;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ClientFrame extends JInternalFrame {

	private static final long serialVersionUID = -1175876732476090807L;
	private ClientPane mainPane;
	private Client client;
	private JPanel actionPane;
	private YapsViewType viewType;

	private ListeClientsFrame parentFrame;

	//
	private JButton findBt;
	private JButton createBt;
	private JButton readBt;
	private JButton updateBt;
	private JButton deleteBt;
	private JButton resetBt;
	private JButton closeBt;

	//

	public ClientFrame(Client client, YapsViewType viewType) {
		this.client = client;
		this.viewType = viewType;
		this.mainPane = new ClientPane(client, viewType);
		actionPane = new JPanel();

		setSize(600, 300);
		setTitle("Liste des vehicules");
		// setLocationRelativeTo(null);
		initFrame();
		this.setVisible(true);
		initViewType(viewType);
	}

	public void initFrame() {
		JPanel globalPane = new JPanel();
		globalPane.setLayout(new BorderLayout());

		JPanel mainBodyPane = new JPanel();
		mainBodyPane.setLayout(new BorderLayout());
		mainBodyPane.setBorder(BorderFactory.createLineBorder(Color.white, 10));

		JPanel mainBorderedPane = new JPanel();
		mainBorderedPane.setBackground(DEFAULT_BG_COLOR);
		mainBorderedPane.setBorder(BorderFactory.createEtchedBorder());
		mainBorderedPane.setLayout(new BorderLayout());

		// JScrollPane scrollPane = new JScrollPane(table);
		mainPane.setBackground(DEFAULT_BG_COLOR);
		mainBorderedPane.add(mainPane, BorderLayout.CENTER);

		mainBodyPane.add(mainBorderedPane, BorderLayout.CENTER);
		globalPane.add(mainBodyPane, BorderLayout.CENTER);

		initComponent();

		JPanel actionBodyPane = new JPanel();
		actionBodyPane.setLayout(new BorderLayout());
		actionBodyPane.setBorder(BorderFactory
				.createLineBorder(Color.white, 10));
		actionBodyPane.add(actionPane, BorderLayout.SOUTH);

		globalPane.add(actionBodyPane, BorderLayout.SOUTH);

		getContentPane().add(globalPane);

	}

	private void initComponent() {
		findBt = new JButton("Find");
		createBt = new JButton("Create");
		readBt = new JButton("View");
		updateBt = new JButton("Update");
		deleteBt = new JButton("Delete");
		resetBt = new JButton("Reset");
		closeBt = new JButton("Close");

		// this.viewType = READ;
		// initViewType();

		actionPane.setLayout(new BorderLayout());
		actionPane.setBorder(BorderFactory.createEtchedBorder());
		actionPane.setOpaque(false);

		JPanel leftPane = new JPanel();
		JPanel centerPane = new JPanel();
		JPanel rightPane = new JPanel();

		leftPane.setOpaque(false);
		leftPane.add(findBt);
		actionPane.add(leftPane, BorderLayout.WEST);

		centerPane.setOpaque(false);
		centerPane.add(createBt);
		centerPane.add(readBt);
		centerPane.add(updateBt);
		centerPane.add(deleteBt);
		actionPane.add(centerPane, BorderLayout.CENTER);

		rightPane.setOpaque(false);
		rightPane.add(resetBt);
		rightPane.add(closeBt);
		actionPane.add(rightPane, BorderLayout.EAST);

		findBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!mainPane.getClient().getCin().isEmpty()) {
					client = ClientCRUD.findClient(mainPane.getClient()
							.getCin());
				}

				if (client == null) {
					JOptionPane.showMessageDialog(mainPane, "tt", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					mainPane.setClient(client);
					mainPane.initViewValues();
					mainPane.initViewType(UPDATE);
					initViewType(UPDATE);
				}

			}
		});

		createBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ClientCRUD.createClient(mainPane.getClient());
				refreshParentFrame();
				dispose();
			}
		});

		readBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				showFrame(READ);
			}
		});

		updateBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ClientCRUD.updateClient(mainPane.getClient());
				refreshParentFrame();
				dispose();
			}
		});

		deleteBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				showFrame(DELETE);
			}
		});

		resetBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mainPane.resetValues();
			}
		});

		closeBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
	}

	protected void showFrame(YapsViewType viewType) {

		if (viewType == UPDATE) {
			dispose();

		}

		if (viewType == DELETE) {
			dispose();

		}
	}

	public ClientPane getMainPane() {
		return mainPane;
	}

	public void setMainPane(ClientPane mainPane) {
		this.mainPane = mainPane;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private void initViewType(YapsViewType viewType) {
		readBt.setVisible(false);
		closeBt.setEnabled(true);

		if (viewType == FIND) {
			findBt.setEnabled(true);
			createBt.setEnabled(false);
			readBt.setEnabled(false);
			updateBt.setEnabled(false);
			deleteBt.setEnabled(false);
			resetBt.setEnabled(true);
		} else if (viewType == CREATE) {
			findBt.setEnabled(false);
			createBt.setEnabled(true);
			readBt.setEnabled(false);
			updateBt.setEnabled(false);
			deleteBt.setEnabled(false);
			resetBt.setEnabled(true);
		} else if (viewType == FIND_OR_CREATE) {
			findBt.setEnabled(true);
			createBt.setEnabled(true);
			readBt.setEnabled(true);
			updateBt.setEnabled(false);
			deleteBt.setEnabled(false);
			resetBt.setEnabled(true);
		} else if (viewType == READ) {
			findBt.setEnabled(false);
			createBt.setEnabled(false);
			readBt.setEnabled(false);
			updateBt.setEnabled(false);
			deleteBt.setEnabled(false);
			resetBt.setEnabled(false);
		} else if (viewType == UPDATE) {
			findBt.setEnabled(false);
			createBt.setEnabled(false);
			readBt.setEnabled(false);
			updateBt.setEnabled(true);
			deleteBt.setEnabled(false);
			resetBt.setEnabled(false);
		} else if (viewType == DELETE) {
			findBt.setEnabled(false);
			createBt.setEnabled(false);
			readBt.setEnabled(true);
			updateBt.setEnabled(false);
			deleteBt.setEnabled(true);
			resetBt.setEnabled(false);
		} else if (viewType == UPDATE_OR_DELETE) {
			findBt.setEnabled(false);
			createBt.setEnabled(false);
			readBt.setEnabled(true);
			updateBt.setEnabled(true);
			deleteBt.setEnabled(true);
			resetBt.setEnabled(false);
		}
	}

	public YapsViewType getViewType() {
		return viewType;
	}

	public void setViewType(YapsViewType viewType) {
		this.viewType = viewType;
	}

	public ListeClientsFrame getParentFrame() {
		return parentFrame;
	}

	public void setParentFrame(ListeClientsFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	public void refreshParentFrame() {
		if (parentFrame != null) {
			parentFrame.refresh();
		}
	}
}