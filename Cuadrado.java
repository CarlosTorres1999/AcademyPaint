package academy.paint;

import java.awt.Color;
import java.awt.Graphics;

public class Cuadrado extends Rectangulo{
/**
 * Constructor del cuadrado
 * @param x Posicion en el eje x
 * @param y Posicion en el eje y
 * @param base Ancho de la figura
 * @param altura se iguala al ancho para que los lados sean iguales
 * @param color color de la figura
 */
	public Cuadrado(int x, int y, int base, int altura, Color color) {
		super(x, y, base, base, color);

	}
    public void dibujar(Graphics g) {

        g.setColor(getColor());
        g.fillRect(getX(), getY(), getBase(), getAltura());
    }

}
