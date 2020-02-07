package Connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.net.ftp.FTPClient;
import Data_Encapsulation.DATA_PACK;
import window.ProjectWindow;

public class Connect {
	
	public Connect ( DATA_PACK server , DATA_PACK ftp) throws Exception {
		
		Connection connection = null;
		FTPClient cliente = new FTPClient();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://"+server.get_Value_by_Key("server")+":3306/"+server.get_Value_by_Key("BASE")
				,server.get_Value_by_Key("USER"), server.get_Value_by_Key("PASS") );
			cliente.connect(ftp.get_Value_by_Key("server"));
			boolean login = cliente.login(ftp.get_Value_by_Key("USER"), ftp.get_Value_by_Key("PASS"));
			System.out.println(login);
			//ProjectWindow.update_server_conn_status("Conected!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			//ProjectWindow.update_server_conn_status("Closed D:");
		}
	}

}
