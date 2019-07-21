package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.builders.CarroBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarroTest {

    @Test
    public void criaCarroUsandoOBuilder(){
        Carro carro = CarroBuilder.umCarro().naSituacao(Carro.Situacao.Disponivel).constroi();
        assertNotNull(carro);
    }

}