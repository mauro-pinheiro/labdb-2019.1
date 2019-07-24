package lab5.xyzrentalcars.repositorio;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.entidades.Cliente;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class DAOGenericoTest {
    private static EntityManagerFactory factory;
    private EntityManager manager;
    private DAOGenerico<Cliente> clienteRepository;

    @BeforeClass
    public static void inicio(){
        factory = Persistence.createEntityManagerFactory("rentalcars");
    }

    @Before
    public void antes(){
        manager = factory.createEntityManager();
        clienteRepository = new DAOGenerico<Cliente>(manager);
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
    public void deveSalvarCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comCPF("1234")
                .comNome("Mauro")
                .comCNH(new CNH("123", LocalDate.now().plusMonths(10)))
                .constroi();

        clienteRepository.salvaOuAtualiza(cliente);
        manager.flush();

        assertNotNull(cliente.getId());
        assertTrue(manager.contains(cliente));
    }

    @Test
    public void deveBuscarClientePeloId(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comCPF("1234")
                .comNome("Mauro")
                .comCNH(new CNH("123", LocalDate.now().plusMonths(10)))
                .constroi();

        clienteRepository.salvaOuAtualiza(cliente);
        manager.flush();

        Cliente clienteNoBanco = clienteRepository.buscaPorId(Cliente.class, cliente.getId());

        assertNotNull(clienteNoBanco);
        assertEquals(cliente,clienteNoBanco);
    }

    @Test
    public void deveAtualizarCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comCPF("1234")
                .comNome("Mauro")
                .comCNH(new CNH("123", LocalDate.now().plusMonths(10)))
                .constroi();

        clienteRepository.salvaOuAtualiza(cliente);

        cliente.setNome("Sergio");

        clienteRepository.salvaOuAtualiza(cliente);
        manager.flush();

        Cliente clienteNoBanco = clienteRepository.buscaPorId(Cliente.class, cliente.getId());

        assertEquals(clienteNoBanco.getNome(), "Sergio");
    }

    @Test
    public void deveExcluirCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comCPF("1234")
                .comNome("Mauro")
                .comCNH(new CNH("123", LocalDate.now().plusMonths(10)))
                .constroi();

        clienteRepository.salvaOuAtualiza(cliente);
        manager.flush();

        Cliente clienteNoBanco = clienteRepository.buscaPorId(Cliente.class, cliente.getId());
        assertNotNull(clienteNoBanco);

        int id = clienteNoBanco.getId();

        clienteRepository.remove(cliente);
        manager.flush();

        clienteNoBanco = clienteRepository.buscaPorId(Cliente.class, id);


        assertNull(clienteNoBanco);
    }
}