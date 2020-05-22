package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Review;
import it.contrader.model.User;

public class ReviewDAO {

	private final String QUERY_ALL = "SELECT * FROM review ";
	private final String QUERY_CREATE = "INSERT INTO review ( testo, negozio, voto,user_id) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM review WHERE user_id=?";
	private final String QUERY_UPDATE = "UPDATE review SET  user_id=?, testo=?, negozio=?, voto=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM review WHERE id=?";
	
	
	
	
	public ReviewDAO() {
		
	}
	
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			return true;			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
		
		
	}
	
	public List<Review> getAll( ) {
		List<Review> reviewList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Review review;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int user_id=resultSet.getInt("user_id");
				String negozio = resultSet.getString("negozio");
				String testo = resultSet.getString("testo");
				int voto = resultSet.getInt("voto");
				review = new Review(user_id,negozio, testo, voto);
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
			preparedStatement.setInt(4, reviewToInsert.getUser_id());
			preparedStatement.setString(1, reviewToInsert.getTesto());
			preparedStatement.setString(2, reviewToInsert.getNegozio());
			preparedStatement.setInt(3, reviewToInsert.getVoto());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public List<Review> read(int user_id) {
		
		List<Review> reviewlist = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Review review;
			
			while (resultSet.next()) {
			
				int id = resultSet.getInt("id");
				String negozio = resultSet.getString("negozio");
				String testo = resultSet.getString("testo");
				int voto = resultSet.getInt("voto");
				
				review = new Review(user_id, negozio, testo, voto);
				review.setId(id);
				reviewlist.add(review);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewlist;
	}
	
	
	public boolean update(Review review) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if (review.getId() == 0) {
			return false;
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE);
			statement.setInt(1,review.getUser_id());
			statement.setString(2,review.getTesto());
			statement.setString(3,review.getNegozio() );
			statement.setInt(4,review.getVoto());
			statement.setInt(5, review.getId());
			int a = statement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


}

