package xyzrentalcar.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;

    @Column(name = "qtde_diarias")
    private Integer quantidadeDiarias;

    private LocalDate data_locacao;
    private LocalDate data_retorno;

    @Column(name = "km_rodados")
    private Integer quilometrosRodados;
    private BigDecimal multa;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToOne @JoinColumn(name = "id_sede_locacao", nullable = false)
    private Sede sedeLocacao;

    @ManyToOne @JoinColumn(name = "id_sede_devolucao", nullable = true)
    private Sede sedeDevolucao;

    @ManyToOne @JoinColumn(name = "id_carro", nullable = false)
    private Carro carro;

    @ManyToOne @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.ATIVA;

    public Integer getId() {
        return id;
    }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

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

    public LocalDate getLocacao() {
        return data_locacao;
    }

    public void setLocacao(LocalDate locacao) {
        this.data_locacao = locacao;
    }

    public LocalDate getRetorno() {
        return data_retorno;
    }

    public void setRetorno(LocalDate retorno) {
        this.data_retorno = retorno;
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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(LocalDate data_locacao) {
        this.data_locacao = data_locacao;
    }

    public LocalDate getData_retorno() {
        return data_retorno;
    }

    public void setData_retorno(LocalDate data_retorno) {
        this.data_retorno = data_retorno;
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

    public Situacao getSituacao() {
        return situacao;
    }

    // public void setSituacao(Situacao situacao) {
    //     this.situacao = situacao;
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reserva other = (Reserva) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reserva [carro=" + carro + ", cliente=" + cliente + ", id=" + id + ", locacao=" + data_locacao + ", multa="
                + multa + ", numero=" + numero + ", quantidadeDiarias=" + quantidadeDiarias + ", quilometrosRodados="
                + quilometrosRodados + ", retorno=" + data_retorno + ", sedeDevolucao=" + sedeDevolucao + ", sedeLocacao="
                + sedeLocacao + ", situacao=" + situacao + ", valorTotal=" + valorTotal + "]";
    }

    public void ativa(){
        situacao = situacao.ativa();
    }

    public void notificaAtrazo(){
        situacao = situacao.notificaAtrazo();
    }

    public void finaliza(){
        situacao = situacao.finaliza();
    }

    public Sede getSedeLocacao() {
        return sedeLocacao;
    }

    public void setSedeLocacao(Sede sedeLocacao) {
        this.sedeLocacao = sedeLocacao;
    }

    public Sede getSedeDevolucao() {
        return sedeDevolucao;
    }

    public void setSedeDevolucao(Sede sedeDevolucao) {
        this.sedeDevolucao = sedeDevolucao;
    }
}