package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.EntidadeBase;
import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cliente implements EntidadeBase {
    private Integer id;
    private String nome;
    private String cpf;
    private CNH cnh;
    private Set<Telefone> telefones = new HashSet<>();
    private Set<Endereco> enderecos = new HashSet<>();
    private Set<Reserva> historicoReservas = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 60, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(columnDefinition = "Char(11)", nullable = false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Embedded
    public CNH getCnh() {
        return cnh;
    }

    public void setCnh(CNH cnh) {
        this.cnh = cnh;
    }

    @ElementCollection
    @CollectionTable(name = "cliente_telefone",
            joinColumns = @JoinColumn(name = "id_cliente"))
    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    @ElementCollection
    @CollectionTable(name = "cliente_enderecos",
            joinColumns = @JoinColumn(name = "id_cliente", nullable = false))
    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @OneToMany(mappedBy = "cliente")
    public Set<Reserva> getHistoricoReservas() {
        return historicoReservas;
    }

    private void setHistoricoReservas(Set<Reserva> historicoReservas) {
        this.historicoReservas = historicoReservas;
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
}
