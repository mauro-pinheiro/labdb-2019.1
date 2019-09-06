package lab5.xyzrentalcars.app.jpa;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import lab5.xyzrentalcars.modelo.entidades.Cliente;
import lab5.xyzrentalcars.modelo.entidades.Sede;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;
import lab5.xyzrentalcars.repositorio.SedeRepository;
import lab5.xyzrentalcars.util.AuxMethods;
import lab5.xyzrentalcars.util.ManagerFactory;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        ManagerFactory.getEntityManager();

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));

        /*
        LocalDate date = LocalDate.of(2019,10,9);
        boolean b = AuxMethods.betweenDates(date,
                LocalDate.of(2018,1,1),
                LocalDate.of(2018,12,31));
        System.out.println(b);
*/
    }
}
