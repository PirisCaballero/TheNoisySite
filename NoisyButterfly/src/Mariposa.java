
import java.awt.Color;
import Ventanas.VentanaFantasy;

public class Mariposa {
	
	public static void main(String[] args) {
		VentanaFantasy vf = new VentanaFantasy("Mariposa", 720, 480, true);
		vf.visible(true);
		vf.setDibujaInmediato(true);
		vf.espera(4000);
		
		double X = 0 ; double Y = 0 ; double t = 20*Math.PI; ; Color col = Color.red; int R = 00 ; 
		int G = 00 ; int B = 00; String color = ""+R+G+B;
		System.out.println(color);
		Color c = new Color(51, 128, 255);
		while (t>0) {
			X = (Math.sin(t) * ( Math.pow(Math.E, (double)Math.cos(t) ) - 2*Math.cos(4*t)  - Math.pow(Math.sin(t/12), 5))) *(-50);
			Y = (Math.cos(t) * ( Math.pow(Math.E, (double)Math.cos(t) ) - 2*Math.cos(4*t) -  Math.pow(Math.sin(t/12), 5))) *(-50);
			t-=0.000001;
			vf.DibujaRectangulo(X+360, Y+240, 1, 1, c);

		}
	}

}
