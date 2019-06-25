package lab5.xyzrentalcars.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 40)
    private String name;
    @Embedded
    private EnderecoSede endereco;
    @ElementCollection
    @Column(name = "telefone", nullable = false)
    @CollectionTable(name = "telefones", joinColumns = @JoinColumn(name = "id_sede", nullable = false))
    private Set<String> telefone = new HashSet<>();
    @Column(name = "nome_do_gerente", length = 40)
    private String nomeGerente;
    @Column(name = "multa_entrega_outro_ponto")
    private BigDecimal multaPontoDiferente;

    @OneToMany(mappedBy = "pontoOrigem")
    private Set<Carro> originados = new HashSet<>();

    @OneToMany(mappedBy = "atual")
    private Set<Carro> atualmenteAqui = new HashSet<>();

    @OneToMany(mappedBy = "locacao")
    private Set<Reserva> historicoLocacao = new HashSet<>();

    @OneToMany(mappedBy = "devolucao")
    private Set<Reserva> historicoDevolucao = new HashSet<>();
}
