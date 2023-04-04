package menu;

import sala.Mapa;
import opcoes.Opcoes;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        Mapa Mapa = new Mapa();
        Opcoes opcoes = new Opcoes(Mapa);
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Reservar uma cadeira");
            System.out.println("2 - Cancelar uma reserva");
            System.out.println("3 - Verificar disponibilidade de cadeira");
            System.out.println("4 - Mostrar mapa da sala");
            System.out.println("5 - Sair");
            opcao = sc.nextInt();

            switch (opcao) {
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
        } while (opcao != 5);
    }
    }
