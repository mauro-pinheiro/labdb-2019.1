package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Lugradouro;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ClienteTest {
    @Test
    public void deveConstruirUmCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("12345")
                .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                .comEnderecos(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua,"3"))
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","111111"),
                        new Telefone("22","22222222"))
                .constroi();
        assertNotNull(cliente);
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveContruirClienteComCNHNula(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("12345")
                //.comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                .comEnderecos(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua,"3"))
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","111111"),
                        new Telefone("22","22222222"))
                .constroi();
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveConstruirClienteComNomeNulo(){
        Cliente cliente = Cliente.Builder.umCliente()
                //.comNome("Mauro")
                .comCPF("12345")
                .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                .comEnderecos(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua,"3"))
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","111111"),
                        new Telefone("22","22222222"))
                .constroi();
        assertNotNull(cliente);
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveCriarClienteComCpfNulo(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                //.comCPF("12345")
                .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                .comEnderecos(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua,"3"))
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","111111"),
                        new Telefone("22","22222222"))
                .constroi();
        assertNotNull(cliente);
    }
}