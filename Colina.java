package academy.paint;

import java.awt.Color;
import java.awt.Graphics;

public class Colina extends Figura{
/**
 * Constructor de la colina
 * @param x posicion x de la figura
 * @param y posicion y de la figura
 * @param base que tal ancho sera
 * @param altura que tan alto sera
 * @param color el color de la figura
 */
	protected Colina(int x, int y, int base, int altura, Color color) {
		super(x, y, base, altura, color);
		// TODO Auto-generated constructor stub
	}
/**
 * metodo para dibujar la figura
 */
	@Override
	public void dibujar(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getBase(), getAltura());
		g.fillRect(getX(), getY() + getAltura()/2 , getBase(), getAltura()/2);	
	}
	
}
