package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Review;


public class ReviewDAO implements DAO<Review> {

	private final String QUERY_ALL = "SELECT * FROM review ";
	private final String QUERY_CREATE = "INSERT INTO review ( voto, user_id, id_esercizio, testo, titolo) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM review WHERE id=?";	
	private final String QUERY_UPDATE = "UPDATE review SET  voto=?, user_id=?, id_esercizio=?, testo=?, titolo=?  WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM review WHERE id=?";
		
	public ReviewDAO() {

	}

	public List<Review> getAll() {
		List<Review> reviewList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Review review;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int voto = resultSet.getInt("voto");				
				int user_id=resultSet.getInt("user_id");
				String id_esercizio = resultSet.getString("id_esercizio");
				String testo = resultSet.getString("testo");
				String titolo = resultSet.getString("titolo");				
				review = new Review(voto, user_id, id_esercizio, testo, titolo);
				review.setId(id);
				reviewList.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewList;
	}

	public boolean insert(Review reviewToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, reviewToInsert.getVoto());
			preparedStatement.setInt(2, reviewToInsert.getUser_id());
			preparedStatement.setString(3, reviewToInsert.getId_esercizio());
			preparedStatement.setString(4, reviewToInsert.getTesto());
			preparedStatement.setString(5, reviewToInsert.getTitolo());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Review read(int reviewId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, reviewId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();			
			String testo, titolo, id_esercizio;
			int voto, user_id;

			testo = resultSet.getString("testo");
			titolo = resultSet.getString("titolo");
			id_esercizio = resultSet.getString("id_esercizio");
			voto = resultSet.getInt("voto");
			user_id = resultSet.getInt("user_id");			
			Review review = new Review(voto, user_id, id_esercizio, testo, titolo);
			review.setId(resultSet.getInt("id"));
			return review;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Review reviewToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		Review reviewRead = read(reviewToUpdate.getId());		
			try {				

		     	PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);				
				preparedStatement.setInt(1, reviewToUpdate.getVoto());
				preparedStatement.setInt(2, reviewToUpdate.getUser_id());
				preparedStatement.setString(3, reviewToUpdate.getId_esercizio());
				preparedStatement.setString(4, reviewToUpdate.getTesto());
				preparedStatement.setString(5, reviewToUpdate.getTitolo());
				preparedStatement.setInt(6, reviewToUpdate.getId());			
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
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