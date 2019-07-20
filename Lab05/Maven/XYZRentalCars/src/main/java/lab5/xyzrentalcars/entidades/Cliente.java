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

    @Embedded
    private CNH cnh;


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

    public CNH getCnh() {
        return cnh;
    }

    public Set<EnderecoCliente> getEnderecos() {
        return enderecos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnh(CNH cnh) {
        this.cnh = cnh;
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


    public boolean possuiReservaAtiva(){
        return historicoReservas.stream()
                                .map(reserva -> reserva.getSituacao())
                                .filter(situacao -> situacao == Reserva.Situacao.ATIVA)
                                .count() != 0;
    }

    public boolean possuiHabilitacaoVencida(){
        return cnh.vencida();
    }
}
