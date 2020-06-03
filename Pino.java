package academy.paint;

import java.awt.Color;
import java.awt.Graphics;

public class Pino extends Figura{
	/**
	 * Constructor de la figura pino
	 */
	private final int LADOS = 3;
	protected Pino(int x, int y, int base, int altura, Color color) {
		super(x, y, base, altura, color);
		// TODO Auto-generated constructor stub
	}
	/**
	 * dibuja el pino, los arreglos x e y sirver para dibujar el Poligono de lado tres
	 */
	@Override
	public void dibujar(Graphics g) {
		g.setColor(getColor());
		int[] x = {(getBase()/2 + getX()), getX() + getBase(), getX()};
		int[] y = {getY(), (getY() + getAltura()/2), (getY() + getAltura()/2)};
		g.fillPolygon(x, y, LADOS);
		g.fillRect(getX() + getBase()/4, getY() + getAltura()/2, getBase()/2, getAltura()/2);
		
	}

}
