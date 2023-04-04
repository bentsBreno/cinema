package opcoes;

import sala.Assento;
import sala.Mapa;

import java.util.Scanner;

public class Opcoes {
    protected Mapa mapa;

    public Opcoes(Mapa mapa) {
        this.mapa = mapa;
    }

    public void reservar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a letra da fileira desejada:");
        int fila = (int) sc.next().toUpperCase().charAt(0) - 'A';
        System.out.println("Digite o número da cadeira desejada:");
        int cadeira = sc.nextInt() - 1;

        Assento[][] assentos = mapa.getAssentos();
        if (assentos[fila][cadeira].isOcupado()) {
            System.out.println("O assento " + (char) (fila + 'A') + (cadeira + 1) + " já está ocupado!");

        } else {
            assentos[fila][cadeira].reservar();
            System.out.println("O assento " + (char) (fila + 'A') + (cadeira + 1) + " reservado com sucesso!");

        }
    }

    public void cancelar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a letra da fileira desejada:");
        int fila = (int) sc.next().toUpperCase().charAt(0) - 'A';
        System.out.println("Digite o número da cadeira desejada:");
        int cadeira = sc.nextInt() - 1;

        Assento[][] assentos = mapa.getAssentos();
        if (assentos[fila][cadeira].isOcupado()) {
            assentos[fila][cadeira].cancelar();
            System.out.println("Reserva cancelada com sucesso!");
        } else {
            System.out.println("O assento " + (char) (fila + 'A') + (cadeira + 1) + " já está livre!");

        }
    }

    public void verificarDisponibilidade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a letra da fileira desejada:");
        int fila = (int) sc.next().toUpperCase().charAt(0) - 'A';
        System.out.println("Digite o número da cadeira desejada:");
        int cadeira = sc.nextInt() - 1;

        Assento[][] assentos = mapa.getAssentos();
        if (assentos[fila][cadeira].isOcupado()) {
            System.out.println("O assento " + (char) (fila + 'A') + (cadeira + 1) + " já está ocupado!");

        } else {
            System.out.println("O assento " + (char) (fila + 'A') + (cadeira + 1) + " está disponível!");

        }
    }

    public void mostrarMapa() {
        mapa.imprimir();
    }
}