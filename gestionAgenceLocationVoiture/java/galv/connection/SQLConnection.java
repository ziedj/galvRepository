package galv.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLConnection {

	String ip, port, dbName, user, passWord;
	Connection con = null;
	Statement statement = null;
	ResultSet rset = null;

	public SQLConnection() {
		this.ip = "localhost";
		this.port = "3306";
		this.dbName = "appgestionagencelocationvoiture";
		this.user = "root";
		this.passWord = "root";
	}

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip
					+ ":" + port + "/" + dbName, user, passWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (statement != null)
				statement.close();
			if (rset != null)
				rset.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeSelect(String query) {
		try {
			statement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			statement.setFetchSize(Integer.MIN_VALUE);
			if (!con.isClosed()) {
				return statement.executeQuery(query);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean executeInsert(String query) {
		try {
			statement = con.createStatement();
			statement.setFetchSize(Integer.MIN_VALUE);
			if (!con.isClosed()) {
				return statement.execute(query);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
