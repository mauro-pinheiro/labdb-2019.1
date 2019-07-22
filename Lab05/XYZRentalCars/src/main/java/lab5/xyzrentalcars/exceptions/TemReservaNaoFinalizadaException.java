package lab5.xyzrentalcars.exceptions;

public class TemReservaNaoFinalizadaException extends RuntimeException {

    public TemReservaNaoFinalizadaException(){
        super("Nao pode realizar outra reserva enquanto tiver uma reserva ativa");
    }
}
