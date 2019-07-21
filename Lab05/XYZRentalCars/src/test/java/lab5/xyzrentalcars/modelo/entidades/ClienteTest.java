package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.builders.ClienteBuilder;
import lab5.xyzrentalcars.builders.EnderecoBuilder;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ClienteTest {
    @Test
    public void criaUmClienteComOBuilder(){
        Cliente cliente = ClienteBuilder.umCliente()
                .comNome("Mauro")
                .comCPF("12345")
                .comNumeroCNH("123456")
                .comValidadeCNH(LocalDate.now().plusMonths(10))
                .comEnderecos(EnderecoBuilder.umEndereco()
                        .naRua("3")
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","111111"),
                        new Telefone("22","22222222"))
                .constroi();
        assertNotNull(cliente);
    }
}