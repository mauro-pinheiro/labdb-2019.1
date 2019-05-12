package ifma.edu.mauro.lbbd.lab3.dao;

import ifma.edu.mauro.lbbd.lab3.entidades.Cidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO implements DAO<Cidade> {
    private Connection conexao;

    public CidadeDAO(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public Cidade salva(Cidade cidade) {
        String sql = "insert into cidades(nome,uf,taxa) values(?,?,?)";

        try(PreparedStatement statement = conexao.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, cidade.getNome());
            statement.setString(2,cidade.getUf());
            statement.setFloat(2,cidade.getTaxa());

            statement.execute();

            try(ResultSet keys = statement.getGeneratedKeys()){
                keys.next();
                cidade.setCodigo_cidade(keys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return cidade;
    }

    @Override
    public List<Cidade> getAll() {
        String sql = "select * from cidades";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            try(ResultSet resultSet = statement.executeQuery(sql)) {

                final List<Cidade> cidades = new ArrayList<>();

                while (resultSet.next()) {
                    Cidade cidade = monta(resultSet);
                    cidades.add(cidade);
                }
                return cidades;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Cidade monta(ResultSet resultSet) {
        try {
            String nome = resultSet.getString("nome");
            String uf = resultSet.getString("uf");
            float taxa = resultSet.getFloat("taxa");
            int codigo = resultSet.getInt("codigo");

            Cidade c = new Cidade(nome,uf,taxa);
            c.setCodigo_cidade(codigo);

            return c;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Cidade buscaPor(int codigo){
        String sql = "select * from cidade where codigo_cidade = ?";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setInt(1, codigo);
            try(ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                Cidade c = monta(resultSet);
                return c;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Cidade buscaPor(String nome){
        String sql = "select * from cidade where nome = ?";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setString(1, nome);
            try(ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                Cidade c = monta(resultSet);
                return c;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Cidade atualizar(Cidade cidade){
        String sql = "update cidade set nome = ?, uf = ?, taxa = ? where codigo_cidade = ?";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setString(1, cidade.getNome());
            statement.setString(2, cidade.getUf());
            statement.setFloat(3, cidade.getTaxa());
            statement.setInt(4, cidade.getCodigo_cidade());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return cidade;
    }
}
