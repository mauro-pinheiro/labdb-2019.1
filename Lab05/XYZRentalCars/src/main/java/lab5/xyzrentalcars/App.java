package lab5.xyzrentalcars;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.entidades.Cliente;
import lab5.xyzrentalcars.util.ManagerFactory;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        EntityManager manager = ManagerFactory.getEntityManager();
    }
}
