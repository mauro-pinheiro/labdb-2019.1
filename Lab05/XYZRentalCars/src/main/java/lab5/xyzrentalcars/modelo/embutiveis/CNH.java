package lab5.xyzrentalcars.modelo.embutiveis;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class CNH {
    private String numero;
    private LocalDate validade;
    private String categoria;

    public CNH(){}

    public CNH(String numero, LocalDate validade) {
        this.numero = numero;
        this.validade = validade;
    }

    public CNH(String numero, LocalDate validade, String categoria) {
        this.numero = numero;
        this.validade = validade;
        this.categoria = categoria;
    }

    @Column(length = 10, nullable = false)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Column(nullable = false)
    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @Column(length = 20)
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean vencida(){
        return LocalDate.now().isAfter(validade);
    }
}
