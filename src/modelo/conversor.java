
package modelo;

public class conversor {


    public double celsiusAFahrenheit(double celsius) {
        // Fórmula: F = (C * 9/5) + 32
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    public double fahrenheitACelsius(double fahrenheit) {
        // Fórmula: C = (F - 32) * 5/9
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}
