package lab5.xyzrentalcars.app.importacao;

public class Main {
    public static void main(String[] args) {
        LeadImport in = new LeadImport("Bruto11.xlsx", true);
        in.toMongo();
    }
}
