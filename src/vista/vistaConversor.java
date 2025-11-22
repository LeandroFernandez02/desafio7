package vista;

import javax.swing.*;
import java.awt.*; // Para Layouts

public class vistaConversor extends JFrame {
    public JTextField campoCelsius;      // Campo para escribir/ver Celsius
    public JTextField campoFahrenheit;   // Campo para escribir/ver Fahrenheit
    public JComboBox<String> comboOpciones; // Menú para elegir la conversión
    public JLabel etiquetaCelsius;
    public JLabel etiquetaFahrenheit;
    public JLabel etiquetaOpcion;

    // --- Constructor: Aquí armamos la ventana ---
    public vistaConversor() {
        // --- Configuramos la ventana ---
        setTitle("Conversor de Temperatura MVC");
        setSize(350, 200); // Tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Que se cierre bien
        // Usamos GridLayout para ordenar en una cuadrícula simple
        setLayout(new GridLayout(3, 2, 10, 10)); // 3 filas, 2 columnas, espacios de 10px

        // --- Creamos los componentes ---
        etiquetaCelsius = new JLabel("Grados Celsius:");
        campoCelsius = new JTextField();

        etiquetaFahrenheit = new JLabel("Grados Fahrenheit:");
        campoFahrenheit = new JTextField();

        etiquetaOpcion = new JLabel("Convertir:");
        String[] opciones = {"Celsius a Fahrenheit", "Fahrenheit a Celsius"};
        comboOpciones = new JComboBox<>(opciones);

     
        // Fila 1
        add(etiquetaCelsius);
        add(campoCelsius);
        // Fila 2
        add(etiquetaFahrenheit);
        add(campoFahrenheit);
        // Fila 3
        add(etiquetaOpcion);
        add(comboOpciones);
    }

    public String getCelsius() {
        return campoCelsius.getText();
    }

    public void setCelsius(String valor) {
        campoCelsius.setText(valor);
    }

    public String getFahrenheit() {
        return campoFahrenheit.getText();
    }

    public void setFahrenheit(String valor) {
        campoFahrenheit.setText(valor);
    }

    public String getOpcionSeleccionada() {
        return (String) comboOpciones.getSelectedItem();
    }
}
