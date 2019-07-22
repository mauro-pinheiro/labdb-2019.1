package lab5.xyzrentalcars.modelo.embutiveis;

import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Endereco {
    public static class Builder {
        private Endereco endereco;

        private Builder(){}

        public static Builder umEndereco(){
            Builder builder = new Builder();
            builder.endereco = new Endereco();
            return builder;
        }

        public Builder naRua(String nome){
            endereco.setTipoLugradouro(TipoLugradouro.Rua);
            endereco.setNome(nome);
            return this;
        }

        public Builder naEstrada(String nome){
            endereco.setTipoLugradouro(TipoLugradouro.Estrada);
            endereco.setNome(nome);
            return this;
        }

        public Builder naAvenida(String nome){
            endereco.setTipoLugradouro(TipoLugradouro.Avenida);
            endereco.setNome(nome);
            return this;
        }

        public Builder naAlameda(String nome){
            endereco.setTipoLugradouro(TipoLugradouro.Alameda);
            endereco.setNome(nome);
            return this;
        }

        public Builder noNumero(String numero){
            endereco.setNumero(numero);
            return this;
        }

        public Builder comComplemento(String complemento){
            endereco.setComplemento(complemento);
            return this;
        }

        public Builder noBairro(String bairro){
            endereco.setBairro(bairro);
            return this;
        }

        public Builder naCidade(String cidade){
            endereco.setCidade(cidade);
            return this;
        }

        public Builder noEstado(String estado){
            endereco.setEstado(estado);
            return this;
        }

        public Builder comCEP(String cep){
            endereco.setCep(cep);
            return this;
        }

        public Endereco constroi() {
            Objects.requireNonNull(endereco.getTipoLugradouro(),"Tipo Lugradouro nao pode ser nulo");
            Objects.requireNonNull(endereco.getNome(),"Nome Lugradouro nao pode ser nulo");
            Objects.requireNonNull(endereco.getBairro(),"Bairro nao pode ser nulo");
            return endereco;
        }
    }

    private TipoLugradouro tipoLugradouro;
    private String nome;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, name = "tipo_lugradouro", nullable = false)
    public TipoLugradouro getTipoLugradouro() {
        return tipoLugradouro;
    }

    public void setTipoLugradouro(TipoLugradouro tipo) {
        this.tipoLugradouro = tipo;
    }

    @Column(length = 60, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Column(length = 30, nullable = false)
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(length = 15)
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Column(length = 15)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(columnDefinition = "char(8)")
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
