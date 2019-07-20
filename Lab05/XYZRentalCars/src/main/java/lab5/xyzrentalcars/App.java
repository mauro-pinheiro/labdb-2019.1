package lab5.xyzrentalcars;

import lab5.xyzrentalcars.util.Manager;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager manager = Manager.getEntityManager();
    }
}
