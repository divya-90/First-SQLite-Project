package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteP {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3370200\\movies.db";
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT rowid, * FROM movies";
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				Integer id = result.getInt("rowid");
				String name = result.getString("name");
				String actor = result.getString("actor");
				String actress = result.getString("actress");
				String director = result.getString("director");
				String yearofrelease = result.getString("yearofrelease");
				
				System.out.println(id + " | " + name + " | " + actor + " | " + actress + " | " + director + " | " + yearofrelease);
			}
		} catch (SQLException e) {
			System.out.println("Error connecting to SQLite database");
			e.printStackTrace();
		}
		

	}

}
