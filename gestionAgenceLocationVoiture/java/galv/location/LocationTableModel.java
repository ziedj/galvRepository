package galv.location;

import galv.crud.LocationCRUD;
import galv.entities.Location;
import galv.utilities.YapsTableModel;

import java.util.List;

public class LocationTableModel extends YapsTableModel<Location> {

	private static final long serialVersionUID = 319512146319841375L;

	@Override
	protected List<Location> buildDataList() {
		return LocationCRUD.findLocations();
	}

	@Override
	protected Object[][] getColumnProperties() {
		return new Object[][] { { "Date debut", Long.class, 200 },
				{ "Date fin", String.class, 170 },
				{ "Duree", String.class, 170 },
				{ "Voiture", String.class, 170 },
				{ "Client", String.class, 130 },
				{ "Prix par jour", String.class, 130 },
				{ "Total", String.class, 130 } };
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Location data = getDataList().get(rowIndex);

		switch (columnIndex) {
		case 0:
			return data.getDateDebut();
		case 1:
			return data.getDateFin();
		case 2:
			return data.getDuree();
		case 3:
			return data.getImmatriculationVoiture();
		case 4:
			return data.getCinClient();
		case 5:
			return data.getPrixUnitaire();
		case 6:
			return data.getSommeTotale();
		default:
			return null;
		}
	}

	@Override
	public String getDefaultTitle() {
		return "Lists all the customers";
	}

}