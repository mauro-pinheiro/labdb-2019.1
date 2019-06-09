package xyzrentalcar.entidades;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "carro")
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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private String modelo;
    private Short ano;
    private Integer quilometragem;
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "id_sede_atual")
    private Sede localizacaoAtual;
    
    @ManyToOne
    @JoinColumn(name = "id_ponto_origem")
    private Sede pontoDeOrigem;
    
    @ManyToOne
    private ClasseCarro classe;
    
    @OneToMany(mappedBy = "carro")
    private Set<Reserva> historicoReservas = new LinkedHashSet<>();
    
    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.DISPONIVEL;

    public Integer getId() {
        return id;
    }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Sede getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public void setLocalizacaoAtual(Sede localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }

    public Sede getPontoDeOrigem() {
        return pontoDeOrigem;
    }

    public void setPontoDeOrigem(Sede pontoDeOrigem) {
        this.pontoDeOrigem = pontoDeOrigem;
    }

    public ClasseCarro getClasse() {
        return classe;
    }

    public void setClasse(ClasseCarro classe) {
        this.classe = classe;
    }

    public Set<Reserva> getHistoricoReservas() {
        return historicoReservas;
    }

    public void setHistoricoReservas(Set<Reserva> historicoReservas) {
        this.historicoReservas = historicoReservas;
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
        Carro other = (Carro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Carro [ano=" + ano + ", classe=" + classe + ", descricao=" + descricao + ", historicoReservas="
                + historicoReservas + ", id=" + id + ", localizacaoAtual=" + localizacaoAtual + ", modelo=" + modelo
                + ", placa=" + placa + ", pontoDeOrigem=" + pontoDeOrigem + ", quilometragem=" + quilometragem
                + ", situacao=" + situacao + "]";
    }

    public void aluga(){
        situacao = situacao.aluga();
    }

    public void devolveOrigem(){
        situacao = situacao.devolveOrigem();
    }

    public void devolveDiferente(){
        situacao = situacao.devolveDiferente();
    }

    public void transfere(){
        situacao = situacao.transfere();
    }
}