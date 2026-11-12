package Conversor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MainTest {

    private static final double DELTA = 1e-9;

    @ParameterizedTest
    @CsvSource({
        "0, 0.0",
        "10, 10.0",
        "-5, -5.0",
        "1000, 1000.0"
    })
    void parsearEnteros(String entrada, double esperado) {
        assertEquals(esperado, Main.parsearMonto(entrada), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
        "10.5, 10.5",
        "0.75, 0.75",
        "-40.25, -40.25",
        "0.0012, 0.0012"
    })
    void parsearDecimalesConPunto(String entrada, double esperado) {
        assertEquals(esperado, Main.parsearMonto(entrada), DELTA);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
        "10,5 | 10.5",
        "0,75 | 0.75",
        "-40,25 | -40.25",
        "0,0012 | 0.0012"
    })
    void parsearDecimalesConComa(String entrada, double esperado) {
        assertEquals(esperado, Main.parsearMonto(entrada), DELTA);
    }

    @Test
    void parsearConEspaciosAlrededor() {
        assertEquals(10.5, Main.parsearMonto("  10.5  "), DELTA);
        assertEquals(10.5, Main.parsearMonto(" \t10,5\n "), DELTA);
        assertEquals(-40.0, Main.parsearMonto("  -40  "), DELTA);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "10.5.2", "10,5,2", "12a", "--5", "foo"})
    void parsearTextoNoNumericoLanzaNumberFormatException(String entrada) {
        assertThrows(NumberFormatException.class, () -> Main.parsearMonto(entrada));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    void parsearVacioLanzaNumberFormatException(String entrada) {
        assertThrows(NumberFormatException.class, () -> Main.parsearMonto(entrada));
    }

    @Test
    void parsearNullLanzaNullPointerException() {
        assertThrows(NullPointerException.class, () -> Main.parsearMonto(null));
    }
}
