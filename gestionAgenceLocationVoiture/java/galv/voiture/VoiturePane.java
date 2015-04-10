package galv.voiture;

import static galv.utilities.YapsViewType.CREATE;
import static galv.utilities.YapsViewType.DELETE;
import static galv.utilities.YapsViewType.FIND;
import static galv.utilities.YapsViewType.FIND_OR_CREATE;
import static galv.utilities.YapsViewType.READ;
import static galv.utilities.YapsViewType.UPDATE;
import static galv.utilities.YapsViewType.UPDATE_OR_DELETE;
import galv.entities.Voiture;
import galv.utilities.YapsViewType;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang.ObjectUtils;
import org.jdesktop.swingx.JXDatePicker;

public class VoiturePane extends JPanel {

	private static final long serialVersionUID = 1418503926208288280L;

	private boolean areMinimumInfoDisplayed;
	private JTextField immatriculationField;
	private JTextField couleurField;
	private JXDatePicker dateMiseEncirculationField;
	private JTextField typeField;

	private Voiture voiture;

	public VoiturePane(Voiture voiture,YapsViewType viewType) {
		this.voiture = voiture;
		initView();
		initViewValues();
		installViewListeners();
		initViewType(viewType);
	}

	public VoiturePane() {
		super();
	}

	protected void initView() {

		JXDatePicker picker = new JXDatePicker();
		picker.setDate(Calendar.getInstance().getTime());
		picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

		immatriculationField = new JTextField();
		couleurField = new JTextField();
		dateMiseEncirculationField = picker;
		typeField = new JTextField();

		int row = 0;
		Insets insets = new Insets(2, 5, 2, 5);

		setLayout(new GridBagLayout());
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		row = 0;
		if (!areMinimumInfoDisplayed) {
			add(new JLabel("immatriculation"), new GridBagConstraints(0, row,
					1, 1, 0.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL, insets, 0, 0));
			add(immatriculationField, new GridBagConstraints(1, row++, 1, 1,
					1.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, insets, 0, 0));
		}

		add(new JLabel("couleur"), new GridBagConstraints(0, row, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				insets, 0, 0));
		add(couleurField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));

		add(new JLabel("dateMiseEncirculation"), new GridBagConstraints(0, row,
				1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.VERTICAL, insets, 0, 0));
		add(dateMiseEncirculationField, new GridBagConstraints(1, row++, 1, 1,
				1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));

		add(new JLabel("type"), new GridBagConstraints(0, row, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL, insets,
				0, 0));
		add(typeField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));

	}

	protected void installViewListeners() {

		immatriculationField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = voiture.getImmatriculation();
				String newValue = immatriculationField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					voiture.setImmatriculation(newValue);
				}
			}
		});

		couleurField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = voiture.getCouleur();
				String newValue = couleurField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					voiture.setCouleur(newValue);
				}
			}
		});

		dateMiseEncirculationField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Date oldValue = voiture.getDateMiseEncirculation();
				Date newValue = dateMiseEncirculationField.getDate();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					voiture.setDateMiseEncirculation(newValue);
				}	
			}
		});

		typeField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = voiture.getType();
				String newValue = typeField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					voiture.setType(newValue);
				}
			}
		});
	}

	protected void initViewValues() {
		immatriculationField
				.setText(voiture.getImmatriculation() == null ? null : voiture
						.getImmatriculation());
		couleurField.setText(voiture.getCouleur());
		dateMiseEncirculationField.setDate(voiture.getDateMiseEncirculation());
		typeField.setText(voiture.getType());
	}
	
	public void resetValues() {
		immatriculationField.setText(null);
		couleurField.setText(null);
		dateMiseEncirculationField.setDate(null);
		typeField.setText(null);
	}

	@Override
	public String toString() {
		String text = "Voiture";
		if (voiture.getImmatriculation() != null
				&& !voiture.getImmatriculation().equals("")) {
			text += " - " + voiture.getImmatriculation();
		}
		return text;
	}

	public boolean areMinimumInfoDisplayed() {
		return areMinimumInfoDisplayed;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public JTextField getImmatriculationField() {
		return immatriculationField;
	}

	public void setImmatriculationField(JTextField immatriculationField) {
		this.immatriculationField = immatriculationField;
	}

	public JTextField getCouleurField() {
		return couleurField;
	}

	public void setCouleurField(JTextField couleurField) {
		this.couleurField = couleurField;
	}

	public JXDatePicker getDateMiseEncirculationField() {
		return dateMiseEncirculationField;
	}

	public void setDateMiseEncirculationField(
			JXDatePicker dateMiseEncirculationField) {
		this.dateMiseEncirculationField = dateMiseEncirculationField;
	}

	public JTextField getTypeField() {
		return typeField;
	}

	public void setTypeField(JTextField typeField) {
		this.typeField = typeField;
	}

	
	public void initViewType(YapsViewType viewType) {

		if (viewType == FIND) {
			immatriculationField.setEditable(true);
			couleurField.setEditable(false);
			dateMiseEncirculationField.setEditable(false);
			typeField.setEditable(false);
		} else if (viewType == CREATE) {
			immatriculationField.setEditable(true);
			couleurField.setEditable(true);
			dateMiseEncirculationField.setEditable(true);
			typeField.setEditable(true);
		} else if (viewType == FIND_OR_CREATE) {
			immatriculationField.setEditable(true);
			couleurField.setEditable(true);
			dateMiseEncirculationField.setEditable(true);
			typeField.setEditable(true);
		} else if (viewType == READ) {
			immatriculationField.setEditable(false);
			couleurField.setEditable(false);
			dateMiseEncirculationField.setEditable(false);
			typeField.setEditable(false);
		} else if (viewType == UPDATE) {
			immatriculationField.setEditable(false);
			couleurField.setEditable(true);
			dateMiseEncirculationField.setEditable(true);
			typeField.setEditable(true);
		} else if (viewType == DELETE) {
			immatriculationField.setEditable(true);
			couleurField.setEditable(true);
			dateMiseEncirculationField.setEditable(true);
			typeField.setEditable(true);
		} else if (viewType == UPDATE_OR_DELETE) {
			immatriculationField.setEditable(true);
			couleurField.setEditable(true);
			dateMiseEncirculationField.setEditable(true);
			typeField.setEditable(true);
		}
	}

}