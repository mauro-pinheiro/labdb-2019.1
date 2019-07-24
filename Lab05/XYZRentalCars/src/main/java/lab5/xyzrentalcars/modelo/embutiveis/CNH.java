package lab5.xyzrentalcars.modelo.embutiveis;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class CNH {
    private String numero;
    private LocalDate validade;
    private String categoria;

    protected CNH(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CNH cnh = (CNH) o;
        return numero.equals(cnh.numero) &&
                validade.equals(cnh.validade) &&
                Objects.equals(categoria, cnh.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, validade, categoria);
    }
}
