package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Review;
import it.contrader.model.User;

public class ReviewDAO {

	private final String QUERY_ALL = "SELECT * FROM review WHERE user=?";
	private final String QUERY_CREATE = "INSERT INTO review (testo, negozio, voto, user_id) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM review WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE review SET  testo=?, negozio=?, voto=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM review WHERE id=?";
	
	
	
	
	public ReviewDAO() {
		
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
				String negozio = resultSet.getString("negozio");
				String testo = resultSet.getString("testo");
				int voto = resultSet.getInt("voto");
				review = new Review(negozio, testo, voto);
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
			preparedStatement.setInt(4, reviewToInsert.getUser());
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
	


}

