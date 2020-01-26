package Connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Data_Encapsulation.DATA_PACK;

public class Connect {
	
	public Connect ( DATA_PACK server ) throws Exception {
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://"+server.get_Value_by_Key("server")+":3306/"+server.get_Value_by_Key("BASE")
				,server.get_Value_by_Key("USER"), server.get_Value_by_Key("PASS") );
			System.out.println("Connected!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
