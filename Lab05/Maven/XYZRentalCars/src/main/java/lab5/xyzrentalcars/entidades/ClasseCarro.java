package lab5.xyzrentalcars.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Classe_Carro")
public class ClasseCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(name = "valor_diaria")
    private BigDecimal valorDiaria;

    @OneToMany(mappedBy = "classe")
    private Set<Carro> carrosAgrupados = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void setCarrosAgrupados(Set<Carro> carrosAgrupados) {
        this.carrosAgrupados = carrosAgrupados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClasseCarro that = (ClasseCarro) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClasseCarro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valorDiaria=" + valorDiaria +
                ", carrosAgrupados=" + carrosAgrupados +
                '}';
    }
}
