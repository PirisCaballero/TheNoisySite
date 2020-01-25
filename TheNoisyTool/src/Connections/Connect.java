package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	public Connect () {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.26:3306/customerdb","xulescode", "xulescode");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
