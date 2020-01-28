package Ventanas;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class VentanaFantasy {
	private JFrame ventana;
	private boolean cuadricula;
	private double anch;
	private double alt;
	private boolean dibujadoInmediato;
	private JPanel panel;
	private Graphics2D graphics;
	private BufferedImage buffer;
	private JLabel mensaje;
	
	@SuppressWarnings("serial")
	public VentanaFantasy (String titulo , int anchura , int altura , boolean cuadricula) {
		ventana = new JFrame();
		ventana.setTitle(titulo);
		alt = altura; anch = anchura;
		ventana.setSize((int)anch , (int)alt);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		buffer = new BufferedImage( 2000, 1500, BufferedImage.TYPE_INT_ARGB );
		graphics = buffer.createGraphics();
		graphics.setPaint ( Color.black );
		graphics.fillRect ( 0, 0, 2000, 1500 );
		mensaje = new JLabel();
		mensaje.setBackground(Color.white);
		mensaje.setSize(anchura , 50);
		panel = new JPanel() {
			{
				setLayout( new BorderLayout());
			}
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				((Graphics2D)g).drawImage( buffer, null, 0, 0 );
			}
		};
		ventana.getContentPane().add(panel , BorderLayout.CENTER);
		ventana.getContentPane().add(mensaje , BorderLayout.SOUTH);
		
		if(cuadricula) {
			Thread t1 = new Thread () {
				@SuppressWarnings("static-access")
				@Override
				public void run () {
					double X = 0; double Y = 0;
					while (X < anch) {
						graphics.setColor(Color.WHITE);
						graphics.drawRect((int)X, 240, 1, 1);
						panel.repaint();
						X+=0.00005;
					}
				}
			};
			Thread t2 = new Thread () {
				@SuppressWarnings("static-access")
				@Override
				public void run () {
					double X = 0; double Y = 0;
					while (Y < alt) {
						graphics.setColor(Color.WHITE);
						graphics.drawRect(360, (int)Y, 1, 1);
						panel.repaint();
						Y+=0.00005;
					}
				}
			};
			t1.start();
			t2.start();
			mensaje.setAlignmentX(SwingConstants.CENTER);
			mensaje.setText("Cuadricula generada");
		}
	}
	
	public void setDibujaInmediato(boolean di) {
		dibujadoInmediato = di;
	}
	
	public void espera( long milis ) {
		try {
			Thread.sleep( milis );
		} catch (InterruptedException e) {
		}
	}
	
	public double getAncho() {
		return ventana.getWidth();
	}
	public void visible(boolean vis) {
		if(!vis) ventana.setVisible(false);
		if(vis) ventana.setVisible(true);
	}
	
	public void DibujaRectangulo(double X , double Y , double ancho , double alto , Color col) {
		graphics.setColor(col);
		graphics.drawRect((int)X, (int)Y, (int)ancho, (int)alto);
		if(dibujadoInmediato) panel.repaint();
	}
	
	public static void main(String[] args) {
		VentanaFantasy vf = new VentanaFantasy("Pruebas", 720, 480 , true);
		vf.visible(true);
		vf.dibujadoInmediato = true;
		
	}

}
