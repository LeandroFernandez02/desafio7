package Desafio7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// --- Imports del Ejercicio 1 (Conversor) ---
import modelo.conversor;
import vista.vistaConversor;
import controlador.controladorConversor;

// --- Imports del Ejercicio 2 (Gestor de Tareas) ---
import vista.vistaEjercicio2;
import controlador.controladorEjercicio2;

public class Desafio7 {

    public static void main(String[] args) {
        
        // Usamos invokeLater para buenas prácticas de Swing (hilos)
        SwingUtilities.invokeLater(() -> {
            crearMenuPrincipal();
        });
    }

    public static void crearMenuPrincipal() {
        // 1. Configuramos la ventana del Menú
        JFrame ventanaMenu = new JFrame("Desafío 7 - Menú Principal");
        ventanaMenu.setSize(300, 200);
        ventanaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaMenu.setLayout(new GridLayout(3, 1, 10, 10)); // 3 filas, 1 columna
        ventanaMenu.setLocationRelativeTo(null); // Centrar en pantalla

        // 2. Creamos un título y los botones
        JLabel etiqueta = new JLabel("Selecciona un ejercicio:", SwingConstants.CENTER);
        JButton botonEj1 = new JButton("Ejercicio 1: Conversor");
        JButton botonEj2 = new JButton("Ejercicio 2: Gestor de Tareas");

        // 3. Acción para el Botón 1 (Conversor)
        botonEj1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirEjercicio1();
            }
        });

        // 4. Acción para el Botón 2 (Tareas)
        botonEj2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirEjercicio2();
            }
        });

        // 5. Agregamos todo a la ventana
        ventanaMenu.add(etiqueta);
        ventanaMenu.add(botonEj1);
        ventanaMenu.add(botonEj2);

        // 6. Mostramos el menú
        ventanaMenu.setVisible(true);
    }

    // --- Lógica para iniciar el Ejercicio 1 ---
    public static void abrirEjercicio1() {
        conversor modelo = new conversor();
        vistaConversor vista = new vistaConversor();
        controladorConversor ctrl = new controladorConversor(modelo, vista);
        
        // Configuramos para que al cerrar ESTA ventana, no se cierre todo el programa, solo esa ventana
        vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vista.setLocationRelativeTo(null); // Centrar
        vista.setVisible(true);
    }

    // --- Lógica para iniciar el Ejercicio 2 ---
    public static void abrirEjercicio2() {
        vistaEjercicio2 vista = new vistaEjercicio2();
        controladorEjercicio2 ctrl = new controladorEjercicio2(vista);
        
        // Configuramos para que al cerrar ESTA ventana, no se cierre todo el programa
        vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vista.setLocationRelativeTo(null); // Centrar
        vista.setVisible(true);
    }
}

