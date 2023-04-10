import org.junit.Test;
import sala.Assento;
import sala.Mapa;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MapaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void InstanciaMapa_ObtenhoAssentos_ValidoQuantidades(){
        Mapa target = new Mapa();

        Assento[][] assentos = target.getAssentos();

        assertEquals(12, assentos.length);
        assertEquals(14, assentos[0].length);
    }

    @Test
    public void InstanciaMapa_ImprimoMapa_MapaImpressoNoConsole(){
        Mapa target = new Mapa();
        setUpStream();


        target.imprimir();
        String expected =
                """
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ A\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ B\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ C\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ D\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ E\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ F\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ G\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ H\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ I\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ J\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ K\r
                        _ _ _ _ _ _ _ _ _ _ _ _ _ _ L\r
                        1 2 3 4 5 6 7 8 9 10 11 12 13 14\r
                        """;
        String actual = outContent.toString();

        assertEquals(actual, expected);
        restoreStream();
    }

    private void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    private void restoreStream() {
        System.setOut(originalOut);
    }
}
