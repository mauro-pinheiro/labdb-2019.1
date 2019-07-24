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

    //Teste 6
    @Test
    public void deveAtualizarCNHDoCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comCNH(new CNH("123",LocalDate.now().minusMonths(10)))
                .constroi();

        clienteRepository.salvaOuAtualiza(cliente);

        CNH cnh = new CNH("1234", LocalDate.now().plusMonths(10));
        cliente.setCnh(cnh);

        clienteRepository.salvaOuAtualiza(cliente);

        manager.flush();

        Cliente clienteNoBanco = clienteRepository.buscaPorId(cliente.getId());

        assertEquals(clienteNoBanco.getCnh(),cnh);
    }
}