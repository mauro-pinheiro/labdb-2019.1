package lab5.xyzrentalcars.builders;

import lab5.xyzrentalcars.modelo.embutiveis.Endereco;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;

public class EnderecoBuilder implements Builder<Endereco> {
    private Endereco endereco;

    private EnderecoBuilder(){}

    public static EnderecoBuilder umEndereco(){
        EnderecoBuilder builder = new EnderecoBuilder();
        builder.endereco = new Endereco();
        return builder;
    }

    public EnderecoBuilder naRua(String nome){
        endereco.setTipoLugradouro(TipoLugradouro.Rua);
        endereco.setNome(nome);
        return this;
    }

    public EnderecoBuilder naEstrada(String nome){
        endereco.setTipoLugradouro(TipoLugradouro.Estrada);
        endereco.setNome(nome);
        return this;
    }

    public EnderecoBuilder naAvenida(String nome){
        endereco.setTipoLugradouro(TipoLugradouro.Avenida);
        endereco.setNome(nome);
        return this;
    }

    public EnderecoBuilder naAlameda(String nome){
        endereco.setTipoLugradouro(TipoLugradouro.Alameda);
        endereco.setNome(nome);
        return this;
    }

    public EnderecoBuilder noNumero(String numero){
        endereco.setNumero(numero);
        return this;
    }

    public EnderecoBuilder comComplemento(String complemento){
        endereco.setComplemento(complemento);
        return this;
    }

    public EnderecoBuilder noBairro(String bairro){
        endereco.setBairro(bairro);
        return this;
    }

    public EnderecoBuilder naCidade(String cidade){
        endereco.setCidade(cidade);
        return this;
    }

    public EnderecoBuilder noEstado(String estado){
        endereco.setEstado(estado);
        return this;
    }

    public EnderecoBuilder comCEP(String cep){
        endereco.setCep(cep);
        return this;
    }

    @Override
    public Endereco constroi() {
        return endereco;
    }
}
