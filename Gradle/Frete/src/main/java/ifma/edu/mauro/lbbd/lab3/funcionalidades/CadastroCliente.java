package ifma.edu.mauro.lbbd.lab3.funcionalidades;

import java.util.Scanner;

import ifma.edu.mauro.lbbd.lab3.dao.ClienteDAO;
import ifma.edu.mauro.lbbd.lab3.entidades.Cliente;
import ifma.edu.mauro.lbbd.lab3.infra.Database;

public class CadastroCliente{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome = in.nextLine();
        String endereco = in.nextLine();
        String telefone = in.nextLine();
        Cliente cliente = new Cliente(nome, endereco, telefone);
        ClienteDAO dao = new ClienteDAO(Database.getConexao());
        dao.salva(cliente);
        System.out.println(cliente);
        in.close();
    }
}