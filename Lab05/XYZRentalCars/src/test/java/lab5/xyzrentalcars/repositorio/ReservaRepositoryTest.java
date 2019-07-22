package lab5.xyzrentalcars.repositorio;

import lab5.xyzrentalcars.builders.*;
import lab5.xyzrentalcars.exceptions.TemReservaNaoFinalizadaException;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import lab5.xyzrentalcars.modelo.entidades.Carro;
import lab5.xyzrentalcars.modelo.entidades.Cliente;
import lab5.xyzrentalcars.modelo.entidades.Reserva;
import lab5.xyzrentalcars.modelo.entidades.Sede;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservaRepositoryTest {
    private static EntityManagerFactory factory;
    private EntityManager manager;
    private ReservaRepository reservaRepository;

    @BeforeClass
    public static void inicio(){
        factory = Persistence.createEntityManagerFactory("rentalcars");
    }

    @Before
    public void antes(){
        manager = factory.createEntityManager();
        reservaRepository = new ReservaRepository(manager);
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

    @Test
    public void deveRealizarReservaDeCarroLocalizadoEmOutrSede(){
        SedeRepository sedeRepository = new SedeRepository(manager);
        Sede sede1 = SedeBuilder.umaSede()
                .comNome("Sede 1")
                .comGerente("Carlos")
                .comMultaPorSedeDiferente(10.90)
                .comEndereco(EnderecoBuilder
                        .umEndereco()
                        .naRua("Tres")
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","1111111111"))
                .constroi();
        Sede sede2 = SedeBuilder.umaSede()
                .comNome("Sede 2")
                .comGerente("Mauro")
                .comMultaPorSedeDiferente(10.90)
                .comEndereco(EnderecoBuilder
                        .umEndereco()
                        .naRua("Tres")
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","1111111111"))
                .constroi();

        sedeRepository.salvaOuAtualiza(sede1);
        sedeRepository.salvaOuAtualiza(sede2);

        Carro carro = CarroBuilder.umCarro()
                .naSituacao(Carro.Situacao.Disponivel)
                .atualmenteNa(sede1)
                .comClasse(ClasseCarro.Compacto)
                .comSedeDeOrigem(sede2)
                .constroi();

        CarroRepository carroRepository = new CarroRepository(manager);
        carroRepository.salvaOuAtualiza(carro);

        Cliente cliente = ClienteBuilder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comNumeroCNH("123")
                .comValidadeCNH(LocalDate.now().plusMonths(10))
                .constroi();
        new ClienteRepository(manager).salvaOuAtualiza(cliente);

        Reserva reserva = ReservaBuilder.umReserva()
                .paraCliente(cliente).doCarro(carro)
                .comSedeDeLocacao(sede2)
                .naSituacao(Reserva.Situcao.Ativa)
                .comDiarias(10)
                .comMulta(new BigDecimal(2.5))
                .comDataLocacao(LocalDate.now())
                .constroi();

        reservaRepository.salvaOuAtualiza(reserva);

        Assert.assertNotNull(reserva);
    }

    @Test(expected = TemReservaNaoFinalizadaException.class)
    public void clienteNaoDeveRealizarReservaSeTiverReservaNaoFinalizada(){
        SedeRepository sedeRepository = new SedeRepository(manager);
        Sede sede1 = SedeBuilder.umaSede()
                .comNome("Sede 1")
                .comGerente("Carlos")
                .comMultaPorSedeDiferente(10.90)
                .comEndereco(EnderecoBuilder
                        .umEndereco()
                        .naRua("Tres")
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","1111111111"))
                .constroi();
        Sede sede2 = SedeBuilder.umaSede()
                .comNome("Sede 2")
                .comGerente("Mauro")
                .comMultaPorSedeDiferente(10.90)
                .comEndereco(EnderecoBuilder
                        .umEndereco()
                        .naRua("Tres")
                        .noNumero("13")
                        .noBairro("Ipem Turu")
                        .constroi())
                .comTelefones(new Telefone("11","1111111111"))
                .constroi();

        sedeRepository.salvaOuAtualiza(sede1);
        sedeRepository.salvaOuAtualiza(sede2);

        Carro carro1 = CarroBuilder.umCarro()
                .naSituacao(Carro.Situacao.Disponivel)
                .atualmenteNa(sede1)
                .comClasse(ClasseCarro.Compacto)
                .comSedeDeOrigem(sede2)
                .constroi();
        Carro carro2 = CarroBuilder.umCarro()
                .naSituacao(Carro.Situacao.Disponivel)
                .atualmenteNa(sede1)
                .comClasse(ClasseCarro.Luxo)
                .comSedeDeOrigem(sede2)
                .constroi();

        CarroRepository carroRepository = new CarroRepository(manager);
        carroRepository.salvaOuAtualiza(carro1);
        carroRepository.salvaOuAtualiza(carro2);

        Cliente cliente = ClienteBuilder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comNumeroCNH("123")
                .comValidadeCNH(LocalDate.now().plusMonths(10))
                .constroi();
        new ClienteRepository(manager).salvaOuAtualiza(cliente);

        Reserva reserva1 = ReservaBuilder.umReserva()
                .paraCliente(cliente).doCarro(carro1)
                .comSedeDeLocacao(sede2)
                .naSituacao(Reserva.Situcao.Ativa)
                .comDiarias(10)
                .comMulta(new BigDecimal(2.5))
                .comDataLocacao(LocalDate.now())
                .constroi();

        Reserva reserva2 = ReservaBuilder.umReserva()
                .paraCliente(cliente).doCarro(carro2)
                .comSedeDeLocacao(sede2)
                .naSituacao(Reserva.Situcao.Ativa)
                .comDiarias(10)
                .comMulta(new BigDecimal(2.5))
                .comDataLocacao(LocalDate.now())
                .constroi();

        reservaRepository.salvaOuAtualiza(reserva1);
        reservaRepository.salvaOuAtualiza(reserva2);
    }
}