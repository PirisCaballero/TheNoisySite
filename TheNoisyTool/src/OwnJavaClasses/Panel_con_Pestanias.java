package OwnJavaClasses;
import java.awt.Color;

import javax.swing.*;

public class Panel_con_Pestanias extends JTabbedPane {
	
	/**
	 * Aitor Piris Caballero
	 */
	private static final long serialVersionUID = 1L;
	private int num_paneles = 0;

	public Panel_con_Pestanias (int paneles_count) {
		setBorder(BorderFactory.createLineBorder(Color.GREEN));
		num_paneles = paneles_count;
		crear_paneles(num_paneles);
	}
	
	private void crear_paneles (int num) {
		for (int i = 0; i < num ; i++) {
			JPanel panel = new JPanel();
			this.add("Panel"+i , panel);
		}
	}
}
