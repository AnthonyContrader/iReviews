package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import it.contrader.model.Tipologia;
import it.contrader.utils.ConnectionSingleton;

public class TipologiaDAO implements DAO<Tipologia> {
	
	private final String QUERY_ALL = "SELECT * FROM tipologia";
	private final String QUERY_CREATE = "INSERT INTO tipologia (tipo) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM tipologia WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE tipologia SET tipo=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM tipologia WHERE id=?";

	@Override
	public List<Tipologia> getAll() {
		List<Tipologia> tipologiaList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Tipologia tipologia;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String tipo = resultSet.getString("tipo");
				tipologia = new Tipologia(tipo);
				tipologia.setId(id);
				tipologiaList.add(tipologia);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipologiaList;
		
	}

	@Override
	public Tipologia read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String tipo;
			tipo = resultSet.getString("tipo");
			Tipologia tipologia = new Tipologia(tipo);
			tipologia.setId(resultSet.getInt("id"));
			return tipologia;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean insert(Tipologia tipologiaInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, tipologiaInsert.getTipo());
			preparedStatement.execute();
			return true;
		} catch (SQLException  e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Tipologia tipologiaUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if (tipologiaUpdate.getId() == 0)
			return false;
		Tipologia tipologiaRead = read(tipologiaUpdate.getId());
		
		if (!tipologiaRead.equals(tipologiaUpdate)) {
			try {
				// Fill the userToUpdate object
				if (tipologiaUpdate.getTipo() == null || tipologiaUpdate.getTipo().equals("")) {
					tipologiaUpdate.setTipo(tipologiaRead.getTipo());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, tipologiaUpdate.getTipo());
				preparedStatement.setInt(2, tipologiaUpdate.getId());
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

	@Override
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
