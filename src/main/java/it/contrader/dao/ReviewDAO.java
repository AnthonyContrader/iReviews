package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Review;
import it.contrader.model.User;

public class ReviewDAO {

	private final String QUERY_ALL = "SELECT * FROM review WHERE utente=?";
	private final String QUERY_CREATE = "INSERT INTO review (negozio, testo, voto) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM review WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE review SET negozio=?, testo=?, voto=? WHERE id=?";
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
	


}

