/*
   Integradevs Academy
   
   Proyecto AcademyPaint
   
*/
package academy.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


/** El PanelDeFiguras contiene las figuras que uno agrega a la Ventana.
 *
 * Utiliza la clase ArrayList para contener las figuras. ArrayList
 * es un arreglo que puede crecer y encogerse una vez que fue creado.
 *
 * ArrayList es muy simple, para crearlo:
 *
 *     ArrayList<Figura> lista = new ArrayList<>();
 *
 * Para agregar algo:
 *
 *     lista.add(miObjeto);
 *
 * Para obtener el dato (en este caso el primer elemento):
 *
 *     MiFigura miObjeto = lista.get(0);
 *
 * Modifique el metodo que dice "MODIFIQUE ESTO", cuidado.. entienda lo que
 * hace.
 *
 */
class PanelDeFiguras extends JPanel {
	
    // esto es algo que exige Java porque JFrame es serializable (que en realidad no tiene sentido)
	// usamos esto solo para apagar la advertencia
	private static final long serialVersionUID = 1L;

    /** ===============  MODIFIQUE ESTO
     * Este metodo esta sobre-escribiendo la version de la superclase
     * @param g el contexto grafico al que vamos a dibujar
     */
    @Override
    public void paint(Graphics g) {
        limpiar(g);
        // AGREGUE EL CODIGO PARA QUE TODAS LAS FIGURAS SE DIBUJEN
        // AL CONTEXTO GRAFICO DE ESTA VENTANA
    	_figuras.forEach(f -> f.dibujar(g));

    }

    /** Para agregar figuras al panel
     *  @param fig la Figura que agregamos
     */
    public void agregar(Figura fig) {
        _figuras.add(fig);
    }

    public void borrarTodo() {
        _figuras.clear();
    }

    /** Un metodo privado para limpiar la ventana
     * @param g el objeto que representa los graficos
     */
    private void limpiar(Graphics g) {

        // obtiene los limites de la parte que necesitamos limpiar
        Rectangle bounds = g.getClipBounds();

        // pintar la ventana del color de fondo que queremos
        g.setColor(_colorFondo);
        g.fillRect(
            (int)bounds.getMinX(),
            (int)bounds.getMinY(),
            (int)bounds.getWidth(),
            (int)bounds.getHeight());
    }
    public void deshacer() {
    	if(_figuras.size() > 0) {
    	_figurasBorradas.add(_figuras.get(_figuras.size() - 1));
    	_figuras.remove(_figuras.size() -1);
    	}else {
    		JOptionPane.showMessageDialog(null, "No se puede deshacer en este punto");
    	}
    	
    }
    
    public void rehacer() {
    	if(_figurasBorradas.size() > 0) {
    	_figuras.add(_figurasBorradas.get(_figurasBorradas.size() - 1));
    	_figurasBorradas.remove(_figurasBorradas.size() -1);
    	}else {
    		JOptionPane.showMessageDialog(null, "No se puede rehacer hasta este punto");
    	}
    }

    public void colorFondo(Color c) {
        _colorFondo = c;
    }

    // guarda cada una de las figuras
    private ArrayList <Figura> _figurasBorradas = new ArrayList<>();
    private ArrayList<Figura> _figuras = new ArrayList<>();
    private Color _colorFondo = Color.WHITE;
}