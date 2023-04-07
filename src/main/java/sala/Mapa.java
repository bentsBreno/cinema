package sala;

public class Mapa {
    protected Assento[][] assentos;
    
    private final static int ROW_SIZE = 12;
    private final static int COLUMN_SIZE = 14;

    public Mapa() {
        this.assentos = new Assento[ROW_SIZE][COLUMN_SIZE];
        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                this.assentos[i][j] = new Assento();
            }
        }
    }

    public void imprimir() {
        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                if (assentos[i][j].isOcupado()) {
                    System.out.print("X "); // cadeira ocupada
                } else {
                    System.out.print("_ "); // cadeira livre
                }
            }
            System.out.println((char)('A' + i)); // imprime a letra da fila
        }
        System.out.println("1 2 3 4 5 6 7 8 9 10 11 12 13 14"); // imprime o número da cadeira
    }

    public Assento[][] getAssentos() {
        return assentos;
    }
}