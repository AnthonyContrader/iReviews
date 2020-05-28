package it.contrader.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Esercizio;
import it.contrader.utils.ConnectionSingleton;

public class EsercizioDAO implements DAO<Esercizio> {
	
	private final String QUERY_ALL = "SELECT * FROM esercizio";
	private final String QUERY_CREATE = "INSERT INTO esercizio ( nome, prezzo_medio,id_tipologia,indirizzo,id_citta) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM esercizio WHERE codice=?";
	private final String QUERY_UPDATE = "UPDATE esercizio SET nome=?, prezzo_medio=?, id_tipologia=?, indirizzo=?, id_citta=? WHERE codice=?";
	private final String QUERY_DELETE = "DELETE FROM esercizio WHERE codice=?";

	public EsercizioDAO() {

	}

	public List<Esercizio> getAll() {
		List<Esercizio> esercizioList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Esercizio esercizio;
			while (resultSet.next()) {
				int codice = Integer.parseInt(resultSet.getString("codice"));
				String nome = resultSet.getString("nome");
				double prezzo_medio = resultSet.getDouble("prezzo_medio");
				int id_tipologia = resultSet.getInt("id_tipologia");
				String indirizzo=resultSet.getString("indirizzo");
				int id_citta=resultSet.getInt("id_citta");
				esercizio = new Esercizio(nome, prezzo_medio, id_tipologia,indirizzo,id_citta);
				esercizio.setCodice(codice);
				esercizioList.add(esercizio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return esercizioList;
	}

	public boolean insert(Esercizio esercizioToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			//preparedStatement.setInt(1, esercizioToInsert.getCodice());
			preparedStatement.setString(1, esercizioToInsert.getNome());
			preparedStatement.setDouble(2, esercizioToInsert.getPrezzo_medio());
			preparedStatement.setInt(3, esercizioToInsert.getId_tipologia());
			preparedStatement.setString(4, esercizioToInsert.getIndirizzo());
			preparedStatement.setInt(5, esercizioToInsert.getId_citta());
			preparedStatement.execute();
		
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Esercizio read(int esercizioCodice) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, esercizioCodice);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String  nome, indirizzo;
			double prezzo_medio;
			int id_tipologia, id_citta;

			nome = resultSet.getString("nome");
			prezzo_medio = resultSet.getDouble("prezzo_medio");
			id_tipologia = resultSet.getInt("id_tipologia");
			indirizzo = resultSet.getString("indirizzo");
			id_citta = resultSet.getInt("id_citta");
			Esercizio esercizio = new Esercizio(nome, prezzo_medio, id_tipologia,indirizzo,id_citta);
			esercizio.setCodice(resultSet.getInt("codice"));

			return esercizio;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Esercizio esercizioToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
//		if (esercizioToUpdate.getCodice() == 0)
//			return false;

		Esercizio esercizioRead = read(esercizioToUpdate.getCodice());
		
		
			try {
				
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, esercizioToUpdate.getNome());
				preparedStatement.setDouble(2, esercizioToUpdate.getPrezzo_medio());
				preparedStatement.setInt(3, esercizioToUpdate.getId_tipologia());
				preparedStatement.setString(4, esercizioToUpdate.getIndirizzo());
				preparedStatement.setInt(5, esercizioToUpdate.getId_citta());
				preparedStatement.setInt(6, esercizioToUpdate.getCodice());
				int a = preparedStatement.executeUpdate();

				if (a > 0)
				    return true;
				else
					return false;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	
    }

	public boolean delete(int codice) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, codice);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}



}
