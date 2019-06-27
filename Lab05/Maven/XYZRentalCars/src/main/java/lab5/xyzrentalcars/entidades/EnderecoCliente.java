package lab5.xyzrentalcars.entidades;

import lab5.xyzrentalcars.entidades.enums.TipoLugradouro;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Endereco")
public class EnderecoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TipoLugradouro lugradouro;
    @Column(nullable = false, length = 40)
    private String nome;
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(nullable = true, length = 40)
    private String complemento;
    @Column(nullable = false, length = 40)
    private String bairro;
    @Column(nullable = false, length = 20)
    private String cidade;
    @Column(nullable = false, length = 20)
    private String estado;
    @Column(nullable = false, length = 8)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public TipoLugradouro getLugradouro() {
        return lugradouro;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setLugradouro(TipoLugradouro lugradouro) {
        this.lugradouro = lugradouro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoCliente that = (EnderecoCliente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EnderecoCliente{" +
                "id=" + id +
                ", lugradouro=" + lugradouro +
                ", nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
