package lab5.xyzrentalcars.entidades;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class CNH {
    private String numero;
    private LocalDate validade;
    private String categria;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getCategria() {
        return categria;
    }

    public void setCategria(String categria) {
        this.categria = categria;
    }

    public boolean vencida(){
        return LocalDate.now().isAfter(validade);
    }
}
