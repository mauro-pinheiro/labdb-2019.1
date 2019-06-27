package lab5.xyzrentalcars.entidades;

import lab5.xyzrentalcars.entidades.enums.TipoLugradouro;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class EnderecoSede {
    @Enumerated(EnumType.STRING)
    @Column(name = "endereco_lugradouro")
    private TipoLugradouro lugradouro;
    @Column(name = "endereco_nome", nullable = false, length = 40)
    private String nome;
    @Column(name = "endereco_numero", nullable = false, length = 10)
    private String numero;
    @Column(nullable = true, length = 40, name = "endereco_complemento")
    private String complemento;
    @Column(nullable = false, length = 40, name = "endereco_bairro")
    private String bairro;
    @Column(nullable = false, length = 20, name = "endereco_cidade")
    private String cidade;
    @Column(nullable = false, length = 20, name = "endereco_estado")
    private String estado;
    @Column(nullable = false, length = 8, name = "endereco_cep")
    private String cep;

    public TipoLugradouro getLugradouro() {
        return lugradouro;
    }

    public void setLugradouro(TipoLugradouro lugradouro) {
        this.lugradouro = lugradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoSede that = (EnderecoSede) o;
        return lugradouro == that.lugradouro &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(numero, that.numero) &&
                Objects.equals(complemento, that.complemento) &&
                Objects.equals(bairro, that.bairro) &&
                Objects.equals(cidade, that.cidade) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(cep, that.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lugradouro, nome, numero, complemento, bairro, cidade, estado, cep);
    }

    @Override
    public String toString() {
        return "EnderecoSede{" +
                "lugradouro=" + lugradouro +
                ", nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
