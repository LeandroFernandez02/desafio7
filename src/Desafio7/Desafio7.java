
package Desafio7;

import vista.vistaEjercicio2; // Traemos la ventana del gestor
import controlador.controladorEjercicio2;  // Traemos el controlador del gestor

public class Desafio7 {

    public static void main(String[] args) {
        vistaEjercicio2 laVentanaDeTareas = new vistaEjercicio2();

        controladorEjercicio2 elControladorDeTareas = new controladorEjercicio2(laVentanaDeTareas);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                laVentanaDeTareas.setVisible(true);
            }
        });

    } 
} 

