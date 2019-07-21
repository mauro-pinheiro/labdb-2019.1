package lab5.xyzrentalcars.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("rentalcars");

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    public static void close(){
        factory.close();
    }
}
