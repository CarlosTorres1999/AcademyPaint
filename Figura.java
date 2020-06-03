/*
   Integradevs Academy
   
   Proyecto AcademyPaint
   
*/
package academy.paint;


import java.awt.Color;
import java.awt.Graphics;

/** Una clase abstracta que representa algo dibujable en
 * la ventana.
 *
 * Figura tiene la responsabilidad de manejar la informacion
 * de posicion, base, altura y color para todas sus subclases
 */
public abstract class Figura {
	private int x;
	private int y;
	private int base;
	private int altura;
	private Color color;
    /** ===============  MODIFIQUE ESTO
      * Este es el constructor de Figura.
      * Protected significa que solo las subclases pueden llamar
      * este constructor.
      */
    protected Figura(int x, int y, int base, int altura, Color color) {
        // GUARDAR LOS PARAMETROS EN ATRIBUTOS QUE USTED AGREGARA A
        // ESTE OBJETO.
    	this.x = x;
    	this.y = y;
    	this.altura = altura;
    	this.base = base;
    	this.color = color;
    }

    /** Un metodo que toda subclase debe tener.
     *  Dibuja la figura a un contexto grafico.
     *  Figura no tiene una implementacion queda como responsabilidad
     *  de la subclase.
     *
     *  @param g el contexto grafico
     */
    public abstract void dibujar(Graphics g);


    /** ===============  MODIFIQUE ESTO
     * Agregue metodos para obtener la posicion, base, altura
     * y color de la figura
     */
    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }
    public int getBase() {
    	return base;
    }
    public int getAltura() {
    	return altura;
    }
    public Color getColor() {
    	return color;
    }

}