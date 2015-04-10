package galv.voiture;

import galv.crud.VoitureCRUD;
import galv.entities.Voiture;
import galv.utilities.YapsTableModel;

import java.util.List;

public class VoitureTableModel extends YapsTableModel<Voiture> {

	private static final long serialVersionUID = 319512146319841375L;

	@Override
	protected List<Voiture> buildDataList() {
		return VoitureCRUD.findVoitures();
	}

	@Override
	protected Object[][] getColumnProperties() {
		return new Object[][] { { "Immatriculation", Long.class, 200 },
				{ "Couleur", String.class, 170 },
				{ "DateMiseEncirculation", String.class, 170 },
				{ "Type", String.class, 130 }};
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Voiture data = getDataList().get(rowIndex);

		switch (columnIndex) {
		case 0:
			return data.getImmatriculation();
		case 1:
			return data.getCouleur();
		case 2:
			return data.getDateMiseEncirculation();
		case 3:
			return data.getType();
		default:
			return null;
		}
	}

	@Override
	public String getDefaultTitle() {
		return "Lists all the customers";
	}

}