package lab5.xyzrentalcars.app.importacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        LeadImport in = new LeadImport(true);
        try(Stream<Path> paths = Files.walk(Paths.get("C:\\Users\\mauro.campos\\Desktop\\BasesNathan-Luana"));
        ){
            paths.filter(Files::isRegularFile).forEach(file -> {
                in.toMongo(file.toString());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
