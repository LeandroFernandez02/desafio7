
package controlador;

// 1. Traemos las herramientas que necesitamos
import modelo.modeloEjercicio2; // Para crear nuevas tareas (el Modelo)
import vista.vistaEjercicio2; // Para hablar con la ventana (la Vista)

import java.awt.event.ActionEvent; // Para saber qué botón se presionó
import java.awt.event.ActionListener; // Para poder "escuchar" los clics
import javax.swing.DefaultListModel; // Para manejar el "almacén" de tareas
import javax.swing.JOptionPane; // Para mostrar mensajes emergentes


public class controladorEjercicio2 implements ActionListener {

    // --- Referencias: Necesita saber dónde está la Vista y el Almacén de Tareas ---
    private vistaEjercicio2 vista;          // La ventana
    private DefaultListModel<modeloEjercicio2> modeloLista; // El almacén de tareas (que está en la vista)

    public controladorEjercicio2(vistaEjercicio2 vista) {
        this.vista = vista;
        // Obtenemos una referencia directa al "almacén" de tareas que está en la vista
        this.modeloLista = vista.modeloLista;

        // --- Conectamos los "Oídos" a los Botones ---
        // Le decimos a los botones de la vista: "Cuando te hagan clic, avísale a ESTE controlador ('this')"
        this.vista.botonAgregar.addActionListener(this);
        this.vista.botonCompletar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        Object botonQueSePresiono = evento.getSource();

        if (botonQueSePresiono == vista.botonAgregar) {
            // Obtenemos el texto que escribió el usuario en el campo
            String nombreTareaNueva = vista.campoNuevaTarea.getText().trim(); // trim() quita espacios al inicio/final

            // Verificamos que no esté vacío
            if (!nombreTareaNueva.isEmpty()) {
                // Creamos un nuevo objeto Tarea (usando la clase del Modelo)
                modeloEjercicio2 tarea = new modeloEjercicio2(nombreTareaNueva);
                // Agregamos esa nueva tarea al "almacén" (el modeloLista)
                modeloLista.addElement(tarea);
                // Limpiamos el campo de texto para que pueda escribir otra
                vista.campoNuevaTarea.setText("");
            } else {
                // Si estaba vacío, mostramos un aviso
                JOptionPane.showMessageDialog(vista, "Por favor, escribe el nombre de la tarea.");
            }

        } else if (botonQueSePresiono == vista.botonCompletar) {
            // Preguntamos a la lista visual: ¿Qué posición está seleccionada?
            int posicionSeleccionada = vista.listaTareasVisual.getSelectedIndex();

            // Si hay algo seleccionado (la posición no es -1)...
            if (posicionSeleccionada != -1) {
                // Obtenemos la Tarea de esa posición desde el "almacén"
                modeloEjercicio2 tareaElegida = modeloLista.getElementAt(posicionSeleccionada);
                // Le cambiamos el estado: si estaba hecha la pone pendiente, si estaba pendiente la pone hecha
                tareaElegida.setCompletada(!tareaElegida.estaCompletada());
                // ¡IMPORTANTE! Le decimos a la vista que se redibuje para mostrar el cambio [X] o [ ]
                vista.refrescarLista();
            } else {
                // Si no seleccionó nada, le avisamos
                JOptionPane.showMessageDialog(vista, "Selecciona una tarea de la lista para marcarla.");
            }
        }
    }
}
