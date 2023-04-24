import opcoes.Opcoes;
import org.junit.Test;
import sala.Assento;
import sala.Mapa;

import static org.junit.Assert.*;

public class MapaTest extends InputTestBase {
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
                        [32mA1 [0m[32mA2 [0m[32mA3 [0m[32mA4 [0m[32mA5 [0m[32mA6 [0m[32mA7 [0m[32mA8 [0m[32mA9 [0m[32mA10 [0m[32mA11 [0m[32mA12 [0m[32mA13 [0m[32mA14 [0m\r
                        [32mB1 [0m[32mB2 [0m[32mB3 [0m[32mB4 [0m[32mB5 [0m[32mB6 [0m[32mB7 [0m[32mB8 [0m[32mB9 [0m[32mB10 [0m[32mB11 [0m[32mB12 [0m[32mB13 [0m[32mB14 [0m\r
                        [32mC1 [0m[32mC2 [0m[32mC3 [0m[32mC4 [0m[32mC5 [0m[32mC6 [0m[32mC7 [0m[32mC8 [0m[32mC9 [0m[32mC10 [0m[32mC11 [0m[32mC12 [0m[32mC13 [0m[32mC14 [0m\r
                        [32mD1 [0m[32mD2 [0m[32mD3 [0m[32mD4 [0m[32mD5 [0m[32mD6 [0m[32mD7 [0m[32mD8 [0m[32mD9 [0m[32mD10 [0m[32mD11 [0m[32mD12 [0m[32mD13 [0m[32mD14 [0m\r
                        [32mE1 [0m[32mE2 [0m[32mE3 [0m[32mE4 [0m[32mE5 [0m[32mE6 [0m[32mE7 [0m[32mE8 [0m[32mE9 [0m[32mE10 [0m[32mE11 [0m[32mE12 [0m[32mE13 [0m[32mE14 [0m\r
                        [32mF1 [0m[32mF2 [0m[32mF3 [0m[32mF4 [0m[32mF5 [0m[32mF6 [0m[32mF7 [0m[32mF8 [0m[32mF9 [0m[32mF10 [0m[32mF11 [0m[32mF12 [0m[32mF13 [0m[32mF14 [0m\r
                        [32mG1 [0m[32mG2 [0m[32mG3 [0m[32mG4 [0m[32mG5 [0m[32mG6 [0m[32mG7 [0m[32mG8 [0m[32mG9 [0m[32mG10 [0m[32mG11 [0m[32mG12 [0m[32mG13 [0m[32mG14 [0m\r
                        [32mH1 [0m[32mH2 [0m[32mH3 [0m[32mH4 [0m[32mH5 [0m[32mH6 [0m[32mH7 [0m[32mH8 [0m[32mH9 [0m[32mH10 [0m[32mH11 [0m[32mH12 [0m[32mH13 [0m[32mH14 [0m\r
                        [32mI1 [0m[32mI2 [0m[32mI3 [0m[32mI4 [0m[32mI5 [0m[32mI6 [0m[32mI7 [0m[32mI8 [0m[32mI9 [0m[32mI10 [0m[32mI11 [0m[32mI12 [0m[32mI13 [0m[32mI14 [0m\r
                        [32mJ1 [0m[32mJ2 [0m[32mJ3 [0m[32mJ4 [0m[32mJ5 [0m[32mJ6 [0m[32mJ7 [0m[32mJ8 [0m[32mJ9 [0m[32mJ10 [0m[32mJ11 [0m[32mJ12 [0m[32mJ13 [0m[32mJ14 [0m\r
                        [32mK1 [0m[32mK2 [0m[32mK3 [0m[32mK4 [0m[32mK5 [0m[32mK6 [0m[32mK7 [0m[32mK8 [0m[32mK9 [0m[32mK10 [0m[32mK11 [0m[32mK12 [0m[32mK13 [0m[32mK14 [0m\r
                        [32mL1 [0m[32mL2 [0m[32mL3 [0m[32mL4 [0m[32mL5 [0m[32mL6 [0m[32mL7 [0m[32mL8 [0m[32mL9 [0m[32mL10 [0m[32mL11 [0m[32mL12 [0m[32mL13 [0m[32mL14 [0m\r                            
                        """;
        String actual = outContent.toString();

        assertEquals(actual, expected);
    }

    @Test
    public void InstanciaMapa_Reservo_MapaImpressoNoConsoleTemOAssentoOcupado(){
        Mapa target = new Mapa();
        Opcoes opcoes = new Opcoes(target);
        setUpStream();
        String userInput = String.format("a%s1",
                System.lineSeparator());

        setarSystemIn(userInput);

        opcoes.reservar();
        target.imprimir();

        String expected =
                """
                        Digite a letra da fileira desejada:\r
                        Digite o número da cadeira desejada:\r
                        O assento A1 foi reservado com sucesso!\r
                        [31mA1 [0m[32mA2 [0m[32mA3 [0m[32mA4 [0m[32mA5 [0m[32mA6 [0m[32mA7 [0m[32mA8 [0m[32mA9 [0m[32mA10 [0m[32mA11 [0m[32mA12 [0m[32mA13 [0m[32mA14 [0m\r
                        [32mB1 [0m[32mB2 [0m[32mB3 [0m[32mB4 [0m[32mB5 [0m[32mB6 [0m[32mB7 [0m[32mB8 [0m[32mB9 [0m[32mB10 [0m[32mB11 [0m[32mB12 [0m[32mB13 [0m[32mB14 [0m\r
                        [32mC1 [0m[32mC2 [0m[32mC3 [0m[32mC4 [0m[32mC5 [0m[32mC6 [0m[32mC7 [0m[32mC8 [0m[32mC9 [0m[32mC10 [0m[32mC11 [0m[32mC12 [0m[32mC13 [0m[32mC14 [0m\r
                        [32mD1 [0m[32mD2 [0m[32mD3 [0m[32mD4 [0m[32mD5 [0m[32mD6 [0m[32mD7 [0m[32mD8 [0m[32mD9 [0m[32mD10 [0m[32mD11 [0m[32mD12 [0m[32mD13 [0m[32mD14 [0m\r
                        [32mE1 [0m[32mE2 [0m[32mE3 [0m[32mE4 [0m[32mE5 [0m[32mE6 [0m[32mE7 [0m[32mE8 [0m[32mE9 [0m[32mE10 [0m[32mE11 [0m[32mE12 [0m[32mE13 [0m[32mE14 [0m\r
                        [32mF1 [0m[32mF2 [0m[32mF3 [0m[32mF4 [0m[32mF5 [0m[32mF6 [0m[32mF7 [0m[32mF8 [0m[32mF9 [0m[32mF10 [0m[32mF11 [0m[32mF12 [0m[32mF13 [0m[32mF14 [0m\r
                        [32mG1 [0m[32mG2 [0m[32mG3 [0m[32mG4 [0m[32mG5 [0m[32mG6 [0m[32mG7 [0m[32mG8 [0m[32mG9 [0m[32mG10 [0m[32mG11 [0m[32mG12 [0m[32mG13 [0m[32mG14 [0m\r
                        [32mH1 [0m[32mH2 [0m[32mH3 [0m[32mH4 [0m[32mH5 [0m[32mH6 [0m[32mH7 [0m[32mH8 [0m[32mH9 [0m[32mH10 [0m[32mH11 [0m[32mH12 [0m[32mH13 [0m[32mH14 [0m\r
                        [32mI1 [0m[32mI2 [0m[32mI3 [0m[32mI4 [0m[32mI5 [0m[32mI6 [0m[32mI7 [0m[32mI8 [0m[32mI9 [0m[32mI10 [0m[32mI11 [0m[32mI12 [0m[32mI13 [0m[32mI14 [0m\r
                        [32mJ1 [0m[32mJ2 [0m[32mJ3 [0m[32mJ4 [0m[32mJ5 [0m[32mJ6 [0m[32mJ7 [0m[32mJ8 [0m[32mJ9 [0m[32mJ10 [0m[32mJ11 [0m[32mJ12 [0m[32mJ13 [0m[32mJ14 [0m\r
                        [32mK1 [0m[32mK2 [0m[32mK3 [0m[32mK4 [0m[32mK5 [0m[32mK6 [0m[32mK7 [0m[32mK8 [0m[32mK9 [0m[32mK10 [0m[32mK11 [0m[32mK12 [0m[32mK13 [0m[32mK14 [0m\r
                        [32mL1 [0m[32mL2 [0m[32mL3 [0m[32mL4 [0m[32mL5 [0m[32mL6 [0m[32mL7 [0m[32mL8 [0m[32mL9 [0m[32mL10 [0m[32mL11 [0m[32mL12 [0m[32mL13 [0m[32mL14 [0m\r                            
                        """;
        String actual = outContent.toString();

        assertEquals(actual, expected);
    }

    @Test
    public void InstanciaMapa_ReservoECancelo_MapaImpressoNoConsoleTemOAssentoLivre(){
        Mapa target = new Mapa();
        Opcoes opcoes = new Opcoes(target);
        setUpStream();
        String userInput = String.format("a%s1",
                System.lineSeparator());

        setarSystemIn(userInput);

        opcoes.reservar();

        String userInputDois= String.format("a%s1",
                System.lineSeparator());

        setarSystemIn(userInputDois);
        opcoes.cancelar();
        target.imprimir();

        String expected =
                """
                        [32mA1 [0m[32mA2 [0m[32mA3 [0m[32mA4 [0m[32mA5 [0m[32mA6 [0m[32mA7 [0m[32mA8 [0m[32mA9 [0m[32mA10 [0m[32mA11 [0m[32mA12 [0m[32mA13 [0m[32mA14 [0m\r
                        [32mB1 [0m[32mB2 [0m[32mB3 [0m[32mB4 [0m[32mB5 [0m[32mB6 [0m[32mB7 [0m[32mB8 [0m[32mB9 [0m[32mB10 [0m[32mB11 [0m[32mB12 [0m[32mB13 [0m[32mB14 [0m\r
                        [32mC1 [0m[32mC2 [0m[32mC3 [0m[32mC4 [0m[32mC5 [0m[32mC6 [0m[32mC7 [0m[32mC8 [0m[32mC9 [0m[32mC10 [0m[32mC11 [0m[32mC12 [0m[32mC13 [0m[32mC14 [0m\r
                        [32mD1 [0m[32mD2 [0m[32mD3 [0m[32mD4 [0m[32mD5 [0m[32mD6 [0m[32mD7 [0m[32mD8 [0m[32mD9 [0m[32mD10 [0m[32mD11 [0m[32mD12 [0m[32mD13 [0m[32mD14 [0m\r
                        [32mE1 [0m[32mE2 [0m[32mE3 [0m[32mE4 [0m[32mE5 [0m[32mE6 [0m[32mE7 [0m[32mE8 [0m[32mE9 [0m[32mE10 [0m[32mE11 [0m[32mE12 [0m[32mE13 [0m[32mE14 [0m\r
                        [32mF1 [0m[32mF2 [0m[32mF3 [0m[32mF4 [0m[32mF5 [0m[32mF6 [0m[32mF7 [0m[32mF8 [0m[32mF9 [0m[32mF10 [0m[32mF11 [0m[32mF12 [0m[32mF13 [0m[32mF14 [0m\r
                        [32mG1 [0m[32mG2 [0m[32mG3 [0m[32mG4 [0m[32mG5 [0m[32mG6 [0m[32mG7 [0m[32mG8 [0m[32mG9 [0m[32mG10 [0m[32mG11 [0m[32mG12 [0m[32mG13 [0m[32mG14 [0m\r
                        [32mH1 [0m[32mH2 [0m[32mH3 [0m[32mH4 [0m[32mH5 [0m[32mH6 [0m[32mH7 [0m[32mH8 [0m[32mH9 [0m[32mH10 [0m[32mH11 [0m[32mH12 [0m[32mH13 [0m[32mH14 [0m\r
                        [32mI1 [0m[32mI2 [0m[32mI3 [0m[32mI4 [0m[32mI5 [0m[32mI6 [0m[32mI7 [0m[32mI8 [0m[32mI9 [0m[32mI10 [0m[32mI11 [0m[32mI12 [0m[32mI13 [0m[32mI14 [0m\r
                        [32mJ1 [0m[32mJ2 [0m[32mJ3 [0m[32mJ4 [0m[32mJ5 [0m[32mJ6 [0m[32mJ7 [0m[32mJ8 [0m[32mJ9 [0m[32mJ10 [0m[32mJ11 [0m[32mJ12 [0m[32mJ13 [0m[32mJ14 [0m\r
                        [32mK1 [0m[32mK2 [0m[32mK3 [0m[32mK4 [0m[32mK5 [0m[32mK6 [0m[32mK7 [0m[32mK8 [0m[32mK9 [0m[32mK10 [0m[32mK11 [0m[32mK12 [0m[32mK13 [0m[32mK14 [0m\r
                        [32mL1 [0m[32mL2 [0m[32mL3 [0m[32mL4 [0m[32mL5 [0m[32mL6 [0m[32mL7 [0m[32mL8 [0m[32mL9 [0m[32mL10 [0m[32mL11 [0m[32mL12 [0m[32mL13 [0m[32mL14 [0m\r                            
                        """;
        String actual = outContent.toString();

        assertTrue(actual.contains(expected));
    }
}
