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
        ManagerFactory.getEntityManager();
    }
}
