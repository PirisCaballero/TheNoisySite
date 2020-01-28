package window;
import javax.swing.*;

public class ProjectWindow {
	
	public ProjectWindow(){
		JFrame window = new JFrame();
		window.setTitle("TheNoisyProject");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1080 , 720);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
