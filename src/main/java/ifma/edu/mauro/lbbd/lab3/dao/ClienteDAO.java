package ifma.edu.mauro.lbbd.lab3.dao;

import ifma.edu.mauro.lbbd.lab3.entidades.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteDAO implements DAO<Cliente> {
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteDAO(){

    }

    @Override
    public Optional<Cliente> get(long id) {
        return Optional.ofNullable(clientes.get((int)id));
    }

    @Override
    public List<Cliente> getAll() {
        return clientes;
    }

    @Override
    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void update(Cliente cliente, String[] params) {
        int i = clientes.indexOf(cliente);
        if(i != -1) {
            cliente = clientes.get(i);
        } else {
            clientes.add(cliente);
        }
        cliente.setNome(Objects.requireNonNull(
                params[0], "Nome não pode ser nulo."));
        cliente.setEndereco(Objects.requireNonNull(
                params[1], "Endereco não pode ser nulo."));
        cliente.setTelefone(Objects.requireNonNull(
                params[2], "Telefone nao pode ser nulo."));
    }

    @Override
    public void delete(Cliente cliente) {
        clientes.remove(cliente);
    }


}
