package Conversor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ConversorMonedaTest {

    private static final double DELTA = 1e-9;
    private final ConversorMoneda conversor = new ConversorMoneda();

    @Test
    void dolar() {
        assertEquals(1.2, conversor.dolar(1000, "Peso a Dolar"), DELTA);
        assertEquals(851.35, conversor.dolar(1, "Dolar a Pesos"), DELTA);
    }

    @Test
    void euro() {
        assertEquals(1.1, conversor.euro(1000, "Peso a Euro"), DELTA);
        assertEquals(932.84, conversor.euro(1, "Euro a Pesos"), DELTA);
    }

    @Test
    void libras() {
        assertEquals(0.92, conversor.libras(1000, "Peso a Libras"), DELTA);
        assertEquals(1084.23, conversor.libras(1, "Libras a Pesos"), DELTA);
    }

    @Test
    void yen() {
        assertEquals(17, conversor.yen(100, "Peso a Yen"), DELTA);
        assertEquals(5.97, conversor.yen(1, "Yen a Pesos"), DELTA);
    }

    @Test
    void wonCoreano() {
        assertEquals(154, conversor.wonCoreano(100, "Peso a Won Coreano"), DELTA);
        // La etiqueta del menu en Main es "Won Coreando a Pesos"; cualquier opcion
        // distinta de "Peso a Won Coreano" convierte de won a pesos.
        assertEquals(65, conversor.wonCoreano(100, "Won Coreando a Pesos"), DELTA);
    }

    @Test
    void ceroConvierteACero() {
        assertEquals(0, conversor.dolar(0, "Peso a Dolar"), DELTA);
        assertEquals(0, conversor.euro(0, "Euro a Pesos"), DELTA);
        assertEquals(0, conversor.yen(0, "Peso a Yen"), DELTA);
    }

    @Test
    void tasasDeIdaYVueltaSonAproximadamenteInversas() {
        // Las tasas estan redondeadas: ida y vuelta debe quedar dentro de un 10%.
        double[][] pares = {
            {conversor.dolar(1, "Peso a Dolar"), conversor.dolar(1, "Dolar a Pesos")},
            {conversor.euro(1, "Peso a Euro"), conversor.euro(1, "Euro a Pesos")},
            {conversor.libras(1, "Peso a Libras"), conversor.libras(1, "Libras a Pesos")},
            {conversor.yen(1, "Peso a Yen"), conversor.yen(1, "Yen a Pesos")},
            {conversor.wonCoreano(1, "Peso a Won Coreano"), conversor.wonCoreano(1, "Won Coreando a Pesos")},
        };
        for (double[] par : pares) {
            double producto = par[0] * par[1];
            assertTrue(Math.abs(producto - 1) < 0.1, "ida*vuelta=" + producto);
        }
    }
}
