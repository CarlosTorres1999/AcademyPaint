package academy.paint;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo extends Oval{
/**
 * Constructor del Ovalo
 * @param x posicion en el eje x
 * @param y posicion el el eje y
 * @param base ancho de la figura
 * @param altura altura de la figura
 * @param color color recibira la figura
 */
	protected Circulo(int x, int y, int base, int altura, Color color) {
		super(x, y, base, base, color);
		
	}
	/**
	 * Metodo que dibuja el ovalo
	 */
	public void dibujar(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getBase(), getAltura());
	}
	
}
