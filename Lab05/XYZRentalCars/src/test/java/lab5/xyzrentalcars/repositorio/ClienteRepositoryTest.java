package lab5.xyzrentalcars.repositorio;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.entidades.Cliente;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

import static org.junit.Assert.*;


public class ClienteRepositoryTest {
    private static EntityManagerFactory factory;
    private EntityManager manager;
    private ClienteRepository clienteRepository;

    @BeforeClass
    public static void inicio(){
        factory = Persistence.createEntityManagerFactory("rentalcars");
    }

    @Before
    public void antes(){
        manager = factory.createEntityManager();
        clienteRepository = new ClienteRepository(manager);
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
    public void deveSalvarUmNovoCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comNumeroCNH("123")
                .comValidadeCNH(LocalDate.now().plusMonths(10))
                .constroi();

        clienteRepository.salvaOuAtualiza(cliente);
        assertTrue(manager.contains(cliente));
    }

    @Test
    public void deveBuscarClientePorId(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comNumeroCNH("123")
                .comValidadeCNH(LocalDate.now().plusMonths(10))
                .constroi();
        clienteRepository.salvaOuAtualiza(cliente);
        manager.flush();
        manager.clear();

        Cliente clienteNoBanco = clienteRepository.buscaPorId(cliente.getId());

        assertEquals(cliente, clienteNoBanco );
    }

    @Test
    public void deveExcluirCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comNumeroCNH("123")
                .comValidadeCNH(LocalDate.now().plusMonths(10))
                .constroi();
        clienteRepository.salvaOuAtualiza(cliente);
        int id = cliente.getId();
        clienteRepository.remove(cliente);
        manager.flush();
        manager.clear();

        Cliente clienteDoBanco = clienteRepository.buscaPorId(id);

        assertNull(clienteDoBanco);
    }

    @Test
    public void deveAlteraCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comNumeroCNH("123")
                .comValidadeCNH(LocalDate.now().plusMonths(10))
                .constroi();
        clienteRepository.salvaOuAtualiza(cliente);
        int id = cliente.getId();

        cliente.setNome("Mauro Sergio");

        clienteRepository.salvaOuAtualiza(cliente);
        manager.flush();

        Cliente clienteDoBanco = clienteRepository.buscaPorId(id);

        assertEquals(clienteDoBanco.getNome(), "Mauro Sergio");
    }

    @Test
    public void deveAtualizarCnhDoCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comNumeroCNH("123")
                .comValidadeCNH(LocalDate.now().plusMonths(10))
                .constroi();
        clienteRepository.salvaOuAtualiza(cliente);
        int id = cliente.getId();

        CNH cnh = new CNH();
        cnh.setNumero("4321");
        cnh.setValidade(LocalDate.now().plusMonths(30));

        clienteRepository.atualizaCNH(cliente, cnh);
        manager.flush();

        Cliente clienteDoBanco = clienteRepository.buscaPorId(id);

        assertEquals(clienteDoBanco.getCnh(), cnh);
    }
}