package ifma.edu.mauro.lbbd.lab3;

import ifma.edu.mauro.lbbd.lab3.dao.ClienteDAO;
import ifma.edu.mauro.lbbd.lab3.entidades.Cliente;
import ifma.edu.mauro.lbbd.lab3.infra.Database;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) new ClienteDAO(
                Database
                        .getConexao())
                .getAll();

        clientes.forEach(System.out::println);
    }
}
