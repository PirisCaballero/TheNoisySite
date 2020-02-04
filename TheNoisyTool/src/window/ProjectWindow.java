package window;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class ProjectWindow {
	private static String Server_Connection_status = "";
	static JLabel ser_conn_status;
	public static void update_server_conn_status (String new_status) {
		ser_conn_status.setText(new_status);
	}
	
	public ProjectWindow(String status){
		JFrame window = new JFrame();
		Server_Connection_status = status;
		window.setTitle("TheNoisyProject");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1080 , 720);
		//window.setResizable(false);
		window.getContentPane().setBackground(Color.BLACK);
		window.getContentPane().setLayout(new BorderLayout());
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		JPanel panel_central = new JPanel();
		//panel_central.setSize(1080 , 520);
		JPanel panel_superior =  new JPanel();
		//panel_superior.setSize(1080 , 50);
		panel_superior.setBorder( BorderFactory.createLineBorder(Color.RED));
		panel_central.setBorder(BorderFactory.createLineBorder(Color.green));
		
		JPanel panel_sur = new JPanel();
		panel_sur.setLayout(new BorderLayout());
		//panel_sur.setSize(1080 , 50);
		panel_sur.setBorder(BorderFactory.createLineBorder(Color.blue));
		ser_conn_status = new JLabel(Server_Connection_status);
		ser_conn_status.setSize(200 , 50);
		panel_sur.add(ser_conn_status , BorderLayout.EAST);
		
		window.getContentPane().add(panel_superior , BorderLayout.NORTH);
		window.getContentPane().add(panel_central , BorderLayout.CENTER);
		window.getContentPane().add(panel_sur , BorderLayout.SOUTH);
		SwingUtilities.updateComponentTreeUI(window);
	}

}
