package lab5.xyzrentalcars.modelo.embutiveis;

import lab5.xyzrentalcars.app.mongo.Documentable;
import lab5.xyzrentalcars.exceptions.InicializacaoDeAtributoRepetidaExceprion;
import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Endereco extends Documentable {
    public static class Builder {
        private Endereco endereco;

        private Builder(){}

        public static Builder umEndereco(){
            Builder builder = new Builder();
            builder.endereco = new Endereco();
            return builder;
        }

        public Builder comLugradouro(Lugradouro lugradouro){
            if(Objects.isNull(endereco.getLugradouro())){
                endereco.setLugradouro(lugradouro);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("tipo de lugradouro");
            }
        }

        public Builder noNumero(String numero){
            if(Objects.isNull(endereco.getNumero())){
                endereco.setNumero(numero);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("numero");
            }

        }

        public Builder comComplemento(String complemento){
            if(Objects.isNull(endereco.getComplemento())){
                endereco.setComplemento(complemento);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("complemento");
            }

        }

        public Builder noBairro(String bairro){
            if(Objects.isNull(endereco.getBairro())){
                endereco.setBairro(bairro);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("bairro");
            }
        }

        public Builder naCidade(String cidade){
            if(Objects.isNull(endereco.getCidade())){
                endereco.setCidade(cidade);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("cidade");
            }

        }

        public Builder noEstado(String estado){
            if(Objects.isNull(endereco.getEstado())){
                endereco.setEstado(estado);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("estado");
            }

        }

        public Builder comCEP(String cep){
            if(Objects.isNull(endereco.getCep())){
                endereco.setCep(cep);
                return this;
            } else {
                throw new InicializacaoDeAtributoRepetidaExceprion("cep");
            }

        }

        public Endereco constroi() {
            Objects.requireNonNull(endereco.getLugradouro(),"Nao pode contruir um endereço com lugradouro nulo");
            Objects.requireNonNull(endereco.getBairro(),"Nao pode construir endereco com bairro nulo");
            return endereco;
        }
    }

    private Lugradouro lugradouro;

    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @Embedded
    public Lugradouro getLugradouro() {
        return lugradouro;
    }

    public void setLugradouro(Lugradouro lugradouro) {
        this.lugradouro = lugradouro;
    }

    @Column(length = 15)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Column(length = 60)
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Column(length = 60, nullable = false)
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(length = 60)
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Column(length = 60)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(columnDefinition = "char(10)")
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
