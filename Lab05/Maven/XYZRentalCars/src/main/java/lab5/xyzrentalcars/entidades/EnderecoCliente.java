package lab5.xyzrentalcars.entidades;

import lab5.xyzrentalcars.entidades.enums.TipoLugradouro;

import javax.persistence.*;

@Entity
@Table(name = "Endereco")
public class EnderecoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TipoLugradouro lugradouro;
    @Column(nullable = false, length = 40)
    private String nome;
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(nullable = true, length = 40)
    private String complemento;
    @Column(nullable = false, length = 40)
    private String bairro;
    @Column(nullable = false, length = 20)
    private String cidade;
    @Column(nullable = false, length = 20)
    private String estado;
    @Column(nullable = false, length = 8)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;


}
