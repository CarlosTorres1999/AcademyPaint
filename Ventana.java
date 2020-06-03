/*
   Integradevs Academy
   
   Proyecto AcademyPaint
   
*/

package academy.paint;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

/** Esta clase define una Ventana al estilo de
 *  GWindows, pero mas simple.
 *  @author Amin Mansuri
 */
public class Ventana extends JFrame {

	// esto es algo que exige Java porque JFrame es 
	// serializable (que en realidad no tiene sentido)
	// usamos esto solo para apagar la advertencia de Eclipse
	private static final long serialVersionUID = 1L;
    
	/** Este es el constructor de la ventana
     * @param titulo el titulo que aparece en la ventana
     */
    public Ventana(String titulo) {
        // llamo el constructor de JFrame con el titulo
        // de la ventana
        super(titulo);

        // establesco el tamano de la ventana
        setSize(400,400);

        // agrego el PanelDeFiguras y utilizo un BorderLayout
        // que posiciona y redimensiona el panel segun la necesidad
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(_panel, BorderLayout.CENTER);

        // establesco que el programa termina si la ventana se cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // hago visible la ventana
        setVisible(true);
    }

    /** Agrega la figura a nuestra lista de figuras
     * @param fig la figura que queremos agregar
     */
    public void agregar(Figura fig) {
        // delego la gestion de figuras a PanelDeFiguras
        _panel.agregar(fig);
        repaint();
    }

    /** ===============  MODIFIQUE ESTO
     * Para probar la clase, agregue sus figuras geometricas
     * a la ventana para ver si todo funciona.
     */
    public static void main(String[] args) {
        Ventana v = new Ventana("hola");

        // AGREGUE SUS FIGURAS GEOMETRICAS A LA VENTANA
        // Ejemplo:
        v.agregar(new Rectangulo(10,10,100,100,Color.RED));
        v.agregar(new Oval(300, 200, 50, 100, Color.BLUE));
        v.agregar(new Triangulo(700, 500, 100, 100, Color.BLACK));
        v.agregar(new Pino(40, 600, 100, 50, Color.GREEN));
        v.agregar(new Colina(100, 500, 30, 50, Color.BLUE));
    }

    // mi panel de figuras: contiene todas las figuras y se
    // encarga de hacer que se dibujen en la pantalla
    private PanelDeFiguras _panel = new PanelDeFiguras();

}

