package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.EntidadeBase;
import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Sede implements EntidadeBase {
    private Integer id;
    private String nome;
    private Endereco endereco;
    private Set<Telefone> telefone = new HashSet<>();
    private String nomeGerente;
    private BigDecimal multaSedeDiferente;
    private Set<Reserva> historicoLocacao = new HashSet<>();
    private Set<Reserva> historicoDevolucao = new HashSet<>();
    private Set<Carro> carrosOriginadosDaSede = new HashSet<>();
    private Set<Carro> carrosAtualmenteNaSede = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
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
            @AttributeOverride(name = "tipoLugradouro",
                    column = @Column(name = "end_tipo_lugradouro", length = 20, nullable = false)),
            @AttributeOverride(name = "nome", column = @Column(name = "end_name", length = 60, nullable = false)),
            @AttributeOverride(name = "numero", column = @Column(name = "end_numero", length = 8)),
            @AttributeOverride(name = "complemento", column = @Column(name = "end_complemento", length = 60)),
            @AttributeOverride(name = "bairro", column = @Column(name = "end_bairro", length = 30, nullable = false)),
            @AttributeOverride(name = "cidade", column = @Column(name = "end_cidade", length = 20)),
            @AttributeOverride(name = "estado", column = @Column(name = "end_estado", length = 20)),
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
        return telefone;
    }

    public void setTelefones(Set<Telefone> telefone) {
        this.telefone = telefone;
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
}
