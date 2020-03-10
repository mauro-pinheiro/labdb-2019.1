package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.app.mongo.Documentable;
import lab5.xyzrentalcars.exceptions.InicializacaoDeAtributoRepetidaExceprion;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import lab5.xyzrentalcars.util.AuxMethods;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Sede extends Documentable implements EntidadeBase {
    public static class Builder {
        private Sede sede;

        private Builder(){}

        public static Builder umaSede(){
            Builder builder = new Builder();
            builder.sede = new Sede();
            return builder;
        }

        static Builder umaSede(int id){
            Builder builder = new Builder();
            builder.sede = new Sede();
            builder.sede.setId(id);
            return builder;
        }

        public Builder comNome(String nome){
            if(Objects.isNull(sede.getNome())) {
                sede.setNome(nome);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("nome");
            }
        }

        public Builder comEndereco(Endereco endereco){
            if(Objects.isNull(sede.getEndereco())) {
                sede.setEndereco(endereco);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("endereco");
            }
        }

        public Builder comTelefones(Telefone ...telefones){
            if(sede.getTelefones().isEmpty()) {
                sede.setTelefones(Set.of(telefones));
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("telefones");
            }
        }

        public Builder comGerente(String nome){
            if(Objects.isNull(sede.getNomeGerente())) {
                sede.setNomeGerente(nome);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("nome do gerente");
            }
        }

        public Builder comMultaPorSedeDiferente(BigDecimal multa){
            if(Objects.isNull(sede.getMultaSedeDiferente())) {
                sede.setMultaSedeDiferente(multa);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("multa Por Sede Diferente");
            }
        }

        public Sede constroi() {
            Objects.requireNonNull(sede.getNome(), "Nome nao pode ser nulo");
            Objects.requireNonNull(sede.getEndereco(), "Endereço nao pode ser nulo");
            return sede;
        }
    }

    protected Sede(){
        setInstance(this);
    }

    private Integer id;
    private String nome;
    private Endereco endereco;
    private Set<Telefone> telefones = new LinkedHashSet<>();
    private String nomeGerente;
    private BigDecimal multaSedeDiferente;
    private Set<Reserva> historicoLocacao = new LinkedHashSet<>();
    private Set<Reserva> historicoDevolucao = new LinkedHashSet<>();
    private Set<Carro> carrosOriginadosDaSede = new LinkedHashSet<>();
    private Set<Carro> carrosAtualmenteNaSede = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 40, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "lugradouro.tipo", column = @Column(length = 20, nullable = false, name = "end_tipo_lugradouro")),
            @AttributeOverride(name = "lugradouro.nome", column = @Column(length = 60, nullable = false, name = "end_nome_lugradouro")),
            @AttributeOverride(name = "numero", column = @Column(name = "end_numero", length = 10)),
            @AttributeOverride(name = "complemento", column = @Column(name = "end_complemento", length = 60)),
            @AttributeOverride(name = "bairro", column = @Column(name = "end_bairro", length = 60, nullable = false)),
            @AttributeOverride(name = "cidade", column = @Column(name = "end_cidade", length = 60)),
            @AttributeOverride(name = "estado", column = @Column(name = "end_estado", length = 60)),
            @AttributeOverride(name = "cep", column = @Column(name = "end_cep", length = 10))
    })
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @ElementCollection
    @CollectionTable(name = "sede_telefones",
            joinColumns = @JoinColumn(name = "id_sede"))
    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Column(name = "nome_gerente", length = 40)
    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    @Column(name = "multa_sede_diferente")
    public BigDecimal getMultaSedeDiferente() {
        return multaSedeDiferente;
    }

    public void setMultaSedeDiferente(BigDecimal multaSedeDiferente) {
        this.multaSedeDiferente = multaSedeDiferente;
    }

    @OneToMany(mappedBy = "sedeLocacao")
    public Set<Reserva> getHistoricoLocacao() {
        return historicoLocacao;
    }

    private void setHistoricoLocacao(Set<Reserva> historicoLocacao) {
        this.historicoLocacao = historicoLocacao;
    }

    @OneToMany(mappedBy = "sedeDevolucao")
    public Set<Reserva> getHistoricoDevolucao() {
        return historicoDevolucao;
    }

    private void setHistoricoDevolucao(Set<Reserva> historicoDevolucao) {
        this.historicoDevolucao = historicoDevolucao;
    }

    @OneToMany(mappedBy = "sedeDeOrigem")
    public Set<Carro> getCarrosOriginadosDaSede() {
        return carrosOriginadosDaSede;
    }

    private void setCarrosOriginadosDaSede(Set<Carro> carrosOriginadosDaSede) {
        this.carrosOriginadosDaSede = carrosOriginadosDaSede;
    }

    @OneToMany(mappedBy = "sedeAtual")
    public Set<Carro> getCarrosAtualmenteNaSede() {
        return carrosAtualmenteNaSede;
    }

    private void setCarrosAtualmenteNaSede(Set<Carro> carrosAtualmenteNaSede) {
        this.carrosAtualmenteNaSede = carrosAtualmenteNaSede;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sede sede = (Sede) o;
        return Objects.equals(id, sede.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Set<Reserva> reservasEmAberto(){
        return historicoLocacao.stream()
                .filter(r -> r.getSituacao() != Reserva.Situcao.Finalizada)
                .collect(Collectors.toSet());
    }

    public Set<Reserva> reservasFinalizadas(LocalDate inicio, LocalDate fim){
        return historicoDevolucao.stream()
                .filter(r -> AuxMethods.betweenDates(r.getDataRetorno(),inicio,fim))
                .collect(Collectors.toSet());
    }
}
