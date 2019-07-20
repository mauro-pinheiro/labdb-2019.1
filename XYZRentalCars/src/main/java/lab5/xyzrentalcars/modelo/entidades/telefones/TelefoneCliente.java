package lab5.xyzrentalcars.modelo.entidades.telefones;

import lab5.xyzrentalcars.modelo.entidades.Cliente;
import lab5.xyzrentalcars.modelo.entidades.Telefone;

import javax.persistence.*;

@Entity
public class TelefoneCliente extends Telefone {
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
