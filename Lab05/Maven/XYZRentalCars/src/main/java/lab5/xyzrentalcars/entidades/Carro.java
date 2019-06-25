package lab5.xyzrentalcars.entidades;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String placa;
    private String modelo;
    private Short ano;
    private BigDecimal quilometragem;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_classe_carro", nullable = false)
    private ClasseCarro classe;
}
