
package modelo;

public class modeloEjercicio2 { // Podrías renombrar la clase a TareaEjercicio2 si prefieres

    private String nombre;       // El texto de la tarea (ej: "Comprar pan")
    private boolean completada; // Un 'interruptor' que dice si está hecha (true) o no (false)

    public modeloEjercicio2(String nombre) {
        this.nombre = nombre;
        this.completada = false; // Por defecto, no está hecha.
    }

    public String getNombre() {
        return nombre;
    }


    public boolean estaCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        // Usamos un operador ternario (una forma corta de hacer un if-else):
        // (condición ? valor_si_es_verdad : valor_si_es_falso)
        String marca = (completada ? "[X] " : "[ ] "); // Pone [X] si 'completada' es true, si no [ ]
        return marca + nombre; // Une la marca con el nombre de la tarea.
    }
}
