package ifma.edu.mauro.lbbd.lab3.entidades;

import java.util.Objects;

public class Frete {
    private int codigo_frete;
    private Cidade cidade;
    private Cliente cliente;
    private String descricao;
    private float peso;
    private float valor;

    public Frete(Cidade cidade, Cliente cliente, String descricao, float peso, float valor) {
        this.cidade = cidade;
        this.cliente = cliente;
        this.descricao = descricao;
        this.peso = peso;
        this.valor = valor;
    }

    public int getCodigo_frete() {
        return codigo_frete;
    }

    public void setCodigo_frete(int codigo_frete) {
        this.codigo_frete = codigo_frete;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Frete{" +
                "codigo_frete=" + codigo_frete +
                ", cidade=" + cidade +
                ", cliente=" + cliente +
                ", descricao='" + descricao + '\'' +
                ", peso=" + peso +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Frete)) return false;
        Frete frete = (Frete) o;
        return getCodigo_frete() == frete.getCodigo_frete() &&
                Float.compare(frete.getPeso(), getPeso()) == 0 &&
                Float.compare(frete.getValor(), getValor()) == 0 &&
                Objects.equals(getCidade(), frete.getCidade()) &&
                Objects.equals(getCliente(), frete.getCliente()) &&
                Objects.equals(getDescricao(), frete.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo_frete(), getCidade(), getCliente(), getDescricao(), getPeso(), getValor());
    }

    public float calculaValor(){
        return peso*valor + cidade.getTaxa();
    }
}
