package lab5.xyzrentalcars.app.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lab5.xyzrentalcars.repositorio.CarroRepository;
import lab5.xyzrentalcars.repositorio.ClienteRepository;
import lab5.xyzrentalcars.repositorio.SedeRepository;
import lab5.xyzrentalcars.util.ManagerFactory;
import lab5.xyzrentalcars.util.MongoConnectionFactory;
import org.bson.Document;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToMongoExporter {
    public static void main(String[] args) {
        EntityManager manager = ManagerFactory.getEntityManager();
        List<Documentable>[] entidades = new List[]{
                new SedeRepository(manager).buscaTodos(),
                new ClienteRepository(manager).buscaTodos(),
                new CarroRepository(manager).buscaTodos()//,
                //new ReservaRepository(manager).buscaTodos()
        };

        MongoDatabase database = MongoConnectionFactory.getDatabase("rentalcarsdb");

        Arrays.stream(entidades).forEach(list -> {
            System.out.println(list);
            MongoCollection<Document> collection = database.getCollection(list.get(0).getClass().getSimpleName());
            collection.insertMany(list.stream().map(e -> e.toMongoDocument()).collect(Collectors.toList()));
        });
    }
}
