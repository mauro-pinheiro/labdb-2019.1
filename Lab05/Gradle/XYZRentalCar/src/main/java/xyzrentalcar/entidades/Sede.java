package xyzrentalcar.entidades;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Sede{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;
    private String endereco;
    private String telefone;

    @Column(name = "nome_gerente")
    private String nomeGerente;

    @Column(name = "multa_sede_diferente")
    private String multaSedeDiferente;

    @OneToMany(mappedBy = "sedeLocacao")
    private Set<Reserva> historicoLocacoes = new LinkedHashSet<>();
    
    @OneToMany(mappedBy = "sedeDevolucao")
    private Set<Reserva> historicoDevolucoes = new LinkedHashSet<>();
    
    @Transient
    private Set<Carro> carrosDisponiveis = new LinkedHashSet<>();
    
    @Transient
    private Set<Carro> carrosOriginou = new LinkedHashSet<>();

    public Sede(String nome, String endereco, String telefone, String nomeGerente, String multaSedeDiferente) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nomeGerente = nomeGerente;
        this.multaSedeDiferente = multaSedeDiferente;
    }

    public Integer getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    public String getMultaSedeDiferente() {
        return multaSedeDiferente;
    }

    public void setMultaSedeDiferente(String multaSedeDiferente) {
        this.multaSedeDiferente = multaSedeDiferente;
    }

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
		Sede other = (Sede) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [endereco=" + endereco + ", id=" + id + ", multaSedeDiferente=" + multaSedeDiferente + ", nome="
				+ nome + ", nomeGerente=" + nomeGerente + ", telefone=" + telefone + "]";
    }

    public Set<Reserva> getHistoricoLocacoes() {
        return historicoLocacoes;
    }

    public void setHistoricoLocacoes(Set<Reserva> historicoLocacoes) {
        this.historicoLocacoes = historicoLocacoes;
    }

    public Set<Reserva> getHistoricoDevolucoes() {
        return historicoDevolucoes;
    }

    public void setHistoricoDevolucoes(Set<Reserva> historicoDevolucoes) {
        this.historicoDevolucoes = historicoDevolucoes;
    }

    public Set<Carro> getCarrosDisponiveis() {
        return carrosDisponiveis;
    }

    public void setCarrosDisponiveis(Set<Carro> carrosDisponiveis) {
        this.carrosDisponiveis = carrosDisponiveis;
    }

    public Set<Carro> getCarrosOriginou() {
        return carrosOriginou;
    }

    public void setCarrosOriginou(Set<Carro> carrosOriginou) {
        this.carrosOriginou = carrosOriginou;
    }
}