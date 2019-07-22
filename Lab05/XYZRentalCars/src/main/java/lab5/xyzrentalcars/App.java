package lab5.xyzrentalcars;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import lab5.xyzrentalcars.modelo.entidades.Cliente;
import lab5.xyzrentalcars.modelo.entidades.Sede;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import lab5.xyzrentalcars.repositorio.SedeRepository;
import lab5.xyzrentalcars.util.ManagerFactory;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        EntityManager manager = ManagerFactory.getEntityManager();
        manager.getTransaction().begin();
        SedeRepository repository = new SedeRepository(manager);
        Sede sede1 = repository.buscaPorNome("Sede 1").get(0);
        repository.remove(sede1);

        Sede sede2 = repository.buscaPorNome("Sede 2").get(0);
        repository.remove(sede2);
        manager.getTransaction().commit();
        ManagerFactory.close();
    }
}
