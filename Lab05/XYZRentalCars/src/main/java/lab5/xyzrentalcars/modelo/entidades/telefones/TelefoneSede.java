package lab5.xyzrentalcars.modelo.entidades.telefones;

import lab5.xyzrentalcars.modelo.entidades.Sede;
import lab5.xyzrentalcars.modelo.entidades.Telefone;

import javax.persistence.*;

@Entity
@Table(name = "Telefone_Sede")
public class TelefoneSede extends Telefone {
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
