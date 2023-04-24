package sala;

public class Mapa {
    protected Assento[][] assentos;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private final static int TAMANHO_LINHA = 12;
    private final static int TAMANHO_COLUNA = 14;

    public Mapa() {
        this.assentos = new Assento[TAMANHO_LINHA][TAMANHO_COLUNA];
        for (int i = 0; i < TAMANHO_LINHA; i++) {
            for (int j = 0; j < TAMANHO_COLUNA; j++) {
                this.assentos[i][j] = new Assento();
            }
        }
    }

    public void imprimir() {
        for (int i = 0; i < TAMANHO_LINHA; i++) {
            for (int j = 0; j < TAMANHO_COLUNA; j++) {
                if (assentos[i][j].isOcupado()) {
                    System.out.print(ANSI_RED + (char) ('A' + i) + "" + (j + 1) + " " + ANSI_RESET); // ocupada
                } else {
                    System.out.print(ANSI_GREEN + (char) ('A' + i) + "" + (j + 1) + " " + ANSI_RESET); // livre
                }
            }
            System.out.println();
        }
    }

    public Assento[][] getAssentos() {
        return assentos;
    }
}