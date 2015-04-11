package galv.client;

import static galv.utilities.YapsViewType.CREATE;
import static galv.utilities.YapsViewType.DELETE;
import static galv.utilities.YapsViewType.FIND;
import static galv.utilities.YapsViewType.FIND_OR_CREATE;
import static galv.utilities.YapsViewType.READ;
import static galv.utilities.YapsViewType.UPDATE;
import static galv.utilities.YapsViewType.UPDATE_OR_DELETE;
import galv.entities.Client;
import galv.utilities.YapsViewType;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang.ObjectUtils;

public class ClientPane extends JPanel {

	private static final long serialVersionUID = 1418503926208288280L;

	private boolean areMinimumInfoDisplayed;
	private JTextField cinField;
	private JTextField firstnameField;
	private JTextField lastnameField;
	private JTextField telephoneField;
	private JTextField emailField;
	private JTextField addressField;

	private Client client;

	public ClientPane(Client client, YapsViewType viewType) {
		this.client = client;
		initView();
		initViewValues();
		installViewListeners();
		initViewType(viewType);
	}

	public ClientPane() {
		super();
	}

	protected void initView() {

		cinField = new JTextField();
		firstnameField = new JTextField();
		lastnameField = new JTextField();
		telephoneField = new JTextField();
		emailField = new JTextField();
		addressField = new JTextField();

		int row = 0;
		Insets insets = new Insets(2, 5, 2, 5);

		setLayout(new GridBagLayout());
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		row = 0;
		if (!areMinimumInfoDisplayed) {
			add(new JLabel("CIN"), new GridBagConstraints(0, row, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					insets, 0, 0));
			add(cinField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
					insets, 0, 0));
		}

		add(new JLabel("Prenom"), new GridBagConstraints(0, row, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				insets, 0, 0));
		add(firstnameField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));

		add(new JLabel("Nom"), new GridBagConstraints(0, row, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL, insets,
				0, 0));
		add(lastnameField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));

		add(new JLabel("Telephone"), new GridBagConstraints(0, row, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				insets, 0, 0));
		add(telephoneField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));

		add(new JLabel("Email"), new GridBagConstraints(0, row, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL, insets,
				0, 0));
		add(emailField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));

		add(new JLabel("Adresse"), new GridBagConstraints(0, row, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				insets, 0, 0));
		add(addressField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));

	}

	protected void installViewListeners() {

		cinField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = client.getCin();
				String newValue = cinField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					client.setCin(newValue);
				}
			}
		});

		firstnameField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = client.getFirstname();
				String newValue = firstnameField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					client.setFirstname(newValue);
				}
			}
		});
		
		lastnameField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = client.getLastname();
				String newValue = lastnameField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					client.setLastname(newValue);
				}
			}
		});

		telephoneField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = client.getTelephone();
				String newValue = telephoneField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					client.setTelephone(newValue);
				}
			}
		});		

		emailField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = client.getEmail();
				String newValue = emailField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					client.setEmail(newValue);
				}
			}
		});
		
		addressField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = client.getAddress();
				String newValue = addressField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					client.setAddress(newValue);
				}
			}
		});		
		
	}

	protected void initViewValues() {
		cinField.setText(client.getCin());
		firstnameField.setText(client.getFirstname());
		lastnameField.setText(client.getLastname());
		telephoneField.setText(client.getTelephone());
		emailField.setText(client.getEmail());
		addressField.setText(client.getAddress());
	}

	public void resetValues() {
		cinField.setText(null);
		firstnameField.setText(null);
		lastnameField.setText(null);
		telephoneField.setText(null);
		emailField.setText(null);
		addressField.setText(null);		
	}

	@Override
	public String toString() {
		String text = "Voiture";
		return text;
	}

	public boolean areMinimumInfoDisplayed() {
		return areMinimumInfoDisplayed;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void initViewType(YapsViewType viewType) {

		if (viewType == FIND) {
			cinField.setEditable(true);
			firstnameField.setEditable(false);
			lastnameField.setEditable(false);
			telephoneField.setEditable(false);
			emailField.setEditable(false);
			addressField.setEditable(false);
		} else if (viewType == CREATE) {
			cinField.setEditable(true);
			firstnameField.setEditable(true);
			lastnameField.setEditable(true);
			telephoneField.setEditable(true);
			emailField.setEditable(true);
			addressField.setEditable(true);
		} else if (viewType == FIND_OR_CREATE) {
			cinField.setEditable(true);
			firstnameField.setEditable(true);
			lastnameField.setEditable(true);
			telephoneField.setEditable(true);
			emailField.setEditable(true);
			addressField.setEditable(true);
		} else if (viewType == READ) {
			cinField.setEditable(false);
			firstnameField.setEditable(false);
			lastnameField.setEditable(false);
			telephoneField.setEditable(false);
			emailField.setEditable(false);
			addressField.setEditable(false);
		} else if (viewType == UPDATE) {
			cinField.setEditable(false);
			firstnameField.setEditable(true);
			lastnameField.setEditable(true);
			telephoneField.setEditable(true);
			emailField.setEditable(true);
			addressField.setEditable(true);
		} else if (viewType == DELETE) {
			cinField.setEditable(true);
			firstnameField.setEditable(true);
			lastnameField.setEditable(true);
			telephoneField.setEditable(true);
			emailField.setEditable(true);
			addressField.setEditable(true);
		} else if (viewType == UPDATE_OR_DELETE) {
			cinField.setEditable(true);
			firstnameField.setEditable(true);
			lastnameField.setEditable(true);
			telephoneField.setEditable(true);
			emailField.setEditable(true);
			addressField.setEditable(true);
		}
	}

}