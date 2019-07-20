package lab5.xyzrentalcars.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Carro {
    public enum Situacao {
        DISPONIVEL {
            @Override
            Situacao aluga() {
                return ALUGADO;
            }

            @Override
            Situacao devolveOrigem() {
                throw new IllegalStateException("Carro nao esta alugado");
            }

            @Override
            Situacao devolveDiferente() {
                throw new IllegalStateException("Carro nao esta alugado");
            }

            @Override
            Situacao transfere() {
                throw new IllegalStateException("Carro nao esta fora da origem");
            }

            @Override
            public String toString() {
                return "DISPONÍVEL";
            }
        },
        ALUGADO {
            @Override
            Situacao aluga() {
                throw new IllegalStateException("Carro nao esta disponível");
            }

            @Override
            Situacao devolveOrigem() {
                return DISPONIVEL;
            }

            @Override
            Situacao devolveDiferente() {
                return FORA;
            }

            @Override
            Situacao transfere() {
                throw new IllegalStateException("Carro nao esta fora da origem");
            }
        },
        FORA {
            @Override
            Situacao aluga() {
                throw new IllegalStateException("Carro nao esta disponível");
            }

            @Override
            Situacao devolveOrigem() {
                throw new IllegalStateException("Carro nao esta alugado");
            }

            @Override
            Situacao devolveDiferente() {
                throw new IllegalStateException("Carro nao esta alugado");
            }

            @Override
            Situacao transfere() {
                return DISPONIVEL;
            }
        };

        abstract Situacao aluga();
        abstract Situacao devolveOrigem();
        abstract Situacao devolveDiferente();
        abstract Situacao transfere();
    }

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

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @Enumerated(EnumType.STRING)
    private ClasseCarro classe;

    @Column(name = "valor_diaria")
    private BigDecimal valorDiaria;

    @PrePersist
    private void recebeValorDiaria(){
        valorDiaria = classe.getValorDiaria();
    }

    @PostPersist
    private void enviaValorDiaria(){
        classe.setValorDiaria(valorDiaria);
    }

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

    public BigDecimal getValorDiaria() {
        return classe.getValorDiaria();
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        classe.setValorDiaria(valorDiaria);
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
                '}';
    }
}
