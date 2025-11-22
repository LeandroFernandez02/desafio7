package controlador;

import modelo.conversor;
import vista.vistaConversor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controladorConversor implements ActionListener {

    private conversor modelo;
    private vistaConversor vista;

    public controladorConversor(conversor m, vistaConversor v) {
        this.modelo = m;
        this.vista = v;

        // Escuchamos a AMBOS botones
        this.vista.botonCalcular.addActionListener(this);
        this.vista.botonLimpiar.addActionListener(this); // <--- NUEVO
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        // --- CASO 1: LÓGICA BOTÓN LIMPIAR ---
        if (evento.getSource() == vista.botonLimpiar) {
            vista.setCelsius("");      // Borramos texto
            vista.setFahrenheit("");   // Borramos texto
            return; // Terminamos aquí, no hace falta calcular nada
        }

        // --- CASO 2: LÓGICA BOTÓN CALCULAR ---
        String opcionSeleccionada = vista.getOpcionSeleccionada();

        try {
            if (opcionSeleccionada.equals("Celsius a Fahrenheit")) {
                String celsiusTexto = vista.getCelsius();
                
                if(!celsiusTexto.isEmpty()) {
                    double celsiusNum = Double.parseDouble(celsiusTexto);
                    double fahrenheitResultado = modelo.celsiusAFahrenheit(celsiusNum);
                    vista.setFahrenheit(String.format("%.2f", fahrenheitResultado));
                } else {
                     JOptionPane.showMessageDialog(vista, "Ingresa un valor en Celsius.");
                }

            } else if (opcionSeleccionada.equals("Fahrenheit a Celsius")) {
                String fahrenheitTexto = vista.getFahrenheit();
                
                if(!fahrenheitTexto.isEmpty()) {
                    double fahrenheitNum = Double.parseDouble(fahrenheitTexto);
                    double celsiusResultado = modelo.fahrenheitACelsius(fahrenheitNum);
                    vista.setCelsius(String.format("%.2f", celsiusResultado));
                } else {
                     JOptionPane.showMessageDialog(vista, "Ingresa un valor en Fahrenheit.");
                }
            }

        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(vista,
                    "Error: Ingresa solo números válidos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}