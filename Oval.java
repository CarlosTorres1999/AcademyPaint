package academy.paint;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Figura{

	protected Oval(int x, int y, int base, int altura, Color color) {
		super(x, y, base, altura, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getBase(), getAltura());
	}
	
}
