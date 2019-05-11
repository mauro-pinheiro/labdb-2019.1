package ifma.edu.mauro.lbbd.lp3.entidades;

import java.util.Objects;

public class Cidade {
    private int codigo_cidade;
    private String nome;
    private String uf;
    private float taxa;

    public Cidade(String nome, String uf, float taxa) {
        this.nome = nome;
        this.uf = uf;
        this.taxa = taxa;
    }

    public int getCodigo_cidade() {
        return codigo_cidade;
    }

    public void setCodigo_cidade(int codigo_cidade) {
        this.codigo_cidade = codigo_cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "codigo_cidade=" + codigo_cidade +
                ", nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                ", taxa=" + taxa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;
        Cidade cidade = (Cidade) o;
        return getCodigo_cidade() == cidade.getCodigo_cidade() &&
                Float.compare(cidade.getTaxa(), getTaxa()) == 0 &&
                Objects.equals(getNome(), cidade.getNome()) &&
                Objects.equals(getUf(), cidade.getUf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo_cidade(), getNome(), getUf(), getTaxa());
    }
}
