package menu;

import sala.Mapa;
import opcoes.Opcoes;

import java.util.Scanner;

public class Menu {
    private static int opcaoEscolhida = 0;
    private static Opcoes opcoes;
    private static boolean deveMostrarMenuDeEscolhas = true;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Mapa Mapa = new Mapa();
        opcoes = new Opcoes(Mapa);

        do {
            if(deveMostrarMenuDeEscolhas){
                imprimirMenuDeEscolhas();
                opcaoEscolhida = sc.nextInt();
            }

            try {
                iniciarFaseEscolhida();
                opcoes.resetarAssento();
            }
            catch (IllegalArgumentException ex){
                System.out.println(ANSI_RED + ex.getMessage() + ANSI_RESET);
                Thread.sleep(100);
            }

            deveMostrarMenuDeEscolhas = opcoes.getFluxoFoiBemSucedido();

        } while (opcaoEscolhida != 5);
    }

    private static void imprimirMenuDeEscolhas(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Reservar uma cadeira");
        System.out.println("2 - Cancelar uma reserva");
        System.out.println("3 - Verificar disponibilidade de cadeira");
        System.out.println("4 - Mostrar mapa da sala");
        System.out.println("5 - Sair");
    }

    private static void iniciarFaseEscolhida(){
        switch (opcaoEscolhida) {
            case 1:
                opcoes.reservar();
                break;
            case 2:
                opcoes.cancelar();
                break;
            case 3:
                opcoes.verificarDisponibilidade();
                break;
            case 4:
                opcoes.mostrarMapa();
                break;
            case 5:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
