package lab5.xyzrentalcars.builders;

import lab5.xyzrentalcars.modelo.entidades.Carro;
import lab5.xyzrentalcars.modelo.entidades.Cliente;
import lab5.xyzrentalcars.modelo.entidades.Reserva;
import lab5.xyzrentalcars.modelo.entidades.Sede;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ReservaBuilder implements Builder<Reserva> {
    private Reserva reserva;

    private ReservaBuilder(){}

    public static ReservaBuilder umReserva(){
        ReservaBuilder builder = new ReservaBuilder();
        builder.reserva = new Reserva();
        return builder;
    }

    public ReservaBuilder comNumero(String numero){
        reserva.setNumero(numero);
        return this;
    }

    public ReservaBuilder comDiarias(Integer diarias){
        reserva.setDiarias(diarias);
        return this;
    }

    public ReservaBuilder comDataLocacao(LocalDate locacao){
        reserva.setDataLocacao(locacao);
        return this;
    }

    public ReservaBuilder comDataRetorno(LocalDate retorno){
        reserva.setDataRetorno(retorno);
        return this;
    }

    public ReservaBuilder comKmRodados(Integer km){
        reserva.setKmRodados(km);
        return this;
    }

    public ReservaBuilder comMulta(BigDecimal multa){
        reserva.setMulta(multa);
        return this;
    }

    public ReservaBuilder naSituacao(Reserva.Situcao situacao){
        reserva.setSituacao(situacao);
        return this;
    }

    public ReservaBuilder paraCliente(Cliente cliente){
        reserva.setCliente(cliente);
        return this;
    }

    public ReservaBuilder doCarro(Carro carro){
        reserva.setCarro(carro);
        return this;
    }

    public ReservaBuilder comSedeDeLocacao(Sede sede){
        reserva.setSedeLocacao(sede);
        return this;
    }

    public ReservaBuilder comSedeDeDevolucao(Sede sede){
        reserva.setSedeDevolucao(sede);
        return this;
    }

    @Override
    public Reserva constroi() {
        return reserva;
    }
}
