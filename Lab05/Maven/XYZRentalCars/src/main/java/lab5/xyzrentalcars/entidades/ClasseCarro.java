package lab5.xyzrentalcars.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
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
}
