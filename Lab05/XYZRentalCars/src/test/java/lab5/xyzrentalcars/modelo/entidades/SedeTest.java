package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Lugradouro;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    //Teste 10
    @Test
    public void recuperaTodasAsReservasEmAbertoDeUmaSede(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Cliente clientes[] = new Cliente[]{
                Cliente.Builder.umCliente()
                        .comCPF("1")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .comNome("Mauro")
                        .constroi(),
                Cliente.Builder.umCliente()
                        .comCPF("2")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .comNome("Sergio")
                        .constroi(),
                Cliente.Builder.umCliente()
                        .comCPF("3")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .comNome("Carlos")
                        .constroi(),
                Cliente.Builder.umCliente()
                        .comCPF("4")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .comNome("João")
                        .constroi(),
                Cliente.Builder.umCliente()
                        .comCPF("5")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .comNome("Pedro")
                        .constroi()
        };

        Carro carros[] = new Carro[]{
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .constroi()
        };

        Reserva reservas[] = new Reserva[]{
                Reserva.Builder.umReserva(1)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.now())
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[0])
                        .doCarro(carros[0])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(2)
                        .naSituacao(Reserva.Situcao.Atrazada)
                        .comDataLocacao(LocalDate.now())
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[1])
                        .doCarro(carros[1])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(3)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.now())
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[2])
                        .doCarro(carros[2])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(4)
                        .naSituacao(Reserva.Situcao.Finalizada)
                        .comDataLocacao(LocalDate.now())
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[3])
                        .doCarro(carros[3])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(5)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.now())
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[4])
                        .doCarro(carros[4])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi()
        };

        int qtdeAbertas = 0;
        for(int i = 0; i < reservas.length; i++){
            if(!Objects.equals(reservas[i].getSituacao(), Reserva.Situcao.Finalizada))
                qtdeAbertas++;
        }


        Set<Reserva> abertas = sede.reservasEmAberto();

        System.out.println(qtdeAbertas);
        Assert.assertEquals(qtdeAbertas, abertas.size());
        abertas.stream()
                .map(r -> r.getSituacao())
                .forEach(s -> Assert.assertNotEquals(s, Reserva.Situcao.Finalizada));
    }
}