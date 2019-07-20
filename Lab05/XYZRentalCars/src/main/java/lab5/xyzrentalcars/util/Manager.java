package lab5.xyzrentalcars.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("rentalcars");

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    public void close(){
        factory.close();
    }
}
