package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.app.mongo.Documentable;
import lab5.xyzrentalcars.exceptions.InicializacaoDeAtributoRepetidaExceprion;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Reserva extends Documentable implements EntidadeBase {
    public enum Situcao {
        Ativa,
        Atrazada,
        Finalizada
    }

    public static class Builder {
        private Reserva reserva;

        private Builder(){}

        public static Builder umReserva(){
            Builder builder = new Builder();
            builder.reserva = new Reserva();
            return builder;
        }

        public static Builder umReserva(int id){
            Builder builder = new Builder();
            builder.reserva = new Reserva();
            builder.reserva.setId(id);
            return builder;
        }

        public Builder comNumero(String numero){
            if(Objects.isNull(reserva.getNumero())) {
                reserva.setNumero(numero);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("numero");
            }
        }

        public Builder comDiarias(Integer diarias){
            if(Objects.isNull(reserva.getDiarias())) {
                reserva.setDiarias(diarias);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("diarias");
            }
        }

        public Builder comDataLocacao(LocalDate locacao){
            if(Objects.isNull(reserva.getDataLocacao())) {
                reserva.setDataLocacao(locacao);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("locacao");
            }
        }

        public Builder comDataRetorno(LocalDate retorno){
            if(Objects.isNull(reserva.getDataRetorno())) {
                reserva.setDataRetorno(retorno);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("retorno");
            }
        }

        public Builder comKmRodados(Integer km){
            if(Objects.isNull(reserva.getKmRodados())) {
                reserva.setKmRodados(km);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("quilometros rodados");
            }
        }

        public Builder comMulta(BigDecimal multa){
            // TODO: Apagar
            return this;
        }

        public Builder naSituacao(Reserva.Situcao situacao){
            if(Objects.isNull(reserva.getSituacao())) {
                reserva.setSituacao(situacao);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("situacao");
            }
        }

        public Builder paraCliente(Cliente cliente){
            if(Objects.isNull(reserva.getCliente())) {
                reserva.setCliente(cliente);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("cliente");
            }
        }

        public Builder doCarro(Carro carro){
            if(Objects.isNull(reserva.getCarro())) {
                reserva.setCarro(carro);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("carro");
            }
        }

        public Builder comSedeDeLocacao(Sede sede){
            if(Objects.isNull(reserva.getSedeLocacao())) {
                reserva.setSedeLocacao(sede);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("sede de locação");
            }
        }

        public Builder comSedeDeDevolucao(Sede sede){
            if(Objects.isNull(reserva.getSedeDevolucao())) {
                reserva.setSedeDevolucao(sede);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("sede de devolucao");
            }
        }

        public Reserva constroi() {
            Objects.requireNonNull(reserva.getSedeLocacao(), "Nao pode construir reserva com sede de locacao nula");
            Objects.requireNonNull(reserva.getDataLocacao(), "Nao pode construir reserva com data de locacao nula");
            Objects.requireNonNull(reserva.getDiarias(), "Nao pode construir reserva com qtde de diarias nula");
            //Objects.requireNonNull(reserva.getMulta(), "Nao pode construir reserva com multa nula");
            Objects.requireNonNull(reserva.getSituacao(), "Nao pode construir reserva com situacao nula");
            Objects.requireNonNull(reserva.getCarro(), "Nao pode construir reserva com carro nulo");
            Objects.requireNonNull(reserva.getCliente(), "Nao pode construir reserva com cliente nulo");

            reserva.multa = reserva.sedeLocacao.getMultaSedeDiferente();
            reserva.setValorTotal(reserva.getCarro().getValorDiaria().multiply(new BigDecimal(reserva.diarias)));
            return reserva;
        }
    }

    public Reserva(){
        setInstance(this);
    }

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

    @PrePersist
    public void antes(){
        BigDecimal valorDiarias = Objects.requireNonNull(this.getCarro()).getValorDiaria();
        BigDecimal diarias = new BigDecimal(Objects.requireNonNull(this.getDiarias()));
        BigDecimal multa = this.getMulta();
        BigDecimal valorTotal = Objects.requireNonNull(valorDiarias)
                .multiply(Objects.requireNonNull(diarias))
                .add(Objects.requireNonNull(multa));
        this.setValorTotal(valorTotal);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 10)
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

    @Column(name = "data_retorno")
    public LocalDate getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDate retorno) {
        this.dataRetorno = retorno;
    }

    @Column(name = "quilometros_rodados")
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
    @Column(length = 20)
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

    public void setCliente(Cliente cliente) {
        if(Objects.nonNull(cliente)){
            if(cliente.temReservaNaoFinalizada()){
                throw new IllegalArgumentException("Cliente tem reserva nao finalizada.");
            } else if(cliente.comCnhVencida()){
                throw new IllegalArgumentException("Cliente esta com a cnh vencida");
            } else {
                this.cliente = cliente;
                this.cliente.getHistoricoReservas().add(this);
            }
        }
    }

    @ManyToOne
    @JoinColumn(name = "id_carro", nullable = false)
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        Objects.requireNonNull(carro).aluga(this);
        this.carro = carro;
    }

    @ManyToOne
    @JoinColumn(name = "id_sede_locacao", nullable = false)
    public Sede getSedeLocacao() {
        return sedeLocacao;
    }

    public void setSedeLocacao(Sede sedeLocacao) {
        this.sedeLocacao = sedeLocacao;
        if(Objects.nonNull(sedeLocacao)){
            sedeLocacao.getHistoricoLocacao().add(this);
        }
    }

    @ManyToOne
    @JoinColumn(name = "id_sede_devolucao")
    public Sede getSedeDevolucao() {
        return sedeDevolucao;
    }

    public void setSedeDevolucao(Sede sedeDevolucao) {
        this.sedeDevolucao = sedeDevolucao;
        if(Objects.nonNull(sedeDevolucao)){
            sedeDevolucao.getHistoricoDevolucao().add(this);
        }
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

    public void finalizar(Sede sede){
        situacao = Situcao.Finalizada;
        if(!Objects.equals(sede,sedeLocacao)){
            this.valorTotal = valorTotal.add(multa);
        }
        carro.retorna(sede);
        setDataRetorno(LocalDate.now());
    }

    public void finalizar(Sede sede, LocalDate date){
        situacao = Situcao.Finalizada;
        if(!Objects.equals(sede,sedeLocacao)){
            this.valorTotal = valorTotal.add(multa);
        }
        carro.retorna(sede);
        setDataRetorno(date);
        sede.getHistoricoDevolucao().add(this);
    }
}
