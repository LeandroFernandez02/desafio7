package vista;

import javax.swing.*;
import java.awt.*; 

public class vistaConversor extends JFrame {
    public JTextField campoCelsius;      
    public JTextField campoFahrenheit;   
    public JComboBox<String> comboOpciones; 
    public JLabel etiquetaCelsius;
    public JLabel etiquetaFahrenheit;
    public JLabel etiquetaOpcion;
    
    // Botones públicos
    public JButton botonCalcular; 
    public JButton botonLimpiar; // <--- NUEVO

    public vistaConversor() {
        setTitle("Conversor de Temperatura MVC");
        setSize(350, 250); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        setLayout(new GridLayout(4, 2, 10, 10)); 

        etiquetaCelsius = new JLabel("Grados Celsius:");
        campoCelsius = new JTextField();

        etiquetaFahrenheit = new JLabel("Grados Fahrenheit:");
        campoFahrenheit = new JTextField();

        etiquetaOpcion = new JLabel("Convertir:");
        String[] opciones = {"Celsius a Fahrenheit", "Fahrenheit a Celsius"};
        comboOpciones = new JComboBox<>(opciones);

        botonCalcular = new JButton("Calcular");
        botonLimpiar = new JButton("Limpiar"); // <--- NUEVO: Inicializamos

        // Fila 1
        add(etiquetaCelsius);
        add(campoCelsius);
        // Fila 2
        add(etiquetaFahrenheit);
        add(campoFahrenheit);
        // Fila 3
        add(etiquetaOpcion);
        add(comboOpciones);
        
        // Fila 4
        add(botonLimpiar);  // <--- NUEVO: Lo ponemos a la izquierda
        add(botonCalcular); // Y Calcular a la derecha
    }

    // Getters y Setters
    public String getCelsius() { return campoCelsius.getText(); }
    public void setCelsius(String valor) { campoCelsius.setText(valor); }
    public String getFahrenheit() { return campoFahrenheit.getText(); }
    public void setFahrenheit(String valor) { campoFahrenheit.setText(valor); }
    public String getOpcionSeleccionada() { return (String) comboOpciones.getSelectedItem(); }
}