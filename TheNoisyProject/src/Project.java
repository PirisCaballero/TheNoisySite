import Principal.TOOL;
import Data_Encapsulation.DATA_PACK;
import Connections.Connect;
import window.ProjectWindow;

public class Project {
	private static Thread sc;
	
	private static void connect_to_server(DATA_PACK ser_conn , DATA_PACK ftp) {
		sc = new Thread () {
			@Override
			public void run () {
				try {
					Connect conn = new Connect(ser_conn , ftp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		sc.start();
	}
	@SuppressWarnings("deprecation")
	private static void kill_server_conn () {
		sc.stop();
		ProjectWindow.update_server_conn_status("Closed D:");
	}
	
	public static void main(String[] args) throws Exception {
		DATA_PACK ser_conn = new DATA_PACK("Server_Connection_Data");
		String server = "thenoisyboy16.ovh";
		String server2 = "83.213.204.144";
		String user = "TheNoisySite";
		String pass = "BI7812cb!";
		String base = "thenoisysite";
		String user2 = "NoisyTool";
		String pass2 = "Nevera98!";
		DATA_PACK ftp_conn = new DATA_PACK("FTP_conn");
		ftp_conn.add_value("server", server2); ftp_conn.add_value("USER", user2); ftp_conn.add_value("PASS", pass2);
		ser_conn.add_value("server", server);ser_conn.add_value("USER", user);ser_conn.add_value("PASS", pass);ser_conn.add_value("BASE", base);
		ProjectWindow w = new ProjectWindow("Connecting...");
		connect_to_server(ser_conn , ftp_conn);
		//kill_server_conn();
	}
}
