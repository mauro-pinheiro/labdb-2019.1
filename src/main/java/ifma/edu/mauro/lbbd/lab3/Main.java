package ifma.edu.mauro.lbbd.lab3;

import ifma.edu.mauro.lbbd.lab3.gui.fx.ClienteForm;
import javafx.application.Application;

public class Main {
    // public static void main(String[] args) {
    //     ArrayList<Cliente> clientes = (ArrayList<Cliente>) new ClienteDAO(
    //             Database
    //                     .getConexao())
    //             .getAll();

    //     clientes.forEach(System.out::println);
    // }

    public static void main(String[] args) {
        Application.launch(ClienteForm.class, args);
    }
}
