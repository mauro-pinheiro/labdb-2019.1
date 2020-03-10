package lab5.xyzrentalcars.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnectionFactory {
    static private MongoClient client;

    private static MongoClient getMongoClient(){
        if(client == null){
            client = MongoClients.create();
        }
        return client;
    }

    public static MongoDatabase getDatabase(String name){
        return getMongoClient().getDatabase(name);
    }

    public static void closeConnection(){
        client.close();
        client = null;
    }
}
