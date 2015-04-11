package galv.crud;

import galv.connection.SQLConnection;
import galv.entities.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class LocationCRUD {

	public static Location createLocation(Location location) {

		Long idVehicule = (VoitureCRUD.findVoiture(location
				.getImmatriculationVoiture())).getId();
		Long idClient = (ClientCRUD.findClient(location.getCinClient()))
				.getId();

		StringBuilder idLocation = new StringBuilder(location.getDateDebut()
				.toString());
		idLocation.append("-").append(location.getImmatriculationVoiture());
		idLocation.append("-").append(location.getCinClient());
		location.setIdLocation(idLocation.toString());

		location.setIdVehicule(idVehicule);
		location.setIdClient(idClient);

		java.sql.Date dateDB = new java.sql.Date(location.getDateDebut()
				.getTime());
		java.sql.Date dateFin = new java.sql.Date(location.getDateDebut()
				.getTime());		
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"INSERT INTO appgestionagencelocationvoiture.location (dateDebut, dateFin, duree, idVoiture, idClient, idLocation, prixUnitaire, sommeTotale) ");
		query.append("VALUES (");
		query.append("'").append(dateDB).append("'").append(",");
		query.append("'").append(dateFin).append("'").append(",");
		query.append("'").append(location.getDuree()).append("'").append(",");
		query.append("'").append(location.getIdVehicule()).append("'")
				.append(",");
		query.append("'").append(location.getIdClient()).append("'")
				.append(",");
		query.append("'").append(location.getIdLocation()).append("'").append(",");
		query.append("'").append(location.getPrixUnitaire()).append("'").append(",");
		query.append("'").append(location.getSommeTotale()).append("'").append(")");
		connection.connect();
		Boolean insertIsDone = connection.executeInsert(query.toString());
		Location insertedLocation = new Location();

		if (insertIsDone) {
			insertedLocation = findLocation(location.getIdLocation());
		}
		System.out.println(insertedLocation.toString());
		return insertedLocation;

	}

	public static Location findLocation(String idLocation) {
		System.out.println("find location with idLocation = " + idLocation);
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"SELECT * FROM appgestionagencelocationvoiture.location where idLocation like '");
		query.append(idLocation);
		query.append("'");
		connection.connect();
		ResultSet result = connection.executeSelect(query.toString());
		Location location = null;
		try {
			while (result.next()) {
				location = new Location();
				location.setId(result.getLong(1));
				location.setDateDebut(result.getDate(2));
				location.setDateFin(result.getDate(3));
				location.setDuree(result.getString(4));
				location.setIdVehicule(result.getLong(5));
				location.setIdClient(result.getLong(6));
				location.setIdLocation(result.getString(7));
				location.setPrixUnitaire(result.getLong(8));
				location.setSommeTotale(result.getLong(9));
				if (location.getIdVehicule() != 0L) {
					location.setImmatriculationVoiture(VoitureCRUD
							.findVoitureById(location.getIdVehicule())
							.getImmatriculation());
				}

				if (location.getIdClient() != 0L) {
					location.setCinClient(ClientCRUD.findClientById(
							location.getIdClient()).getCin());
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return location;

	}

	public static void deleteLocation(Location location) {
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"DELETE FROM appgestionagencelocationvoiture.location ");
		query.append("WHERE idLocation = '").append(location.getIdLocation())
				.append("'");
		connection.connect();
		connection.executeInsert(query.toString());
	}

	public static Location updateLocation(Location location) {
		Long idVehicule = (VoitureCRUD.findVoiture(location
				.getImmatriculationVoiture())).getId();
		Long idClient = (ClientCRUD.findClient(location.getCinClient()))
				.getId();

		location.setIdVehicule(idVehicule);
		location.setIdClient(idClient);
		
		java.sql.Date dateDB = new java.sql.Date(location.getDateDebut()
				.getTime());
		java.sql.Date dateFin = new java.sql.Date(location.getDateDebut()
				.getTime());	

		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"UPDATE appgestionagencelocationvoiture.location ");
		query.append("set dateDebut = '");
		query.append(dateDB).append("'").append(",");
		query.append(" dateFin = '");
		query.append(dateFin).append("'").append(",");
		query.append(" duree = '");
		query.append(location.getDuree()).append("'").append(",");
		query.append(" idVoiture = '");
		query.append(location.getIdVehicule()).append("'").append(",");
		query.append(" idClient = '");
		query.append(location.getIdClient()).append("'").append(",");
		query.append(" idLocation = '");
		query.append(location.getIdLocation()).append("'");
		query.append(" prixUnitaire = '");
		query.append(location.getPrixUnitaire()).append("'");
		query.append(" sommeTotale = '");
		query.append(location.getSommeTotale()).append("'");		
		query.append(" WHERE id = ").append(location.getId()).append(";");
		connection.connect();
		Boolean updated = connection.executeInsert(query.toString());
		Location updatedLocation = new Location();
		if (updated) {
			updatedLocation = findLocation(location.getIdLocation());
		}
		System.out.println(updatedLocation.toString());
		return updatedLocation;

	}

	public static List<Location> findLocations() {
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		String query = "SELECT * FROM appgestionagencelocationvoiture.location";
		connection.connect();
		ResultSet result = connection.executeSelect(query);
		List<Location> list = new ArrayList<Location>();
		Location location = new Location();
		try {
			while (result.next()) {
				location.setId(result.getLong(1));
				location.setDateDebut(result.getDate(2));
				location.setDateFin(result.getDate(3));
				location.setDuree(result.getString(4));
				location.setIdVehicule(result.getLong(5));
				location.setIdClient(result.getLong(6));
				location.setIdLocation(result.getString(7));
				location.setPrixUnitaire(result.getLong(8));
				location.setSommeTotale(result.getLong(9));
				if (location.getIdVehicule() != 0L) {
					location.setImmatriculationVoiture(VoitureCRUD
							.findVoitureById(location.getIdVehicule())
							.getImmatriculation());
				}

				if (location.getIdClient() != 0L) {
					location.setCinClient(ClientCRUD.findClientById(
							location.getIdClient()).getCin());
				}

				list.add(location);
				location = new Location();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
