package lab5.xyzrentalcars.entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 40, unique = true)
    private String nome;
    @Column(nullable = false, columnDefinition = "char(11)", unique = true)
    private String cpf;
    @OneToMany(mappedBy = "cliente")
    private Set<EnderecoCliente> enderecos = new HashSet<>();
    private String numeroCNH;
    private LocalDate validadeCNH;
    private String categriaCNH;

    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> historicoReservas = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Set<EnderecoCliente> getEnderecos() {
        return enderecos;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public LocalDate getValidadeCNH() {
        return validadeCNH;
    }

    public String getCategriaCNH() {
        return categriaCNH;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEnderecos(Set<EnderecoCliente> enderecos) {
        this.enderecos = enderecos;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public void setValidadeCNH(LocalDate validadeCNH) {
        this.validadeCNH = validadeCNH;
    }

    public void setCategriaCNH(String categriaCNH) {
        this.categriaCNH = categriaCNH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", enderecos=" + enderecos +
                ", numeroCNH='" + numeroCNH + '\'' +
                ", validadeCNH=" + validadeCNH +
                ", categriaCNH='" + categriaCNH + '\'' +
                ", historicoReservas=" + historicoReservas +
                '}';
    }
}
