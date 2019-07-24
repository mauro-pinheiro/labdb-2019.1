package lab5.xyzrentalcars.modelo.embutiveis;

import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnderecoTest {
    @Test
    public void deveContruirEnderecoSeTodosAtributosNotNullForemAtribuidos(){
        Endereco endereco = Endereco.Builder.umEndereco()
                .comLugradouro(new Lugradouro(TipoLugradouro.Rua,"3"))
                .noBairro("Turu")
                .constroi();

        assertNotNull(endereco);
        assertNotNull(endereco.getLugradouro());
        assertNotNull(endereco.getBairro());
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveContruirEnderecoComBairroNulo(){
        Endereco.Builder.umEndereco()
                .comLugradouro(new Lugradouro(TipoLugradouro.Rua,"3"))
                //.noBairro("Turu")
                .constroi();
    }
    @Test(expected = NullPointerException.class)
    public void naoDeveContruirEnderecoComLugradouroNulo(){
        Endereco.Builder.umEndereco()
                //.comLugradouro(new Lugradouro(TipoLugradouro.Rua,"3"))
                .noBairro("Turu")
                .constroi();
    }
}