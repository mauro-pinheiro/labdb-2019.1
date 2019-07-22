package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarroTest {

    @Test
    public void deveCriarUmCarroForaDaSedeDeOrigem(){
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        sede1.setId(1);

        Sede sede2 = Sede.Builder.umaSede()
                .comNome("Sede 2")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
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
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();

        Assert.assertNotNull(carro);
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveCriarCarroSemClasse(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede)
                //.daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();
    }

    @Test(expected = NullPointerException.class)
    public void naoDeveCriaCarroSemOrigem(){
        Carro carro = Carro.Builder.umCarro()
                //.comSedeDeOrigem(sede)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();
    }


    @Test
    public void atribuiSituacaoDisponivelCasoNaoAtribuida(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede)
                .daClasse(ClasseCarro.Compacto)
                //.naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();

        Assert.assertEquals(carro.getSituacao(), Carro.Situacao.Disponivel);
    }

    @Test
    public void sedeDeOrigemEAtualIguaisQuandoSituacaoEhDisponivel(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede)
                .daClasse(ClasseCarro.Compacto)
                //.naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();

        Assert.assertEquals(carro.getSedeDeOrigem(), carro.getSedeAtual());
    }

    @Test
    public void seAlugadoSedeAtualEhNula(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Alugado)
                .daCor("Preto")
                .constroi();

        Assert.assertNull(carro.getSedeAtual());
    }


    @Test
    public void trasferiSucesso(){
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        sede1.setId(1);

        Sede sede2 = Sede.Builder.umaSede()
                .comNome("Sede 2")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
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
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        sede1.setId(1);

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede1)
                //.atualmenteNaSede(sede2)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();

        carro.transferi(sede1);
    }

    @Test
    public void alugaSucesso(){
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        sede1.setId(1);

        Carro carro = Carro.Builder.umCarro()
                .comSedeDeOrigem(sede1)
                //.atualmenteNaSede(sede2)
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
                .daCor("Preto")
                .constroi();

        carro.aluga(new Reserva());

        assertEquals(carro.getSituacao(), Carro.Situacao.Alugado);
        assertNull(carro.getSedeAtual());
        assertTrue(carro.getHistoricoReservas().size()>0);
    }

    @Test(expected = IllegalStateException.class)
    public void alugaFalha(){
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(10)
                .comGerente("Mauro").comEndereco(Endereco.Builder.umEndereco()
                        .naRua("3")
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        sede1.setId(1);

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