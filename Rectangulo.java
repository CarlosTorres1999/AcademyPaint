/*
   Integradevs Academy
   
   Proyecto AcademyPaint
   
*/

package academy.paint;

import java.awt.Color;
import java.awt.Graphics;

/** Esta clase contiene la informacion para dibujar un rectangulo */
public class Rectangulo extends Figura {

    /** Constructor: deja que Figura haga el trabajo de manejar
     * la posicion, dimensiones y color de la figura.
     */
    public Rectangulo(int x, int y, int base, int altura, Color color) {
        super(x,y,base,altura,color);
    }

    /** ===============  MODIFIQUE ESTO
     * Se dibuja a la ventana
     */
    public void dibujar(Graphics g) {

        // Descomente las siguientes lineas una vez que los metodos de
        // Figura getX(), getY(), getBase() y getAltura(), y getColor() o sus
        // equivalentes esten implementados
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getBase(), getAltura());
    }
}