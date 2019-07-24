package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Lugradouro;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class ReservaTest {

    @Test
    public void deveConstruirUmaReservaSeTodosAtributosNotNullForemAtribuidos(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Reserva reserva = Reserva.Builder.umReserva()
                .comSedeDeLocacao(sede)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
        assertNotNull(reserva);
        assertNotNull(reserva.getSedeLocacao());
        assertNotNull(reserva.getDataLocacao());
        assertNotNull(reserva.getDiarias());
        assertNotNull(reserva.getMulta());
        assertNotNull(reserva.getSituacao());
    }

    @Test(expected = NullPointerException.class)
    public void naoaDeveContruirReservaComDataDeLocacaoNula(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Reserva reserva = Reserva.Builder.umReserva()
                //.comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveContruirReservaComQtdeDiariasNula(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Reserva reserva = Reserva.Builder.umReserva()
                .comDataLocacao(LocalDate.now())
                //.comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveContruirReservaComMultaNula(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Reserva reserva = Reserva.Builder.umReserva()
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                //.comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveContruirReservaComCarroNulo(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(sede)
                .constroi();
        Reserva reserva = Reserva.Builder.umReserva()
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                //.doCarro(carro)
                .constroi();
    }

    @Test(expected = NullPointerException.class)
    public void nadaDeveContruirReservaComClienteNulo(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                .constroi();
        Reserva reserva = Reserva.Builder.umReserva()
                //.comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                //.paraCliente(cliente)
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }

    @Test(expected = NullPointerException.class)
    public void nadaDeveContruirReservaComSedeDeLocacaoNula(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Reserva reserva = Reserva.Builder.umReserva()
                //.comSedeDeLocacao(sede)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveContruirReservaParaClienteComReservaNaoFinalizada(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Cliente cliente1 = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                .constroi();

        Reserva reserva1 = Reserva.Builder.umReserva(1)
                .comSedeDeLocacao(sede)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(cliente1)
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();

        Reserva reserva2 = Reserva.Builder.umReserva(2)
                .comSedeDeLocacao(sede)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(cliente1)
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }

    @Test
    public void deveMudarSituacaoDoCarroParaAlugadoAoCriarUmaReserva(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(sede)
                .constroi();

        assertEquals(carro.getSituacao(), Carro.Situacao.Disponivel);

        Reserva reserva1 = Reserva.Builder.umReserva()
                .comSedeDeLocacao(sede)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                .doCarro(carro)
                .constroi();

        assertEquals(carro.getSituacao(), Carro.Situacao.Alugado);
    }

    @Test
    public void deveCriarReservaParaCarroDisponivel(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(sede)
                .constroi();

        assertEquals(carro.getSituacao(), Carro.Situacao.Disponivel);

        Reserva reserva1 = Reserva.Builder.umReserva()
                .comSedeDeLocacao(sede)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                .doCarro(carro)
                .constroi();

        assertNotNull(reserva1);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveCriarReservaParaCarroAlugado(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Alugado)
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(null)
                .constroi();

        Reserva reserva1 = Reserva.Builder.umReserva()
                .comSedeDeLocacao(sede)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                .doCarro(carro)
                .constroi();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveContruirReservaParaCarroForaDaSedeDeOrigem(){
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Sede sede2 = Sede.Builder.umaSede(2)
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.ForaDaSedeDeOrigem)
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede2)
                .constroi();

        Reserva reserva1 = Reserva.Builder.umReserva()
                .comSedeDeLocacao(sede1)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(Cliente.Builder.umCliente()
                        .comNome("Mauro")
                        .comCPF("1234")
                        .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                        .constroi())
                .doCarro(carro)
                .constroi();
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveContruirReservaParaClienteComCNHVencida(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Cliente cliente1 = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comCNH(new CNH("1234", LocalDate.now().minusMonths(10)))
                .constroi();

        Reserva reserva1 = Reserva.Builder.umReserva(1)
                .comSedeDeLocacao(sede)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(cliente1)
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }
}