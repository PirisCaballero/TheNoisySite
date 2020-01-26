import Principal.TOOL;
import Data_Encapsulation.DATA_PACK;
import Connections.Connect;

public class Project {
	
	
	public static void main(String[] args) throws Exception {
		DATA_PACK dt = new DATA_PACK("prueba");
		TOOL t = new TOOL();
		dt.add_value("TOOL", t.alive());
		dt.to_String();
		
		DATA_PACK ser_conn = new DATA_PACK("Server_Connection_Data");
		String server = "thenoisyboy16.ovh";
		String user = "TheNoisySite";
		String pass = "BI7812cb!";
		String base = "thenoisysite";
		
		ser_conn.add_value("server", server);ser_conn.add_value("USER", user);ser_conn.add_value("PASS", pass);ser_conn.add_value("BASE", base);
		Connect conn = new Connect(ser_conn);
	}
}
