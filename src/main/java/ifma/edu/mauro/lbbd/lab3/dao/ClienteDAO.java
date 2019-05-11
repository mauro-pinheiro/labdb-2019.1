package ifma.edu.mauro.lbbd.lab3.dao;

import ifma.edu.mauro.lbbd.lab3.entidades.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente>{
    private Connection conexao;

    public ClienteDAO(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public Cliente salva(Cliente cliente) {
        String sql = "insert into cliente(nome,endereco,telefone" +
                " values(?,?,?)";
        try(PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,cliente.getNome());
            statement.setString(2,cliente.getEndereco());
            statement.setString(3,cliente.getTelefone());

            statement.execute();

            try(ResultSet keys = statement.getGeneratedKeys()){
                keys.next();
                cliente.setCodigo_cliente(keys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return cliente;
    }

    @Override
    public List<Cliente> getAll() {
        String sql = "select * from cliente";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery(sql);

            final List<Cliente> clientes = new ArrayList<>();

            while(resultSet.next()){
                Cliente cliente = monta(resultSet);
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Cliente monta(ResultSet resultSet) {
        try {
            String nome = resultSet.getString("nome");
            String endereco = resultSet.getString("endereco");
            String telefone = resultSet.getString("telefone");
            int id = resultSet.getInt("codigo");

            Cliente c = new Cliente(nome,endereco,telefone);
            c.setCodigo_cliente(id);
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Cliente buscaPor(int codigo){
        String sql = "select * from cliente where codigo_cliente = codigo";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            Cliente c = monta(resultSet);
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}