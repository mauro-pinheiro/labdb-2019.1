package lab5.xyzrentalcars.builders;

import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.embutiveis.Telefone;
import lab5.xyzrentalcars.modelo.entidades.Sede;

import java.math.BigDecimal;
import java.util.Set;

public class SedeBuilder implements Builder<Sede> {
    private Sede sede;

    private SedeBuilder(){}

    public static SedeBuilder umaSede(){
        SedeBuilder builder = new SedeBuilder();
        builder.sede = new Sede();
        return builder;
    }

    public SedeBuilder comNome(String nome){
        sede.setNome(nome);
        return this;
    }

    public SedeBuilder comEndereco(Endereco endereco){
        sede.setEndereco(endereco);
        return this;
    }

    public SedeBuilder comTelefones(Telefone ...telefones){
        sede.setTelefones(Set.of(telefones));
        return this;
    }

    public SedeBuilder comGerente(String nome){
        sede.setNomeGerente(nome);
        return this;
    }

    public SedeBuilder comMultaPorSedeDiferente(double multa){
        sede.setMultaSedeDiferente(new BigDecimal(multa));
        return this;
    }

    @Override
    public Sede constroi() {
        return sede;
    }
}
