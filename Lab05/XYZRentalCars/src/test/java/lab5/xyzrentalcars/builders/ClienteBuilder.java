package lab5.xyzrentalcars.builders;

import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import lab5.xyzrentalcars.modelo.entidades.Cliente;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class ClienteBuilder implements Builder<Cliente> {
    private Cliente cliente;

    private ClienteBuilder(){}

    public static ClienteBuilder umCliente(){
        ClienteBuilder builder = new ClienteBuilder();
        builder.cliente = new Cliente();
        return builder;
    }

    public ClienteBuilder comNome(String nome){
        cliente.setNome(nome);
        return this;
    }

    public ClienteBuilder comCPF(String cpf){
        cliente.setCpf(cpf);
        return this;
    }

    public ClienteBuilder comNumeroCNH(String numero){
        if(Objects.isNull(cliente.getCnh())){
            cliente.setCnh(new CNH());
        }
        cliente.getCnh().setNumero(numero);
        return this;
    }

    public ClienteBuilder comValidadeCNH(LocalDate validade){
        if(Objects.isNull(cliente.getCnh())){
            cliente.setCnh(new CNH());
        }
        cliente.getCnh().setValidade(validade);
        return this;
    }

    public ClienteBuilder comCategoriaCNH(String categoria){
        if(Objects.isNull(cliente.getCnh())){
            cliente.setCnh(new CNH());
        }
        cliente.getCnh().setCategoria(categoria);
        return this;
    }

    public ClienteBuilder comTelefones(Telefone ...telefones){
        cliente.setTelefones(Set.of(telefones));
        return this;
    }

    public ClienteBuilder comEnderecos(Endereco ...enderecos){
        cliente.setEnderecos(Set.of(enderecos));
        return this;
    }

    @Override
    public Cliente constroi() {
        return cliente;
    }
}
