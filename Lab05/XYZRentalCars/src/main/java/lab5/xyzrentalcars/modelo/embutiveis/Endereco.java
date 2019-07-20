package lab5.xyzrentalcars.modelo.embutiveis;

import javax.persistence.*;

@Embeddable
public class Endereco {
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

    @Column(length = 15, nullable = false)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Column(length = 60, nullable = false)
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

    @Column(length = 15, nullable = false)
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Column(length = 15, nullable = false)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(columnDefinition = "char(8)", nullable = false)
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
