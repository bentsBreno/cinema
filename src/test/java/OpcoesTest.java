import opcoes.Opcoes;
import org.junit.Assert;
import org.junit.Test;
import sala.Mapa;

import java.io.ByteArrayInputStream;

public class OpcoesTest extends InputTestBase {
    @Test
    public void InstanciaOpcoes_Reservo_Sucesso(){
        Mapa mapa = new Mapa();
        Opcoes target = new Opcoes(mapa);
        setUpStream();

        String userInput = String.format("a%s1",
                System.lineSeparator());

        setarSystemIn(userInput);

        target.reservar();

        String expected = "O assento A1 foi reservado com sucesso!";
        String actual = obterUltimaLinhaImpressaNoConsole();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void InstanciaOpcoes_ReservoMesmoAssento_Erro(){
        Mapa mapa = new Mapa();
        Opcoes target = new Opcoes(mapa);
        setUpStream();

        String userInput = String.format("a%s1",
                System.lineSeparator());

        setarSystemIn(userInput);

        target.reservar();

        String segundoUserInput = String.format("a%s1",
                System.lineSeparator());

        setarSystemIn(segundoUserInput);

        target.reservar();

        String expected = "O assento A1 já está ocupado!";
        String actual = obterUltimaLinhaImpressaNoConsole();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void InstanciaOpcoes_InputoTiposErrados_Erros(){
        Mapa mapa = new Mapa();
        Opcoes target = new Opcoes(mapa);
        setUpStream();

        String userInput = String.format("1",
                System.lineSeparator());

        setarSystemIn(userInput);

        target.reservar();

        String expected = "O assento A1 já está ocupado!";
        String actual = obterUltimaLinhaImpressaNoConsole();

        Assert.assertThrows(IllegalArgumentException.class, () ->target.reservar(), "a");
    }

    private void ReservarAssentoA1(){

    }
}
