package ifma.edu.mauro.lbbd.lab3;

import java.util.ArrayList;

import ifma.edu.mauro.lbbd.lab3.dao.CidadeDAO;
import ifma.edu.mauro.lbbd.lab3.dao.ClienteDAO;
import ifma.edu.mauro.lbbd.lab3.dao.FreteDAO;
import ifma.edu.mauro.lbbd.lab3.entidades.Cidade;
import ifma.edu.mauro.lbbd.lab3.entidades.Cliente;
import ifma.edu.mauro.lbbd.lab3.entidades.Frete;
import ifma.edu.mauro.lbbd.lab3.infra.Database;

public class Main {
    //testa cliente dao
    // public static void main(String[] args) {
    //     ArrayList<Cliente> clientes = (ArrayList<Cliente>) new ClienteDAO(
    //             Database
    //                     .getConexao())
    //             .getAll();

    //     clientes.forEach(System.out::println);
    // }

    //testa cidade dao
    // public static void main(String[] args) {
    //     ArrayList<Cidade> cidades = (ArrayList<Cidade>) new CidadeDAO(
    //         Database.getConexao()).getAll();

    //     cidades.forEach(System.out::println);
    // }

    public static void main(String[] args) {
        FreteDAO dao = new FreteDAO(Database.getConexao());
        // ClienteDAO cdao = new ClienteDAO(Database.getConexao());
        // Cliente cliente = cdao.buscaPor(1);

        // float valor = dao.maiorValor();

        // System.out.println(valor);

        Cidade cidade = dao.cidadeMaisFretes();
        System.out.println(cidade);

        // ArrayList<Frete> fretes = (ArrayList<Frete>) new FreteDAO(
        //     Database.getConexao()).buscaPor(cliente);

        // fretes.forEach(System.out::println);

    }

    // public static void main(String[] args) {
    //     Application.launch(ClienteForm.class, args);
    // }
}
