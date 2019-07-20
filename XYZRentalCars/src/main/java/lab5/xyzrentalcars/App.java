package lab5.xyzrentalcars;

import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("rentalcars");
    }
}
