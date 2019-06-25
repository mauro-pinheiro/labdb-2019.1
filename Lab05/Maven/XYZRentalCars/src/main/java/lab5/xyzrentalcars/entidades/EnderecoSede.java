package lab5.xyzrentalcars.entidades;

import lab5.xyzrentalcars.entidades.enums.TipoLugradouro;

import javax.persistence.*;

@Embeddable
public class EnderecoSede {
    @Enumerated(EnumType.STRING)
    @Column(name = "endereco_lugradouro")
    private TipoLugradouro lugradouro;
    @Column(name = "endereco_nome", nullable = false, length = 40)
    private String nome;
    @Column(name = "endereco_numero", nullable = false, length = 10)
    private String numero;
    @Column(nullable = true, length = 40, name = "endereco_complemento")
    private String complemento;
    @Column(nullable = false, length = 40, name = "endereco_bairro")
    private String bairro;
    @Column(nullable = false, length = 20, name = "endereco_cidade")
    private String cidade;
    @Column(nullable = false, length = 20, name = "endereco_estado")
    private String estado;
    @Column(nullable = false, length = 8, name = "endereco_cep")
    private String cep;
}
