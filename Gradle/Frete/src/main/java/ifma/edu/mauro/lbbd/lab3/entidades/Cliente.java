package ifma.edu.mauro.lbbd.lab3.entidades;

import java.util.Objects;

public class Cliente {
    private int codigo_cliente = -1;
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo_cliente=" + codigo_cliente +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getCodigo_cliente() == cliente.getCodigo_cliente() &&
                Objects.equals(getNome(), cliente.getNome()) &&
                Objects.equals(getEndereco(), cliente.getEndereco()) &&
                Objects.equals(getTelefone(), cliente.getTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo_cliente(), getNome(), getEndereco(), getTelefone());
    }
}
