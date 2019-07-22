package lab5.xyzrentalcars.modelo.entidades;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReservaTest {

    @Test
    public void criaReservaUsandoOBuilder(){
        Reserva reserva = Reserva.Builder.umReserva().constroi();
        assertNotNull(reserva);
    }

}