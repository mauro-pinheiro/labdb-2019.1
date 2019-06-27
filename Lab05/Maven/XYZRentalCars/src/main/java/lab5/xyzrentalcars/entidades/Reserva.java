package lab5.xyzrentalcars.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Reserva {
    public enum Situacao {
        ATIVA {
            @Override
            Situacao ativa() {
                throw new IllegalStateException("Reserva já foi ativada");
            }

            @Override
            Situacao notificaAtrazo() {
                return ATRASADA;
            }

            @Override
            Situacao finaliza() {
                return FINALIZADA;
            }
        },
        ATRASADA {
            @Override
            Situacao ativa() {
                throw new IllegalStateException("Reserva já foi ativada");
            }

            @Override
            Situacao notificaAtrazo() {
                throw new IllegalStateException("Atraso já notificado");
            }

            @Override
            Situacao finaliza() {
                return FINALIZADA;
            }
        },
        FINALIZADA {
            @Override
            Situacao ativa() {
                throw new IllegalStateException("Atraso já finalizada");
            }

            @Override
            Situacao notificaAtrazo() {
                throw new IllegalStateException("Atraso já finalizada");
            }

            @Override
            Situacao finaliza() {
                throw new IllegalStateException("Atraso já finalizada");
            }
        };

        abstract Situacao ativa();
        abstract Situacao notificaAtrazo();
        abstract Situacao finaliza();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    @Column(name = "quantidade_diarias")
    private Integer quantidadeDiarias;
    @Column(name = "data_locacao")
    private LocalDate dataLocacao;
    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;
    @Column(name = "quilometros_rodados")
    private Integer quilometrosRodados;
    private BigDecimal multa;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "id_sede_locacao", nullable = false)
    private Sede locacao;

    @ManyToOne
    @JoinColumn(name = "id_sede_devolucao", nullable = false)
    private Sede devolucao;

    @ManyToOne
    @JoinColumn(name = "id_carro", nullable = false)
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public void setQuantidadeDiarias(Integer quantidadeDiarias) {
        this.quantidadeDiarias = quantidadeDiarias;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getQuilometrosRodados() {
        return quilometrosRodados;
    }

    public void setQuilometrosRodados(Integer quilometrosRodados) {
        this.quilometrosRodados = quilometrosRodados;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Sede getLocacao() {
        return locacao;
    }

    public void setLocacao(Sede locacao) {
        this.locacao = locacao;
    }

    public Sede getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Sede devolucao) {
        this.devolucao = devolucao;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", quantidadeDiarias=" + quantidadeDiarias +
                ", dataLocacao=" + dataLocacao +
                ", dataDevolucao=" + dataDevolucao +
                ", quilometrosRodados=" + quilometrosRodados +
                ", multa=" + multa +
                ", situacao=" + situacao +
                ", valorTotal=" + valorTotal +
                ", locacao=" + locacao +
                ", devolucao=" + devolucao +
                ", carro=" + carro +
                ", cliente=" + cliente +
                '}';
    }

    public Situacao ativa() throws IllegalAccessException {
        if(Objects.isNull(situacao)){
            if(cliente.possuiReservaAtiva()){
                throw new IllegalAccessException("Cliente possui reserva nao finalizada");
            }
            else if (cliente.possuiHabilitacaoVencida()){
                throw  new IllegalArgumentException("Cliente possui cnh vencida");
            }
            else {
                return Situacao.ATIVA;
            }
        }
        return situacao.ativa();
    }

    public Situacao notificaAtrazo() {
        return situacao.notificaAtrazo();
    }

    public Situacao finaliza() {
        return situacao.finaliza();
    }
}
