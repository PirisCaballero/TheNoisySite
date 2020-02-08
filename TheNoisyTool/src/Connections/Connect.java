package Connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import Data_Encapsulation.DATA_PACK;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import window.ProjectWindow;

public class Connect {
	
	public static boolean Connect ( DATA_PACK server , DATA_PACK ftp , JFrame win) throws Exception {
		
		Connection connection = null;
		FTPClient cliente = new FTPClient();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://"+server.get_Value_by_Key("server")+":3306/"+server.get_Value_by_Key("BASE")
				,server.get_Value_by_Key("USER"), server.get_Value_by_Key("PASS") );
			System.out.println("No es la BBDD");
			cliente.connect(ftp.get_Value_by_Key("server") , 210);
			boolean login = cliente.login(ftp.get_Value_by_Key("USER"), ftp.get_Value_by_Key("PASS"));
			System.out.println(login);
			ProjectWindow.update_server_conn_status("Conected!" , connection.isClosed());
			
			int respuesta , i;
			FTPFile[] lista;
			cliente.enterLocalPassiveMode();
			respuesta = cliente.getReplyCode();
			if(FTPReply.isPositiveCompletion(respuesta) == true ) {
				 cliente.changeWorkingDirectory("/App_images");
				 System.out.println( cliente.printWorkingDirectory() );
				 lista = cliente.listFiles();
				 
				 for(i=0; i<lista.length; i++) {
					 System.out.println(lista[i].getName()  );
				 }
			 }else {
				 System.out.println("Error de conexion");
			 }
			
			
			return !connection.isClosed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println(":::(((");
			e.printStackTrace();
			ProjectWindow.update_server_conn_status("Closed D:" , true);
			win.repaint();
			return !connection.isClosed();
		}
	}

}
