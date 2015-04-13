package galv.location;

import static galv.utilities.YapsViewType.CREATE;
import static galv.utilities.YapsViewType.DELETE;
import static galv.utilities.YapsViewType.FIND;
import static galv.utilities.YapsViewType.FIND_OR_CREATE;
import static galv.utilities.YapsViewType.READ;
import static galv.utilities.YapsViewType.UPDATE;
import static galv.utilities.YapsViewType.UPDATE_OR_DELETE;
import galv.crud.ClientCRUD;
import galv.crud.VoitureCRUD;
import galv.entities.Location;
import galv.utilities.DateUtility;
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
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang.ObjectUtils;
import org.jdesktop.swingx.JXDatePicker;

public class LocationPane extends JPanel {

	private static final long serialVersionUID = 1418503926208288280L;

	private boolean areMinimumInfoDisplayed;
	
	private JXDatePicker dateDebutField;
	private JXDatePicker dateFinField;
	
	private JComboBox voitureImmatriculationField;
	private JComboBox clientCINField;
	
	private JTextField dureeField;

	private JTextField prixUnitaireField;

	private JTextField sommeTotaleField;
	

	public Location location;

	public LocationPane(Location location,YapsViewType viewType) {
		this.location = location;
		initView();
		initViewValues();
		installViewListeners();
		initViewType(viewType);
	}

	public LocationPane() {
		super();
	}

	protected void initView() {
		
		List<String> listCIN = ClientCRUD.findListCIN();
		List<String> listImmatriculation = VoitureCRUD.findListImmatriculation();

		JXDatePicker pickerDateDebut = new JXDatePicker();
		pickerDateDebut.setDate(Calendar.getInstance().getTime());
		pickerDateDebut.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		
		dateDebutField = pickerDateDebut;
		
		JXDatePicker pickerDateFin = new JXDatePicker();
		pickerDateFin.setDate(Calendar.getInstance().getTime());
		pickerDateFin.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		
		dateFinField = pickerDateFin;
		
		dureeField = new JTextField();
		
		voitureImmatriculationField = new JComboBox(listImmatriculation.toArray());;
		clientCINField = new JComboBox(listCIN.toArray());				
						
		prixUnitaireField = new JTextField();
		sommeTotaleField = new JTextField();

		int row = 0;
		Insets insets = new Insets(2, 5, 2, 5);

		setLayout(new GridBagLayout());
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		row = 0;
		if (!areMinimumInfoDisplayed) {
			add(new JLabel("Date de debut"), new GridBagConstraints(0, row, 1,
					1, 0.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL, insets, 0, 0));
			add(dateDebutField, new GridBagConstraints(1, row++, 1, 1, 1.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, insets, 0, 0));
		}

		add(new JLabel("Date de fin"), new GridBagConstraints(0, row, 1,
				1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.VERTICAL, insets, 0, 0));
		add(dateFinField, new GridBagConstraints(1, row++, 1, 1, 1.0,
				0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));		
		
		add(new JLabel("Duree"), new GridBagConstraints(0, row, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL, insets,
				0, 0));
		add(dureeField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));

		add(new JLabel("Voiture"), new GridBagConstraints(0, row, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				insets, 0, 0));
		add(voitureImmatriculationField, new GridBagConstraints(1, row++, 1,
				1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));

		add(new JLabel("Client"), new GridBagConstraints(0, row, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				insets, 0, 0));
		add(clientCINField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));
		
		add(new JLabel("Prix par jour"), new GridBagConstraints(0, row, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				insets, 0, 0));
		add(prixUnitaireField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));
		
		add(new JLabel("Somme"), new GridBagConstraints(0, row, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				insets, 0, 0));
		add(sommeTotaleField, new GridBagConstraints(1, row++, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets,
				0, 0));

	}

	protected void installViewListeners() {
		
		dateDebutField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Date oldValue = location.getDateDebut();
				Date newValue = dateDebutField.getDate();;


				if (!ObjectUtils.equals(oldValue, newValue)) {
					location.setDateDebut(newValue);
				}
				
				if ((location.getDateDebut() != null) && (location.getDateFin() != null)) {
					location.setDuree(String.valueOf(DateUtility.getDaysDifference(location.getDateDebut(),location.getDateFin())));
					dureeField.setText(location.getDuree());
				}
			}

		});
		
		dateFinField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Date oldValue = location.getDateDebut();
				Date newValue = dateFinField.getDate();;


				if (!ObjectUtils.equals(oldValue, newValue)) {
					location.setDateFin(newValue);
				}
				if ((location.getDateDebut() != null) && (location.getDateFin() != null)) {
					location.setDuree(String.valueOf(DateUtility.getDaysDifference(location.getDateDebut(),location.getDateFin())));
					dureeField.setText(location.getDuree());
				}				
			}

		});
		
		dureeField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				String oldValue = location.getDuree();
				String newValue = dureeField.getText();

				if (!ObjectUtils.equals(oldValue, newValue)) {
					location.setDuree(newValue);
				}
			}

		});
		
		voitureImmatriculationField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (voitureImmatriculationField.getSelectedItem() != null) {
					String oldValue = location.getImmatriculationVoiture();
					String newValue = voitureImmatriculationField.getSelectedItem()
							.toString();

					if (!ObjectUtils.equals(oldValue, newValue)) {
						location.setImmatriculationVoiture(newValue);
					}
				}

			}
		});


		clientCINField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (clientCINField.getSelectedItem() != null) {
					String oldValue = location.getCinClient();
					String newValue = clientCINField.getSelectedItem()
							.toString();

					if (!ObjectUtils.equals(oldValue, newValue)) {
						location.setCinClient(newValue);
					}
				}

			}
		});
		
		prixUnitaireField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				Long oldValue = location.getPrixUnitaire();
				Long newValue = Long.parseLong(prixUnitaireField.getText());

				if (!ObjectUtils.equals(oldValue, newValue)) {
					location.setPrixUnitaire(newValue);
				}
			}

		});
		
		sommeTotaleField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent evt) {
				Long oldValue = location.getSommeTotale();
				Long newValue = Long.parseLong(sommeTotaleField.getText());

				if (!ObjectUtils.equals(oldValue, newValue)) {
					location.setSommeTotale(newValue);
				}
			}

		});
		
	}

	protected void initViewValues() {
		dateDebutField.setDate(location.getDateDebut());
		dateFinField.setDate(location.getDateFin());
		dureeField.setText(location.getDuree());
		voitureImmatriculationField
				.setSelectedItem(location.getImmatriculationVoiture());
		clientCINField.setSelectedItem(location.getCinClient());
		prixUnitaireField.setText(location.getPrixUnitaire() != null ? Long.toString(location.getPrixUnitaire()) : null);
		sommeTotaleField.setText(location.getSommeTotale() != null ? Long.toString(location.getSommeTotale()) : null);
	}
	
	public void resetValues() {
		dateDebutField.setDate(null);
		dateFinField.setDate(null);
		dureeField.setText(null);
		voitureImmatriculationField
				.setSelectedItem(null);
		clientCINField.setSelectedItem(null);
		prixUnitaireField.setText(null);
		sommeTotaleField.setText(null);
	}

	@Override
	public String toString() {

		return " ";
	}

	public boolean areMinimumInfoDisplayed() {
		return areMinimumInfoDisplayed;
	}


	
	public void initViewType(YapsViewType viewType) {

		if (viewType == FIND) {
			dateDebutField.setEditable(true);
			dateFinField.setEditable(false);
			dureeField.setEditable(false);
			voitureImmatriculationField.setEditable(false);
			clientCINField.setEditable(false);
			prixUnitaireField.setEditable(false);
			sommeTotaleField.setEditable(false);
		} else if (viewType == CREATE) {
			dateDebutField.setEditable(true);
			dateFinField.setEditable(true);
			dureeField.setEditable(true);
			voitureImmatriculationField.setEditable(true);
			clientCINField.setEditable(true);
			prixUnitaireField.setEditable(true);
			sommeTotaleField.setEditable(true);
		} else if (viewType == FIND_OR_CREATE) {
			dateDebutField.setEditable(true);
			dateFinField.setEditable(true);
			dureeField.setEditable(true);
			voitureImmatriculationField.setEditable(true);
			clientCINField.setEditable(true);
			prixUnitaireField.setEditable(true);
			sommeTotaleField.setEditable(true);
		} else if (viewType == READ) {
			dateDebutField.setEditable(false);
			dateFinField.setEditable(false);
			dureeField.setEditable(false);
			voitureImmatriculationField.setEditable(false);
			clientCINField.setEditable(false);
			prixUnitaireField.setEditable(false);
			sommeTotaleField.setEditable(false);
		} else if (viewType == UPDATE) {
			dateDebutField.setEditable(false);
			dateFinField.setEditable(true);
			dureeField.setEditable(true);
			voitureImmatriculationField.setEditable(true);
			clientCINField.setEditable(true);
			prixUnitaireField.setEditable(true);
			sommeTotaleField.setEditable(true);
		} else if (viewType == DELETE) {
			dateDebutField.setEditable(true);
			dateFinField.setEditable(true);
			dureeField.setEditable(true);
			voitureImmatriculationField.setEditable(true);
			clientCINField.setEditable(true);
			prixUnitaireField.setEditable(true);
			sommeTotaleField.setEditable(true);
		} else if (viewType == UPDATE_OR_DELETE) {
			dateDebutField.setEditable(true);
			dateFinField.setEditable(true);
			dureeField.setEditable(true);
			voitureImmatriculationField.setEditable(true);
			clientCINField.setEditable(true);
			prixUnitaireField.setEditable(true);
			sommeTotaleField.setEditable(true);
		}
	}

	
	
}