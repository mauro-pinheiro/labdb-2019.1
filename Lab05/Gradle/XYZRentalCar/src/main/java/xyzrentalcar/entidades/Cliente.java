package xyzrentalcar.entidades;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String cnh;

    @Column(name = "validade_cnh")
    private LocalDate validadeCNH;

    @Column(name = "categoria_cnh")
    private String categoriaCNH;

    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> historicoReservas = new LinkedHashSet<>();

    public Cliente(String nome, String cpf, String cnh, LocalDate validadeCNH, String categoriaCNH) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.validadeCNH = validadeCNH;
        this.categoriaCNH = categoriaCNH;
    }

    public Integer getId() {
        return id;
    }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public LocalDate getValidadeCNH() {
        return validadeCNH;
    }

    public void setValidadeCNH(LocalDate validadeCNH) {
        this.validadeCNH = validadeCNH;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
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
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [categoriaCNH=" + categoriaCNH + ", cnh=" + cnh + ", cpf=" + cpf + ", id=" + id + ", nome="
                + nome + ", validadeCNH=" + validadeCNH + "]";
    }

    public Set<Reserva> getHistoricoReservas() {
        return historicoReservas;
    }

    public void setHistoricoReservas(Set<Reserva> historicoReservas) {
        this.historicoReservas = historicoReservas;
    }
}