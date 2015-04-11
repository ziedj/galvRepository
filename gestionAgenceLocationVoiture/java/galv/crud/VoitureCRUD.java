package galv.crud;

import galv.connection.SQLConnection;
import galv.entities.Voiture;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class VoitureCRUD {

	public static Voiture createVoiture(Voiture voiture) {

		java.sql.Date dateDB = new java.sql.Date(voiture
				.getDateMiseEncirculation().getTime());

		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"INSERT INTO appgestionagencelocationvoiture.voiture (immatriculation, couleur, dateMiseEncirculation, type) ");
		query.append("VALUES (");
		query.append("'").append(voiture.getImmatriculation()).append("'")
				.append(",");
		query.append("'").append(voiture.getCouleur()).append("'").append(",");
		query.append("'").append(dateDB).append("'").append(",");
		query.append("'").append(voiture.getType()).append("'").append(")");
		connection.connect();
		Boolean insertIsDone = connection.executeInsert(query.toString());
		Voiture insertedVoiture = new Voiture();

		if (insertIsDone) {
			insertedVoiture = findVoiture(voiture.getImmatriculation());
		}
		return insertedVoiture;

	}

	public static Voiture findVoiture(String immatriculation) {
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"SELECT * FROM appgestionagencelocationvoiture.voiture where immatriculation like '");
		query.append(immatriculation);
		query.append("'");
		connection.connect();
		ResultSet result = connection.executeSelect(query.toString());
		Voiture voiture = null;
		try {
			while (result.next()) {
				voiture = new Voiture();
				voiture.setId(result.getLong(1));
				voiture.setImmatriculation(result.getString(2));
				voiture.setCouleur(result.getString(3));
				voiture.setDateMiseEncirculation(result.getDate(4));
				voiture.setType(result.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voiture;

	}

	public static void deleteVoiture(Voiture voiture) {
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"DELETE FROM appgestionagencelocationvoiture.voiture ");
		query.append("WHERE immatriculation = '")
				.append(voiture.getImmatriculation()).append("'");
		connection.connect();
		connection.executeInsert(query.toString());
	}

	public static Voiture updateVoiture(Voiture voiture) {
		java.sql.Date dateDB = new java.sql.Date(voiture
				.getDateMiseEncirculation().getTime());
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"UPDATE appgestionagencelocationvoiture.voiture ");
		query.append("set couleur = '");
		query.append(voiture.getCouleur()).append("'").append(",");
		query.append(" dateMiseEncirculation = ");
		query.append("'").append(dateDB).append("'").append(",");
		query.append(" type = '");
		query.append(voiture.getType()).append("'");
		query.append(" WHERE id = ").append(voiture.getId()).append(";");
		connection.connect();
		Boolean updated = connection.executeInsert(query.toString());
		Voiture updatedVoiture = new Voiture();
		if (updated) {
			updatedVoiture = findVoiture(voiture.getImmatriculation());
		}
		return updatedVoiture;

	}

	public static List<Voiture> findVoitures() {
		SQLConnection connection = new SQLConnection();
		String query = "SELECT * FROM appgestionagencelocationvoiture.voiture";
		connection.connect();
		ResultSet result = connection.executeSelect(query);
		List<Voiture> list = new ArrayList<Voiture>();
		Voiture voiture = new Voiture();
		try {
			while (result.next()) {
				voiture.setId(result.getLong(1));
				voiture.setImmatriculation(result.getString(2));
				voiture.setCouleur(result.getString(3));
				voiture.setDateMiseEncirculation(result.getDate(4));
				voiture.setType(result.getString(5));
				list.add(voiture);
				voiture = new Voiture();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public static Voiture findVoitureById(Long idVoiture) {

		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"SELECT * FROM appgestionagencelocationvoiture.voiture where id = ");
		query.append(idVoiture);
		connection.connect();
		ResultSet result = connection.executeSelect(query.toString());
		Voiture voiture = new Voiture();
		try {
			while (result.next()) {
				voiture.setId(result.getLong(1));
				voiture.setImmatriculation(result.getString(2));
				voiture.setCouleur(result.getString(3));
				voiture.setDateMiseEncirculation(result.getDate(4));
				voiture.setType(result.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voiture;

	}

	public static List<String> findListImmatriculation() {
		SQLConnection connection = new SQLConnection();
		String query = "SELECT * FROM appgestionagencelocationvoiture.voiture";
		connection.connect();
		ResultSet result = connection.executeSelect(query);
		List<String> list = new ArrayList<String>();
		try {
			while (result.next()) {
				list.add(result.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

}
