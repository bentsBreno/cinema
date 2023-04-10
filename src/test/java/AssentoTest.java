import org.junit.Assert;
import org.junit.Test;
import sala.Assento;

public class AssentoTest {
    // Seguindo o modelo GivenWhenThen
    // https://martinfowler.com/bliki/GivenWhenThen.html
    @Test
    public void InstanciaAssento_ObtenhoPropriedades_ValidoValoresIniciais(){
        Assento target = new Assento();

        boolean estahOcupado = target.isOcupado();

        Assert.assertFalse(estahOcupado);
    }

    @Test
    public void InstanciaAssento_Reservo_ValidoReserva(){
        Assento target = new Assento();

        target.reservar();
        boolean estahOcupado = target.isOcupado();

        Assert.assertTrue(estahOcupado);
    }

    @Test
    public void InstanciaAssento_ReservoEcancelo_ValidoCancelamento(){
        Assento target = new Assento();
        target.reservar();
        target.cancelar();

        boolean estahOcupado = target.isOcupado();

        Assert.assertFalse(estahOcupado);
    }
}
