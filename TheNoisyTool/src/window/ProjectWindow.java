package window;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ProjectWindow {
	private static String Server_Connection_status = "";
	protected static JLabel ser_conn_status =  new JLabel();
	protected static JLabel loading = new JLabel();
	public static void update_server_conn_status (String new_status) {
		ser_conn_status.setText(new_status);
	}
	
	public ProjectWindow(String status) throws IOException{
		JFrame window = new JFrame();
		Server_Connection_status = status;
		window.setTitle("TheNoisyProject");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1080 , 755);
		//window.setResizable(false);
		window.getContentPane().setBackground(Color.BLACK);
		window.getContentPane().setLayout(null);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		JPanel panel_central = new JPanel();
		panel_central.setBounds(0 , 50 ,1080 , 620);
		JPanel panel_superior =  new JPanel();
		panel_superior.setBounds(0 , 0 , 1080 , 50);
		panel_superior.setBorder( BorderFactory.createLineBorder(Color.RED));
		panel_central.setBorder(BorderFactory.createLineBorder(Color.green));
		
		JPanel panel_sur = new JPanel();
		panel_sur.setLayout(null);
		panel_sur.setBounds(0 , 670, 1080 , 50);
		panel_sur.setBorder(BorderFactory.createLineBorder(Color.blue));
		panel_sur.setBackground(Color.blue);
		ser_conn_status.setText(Server_Connection_status);
		ser_conn_status.setBorder(BorderFactory.createLineBorder(Color.black));
		ser_conn_status.setBounds( 900 , 0 , 100 , 50);
		ser_conn_status.setOpaque(true);
		panel_sur.add(ser_conn_status);
		
		window.getContentPane().add(panel_superior);
		window.getContentPane().add(panel_central);
		window.getContentPane().add(panel_sur);
		SwingUtilities.updateComponentTreeUI(window);
	}
	
	public static void main(String[] args) throws IOException {
		ProjectWindow pr = new ProjectWindow("Pruebas");
	}

}
