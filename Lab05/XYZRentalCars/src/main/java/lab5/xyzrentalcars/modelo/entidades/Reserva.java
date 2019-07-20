package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.modelo.EntidadeBase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Reserva implements EntidadeBase {
    private Integer id;
    private String numero;
    private Integer diarias;
    private LocalDate dataLocacao;
    private LocalDate dataRetorno;
    private Integer kmRodados;
    private BigDecimal multa;
    private Situcao situacao;
    private BigDecimal valorTotal;
    private Cliente cliente;
    private Carro carro;
    private Sede sedeLocacao;
    private Sede sedeDevolucao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 10, nullable = false)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Column(name = "qtde_diarias", nullable = false)
    public Integer getDiarias() {
        return diarias;
    }

    public void setDiarias(Integer diarias) {
        this.diarias = diarias;
    }

    @Column(name = "data_locacao", nullable = false)
    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate locacao) {
        this.dataLocacao = locacao;
    }

    @Column(name = "data_retorno", nullable = false)
    public LocalDate getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDate retorno) {
        this.dataRetorno = retorno;
    }

    @Column(name = "quilometros_rodados", nullable = false)
    public Integer getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(Integer kmRodados) {
        this.kmRodados = kmRodados;
    }

    @Column(nullable = false)
    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    @Enumerated(EnumType.STRING)
    public Situcao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situcao situacao) {
        this.situacao = situacao;
    }

    @Column(name = "valor_total", nullable = false)
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    public Cliente getCliente() {
        return cliente;
    }

    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name = "id_carro", nullable = false)
    public Carro getCarro() {
        return carro;
    }

    private void setCarro(Carro carro) {
        this.carro = carro;
    }

    @ManyToOne
    @JoinColumn(name = "id_sede_locacao", nullable = false)
    public Sede getSedeLocacao() {
        return sedeLocacao;
    }

    private void setSedeLocacao(Sede sedeLocacao) {
        this.sedeLocacao = sedeLocacao;
    }

    @ManyToOne
    @JoinColumn(name = "id_sede_devolucao", nullable = true)
    public Sede getSedeDevolucao() {
        return sedeDevolucao;
    }

    public void setSedeDevolucao(Sede sedeDevolucao) {
        this.sedeDevolucao = sedeDevolucao;
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

    private enum Situcao {
        Ativa,
        Atrazada,
        Finalizada
    }
}
