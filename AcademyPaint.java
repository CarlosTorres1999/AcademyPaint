/*
   Integradevs Academy
   
   Proyecto AcademyPaint
   
*/
package academy.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 * Este es un programa de dibujo simple escrito en Java.
 */
public class AcademyPaint extends JFrame implements MouseInputListener {

	// esto es algo que exige Java porque JFrame es serializable (que en realidad no
	// tiene sentido)
	// usamos esto solo para apagar la advertencia
	private static final long serialVersionUID = 1L;

	/**
	 * Este es el constructor de la ventana
	 * 
	 * @param titulo el titulo que aparece en la ventana
	 */
	public AcademyPaint(String titulo) {
		// llamo el constructor de JFrame con el titulo
		// de la ventana
		super(titulo);

		// establesco el tamano de la ventana
		setSize(400, 400);

		// Crear el panel de figuras y las dos barras
		// de herramientas (figuras y colores)
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(_panel, BorderLayout.CENTER);
		contentPane.add(figuras(), BorderLayout.NORTH);
		contentPane.add(colores(), BorderLayout.WEST);
		contentPane.add(funciones(), BorderLayout.SOUTH);

		// Establecer que esta clase se va a encargar de manejar
		// los eventos del mouse
		_panel.addMouseListener(this);
		_panel.addMouseMotionListener(this);

		// establesco que el programa termina si la ventana se cierr
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// hago visible la ventana
		setVisible(true);
	}

	/**
	 * =============== MODIFIQUE ESTO Metodo privado crear la barra de figuras
	 */
	private JPanel figuras() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		// AGREGUE MAS BOTONES
		// AGREGUE UN NUEVO TIPO DE FiguraBuilder PARA CADA FIGURA
		panel.add(_rectangulo);
		panel.add(_ovalo);
		panel.add(_trianguloRectangulo);
		panel.add(_colina);
		panel.add(_pino);
		panel.add(_circulo);
		panel.add(_cuadrado);
		panel.add(_borrarTodo);
		_trianguloRectangulo.addActionListener((e) -> _fabrica = Triangulo::new);
		_rectangulo.addActionListener((e) -> _fabrica = Rectangulo::new);
		_ovalo.addActionListener((e) -> _fabrica  = Oval::new);
		_colina.addActionListener((e) -> _fabrica = Colina::new);
		_pino.addActionListener((e) -> _fabrica = Pino::new);
		_circulo.addActionListener((e) -> _fabrica = Circulo::new);
		_cuadrado.addActionListener((e) -> _fabrica = Cuadrado::new);
		return panel;
	}

	/**
	 * =============== MODIFIQUE ESTO Metodo privado para crear la barra de colores
	 */
	private JPanel colores() {
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// AGREGUE MAS BOTONES
		JButton azul = new JButton("AZUL");
		azul.setBackground(Color.BLUE);
		azul.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton rojo = new JButton("ROJO");
		rojo.setBackground(Color.RED);
		rojo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton verde = new JButton("VERDE");
		verde.setBackground(Color.GREEN);
		verde.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton amarillo = new JButton("AMARILLO");
		amarillo.setBackground(Color.YELLOW);
		amarillo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel paleta = new JLabel("PALETA DE COLORES");
		paleta.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(paleta);
		panel.add(verde);
		panel.add(amarillo);
		panel.add(rojo);
		panel.add(azul);
		
		_borrarTodo.addActionListener((e) -> {
			_panel.borrarTodo();
			repaint();
		});
		
		rojo.addActionListener((e) -> _color = Color.RED);
		azul.addActionListener((e) -> _color = Color.BLUE);
		verde.addActionListener((e) -> _color = Color.GREEN);
		amarillo.addActionListener((e) -> _color = Color.YELLOW);
		return panel;

	}

	/** Esto se ejecuta cuando el usario suelta el mouse */
	@Override
	public void mouseReleased(MouseEvent e) {

		// si no estamos dibujando el rectangulo de guia
		if (!_dibujando) {

			// indicar que si lo estamos haciendo ahora
			_dibujando = true;

			// guardar la posicion inicial
			_inicioX = e.getX();
			_inicioY = e.getY();

			// dar un valore inicial a la posicion final
			_finX = _inicioX;
			_finY = _inicioY;

		} else {

			// Indicar que ya no estamos dibujando
			_dibujando = false;

			// agregar la figura a la ventana
			_panel.agregar(
					_fabrica.apply(Math.min(_inicioX, _finX), // utilizar la pos mas peq como inicial
					Math.min(_inicioY, _finY), Math.abs(_finX - _inicioX), // calcular base
					Math.abs(_finY - _inicioY), // calcular altura
					_color));

			// forzar que se repinte la ventana para eliminar el rectangulo
			// de guia
			repaint();
		}

	}
	/**
	 * Agrega al frame el panel donde se encuentra los botones deshacer y rehacer
	 * @return el panel con los elementos dicho anteriormente
	 */
	private JPanel funciones() {
		JPanel funcion = new JPanel();
		JButton deshacer = new JButton("Deshacer");
		
		JButton rehacer = new JButton("Rehacer");
		funcion.add(deshacer);
		
		funcion.add(rehacer);
		
		
		
		deshacer.addActionListener((e) -> {
			_panel.deshacer();
			repaint();
		});
		
		rehacer.addActionListener((e) -> {
			_panel.rehacer();
			repaint();
		});
		return funcion;
	}

	/** Esto se ejecuta cuando el usuario mueve el mouse */
	@Override
	public void mouseMoved(MouseEvent e) {

		// si estamos dibujando dibujar el rectangulo de guia
		if (_dibujando) {

			// obtener contexto grafico del panel
			Graphics g = _panel.getGraphics();

			// fijar color normal a blanco
			g.setColor(Color.WHITE);

			// cambiar a modalidad XOR de dibujo utilizando ROJO como
			// color de guia
			g.setXORMode(Color.RED);

			// dibujar el rectangulo encima del anteriormente dibujado
			// en modalidad XOR esto lo borra restaurando el fondo
			dibujarRect(g, _inicioX, _inicioY, _finX, _finY);

			// obtener nueva posicion final
			_finX = e.getX();
			_finY = e.getY();

			// hacer nuevo rectangulo de guia
			dibujarRect(g, _inicioX, _inicioY, _finX, _finY);
		}

	}

	/** Eventos ignorados */
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	/** Metodo privado que ayuda a dibujar un rectangulo dado dos puntos */
	private void dibujarRect(Graphics g, int x1, int y1, int x2, int y2) {
		// encontrar cual es menor
		int inicioX = Math.min(x1, x2);
		int inicioY = Math.min(y1, y2);

		// encontrar el mayor
		int finX = Math.max(x1, x2);
		int finY = Math.max(y1, y2);

		// dibujar con el punto inicial, base y altura
		g.drawRect(inicioX, inicioY, finX - inicioX, finY - inicioY);
	}

	/**
	 * Metodo utilizado para seleccionar el builder que se va a utilizar
	 */
	public void setFactory(Fabrica<Integer, Integer, Integer, Integer, Color, Figura> fab) {
		_fabrica = fab;
	}

	/**
	 * Metodo utilizado para seleccionar el color que se va a utilizar
	 */
	void setColor(Color color) {
		_color = color;
	}

	/** crea la ventana */
	public static void main(String[] args) {
		new AcademyPaint("AcademyPaint");
	}

	// El panel
	private PanelDeFiguras _panel = new PanelDeFiguras();

	// ahora solo hay un rectangulo.. usted tendra que agregar
	// mas botones
	private JButton _colina = new JButton("Colina");
	private JButton _rectangulo = new JButton("Rectangulo");
	private JButton _ovalo = new JButton("Ovalo");
	private JButton _trianguloRectangulo = new JButton("Triangulo");
	private JButton _pino = new JButton("Pino");
	private JButton _circulo = new JButton("Circulo");
	private JButton _cuadrado = new JButton("Cuadrado");
	private JButton _borrarTodo = new JButton("Borrar Todo");
	// verdadero si estamos en medio de dibujar el rectangulo
	// de guia para hacer un dibujo
	private boolean _dibujando = false;

	// posiciones iniciales y finales de la figura
	private int _inicioX, _inicioY, _finX, _finY;

	// color predeterminado de figuras
	private Color _color = Color.BLACK;

	// Esta es la forma que apuntamos al constructor de Rectangulo
	// en Java 8
	private Fabrica<Integer, Integer, Integer, Integer, Color, Figura> _fabrica = Rectangulo::new;
	

}
