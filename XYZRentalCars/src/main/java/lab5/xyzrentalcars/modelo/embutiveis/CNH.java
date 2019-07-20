package lab5.xyzrentalcars.modelo.embutiveis;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class CNH {
    private String numero;
    private LocalDate validade;
    private String categoria;

    @Column(length = 10, name = "numero_cnh", nullable = false)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Column(name = "validade_cnh", nullable = false)
    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @Column(name = "categoria_cnh", nullable = false)
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
