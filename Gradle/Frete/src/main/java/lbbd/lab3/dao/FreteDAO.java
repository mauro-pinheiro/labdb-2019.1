package lbbd.lab3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lbbd.lab3.entidades.Cidade;
import lbbd.lab3.entidades.Cliente;
import lbbd.lab3.entidades.Frete;

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
            int codigo_frete = resultSet.getInt("codigo_frete");
            int codigo_cidade = resultSet.getInt("codigo_cidade");
            int codigo_cliente = resultSet.getInt("codigo_cliente");
            String descricao = resultSet.getString("descricao");
            float peso = resultSet.getFloat("peso");

            Cidade c = new CidadeDAO(conexao).buscaPor(codigo_cidade);
            Cliente cl = new ClienteDAO(conexao).buscaPor(codigo_cliente);
            Frete f = new Frete(c, cl, descricao, peso);
            f.setCodigo_frete(codigo_frete);
            return f;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Frete buscaPor(int codigo_frete){
        String sql = "select * from frete where codigo_frete = ?";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setInt(1, codigo_frete);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next())
                    return monta(resultSet);
                return null;
            }
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Frete> buscaPor(Cliente cliente){
        String sql = "select * from frete where codigo_cliente = ?";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setInt(1, cliente.getCodigo_cliente());

            try(ResultSet resultSet = statement.executeQuery()){
                List<Frete> fretes = new ArrayList<>();
                while(resultSet.next()){
                    Frete frete = monta(resultSet);
                    fretes.add(frete);
                }
                return fretes;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Frete maiorValor(){
        String sql = "select * from frete order by valor desc limit 1";
        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next())
                    return monta(resultSet);
                return null;
            } 
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public float buscaValor(int codigo_frete){
        String sql = "select valor from frete where codigo_frete = ?";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setInt(1, codigo_frete);

            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next())
                    return resultSet.getFloat("valor");
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
