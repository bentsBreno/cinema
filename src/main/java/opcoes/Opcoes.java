package opcoes;

import sala.Assento;
import sala.Mapa;

import java.util.Scanner;

public class Opcoes {
    private Mapa mapa;
    private int filaEscolhida;
    private int cadeiraEscolhida;

    public Opcoes(Mapa mapa) {
        this.mapa = mapa;
    }

    public void reservar() {
        this.receberFilaEcadeira();
        this.validarFilaEcadeira();

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
                    + " reservado com sucesso!");
        }
    }

    public void cancelar() {
        this.receberFilaEcadeira();
        this.validarFilaEcadeira();

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
    }

    public void verificarDisponibilidade() {
        this.receberFilaEcadeira();
        this.validarFilaEcadeira();

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
    }

    public void mostrarMapa() {
        mapa.imprimir();
    }

    private void validarFilaEcadeira(){
        if(this.filaEscolhida > 12 || this.filaEscolhida < 1){
            //Criar excecao
        }

        if(this.cadeiraEscolhida > 14 || this.cadeiraEscolhida < 1){

        }
    }

    private void receberFilaEcadeira(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a letra da fileira desejada:");
        this.filaEscolhida = sc.next().toUpperCase().charAt(0) - 'A';
        System.out.println("Digite o número da cadeira desejada:");
        this.cadeiraEscolhida = sc.nextInt() - 1;
    }
}