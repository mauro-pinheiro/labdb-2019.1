package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.exceptions.InicializacaoDeAtributoRepetidaExceprion;
import lab5.xyzrentalcars.modelo.EntidadeBase;
import lab5.xyzrentalcars.modelo.embutiveis.CNH;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cliente implements EntidadeBase {
    public static class Builder {
        private Cliente cliente;

        private Builder(){}

        public static Builder umCliente(){
            Builder builder = new Builder();
            builder.cliente = new Cliente();
            return builder;
        }

        public Builder comNome(String nome){
            if(Objects.isNull(cliente.getNome())) {
                cliente.setNome(nome);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("nome");
            }
        }

        public Builder comCPF(String cpf){
            if(Objects.isNull(cliente.getCpf())) {
                cliente.setCpf(cpf);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("cpf");
            }
        }

        public Builder comCNH(CNH cnh){
            if(Objects.isNull(cliente.getCnh())){
                cliente.setCnh(cnh);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("cnh");
            }
        }


        public Builder comTelefones(Telefone ...telefones){
            if(cliente.getTelefones().isEmpty()) {
                cliente.setTelefones(Set.of(telefones));
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("telefones");
            }
        }

        public Builder comEnderecos(Endereco ...enderecos){
            if(cliente.getEnderecos().isEmpty()) {
                cliente.setEnderecos(Set.of(enderecos));
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("enderecos");
            }
        }

        public Cliente constroi() {
            Objects.requireNonNull(cliente.getCnh(),"CNH nao pode ser nula");
            Objects.requireNonNull(cliente.getNome(), "Nome nao pode ser nulo");
            Objects.requireNonNull(cliente.getCpf(), "CPFs nao pode ser nulo");
            return cliente;
        }
    }

    private Integer id;
    private String nome;
    private String cpf;
    private CNH cnh;
    private Set<Telefone> telefones = new LinkedHashSet<>();
    private Set<Endereco> enderecos = new LinkedHashSet<>();
    private Set<Reserva> historicoReservas = new LinkedHashSet<>();

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

    @Column(columnDefinition = "Char(11)", nullable = false, unique = true)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "numero", column = @Column(name = "numero_cnh", length = 60, nullable = false)),
            @AttributeOverride(name = "validade", column = @Column(name = "validade_cnh", nullable = false)),
            @AttributeOverride(name = "categoria", column = @Column(name = "categoria_cnh", length = 20))
    })
    public CNH getCnh() {
        return cnh;
    }

    public void setCnh(CNH cnh) {
        this.cnh = cnh;
    }

    @ElementCollection
    @CollectionTable(name = "cliente_telefones",
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

    public boolean comCnhVencida(){
        return cnh.vencida();
    }

    public boolean temReservaNaoFinalizada(){
        return historicoReservas.stream()
                .filter(reserva -> !Objects.equals(reserva.getSituacao(), Reserva.Situcao.Finalizada))
                .count() > 0;
    }
}
