package ifma.edu.mauro.lbbd.lab3.funcionalidades;

import java.util.Scanner;

import ifma.edu.mauro.lbbd.lab3.dao.CidadeDAO;
import ifma.edu.mauro.lbbd.lab3.entidades.Cidade;
import ifma.edu.mauro.lbbd.lab3.infra.Database;

public class CadastroCidade {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome = in.nextLine();
        String uf = in.nextLine();
        float taxa = Float.parseFloat(in.next());
        Cidade cidade = new Cidade(nome,uf, taxa);
        CidadeDAO dao = new CidadeDAO(Database.getConexao());
        cidade = dao.salva(cidade);
        System.out.println(cidade);
        in.close();
    }
}