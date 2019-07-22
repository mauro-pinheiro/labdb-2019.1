package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SedeTest {
    @Test
    public void criaUmaSedeUsandoOBuilder(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comGerente("Carlos")
                .comMultaPorSedeDiferente(10.90)
                .comEndereco(Endereco.Builder
                        .umEndereco()
                        .naRua("Tres")
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","1111111111"))
                .constroi();


        assertNotNull(sede);
    }
}