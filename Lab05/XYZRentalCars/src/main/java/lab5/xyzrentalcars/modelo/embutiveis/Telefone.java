package lab5.xyzrentalcars.modelo.embutiveis;

import lab5.xyzrentalcars.app.mongo.Documentable;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Telefone extends Documentable {
    private String codigoArea;
    private String numero;

    public Telefone(){
        setInstance(this);
    }

    public Telefone(String numero) {
        this.numero = numero;
    }

    public Telefone(String codigoArea, String numero) {
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    @Column(name = "codigo_area", columnDefinition = "char(2)")
    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    @Column(columnDefinition = "char(10)", nullable = false)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(codigoArea, telefone.codigoArea) &&
                Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoArea, numero);
    }
}
