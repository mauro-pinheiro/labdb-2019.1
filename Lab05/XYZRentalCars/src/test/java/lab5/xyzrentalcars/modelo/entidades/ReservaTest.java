package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.builders.ReservaBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservaTest {

    @Test
    public void criaReservaUsandoOBuilder(){
        Reserva reserva = ReservaBuilder.umReserva().constroi();
        assertNotNull(reserva);
    }

}