package lab5.xyzrentalcars.modelo.entidades;

import lab5.xyzrentalcars.exceptions.InicializacaoDeAtributoRepetidaExceprion;
import lab5.xyzrentalcars.modelo.EntidadeBase;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Carro implements EntidadeBase {

    public enum Situacao {
        Disponivel{
            @Override
            Situacao retornaNaOrigem() {
                throw new IllegalStateException("Nao pode retornar um carro disponivel");
            }

            @Override
            Situacao retornaForaDaOrigem() {
                throw new IllegalStateException("Nao pode retornar um carro disponivel");
            }

            @Override
            Situacao transferiParaOrigem() {
                throw new IllegalStateException("Nao pode transferi um carro que ja esta na origem");
            }

            @Override
            Situacao aluga() {
                return Alugado;
            }
        },
        Alugado {
            @Override
            Situacao retornaNaOrigem() {
                return Disponivel;
            }

            @Override
            Situacao retornaForaDaOrigem() {
                return ForaDaSedeDeOrigem;
            }

            @Override
            Situacao transferiParaOrigem() {
                throw new IllegalStateException("Nao pode transferir um carro alugado");
            }

            @Override
            Situacao aluga() {
                throw new IllegalStateException("Nao pode alugar um carro alugado");
            }
        },
        ForaDaSedeDeOrigem {
            @Override
            Situacao retornaNaOrigem() {
                throw new IllegalStateException("Nao pode retornar um carro fora da origem");
            }

            @Override
            Situacao retornaForaDaOrigem() {
                throw new IllegalStateException("Nao pode retornar um carro fora da origem");
            }

            @Override
            Situacao transferiParaOrigem() {
                return Disponivel;
            }

            @Override
            Situacao aluga() {
                return Alugado;
            }
        };

        abstract Situacao retornaNaOrigem();
        abstract Situacao retornaForaDaOrigem();
        abstract Situacao transferiParaOrigem();
        abstract Situacao aluga();
    }

    public static class Builder{
        private Carro carro;

        private Builder(){
        }

        public static Builder umCarro(){
            Builder builder = new Builder();
            builder.carro = new Carro();
            return builder;
        }

        static Builder umCarro(int id){
            Builder builder = new Builder();
            builder.carro = new Carro();
            builder.carro.setId(id);
            return builder;
        }

        public Builder comPlaca(String placa){
            if(Objects.isNull(carro.getPlaca())){
                carro.setPlaca(placa);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("placa");
            }
        }

        public Builder doModelo(String modelo){
            if(Objects.isNull(carro.getModelo())){
                carro.setModelo(modelo);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("modelo");
            }
        }

        public Builder doAno(Short ano){
            if(Objects.isNull(carro.getAno())){
                carro.setAno(ano);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("ano");
            }
        }

        public Builder daCor(String cor){
            if(Objects.isNull(carro.getCor())){
                carro.setCor(cor);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("cor");
            }
        }

        public Builder comQuilometragem(Integer km){
            if(Objects.isNull(carro.getQuilometragem())){
                carro.setQuilometragem(km);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("quilometragem");
            }
        }

        public Builder comDescricao(String desc){
            if(Objects.isNull(carro.getDescricao())){
                carro.setDescricao(desc);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("descrição");
            }
        }

        Builder naSituacao(Situacao situacao){
            if(Objects.isNull(carro.getSituacao())){
                carro.setSituacao(situacao);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("situação");
            }
        }

        public Builder daClasse(ClasseCarro classe){
            if(Objects.isNull(carro.getClasse())){
                carro.setClasse(classe);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("placa");
            }
        }

        public Builder comSedeDeOrigem(Sede origem){
            if(Objects.isNull(carro.getSedeDeOrigem())){
                carro.setSedeDeOrigem(origem);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("sede de origem");
            }
        }

        public Builder atualmenteNaSede(Sede atual){
            if(Objects.isNull(carro.getSedeAtual())){
                carro.setSedeAtual(atual);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("sede atual");
            }
        }

        public Carro constroi(){
            Objects.requireNonNull(carro.getClasse(), "Classe do carro nao pode ser nula");
            Objects.requireNonNull(carro. getSedeDeOrigem(), "Sede de origem do carro nao pode ser nula");

            if(Objects.isNull(carro.getSituacao())){
                carro.setSituacao(Situacao.Disponivel);
            }
            if(Objects.equals(carro.getSituacao(), Situacao.Disponivel)){
                carro.setSedeAtual(carro.getSedeDeOrigem());
            }
            else if(Objects.equals(carro.getSituacao(), Situacao.Alugado)){
                carro.setSedeAtual(null);
            }
            else if(Objects.equals(carro.getSedeAtual(),carro.getSedeDeOrigem())){
                carro.setSituacao(Situacao.Disponivel);
            }
            return carro;
        }
    }

    private Integer id;
    private String placa;
    private String modelo;
    private Short ano;
    private String cor;
    private Integer quilometragem;
    private String descricao;
    private Situacao situacao;
    private ClasseCarro classe;
    private Sede sedeDeOrigem;
    private Sede sedeAtual;
    private Set<Reserva> historicoReservas = new HashSet<>();


    protected Carro(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return id;
    }

    private void setId(Integer id){
        this.id = id;
    }

    @Column(length = 10)
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Column(length = 30)
    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(columnDefinition = "YEAR(4)")
    public Short getAno() {
        return ano;
    }

    private void setAno(Short ano) {
        this.ano = ano;
    }

    @Column(length = 20)
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    @Column(columnDefinition = "Text")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    public Situacao getSituacao() {
        return situacao;
    }

    private void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    public ClasseCarro getClasse() {
        return classe;
    }

    private void setClasse(ClasseCarro classe) {
        this.classe = classe;
    }

    @Column(name = "valor_diaria")
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
    public Sede getSedeDeOrigem() {
        return sedeDeOrigem;
    }

    private void setSedeDeOrigem(Sede original) {
        Objects.requireNonNull(original.getCarrosOriginadosDaSede()).add(this);
        if(Objects.nonNull(sedeDeOrigem)){
            sedeDeOrigem.getCarrosOriginadosDaSede().remove(this);
        }
        sedeDeOrigem = original;

    }

    @ManyToOne
    @JoinColumn(name = "id_sede_atual")
    public Sede getSedeAtual() {
        return sedeAtual;
    }

    private void setSedeAtual(Sede atual) {
        if(Objects.nonNull(atual)){
            atual.getCarrosAtualmenteNaSede().add(this);
        }

        if(Objects.nonNull(sedeAtual)){
            sedeAtual.getCarrosAtualmenteNaSede().remove(this);
        }
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

    public void retorna(Sede sede){
        if(Objects.equals(sede, getSedeDeOrigem())){
            situacao = situacao.retornaNaOrigem();
        } else {
            situacao = situacao.transferiParaOrigem();
        }
        setSedeAtual(sede);
    }

    public void aluga(Reserva reserva){
        situacao = situacao.aluga();
        historicoReservas.add(reserva);
        setSedeAtual(null);
    }

    public void transferi(Sede sede){
        situacao = situacao.transferiParaOrigem();
        if (!Objects.equals(this.getSedeAtual(), sede)) {
            this.setSedeAtual(sede);
        }
    }

}
