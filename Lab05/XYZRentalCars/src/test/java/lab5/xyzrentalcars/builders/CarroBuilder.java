package lab5.xyzrentalcars.builders;

import lab5.xyzrentalcars.modelo.entidades.Carro;
import lab5.xyzrentalcars.modelo.entidades.Sede;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;

public class CarroBuilder implements Builder<Carro> {
    private Carro carro;

    private CarroBuilder(){}

    public static CarroBuilder umCarro(){
        CarroBuilder builder = new CarroBuilder();
        builder.carro = new Carro();
        return builder;
    }

    public CarroBuilder comPlaca(String placa){
        carro.setPlaca(placa);
        return this;
    }

    public CarroBuilder doModelo(String modelo){
        carro.setModelo(modelo);
        return this;
    }

    public CarroBuilder doAno(Short ano){
        carro.setAno(ano);
        return this;
    }

    public CarroBuilder daCor(String cor){
        carro.setCor(cor);
        return this;
    }

    public CarroBuilder comQuilometragem(Integer km){
        carro.setQuilometragem(km);
        return this;
    }

    public CarroBuilder comDescricao(String descricao){
        carro.setDescricao(descricao);
        return this;
    }

    public CarroBuilder naSituacao(Carro.Situacao situacao){
        carro.setSituacao(situacao);
        return this;
    }

    public CarroBuilder comSedeDeOrigem(Sede origem){
        carro.setSedeDeOrigem(origem);
        return this;
    }

    public CarroBuilder atualmenteNa(Sede sede){
        carro.setSedeAtual(sede);
        return this;
    }

    public CarroBuilder comClasse(ClasseCarro classe){
        carro.setClasse(classe);
        return this;
    }

    @Override
    public Carro constroi() {
        return carro;
    }
}
