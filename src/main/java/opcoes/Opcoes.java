package opcoes;

import sala.Assento;
import sala.Mapa;

import java.util.Scanner;

public class Opcoes {
    private Mapa mapa;
    private int filaEscolhida;
    private int cadeiraEscolhida;
    private final String ONLY_NUMBERS_REGEX = "[0-9]+";
    protected boolean fluxoFoiBemSucedido;
    public Opcoes(Mapa mapa) {
        this.mapa = mapa;
    }

    public void reservar() {
        this.receberEvalidarFilaEcadeira();
        Assento[][] assentos = mapa.getAssentos();

        if (assentos[filaEscolhida][cadeiraEscolhida].isOcupado()) {
            System.out.println("O assento "
                    + (char) (filaEscolhida + 'A')
                    + (cadeiraEscolhida + 1)
                    + " já está ocupado!");
        } else {
            assentos[filaEscolhida][cadeiraEscolhida].reservar();
            System.out.println("O assento "
                    + (char) (filaEscolhida + 'A')
                    + (cadeiraEscolhida + 1)
                    + " foi reservado com sucesso!");
        }

        setFluxoFoiBemSucedido(true);
    }

    public void cancelar() {
        this.receberEvalidarFilaEcadeira();
        Assento[][] assentos = mapa.getAssentos();

        if (assentos[filaEscolhida][cadeiraEscolhida].isOcupado()) {
            assentos[filaEscolhida][cadeiraEscolhida].cancelar();
            System.out.println("Reserva cancelada com sucesso!");
        } else {
            System.out.println("O assento "
                    + (char) (filaEscolhida + 'A')
                    + (cadeiraEscolhida + 1)
                    + " já está livre!");
        }

        setFluxoFoiBemSucedido(true);
    }

    public void verificarDisponibilidade() {
        receberEvalidarFilaEcadeira();
        Assento[][] assentos = mapa.getAssentos();

        if (assentos[filaEscolhida][cadeiraEscolhida].isOcupado()) {
            System.out.println("O assento "
                    + (char) (filaEscolhida + 'A')
                    + (cadeiraEscolhida + 1)
                    + " já está ocupado!");

        } else {
            System.out.println("O assento "
                    + (char) (filaEscolhida + 'A')
                    + (cadeiraEscolhida + 1)
                    + " está disponível!");
        }

        setFluxoFoiBemSucedido(true);
    }

    public void mostrarMapa() {
        mapa.imprimir();
    }

    private void validarFila(int input){
        if(input > mapa.getAssentos()[0].length -1 || input < 0){
            setFluxoFoiBemSucedido(false);
            throw new IllegalArgumentException("A fila escolhida deve estar entre A e L.");
        }
    }

    private void validarCadeira(String input) {
        if (!input.matches(ONLY_NUMBERS_REGEX)){
            setFluxoFoiBemSucedido(false);
            throw new IllegalArgumentException("A cadeira escolhida deve ser um número.");
        }

        int intInput = Integer.parseInt(input)  -1;

        if ( intInput > mapa.getAssentos()[0].length || intInput < 0){
            setFluxoFoiBemSucedido(false);
            throw new IllegalArgumentException("A cadeira escolhida deve estar entre 1 e 14.");
        }
    }

    private void receberEvalidarFilaEcadeira(){
        Scanner sc = new Scanner(System.in);

        if (filaEscolhida == 0){
            System.out.println("Digite a letra da fileira desejada:");
            int input = sc.next().toUpperCase().charAt(0) - 'A';
            validarFila(input);
            this.filaEscolhida = input;
        }

        if (cadeiraEscolhida == 0) {
            System.out.println("Digite o número da cadeira desejada:");
            String input = sc.next();
            validarCadeira(input);
            this.cadeiraEscolhida = Integer.parseInt(input)  -1;
        }
    }

    public boolean getFluxoFoiBemSucedido() {
        return fluxoFoiBemSucedido;
    }

    public void setFluxoFoiBemSucedido(boolean fluxoFoiBemSucedido) {
        this.fluxoFoiBemSucedido = fluxoFoiBemSucedido;
    }

    public void resetarAssento(){
        filaEscolhida = 0;
        cadeiraEscolhida = 0;
    }
}