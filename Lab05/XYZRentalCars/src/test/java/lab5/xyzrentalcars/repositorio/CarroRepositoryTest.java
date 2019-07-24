package lab5.xyzrentalcars.repositorio;

import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Lugradouro;
import lab5.xyzrentalcars.modelo.entidades.Carro;
import lab5.xyzrentalcars.modelo.entidades.Sede;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;

public class CarroRepositoryTest {
    private static EntityManagerFactory factory;
    private EntityManager manager;
    private CarroRepository carroRepository;

    @BeforeClass
    public static void inicio(){
        factory = Persistence.createEntityManagerFactory("rentalcars");
    }

    @Before
    public void antes(){
        manager = factory.createEntityManager();
        carroRepository = new CarroRepository(manager);
        manager.getTransaction().begin();
    }

    @After
    public void depois(){
        manager.getTransaction().rollback();
    }

    @AfterClass
    public static void fim(){
        factory.close();
    }

    //Teste 1
    @Test
    public void deveRetornarTodosOsCarrosDaClasseCompacto(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Carro carros[] = new Carro[]{
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Luxo)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Medio)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Grande)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.SubCompacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Luxo)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Luxo)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),

        };

        new SedeRepository(manager).salvaOuAtualiza(sede);

        int qtdeCompactos = 0;
        for(Carro carro : carros){
            carroRepository.salvaOuAtualiza(carro);
            if(Objects.equals(carro.getClasse(), ClasseCarro.Compacto))
                qtdeCompactos++;
        }
        manager.flush();

        List<Carro> compactos = carroRepository.buscaPorClasse(ClasseCarro.Compacto);

        Assert.assertEquals(qtdeCompactos, compactos.size());
        compactos.forEach(c -> Assert.assertEquals(c.getClasse(), ClasseCarro.Compacto));
    }

    //Teste 2
    @Test
    public void deveRetornarTodosOsCarrosDaClasseLuxo(){
        Sede sede = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        Carro carros[] = new Carro[]{
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Luxo)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Medio)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Grande)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.SubCompacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Luxo)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Compacto)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),
                Carro.Builder.umCarro()
                        .daClasse(ClasseCarro.Luxo)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi(),

        };

        new SedeRepository(manager).salvaOuAtualiza(sede);

        int qtdeLuxo = 0;
        for(Carro carro : carros){
            carroRepository.salvaOuAtualiza(carro);
            if(Objects.equals(carro.getClasse(), ClasseCarro.Luxo))
                qtdeLuxo++;
        }
        manager.flush();

        List<Carro> luxos = carroRepository.buscaPorClasse(ClasseCarro.Luxo);

        Assert.assertEquals(qtdeLuxo, luxos.size());
        luxos.forEach(c -> Assert.assertEquals(c.getClasse(), ClasseCarro.Luxo));
    }
}