package lab5.xyzrentalcars.app.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lab5.xyzrentalcars.modelo.entidades.Carro;
import lab5.xyzrentalcars.modelo.entidades.Cliente;
import lab5.xyzrentalcars.modelo.entidades.Reserva;
import lab5.xyzrentalcars.modelo.entidades.Sede;
import lab5.xyzrentalcars.repositorio.CarroRepository;
import lab5.xyzrentalcars.repositorio.ClienteRepository;
import lab5.xyzrentalcars.repositorio.ReservaRepository;
import lab5.xyzrentalcars.repositorio.SedeRepository;
import lab5.xyzrentalcars.util.ManagerFactory;
import org.bson.Document;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToMongoExporter {
    public static void main(String[] args) {
        EntityManager manager = ManagerFactory.getEntityManager();
        List<Documentable>[] entidades = new List[]{
                new ClienteRepository(manager).buscaTodos(),
                new SedeRepository(manager).buscaTodos(),
                new CarroRepository(manager).buscaTodos()//,
                //new ReservaRepository(manager).buscaTodos()
        };

        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("rentalcarsdb");

        Arrays.stream(entidades).forEach(list -> {
            MongoCollection<Document> collection = database.getCollection(list.get(0).getClass().getSimpleName());
            collection.insertMany(list.stream().map(e -> e.toMongoDocument()).collect(Collectors.toList()));
        });
    }
}
