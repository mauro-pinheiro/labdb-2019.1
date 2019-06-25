package lab5.xyzrentalcars.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Reserva {
    enum Situacao {ATIVA, ATRAZADA, FINALIZADA};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    @Column(name = "quantidade_diarias")
    private Integer quantidadeDiarias;
    @Column(name = "data_locacao")
    private LocalDate dataLocacao;
    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;
    @Column(name = "quilometros_rodados")
    private Integer quilometrosRodados;
    private BigDecimal multa;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "id_sede_locacao", nullable = false)
    private Sede locacao;

    @ManyToOne
    @JoinColumn(name = "id_sede_devolucao", nullable = false)
    private Sede devolucao;

    @ManyToOne
    @JoinColumn(name = "id_carro", nullable = false)
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
}
