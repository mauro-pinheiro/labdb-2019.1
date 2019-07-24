package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Lugradouro;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SedeTest {
    @Test
    public void deveContruirUmaSedeSeTodosAtributosNotNullForemAtribuidos(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comGerente("Carlos")
                .comMultaPorSedeDiferente(new BigDecimal(10.9))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11", "1111111111"))
                .constroi();
        assertNotNull(sede);
        assertNotNull(sede.getNome());
        assertNotNull(sede.getEndereco());
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveContruirUmaSedeComEnderecoNulo(){
        Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comGerente("Carlos")
                .comMultaPorSedeDiferente(new BigDecimal(10.9))
                .comTelefones(new Telefone("11","1111111111"))
                .constroi();
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveContruirUmaSedeComNomeNulo(){
        Sede.Builder.umaSede()
                .comGerente("Carlos")
                .comMultaPorSedeDiferente(new BigDecimal(10.9))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua,"3"))
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","1111111111"))
                .constroi();
    }
}