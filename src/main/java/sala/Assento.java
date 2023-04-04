package sala;

public class Assento {
    protected boolean ocupado;

    public Assento() {
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void reservar() {
        this.ocupado = true;
    }

    public void cancelar() {
        this.ocupado = false;
    }
}