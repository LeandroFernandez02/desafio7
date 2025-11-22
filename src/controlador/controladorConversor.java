/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.conversor;
import vista.vistaConversor;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controladorConversor implements ActionListener {

    // --- Referencias al Modelo y la Vista ---
    private conversor modelo;
    private vistaConversor vista;

    public controladorConversor(conversor m, vistaConversor v) {
        this.modelo = m;
        this.vista = v;

        this.vista.campoCelsius.addActionListener(this);
        this.vista.campoFahrenheit.addActionListener(this);
        this.vista.comboOpciones.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        // Averiguamos qué componente disparó el evento
        Object fuenteDelEvento = evento.getSource();
        String opcionSeleccionada = vista.getOpcionSeleccionada();

        try {
            // Caso 1: Se modificó Celsius o se eligió "C a F"
            if (fuenteDelEvento == vista.campoCelsius || (fuenteDelEvento == vista.comboOpciones && opcionSeleccionada.equals("Celsius a Fahrenheit"))) {
                // Leemos el valor de Celsius desde la Vista
                String celsiusTexto = vista.getCelsius();
                // Lo convertimos a número
                double celsiusNum = Double.parseDouble(celsiusTexto);
                // Le pedimos al Modelo que calcule
                double fahrenheitResultado = modelo.celsiusAFahrenheit(celsiusNum);
                // Le decimos a la Vista que muestre el resultado (formateado)
                vista.setFahrenheit(String.format("%.2f", fahrenheitResultado)); // ".2f" = 2 decimales

                // Caso 2: Se modificó Fahrenheit o se eligió "F a C"
            } else if (fuenteDelEvento == vista.campoFahrenheit || (fuenteDelEvento == vista.comboOpciones && opcionSeleccionada.equals("Fahrenheit a Celsius"))) {
                // Leemos el valor de Fahrenheit desde la Vista
                String fahrenheitTexto = vista.getFahrenheit();
                // Lo convertimos a número
                double fahrenheitNum = Double.parseDouble(fahrenheitTexto);
                // Le pedimos al Modelo que calcule
                double celsiusResultado = modelo.fahrenheitACelsius(fahrenheitNum);
                // Le decimos a la Vista que muestre el resultado (formateado)
                vista.setCelsius(String.format("%.2f", celsiusResultado));
            }

        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(vista,
                    "Error: Ingresa solo números válidos.",
                    "Error de Entrada",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
