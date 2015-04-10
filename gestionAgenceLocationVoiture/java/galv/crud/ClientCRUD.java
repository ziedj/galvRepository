package galv.crud;

import galv.connection.SQLConnection;
import galv.entities.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ClientCRUD {

	public static Client createCustomer(Client client) {
		System.out.println("create Customer with cin = " + client.getCin());
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"INSERT INTO appgestionvoiture.customer (cin, firstName, lastName, telephone, email, address) ");
		query.append("VALUES (");
		query.append("'").append(client.getCin()).append("'").append(",");
		query.append("'").append(client.getFirstname()).append("'")
				.append(",");
		query.append("'").append(client.getLastname()).append("'")
				.append(",");
		query.append("'").append(client.getTelephone()).append("'")
				.append(",");
		query.append("'").append(client.getEmail()).append("'").append(",");
		query.append("'").append(client.getAddress()).append("'").append(")");
		connection.connect();
		Boolean insertIsDone = connection.executeInsert(query.toString());
		Client insertedClient = new Client();

		if (insertIsDone) {
			insertedClient = findClient(client.getCin());
		}
		System.out.println(insertedClient.toString());
		return insertedClient;

	}

	public static Client findClient(String cin) {
		System.out.println("find Customer with cin = " + cin);
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"SELECT * FROM appgestionvoiture.customer where cin like '");
		query.append(cin);
		query.append("'");
		connection.connect();
		ResultSet result = connection.executeSelect(query.toString());
		Client client = null;
		try {
			while (result.next()) {
				client = new Client();
				client.setId(result.getLong(1));
				client.setCin(result.getString(2));
				client.setFirstname(result.getString(3));
				client.setLastname(result.getString(4));
				client.setTelephone(result.getString(5));
				client.setEmail(result.getString(6));
				client.setAddress(result.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;

	}

	public static void deleteCustomer(Client customer) {
		System.out.println("delete Customer with cin = " + customer.getCin());
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"DELETE FROM appgestionvoiture.customer ");
		query.append("WHERE cin = '").append(customer.getCin()).append("'");
		connection.connect();
		connection.executeInsert(query.toString());

	}

	public static Client updateClient(Client client) {
		System.out.println("update Customer with cin = " + client.getCin());
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"UPDATE appgestionvoiture.customer ");
		query.append("set firstName = '");
		query.append(client.getFirstname()).append("'").append(",");
		query.append(" lastName = '");
		query.append(client.getLastname()).append("'").append(",");
		query.append(" telephone = '");
		query.append(client.getTelephone()).append("'").append(",");
		query.append(" email = '");
		query.append(client.getEmail()).append("'").append(" ");
		query.append("WHERE cin = '").append(client.getCin()).append("'");
		connection.connect();
		Boolean updated = connection.executeInsert(query.toString());
		Client updatedCustomer = new Client();
		if (updated) {
			updatedCustomer = findClient(client.getCin());
		}
		System.out.println(updatedCustomer.toString());
		return client;

	}

	public static List<Client> findClients() {
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		String query = "SELECT * FROM appgestionvoiture.customer";
		connection.connect();
		ResultSet result = connection.executeSelect(query);
		List<Client> list = new ArrayList<Client>();
		Client client = new Client();
		try {
			while (result.next()) {
				client.setId(result.getLong(1));
				client.setCin(result.getString(2));
				client.setFirstname(result.getString(3));
				client.setLastname(result.getString(4));
				client.setTelephone(result.getString(5));
				client.setEmail(result.getString(6));
				client.setAddress(result.getString(7));
				list.add(client);
				client = new Client();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	
	public static Client findClientById(Long idClient) {

		SQLConnection connection = new SQLConnection();
		StringBuilder query = new StringBuilder(
				"SELECT * FROM appgestionvoiture.customer where id = ");
		query.append(idClient);
		connection.connect();
		ResultSet result = connection.executeSelect(query.toString());
		Client client = new Client();
		try {
			while (result.next()) {
				client.setId(result.getLong(1));
				client.setCin(result.getString(2));
				client.setFirstname(result.getString(3));
				client.setLastname(result.getString(4));
				client.setTelephone(result.getString(5));
				client.setEmail(result.getString(6));
				client.setAddress(result.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(client.toString());
		return client;

	}


	public static List<String> findListCIN() {
		/**
    	 * 
    	 */
		SQLConnection connection = new SQLConnection();
		String query = "SELECT * FROM appgestionvoiture.customer";
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
