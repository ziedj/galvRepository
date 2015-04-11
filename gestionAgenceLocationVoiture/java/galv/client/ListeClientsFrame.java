package galv.client;

import static galv.utilities.YapsUIConstants.DEFAULT_BG_COLOR;
import static galv.utilities.YapsViewType.CREATE;
import static galv.utilities.YapsViewType.DELETE;
import static galv.utilities.YapsViewType.FIND;
import static galv.utilities.YapsViewType.READ;
import static galv.utilities.YapsViewType.UPDATE;
import galv.crud.ClientCRUD;
import galv.entities.Client;
import galv.mainPck.PrincipalJFrame;
import galv.utilities.YapsTable;
import galv.utilities.YapsViewType;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListeClientsFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientTableModel tableModel = new ClientTableModel();
	private YapsTable table;
	private JPanel actionPane;

	private JDesktopPane desktopPane;
	private JScrollPane scrollPane;

	JPanel mainBodyPane;

	private JButton findBt;
	private JButton createBt;
	private JButton readBt;
	private JButton updateBt;
	private JButton deleteBt;
	private JButton resetBt;
	private JButton closeBt;

	public ListeClientsFrame() {

		this.desktopPane = PrincipalJFrame.getDesktopPane();

		setSize(600, 300);
		setTitle("Liste des vehicules");
		initTable();
		this.setVisible(true);
		initViewType();
	}

	/**
	 * 
	 * @param query
	 */
	public void initTable() {
		table = new YapsTable(tableModel);
		actionPane = new JPanel();

		JPanel globalPane = new JPanel();
		globalPane.setLayout(new BorderLayout());

		mainBodyPane = new JPanel();
		mainBodyPane.setLayout(new BorderLayout());
		mainBodyPane.setBorder(BorderFactory.createLineBorder(Color.white, 10));

		JPanel mainBorderedPane = new JPanel();
		mainBorderedPane.setBackground(DEFAULT_BG_COLOR);
		mainBorderedPane.setBorder(BorderFactory.createEtchedBorder());
		mainBorderedPane.setLayout(new BorderLayout());

		scrollPane = new JScrollPane(table);
		scrollPane.setBackground(DEFAULT_BG_COLOR);
		mainBorderedPane.add(scrollPane, BorderLayout.CENTER);

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
				showFrame(FIND);
			}
		});

		createBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				showFrame(CREATE);
			}
		});

		readBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				showFrame(READ);
			}
		});

		updateBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				showFrame(UPDATE);
			}
		});

		deleteBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				showFrame(DELETE);
			}
		});

		resetBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});

		closeBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
	}

	protected void showFrame(YapsViewType viewType) {
		int[] selectedRows = table.getSelectedRows();
		if (viewType == CREATE) {
			Client client = new Client();
			ClientFrame frame = new ClientFrame(client, CREATE);
			desktopPane.add(frame);
			frame.setLocation((PrincipalJFrame.width - frame.getWidth()) / 2,
					(PrincipalJFrame.height - frame.getHeight()) / 2);
			frame.setVisible(true);
			frame.toFront();
			frame.setParentFrame(this);
			return;
		}

		if (viewType == FIND) {
			Client client = new Client();
			ClientFrame frame = new ClientFrame(client, FIND);
			desktopPane.add(frame);
			frame.setVisible(true);
			frame.toFront();
			frame.setParentFrame(this);
			return;
		}

		for (int selectedRowIndex : selectedRows) {
			Client client = tableModel.getDataList().get(selectedRowIndex);

			if (viewType == READ) {
				ClientFrame frame = new ClientFrame(client, READ);
				desktopPane.add(frame);
				frame.setVisible(true);
				frame.toFront();
			}

			if (viewType == UPDATE) {
				ClientFrame frame = new ClientFrame(client, UPDATE);
				desktopPane.add(frame);
				frame.setVisible(true);
				frame.toFront();
				frame.setParentFrame(this);
			}

			if (viewType == DELETE) {
				ClientCRUD.deleteClient(client);
				refresh();
			}
		}
	}

	private void initViewType() {
		resetBt.setVisible(false);
		return;
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
		tableModel.setDataList(tableModel.buildDataList());
		table.invalidate();
		table.validate();
		table.repaint();
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JPanel getMainBodyPane() {
		return mainBodyPane;
	}

	public void setMainBodyPane(JPanel mainBodyPane) {
		this.mainBodyPane = mainBodyPane;
	}

}
