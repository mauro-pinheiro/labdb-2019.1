package lab5.xyzrentalcars;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Lugradouro;
import lab5.xyzrentalcars.modelo.entidades.Carro;
import lab5.xyzrentalcars.modelo.entidades.Cliente;
import lab5.xyzrentalcars.modelo.entidades.Reserva;
import lab5.xyzrentalcars.modelo.entidades.Sede;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import lab5.xyzrentalcars.relatorio.Relatorio;
import lab5.xyzrentalcars.repositorio.CarroRepository;
import lab5.xyzrentalcars.repositorio.ClienteRepository;
import lab5.xyzrentalcars.repositorio.ReservaRepository;
import lab5.xyzrentalcars.repositorio.SedeRepository;
import lab5.xyzrentalcars.util.AuxMethods;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class Testes {
    private static EntityManagerFactory factory;
    private EntityManager manager;
    private CarroRepository carroRepository;
    private ClienteRepository clienteRepository;
    private ReservaRepository reservaRepository;
    private SedeRepository sedeRepository;

    @BeforeClass
    public static void inicio(){
        factory = Persistence.createEntityManagerFactory("rentalcars");
    }

    @Before
    public void antes(){
        manager = factory.createEntityManager();
        carroRepository = new CarroRepository(manager);
        clienteRepository = new ClienteRepository(manager);
        reservaRepository = new ReservaRepository(manager);
        sedeRepository = new SedeRepository(manager);
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
                .naSituacao(Carro.Situacao.Disponivel)
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
                        .naSituacao(Carro.Situacao.Disponivel)
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
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();

        assertNotNull(reserva2);
    }

    //Teste 6
    @Test
    public void deveAtualizarCNHDoCliente(){
        Cliente cliente = Cliente.Builder.umCliente()
                .comNome("Mauro")
                .comCPF("1234")
                .comCNH(new CNH("123", LocalDate.now().minusMonths(10)))
                .constroi();

        clienteRepository.salvaOuAtualiza(cliente);

        CNH cnh = new CNH("1234", LocalDate.now().plusMonths(10));
        cliente.setCnh(cnh);

        clienteRepository.salvaOuAtualiza(cliente);

        manager.flush();

        Cliente clienteNoBanco = clienteRepository.buscaPorId(cliente.getId());

        assertEquals(clienteNoBanco.getCnh(),cnh);
    }

    //Teste 7
    @Test(expected = IllegalStateException.class)
    public void naoDeveAlugarCarroAlugado(){
        Sede sede1 = Sede.Builder.umaSede()
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
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
                .constroi();

        assertFalse(cliente1.comCnhVencida());
        assertNotNull(reserva1);
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
                        .naSituacao(Carro.Situacao.Disponivel)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .constroi())
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

    //Teste 11
    @Test
    public void deveCobrarTaxaParaCarroDevolvidoEmOutraSede() {
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        manager.persist(sede1);
        Sede sede2 = Sede.Builder.umaSede()
                .comNome("Sede 2")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        manager.persist(sede2);
        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
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
        Sede sede1 = Sede.Builder.umaSede()
                .comNome("Sede 1")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();

        manager.persist(sede1);
        Sede sede2 = Sede.Builder.umaSede()
                .comNome("Sede 2")
                .comMultaPorSedeDiferente(new BigDecimal(10))
                .comEndereco(Endereco.Builder.umEndereco()
                        .comLugradouro(new Lugradouro(TipoLugradouro.Rua, "3"))
                        .noBairro("Turu")
                        .constroi())
                .constroi();
        manager.persist(sede2);

        Carro carro = Carro.Builder.umCarro()
                .daClasse(ClasseCarro.Compacto)
                .naSituacao(Carro.Situacao.Disponivel)
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

    //Teste 13
    @Test
    public void deveSaberQualClasseDeCarroTeveMenosReservas(){
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
                        .daClasse(ClasseCarro.SubCompacto)
                        .comSedeDeOrigem(sede)
                        .atualmenteNaSede(sede)
                        .naSituacao(Carro.Situacao.Disponivel)
                        .constroi()
        };

        Reserva reservas[] = new Reserva[]{
                Reserva.Builder.umReserva(1)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.of(2018,10,9))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[0])
                        .doCarro(carros[0])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(2)
                        .naSituacao(Reserva.Situcao.Atrazada)
                        .comDataLocacao(LocalDate.of(2018,10,10))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[1])
                        .doCarro(carros[1])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(3)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.of(2018,11,11))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[2])
                        .doCarro(carros[2])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(4)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.of(2019,1,9))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[3])
                        .doCarro(carros[3])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(5)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.of(2019,2,3))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[4])
                        .doCarro(carros[4])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi()
        };

        ClasseCarro expected = ClasseCarro.SubCompacto;
        ClasseCarro minCarro = Relatorio.comMenosReservas(Arrays.asList(reservas));

        assertEquals(expected,minCarro);
    }

    //Teste 14
    @Test
    public void deveRecuperarTadasAsReservasFinalizadasNumaSedeNumDeterminadoPeriodo(){
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
                        .comDataLocacao(LocalDate.of(2018,10,9))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[0])
                        .doCarro(carros[0])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(2)
                        .naSituacao(Reserva.Situcao.Atrazada)
                        .comDataLocacao(LocalDate.of(2018,10,10))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[1])
                        .doCarro(carros[1])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(3)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.of(2018,11,11))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[2])
                        .doCarro(carros[2])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(4)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.of(2019,1,9))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[3])
                        .doCarro(carros[3])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi(),
                Reserva.Builder.umReserva(5)
                        .naSituacao(Reserva.Situcao.Ativa)
                        .comDataLocacao(LocalDate.of(2019,2,3))
                        .comSedeDeLocacao(sede)
                        .paraCliente(clientes[4])
                        .doCarro(carros[4])
                        .comDiarias(10)
                        .comMulta(new BigDecimal(10))
                        .constroi()
        };

        reservas[1].finalizar(sede,LocalDate.of(2018,10,19));
        reservas[3].finalizar(sede,LocalDate.of(2019,1,19));

        LocalDate inicio = LocalDate.of(2018,1,1);
        LocalDate fim = LocalDate.of(2018,12,31);

        int qtdeFinalizadas = 0;
        for (Reserva reserva : sede.getHistoricoDevolucao()) {
            LocalDate date = reserva.getDataLocacao();
            if(AuxMethods.betweenDates(date,inicio,fim)){
                qtdeFinalizadas++;
            }
        }


        Set<Reserva> finalizadas = sede.reservasFinalizadas(inicio, fim);

        System.out.println(qtdeFinalizadas);
        Assert.assertEquals(qtdeFinalizadas, finalizadas.size());
        finalizadas.stream()
                .map(r -> r.getSituacao())
                .forEach(s -> Assert.assertEquals(s, Reserva.Situcao.Finalizada));
    }
}
