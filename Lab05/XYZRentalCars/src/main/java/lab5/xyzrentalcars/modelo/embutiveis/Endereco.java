package lab5.xyzrentalcars.modelo.embutiveis;

import lab5.xyzrentalcars.modelo.enums.TipoLugradouro;

import javax.persistence.*;

@Embeddable
public class Endereco {
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
