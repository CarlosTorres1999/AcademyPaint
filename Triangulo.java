package academy.paint;

import java.awt.Color;
import java.awt.Graphics;

public class Triangulo extends Figura{
/**
 * Constructor del triangulo
 * @param x posicion en el eje x
 * @param y posicion en el eje y
 * @param base el anchor
 * @param altura la altura
 * @param color el color de la figura
 */
	protected Triangulo(int x, int y, int base, int altura, Color color) {
		super(x, y, base, altura, color);
		
	}
		/**
		 * Metodo para dibujar el triangulo
		 */
	@Override
	public void dibujar(Graphics g) {
		g.setColor(getColor());
		int[] x = {(getBase()/2 + getX()), getX() + getBase(), getX()};
		int[] y = { getY(), getY() + getAltura(), getY() + getAltura()};
		g.fillPolygon(x, y, 3);
	}

}
