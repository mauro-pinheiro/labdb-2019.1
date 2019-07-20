package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.enums.ClasseCarro;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Carro {
    private Integer id;
    private String placa;
    private String modelo;
    private Short ano;
    private String cor;
    private Integer quilometragem;
    private String descricao;
    private Situacao situacao;
    private ClasseCarro classe;
    private Set<Reserva> historicoReservas = new HashSet<>();
    private Sede sedeOriginal;
    private Sede sedeAtual;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return id;
    }

    private void setId(Integer id){
        this.id = id;
    }

    @Column(length = 10, nullable = false)
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Column(length = 30, nullable = false)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(columnDefinition = "YEAR(4)", nullable = false)
    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    @Column(length = 20, nullable = false)
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Column(nullable = false)
    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    @Column(columnDefinition = "TEXT", nullable = true)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Enumerated(EnumType.STRING)
    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Enumerated(EnumType.STRING)
    public ClasseCarro getClasse() {
        return classe;
    }

    public void setClasse(ClasseCarro classe) {
        this.classe = classe;
    }

    @Column(name = "valor_diaria", nullable = false)
    public BigDecimal getValorDiaria() {
        return classe.getValorDiaria();
    }

    private void setValorDiaria(BigDecimal valorDiaria) {
        classe.setValorDiaria(valorDiaria);
    }

    @OneToMany(mappedBy = "carro")
    public Set<Reserva> getHistoricoReservas() {
        return historicoReservas;
    }

    private void setHistoricoReservas(Set<Reserva> historicoReservas) {
        this.historicoReservas = historicoReservas;
    }

    @ManyToOne
    @JoinColumn(name = "id_sede_de_origem", nullable = false)
    public Sede getSedeOriginal() {
        return sedeOriginal;
    }

    private void setSedeOriginal(Sede original) {
        this.sedeOriginal = original;
    }

    @ManyToOne
    @JoinColumn(name = "id_sede_atual", nullable = true)
    public Sede getSedeAtual() {
        return sedeAtual;
    }

    public void setSedeAtual(Sede atual) {
        this.sedeAtual = atual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(id, carro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private enum Situacao {
        Disponivel,
        Alugado,
        ForaOrigem
    }
}
