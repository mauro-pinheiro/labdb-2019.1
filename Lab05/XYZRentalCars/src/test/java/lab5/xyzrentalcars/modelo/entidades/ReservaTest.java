package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Lugradouro;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import org.junit.Assert;
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
                        .naSituacao(Carro.Situacao.Disponível)
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
                        .naSituacao(Carro.Situacao.Disponível)
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
                        .naSituacao(Carro.Situacao.Disponível)
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
                        .naSituacao(Carro.Situacao.Disponível)
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
                .naSituacao(Carro.Situacao.Disponível)
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
                        .naSituacao(Carro.Situacao.Disponível)
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
                        .naSituacao(Carro.Situacao.Disponível)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }

    //Teste 4
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
                        .naSituacao(Carro.Situacao.Disponível)
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
                        .naSituacao(Carro.Situacao.Disponível)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }

    //Teste 5
    @Test
    public void DeveContruirReservaParaClienteSemPendencias(){
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
                        .naSituacao(Carro.Situacao.Disponível)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();

        reserva1.finalizar(sede);

        Reserva reserva2 = Reserva.Builder.umReserva(2)
                .comSedeDeLocacao(sede)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(cliente1)
                .doCarro(Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponível)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();

        assertNotNull(reserva2);
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
                .naSituacao(Carro.Situacao.Disponível)
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(sede)
                .constroi();

        assertEquals(carro.getSituacao(), Carro.Situacao.Disponível);

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
                .naSituacao(Carro.Situacao.Disponível)
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(sede)
                .constroi();

        assertEquals(carro.getSituacao(), Carro.Situacao.Disponível);

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

    //Teste 7
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

    //Teste 9
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
                        .naSituacao(Carro.Situacao.Disponível)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();
    }

    //Teste 8
    @Test
    public void deveContruirReservaParaClienteComCNHDentroDaValidade(){
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
                        .naSituacao(Carro.Situacao.Disponível)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();

        assertFalse(cliente1.comCnhVencida());
        assertNotNull(reserva1);
    }

    //Teste 3
    @Test
    public void deveRealizarReservaParaCarroEmOutraSede(){
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Sede sede2 = Sede.Builder.umaSede()
                .comNome("Sede 2")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponível)
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede1)
                .constroi();

        Cliente cliente1 = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                .constroi();

        Reserva reserva1 = Reserva.Builder.umReserva(1)
                .comSedeDeLocacao(sede2)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(cliente1)
                .doCarro(carro)
                .constroi();

        assertEquals(carro.getSedeDeOrigem(), sede1);
        assertNotNull(reserva1);
        assertEquals(reserva1.getSedeLocacao(), sede2);
    }

    //Teste 11
    @Test
    public void deveCobrarTaxaParaCarroDevolvidoEmOutraSede() {
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Sede sede2 = Sede.Builder.umaSede(2)
                .comNome("Sede 2")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponível)
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede1)
                .constroi();

        Cliente cliente1 = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                .constroi();

        Reserva reserva1 = Reserva.Builder.umReserva(1)
                .comSedeDeLocacao(sede1)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(cliente1)
                .doCarro(carro)
                .constroi();

        reserva1.finalizar(sede2);

        Assert.assertEquals(reserva1.getValorTotal(), sede1.getMultaSedeDiferente()
                .add(carro.getValorDiaria()
                .multiply(new BigDecimal(reserva1.getDiarias()))));
    }

    //Teste 12
    @Test
    public void naoDeveCobrarTaxaParaCarroDevolvidoNaMesmaSede() {
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Sede sede2 = Sede.Builder.umaSede(2)
                .comNome("Sede 2")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponível)
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede1)
                .constroi();

        Cliente cliente1 = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comCNH(new CNH("1234", LocalDate.now().plusMonths(10)))
                .constroi();

        Reserva reserva1 = Reserva.Builder.umReserva(1)
                .comSedeDeLocacao(sede1)
                .comDataLocacao(LocalDate.now())
                .comDiarias(10)
                .comMulta(new BigDecimal(10))
                .naSituacao(Reserva.Situcao.Ativa)
                .paraCliente(cliente1)
                .doCarro(carro)
                .constroi();

        reserva1.finalizar(sede1);

        Assert.assertEquals(reserva1.getValorTotal(), carro.getValorDiaria()
                        .multiply(new BigDecimal(reserva1.getDiarias())));
    }
}