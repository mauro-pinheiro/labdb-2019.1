package lab5.xyzrentalcars.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String placa;
    @Column(nullable = false)
    private String modelo;
    @Column(columnDefinition = "YEAR(4)")
    private Short ano;
    @Column(nullable = false)
    private Integer quilometragem;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_classe_carro", nullable = false)
    private ClasseCarro classe;

    @ManyToOne
    @JoinColumn(name = "id_sede_origem", nullable = false)
    private Sede pontoOrigem;

    @ManyToOne
    @JoinColumn(name = "id_sede_atual", nullable = true)
    private Sede atual;

    @OneToMany(mappedBy = "carro")
    private Set<Reserva> historicoReservas = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Short getAno() {
        return ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public String getDescricao() {
        return descricao;
    }

    public ClasseCarro getClasse() {
        return classe;
    }

    public Sede getPontoOrigem() {
        return pontoOrigem;
    }

    public Sede getAtual() {
        return atual;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setClasse(ClasseCarro classe) {
        this.classe = classe;
    }

    public void setPontoOrigem(Sede pontoOrigem) {
        this.pontoOrigem = pontoOrigem;
    }

    public void setAtual(Sede atual) {
        this.atual = atual;
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

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", quilometragem=" + quilometragem +
                ", descricao='" + descricao + '\'' +
                ", classe=" + classe +
                ", pontoOrigem=" + pontoOrigem +
                ", atual=" + atual +
                ", historicoReservas=" + historicoReservas +
                '}';
    }
}
