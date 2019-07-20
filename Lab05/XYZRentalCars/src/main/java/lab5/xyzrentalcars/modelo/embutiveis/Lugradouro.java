package lab5.xyzrentalcars.modelo.embutiveis;

import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

@Embeddable
public class Lugradouro {
    private TipoLugradouro tipo;
    private String nome;

    @Enumerated
    public TipoLugradouro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLugradouro tipo) {
        this.tipo = tipo;
    }

    @Column(length = 40, nullable = false, name = "lugradouro")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
