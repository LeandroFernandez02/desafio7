package vista;

// 1. Traemos las herramientas de Swing (ventanas, botones, listas) y AWT (diseño)
import javax.swing.*;
import java.awt.*;
// Necesitamos saber qué tipo de cosa va a mostrar la lista (viene del paquete 'modelo')
import modelo.modeloEjercicio2; // <-- ¡Importante! Usa el nombre exacto de tu clase Tarea

public class vistaEjercicio2 extends JFrame {


    public JList<modeloEjercicio2> listaTareasVisual; // La lista donde se ven las tareas
    public DefaultListModel<modeloEjercicio2> modeloLista; // El "almacén" donde REALMENTE están las tareas
    public JScrollPane panelConScroll;                 // Para poder deslizar la lista
    public JTextField campoNuevaTarea;                 // Donde se escribe el nombre de la tarea nueva
    public JButton botonAgregar;                       // El botón "Agregar Tarea"
    public JButton botonCompletar;                     // El botón "Marcar Completada"


    public vistaEjercicio2() {
        // --- Configuramos la ventana principal ---
        setTitle("Mi Gestor de Tareas (MVC)"); // Título que aparece arriba
        setSize(450, 350);                      // Tamaño inicial (ancho, alto)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que el programa termine al cerrar la ventana
        // Usamos BorderLayout para organizar: lista al centro, botones abajo
        setLayout(new BorderLayout(10, 10)); // 10 píxeles de espacio entre áreas

        modeloLista = new DefaultListModel<>();

        // --- Creamos la lista visual ---
        listaTareasVisual = new JList<>(modeloLista); // Le decimos: "Mostrá lo que hay en modeloLista"
        listaTareasVisual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede elegir una tarea a la vez

        // --- Ponemos la lista dentro de un panel deslizable ---
        panelConScroll = new JScrollPane(listaTareasVisual);

        // --- Creamos el panel de abajo para los botones y el campo de texto ---
        JPanel panelInferior = new JPanel();
        // FlowLayout pone las cosas una al lado de la otra, centradas
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // 10px de espacio

        // Creamos los componentes del panel inferior
        JLabel etiquetaNueva = new JLabel("Nueva Tarea:"); // Un texto fijo
        campoNuevaTarea = new JTextField(15);             // Campo para escribir (15 caracteres de ancho aprox)
        botonAgregar = new JButton("Agregar Tarea");
        botonCompletar = new JButton("Marcar/Desmarcar"); // Cambié el texto para que sea más claro

        // Agregamos todo al panel inferior en orden
        panelInferior.add(etiquetaNueva);
        panelInferior.add(campoNuevaTarea);
        panelInferior.add(botonAgregar);
        panelInferior.add(botonCompletar);

        // --- Colocamos los paneles principales en la ventana ---
        // El panel con la lista va en el medio
        add(panelConScroll, BorderLayout.CENTER);
        // El panel con los botones y campo de texto va abajo
        add(panelInferior, BorderLayout.SOUTH);
    }
    public void refrescarLista() {
        // Simplemente le decimos a la lista que se repinte
        listaTareasVisual.repaint();
        // Y que revalide su layout (a veces necesario)
        listaTareasVisual.revalidate();
    }
}