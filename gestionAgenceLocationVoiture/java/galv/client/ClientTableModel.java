package galv.client;

import galv.crud.ClientCRUD;
import galv.entities.Client;
import galv.utilities.YapsTableModel;

import java.util.List;

public class ClientTableModel extends YapsTableModel<Client> {

	private static final long serialVersionUID = 319512146319841375L;

	@Override
	protected List<Client> buildDataList() {
		return ClientCRUD.findClients();
	}

	@Override
	protected Object[][] getColumnProperties() {
		return new Object[][] { { "Cin", Long.class, 200 },
				{ "Prenom", String.class, 170 }, 
				{ "Non", String.class, 170 },
				{ "Telephone", String.class, 170 },
				{ "Email", String.class, 130 },
				{ "Adresse", String.class, 130 } };
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Client data = getDataList().get(rowIndex);

		switch (columnIndex) {
		case 0:
			return data.getCin();
		case 1:
			return data.getFirstname();
		case 2:
			return data.getLastname();
		case 3:
			return data.getTelephone();
		case 4:
			return data.getEmail();
		case 5:
			return data.getAddress();			
		default:
			return null;
		}
	}

	@Override
	public String getDefaultTitle() {
		return "Lists all the customers";
	}

}