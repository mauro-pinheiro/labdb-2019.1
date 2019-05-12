package ifma.edu.mauro.lbbd.lab3.dao;

import ifma.edu.mauro.lbbd.lab3.entidades.Cidade;
import ifma.edu.mauro.lbbd.lab3.entidades.Cliente;
import ifma.edu.mauro.lbbd.lab3.entidades.Frete;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FreteDAO implements DAO<Frete> {
    private Connection conexao;

    public FreteDAO(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public Frete salva(Frete frete) {
        String sql = "insert into frete(codigo_cidade, codigo_cliente, descricao,peso, valor)" +
                "values(?,?,?,?,?)";

        try(PreparedStatement statement = conexao.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setInt(1,frete.getCidade().getCodigo_cidade());
            statement.setInt(2,frete.getCliente().getCodigo_cliente());
            statement.setString(3,frete.getDescricao());
            statement.setFloat(4,frete.getPeso());
            statement.setFloat(5,frete.getValor());

            statement.execute();

            try(ResultSet keys = statement.getGeneratedKeys()){
                keys.next();
                frete.setCodigo_frete(keys.getInt(1));
                return frete;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Frete> getAll() {
        String sql = "select * from frete";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            try(ResultSet resultSet = statement.executeQuery()){
                final List<Frete> fretes = new ArrayList<>();

                while(resultSet.next()){
                    Frete f = monta(resultSet);
                    fretes.add(f);
                }
                return fretes;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Frete monta(ResultSet resultSet) {
        try {
            int codigo_cidade = resultSet.getInt("codigo_cidade");
            int codigo_cliente = resultSet.getInt("codigo_cliente");
            String descricao = resultSet.getString("descricao");
            float peso = resultSet.getFloat("peso");
            float valor = resultSet.getFloat("valor");

            Cidade c = new CidadeDAO(conexao).buscaPor(codigo_cidade);
            Cliente cl = new ClienteDAO(conexao).buscaPor(codigo_cliente);
            Frete f = new Frete(c, cl, descricao, peso, valor);
            return f;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
