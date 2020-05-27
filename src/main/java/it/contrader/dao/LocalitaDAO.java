package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Localita;
//import it.contrader.model.Esercizio;


public class LocalitaDAO implements DAO<Localita> {

	private final String QUERY_ALL = "SELECT * FROM localita";
	private final String QUERY_CREATE = "INSERT INTO localita (citta) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM localita WHERE id=?";
	//private final String QUERY_READ = "SELECT * FROM esercizio WHERE id_citta=id";
	private final String QUERY_UPDATE = "UPDATE localita SET citta=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM localita WHERE id=?";

	public LocalitaDAO() {

	}
	
	public List<Localita> getAll() {
		List<Localita> localitasList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Localita localita;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String citta = resultSet.getString("citta");
				localita = new Localita(citta);
				localita.setId(id);
				localitasList.add(localita);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localitasList;
	}

	public boolean insert(Localita localitaToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, localitaToInsert.getCitta());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	
	public Localita read(int localitaId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, localitaId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String citta;

			citta = resultSet.getString("citta");
			Localita localita = new Localita(citta);
			localita.setId(resultSet.getInt("id"));

			return localita;
		} catch (SQLException e) {
			return null;
		}

	}

/*ancora da sistemare
	public Localita read(int localitaId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, localitaId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String citta;

			citta= resultSet.getString("citta");
			Localita localita = new Localita(citta);
			localita.setId(resultSet.getInt("id"));

			return localita;
		} catch (SQLException e) {
			return null;
		}
Sistemare  */
		

	public boolean update(Localita localitaToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (localitaToUpdate.getId() == 0)
			return false;

		Localita localitaRead = read(localitaToUpdate.getId());
		if (!localitaRead.equals(localitaToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (localitaToUpdate.getCitta() == null || localitaToUpdate.getCitta().equals("")) {
					localitaToUpdate.setCitta(localitaRead.getCitta());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, localitaToUpdate.getCitta());
				preparedStatement.setInt(2, localitaToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

	
}