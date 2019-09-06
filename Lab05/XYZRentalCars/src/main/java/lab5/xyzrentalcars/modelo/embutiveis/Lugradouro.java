package lab5.xyzrentalcars.modelo.embutiveis;

import lab5.xyzrentalcars.app.mongo.Documentable;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Lugradouro extends Documentable {
    private TipoLugradouro tipo;
    private String nome;

    protected Lugradouro(){}

    public Lugradouro(TipoLugradouro tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, name = "tipo_lugradouro")
    public TipoLugradouro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLugradouro tipo) {
        this.tipo = tipo;
    }

    @Column(nullable = false, length = 40, name = "nome_lugradouro")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
