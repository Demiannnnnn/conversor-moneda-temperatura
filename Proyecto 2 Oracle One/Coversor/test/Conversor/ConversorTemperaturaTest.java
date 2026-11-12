package Conversor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConversorTemperaturaTest {

    private static final double DELTA = 1e-9;
    private final ConversorTemperatura conversor = new ConversorTemperatura();

    @ParameterizedTest
    @CsvSource({"0, 32", "100, 212", "-40, -40", "37, 98.6"})
    void celsiusAFahrenheit(double celsius, double fahrenheit) {
        assertEquals(fahrenheit, conversor.Celsius(celsius, "Celsius a Fahrenheit"), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"0, 273.15", "100, 373.15", "-273.15, 0"})
    void celsiusAKelvin(double celsius, double kelvin) {
        assertEquals(kelvin, conversor.Celsius(celsius, "Celsius a Kelvin"), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"32, 0", "212, 100", "-40, -40"})
    void fahrenheitACelsius(double fahrenheit, double celsius) {
        assertEquals(celsius, conversor.Fahrenheit(fahrenheit, "Fahrenheit a Celsius"), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"32, 273.15", "212, 373.15"})
    void fahrenheitAKelvin(double fahrenheit, double kelvin) {
        assertEquals(kelvin, conversor.Fahrenheit(fahrenheit, "Fahrenheit a Kelvin"), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"273.15, 0", "373.15, 100", "0, -273.15"})
    void kelvinACelsius(double kelvin, double celsius) {
        assertEquals(celsius, conversor.Kelvin(kelvin, "Kelvin a Celsius"), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"273.15, 32", "373.15, 212", "233.15, -40"})
    void kelvinAFahrenheit(double kelvin, double fahrenheit) {
        assertEquals(fahrenheit, conversor.Kelvin(kelvin, "Kelvin a Fahrenheit"), DELTA);
    }

    @Test
    void idaYVueltaCelsiusFahrenheit() {
        double f = conversor.Celsius(25, "Celsius a Fahrenheit");
        assertEquals(25, conversor.Fahrenheit(f, "Fahrenheit a Celsius"), DELTA);
    }
}
