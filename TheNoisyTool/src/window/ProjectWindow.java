package window;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

import OwnJavaClasses.Panel_con_Pestanias;

public class ProjectWindow {
	private static String Server_Connection_status = "";
	protected static JLabel ser_conn_status =  new JLabel();
	protected static JLabel loading = new JLabel();
	private static JFrame window;
	private static JPanel panel_sur;
	public static void update_server_conn_status (String new_status , boolean closed) {
		if(new_status == "Conected!" && closed ==  false) {
			ser_conn_status.setText(new_status);
			loading.setIcon(new ImageIcon("ResourceFolder/img/re-HUD.gif"));
			loading.setBounds(980 , 0 , 80 ,50);
			panel_sur.setBackground(Color.black);
		}else if (new_status == "Closed D:" && closed==true) {
			ser_conn_status.setText("Closed D:");
			ser_conn_status.setBounds(850 , 0 , 150 , 50);
			loading.setIcon(new ImageIcon("ResourceFolder/img/re-loader02.gif"));
			loading.setBounds(1000 , 0 , 80 ,50);
		}
	}
	
	public ProjectWindow(String status) throws IOException{
		window = new JFrame();
		Server_Connection_status = status;
		window.setTitle("TheNoisyProject");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1080 , 747);
		window.setResizable(false);
		//window.getContentPane().setBackground(Color.BLACK);
		window.getContentPane().setLayout(null);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		////////////////////////////////////////////////
		JPanel panel_central = new JPanel();
		panel_central.setBounds(250 , 50 ,1080 , 620);
		panel_central.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		JTabbedPane panel_derecha = new JTabbedPane();
		panel_derecha.setBounds(0, 50, 250, 620);
		panel_derecha.setBorder(BorderFactory.createLineBorder(Color.yellow));
		JPanel panel_tabbed_1 = new JPanel();
		panel_tabbed_1.setBounds(0, 0, 250, 620);
		panel_derecha.add("Panel 1" , panel_tabbed_1);
		JPanel panel_tabbed_2 = new JPanel();
		panel_tabbed_2.setBounds(0 , 0 , 250 , 620);
		panel_derecha.add("Panel 2" , panel_tabbed_2);
		
		//////////////////////////////////////////////////////////
		JPanel panel_superior =  new JPanel();
		panel_superior.setBounds(0 , 0 , 1080 , 50);
		panel_superior.setBorder( BorderFactory.createLineBorder(Color.RED));
		
		panel_sur = new JPanel();
		panel_sur.setLayout(null);
		panel_sur.setBounds(0 , 670, 1080 , 50);
		panel_sur.setBackground( new Color(28 , 29 , 33) );
		ser_conn_status.setText(Server_Connection_status);
		ser_conn_status.setBounds( 900 , 0 , 100 , 50);
		ser_conn_status.setForeground(Color.white);
		loading.setIcon(new ImageIcon("ResourceFolder/img/re-loader02.gif"));
		loading.setBounds(1000 , 0 , 80 ,50);
		panel_sur.add(loading);
		panel_sur.add(ser_conn_status);
		
		window.getContentPane().add(panel_superior);
		window.getContentPane().add(panel_central);
		window.getContentPane().add(panel_derecha);
		window.getContentPane().add(panel_sur);
		SwingUtilities.updateComponentTreeUI(window);
	}
	
	public static void main(String[] args) throws IOException {
		ProjectWindow pr = new ProjectWindow("Pruebas");
	}

}
