package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.builders.EnderecoBuilder;
import lab5.xyzrentalcars.builders.SedeBuilder;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SedeTest {
    @Test
    public void criaUmaSedeUsandoOBuilder(){
        Sede sede = SedeBuilder.umaSede()
                .comNome("Sede1")
                .comGerente("Tomas")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comTelefones(new Telefone("11","11111111"))
                .comEndereco(EnderecoBuilder.umEndereco()
                        .naRua("3")
                        .noBairro("Ipem Turu")
                        .constroi())
                .constroi();

        assertNotNull(sede);
    }
}