package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Lugradouro;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CarroTest {

    @Test(expected = NullPointerException.class)
    public void naoDeveContruirUmCarroComSedeDeOrigemNula(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .atualmenteNaSede(sede)
                .constroi();
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveContruirUmCarroComSituacaoNula(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                //.naSituacao(Carro.Situacao.Disponivel)
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(sede)
                .constroi();
    }

    @Test
    public void deveContruirUmCarroUmCarroDisponivelComSedeDeOrigemIgualASedeAtual(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        assertNotNull(Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(sede)
                .constroi());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveConstruirUmCarroDisponivelComSedeAtualDiferenteDaSedeDeOrigem(){
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Sede sede2 = Sede.Builder.umaSede(2)
                .comNome("Sede 2")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede2)
                .constroi();
    }

    @Test
    public void deveContruirUmCarroUmCarroAlugadoComSedeAtualNula(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        assertNotNull(Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Alugado)
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(null)
                .constroi());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveContruirUmCarroAlugadoComSedeAtualDiferenteDeNull(){
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Sede sede2 = Sede.Builder.umaSede(2)
                .comNome("Sede 2")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Alugado)
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede2)
                .constroi();
    }

    @Test
    public void deveContruirUmCarroForaDaSedeDeOrigemComSedeAtualDeferenteDaSedeDeOrigemENaoNula(){
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Sede sede2 = Sede.Builder.umaSede(2)
                .comNome("Sede 2")
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

        assertNotNull(carro);
        assertNotNull(carro.getSedeAtual());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveContruirUmCarroForaDaSedeDeOrigemComSedeAtualNula(){
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.ForaDaSedeDeOrigem)
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(null)
                .constroi();
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveContruirUmCarroForaDaSedeDeOrigemComSedeDeOrigemIgualASedeAtual(){
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.ForaDaSedeDeOrigem)
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede1)
                .constroi();
    }

    @Test
    public void deveCriarUmCarroForaDaSedeDeOrigem(){
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        sede1.setId(1);

        Sede sede2 = Sede.Builder.umaSede()
                .comNome("Sede 2")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        sede2.setId(2);

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede2)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.ForaDaSedeDeOrigem)
                .daCor("Preto")
                .constroi();

        assertEquals(carro.getSituacao(), Carro.Situacao.ForaDaSedeDeOrigem);
    }

    @Test
    public void deveCriarCarroSeTodosAtributosNotNullForemAtrbuidos(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede)
                .atualmenteNaSede(sede)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();

        assertNotNull(carro);
        assertNotNull(carro.getClasse());
        assertNotNull(carro.getSedeDeOrigem());
        assertNotNull(carro.getSituacao());
    }

    @Test
    public void trasferiSucesso(){
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        sede1.setId(1);

        Sede sede2 = Sede.Builder.umaSede()
                .comNome("Sede 2")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        sede2.setId(2);

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede2)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.ForaDaSedeDeOrigem)
                .daCor("Preto")
                .constroi();

        carro.transferi(sede1);

        Assert.assertEquals(carro.getSituacao(), Carro.Situacao.Disponivel);
        Assert.assertEquals(carro.getSedeAtual(), sede1);
    }

    @Test(expected = IllegalStateException.class)
    public void transferiFalhou(){
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede1)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();

        carro.transferi(sede1);
    }

    @Test
    public void deveAlugarCarroDisponivel(){
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede1)
                .atualmenteNaSede(sede1)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();

        carro.aluga(new Reserva());

        assertEquals(carro.getSituacao(), Carro.Situacao.Alugado);
        assertNull(carro.getSedeAtual());
        assertTrue(carro.getHistoricoReservas().size()>0);
    }

    //Teste 7
    @Test(expected = IllegalStateException.class)
    public void naoDeveAlugarCarroAlugado(){
        Sede sede1 = Sede.Builder.umaSede(1)
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede1)
                //.atualmenteNaSede(sede2)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Alugado)
                .daCor("Preto")
                .constroi();

        carro.aluga(new Reserva());
    }
}