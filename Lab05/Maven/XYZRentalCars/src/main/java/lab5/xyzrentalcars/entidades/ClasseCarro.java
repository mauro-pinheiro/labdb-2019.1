package lab5.xyzrentalcars.entidades;

import java.math.BigDecimal;

public enum ClasseCarro {
    SubCompacto(new BigDecimal(10)),
    Compacto(new BigDecimal(13)),
    Medio(new BigDecimal(16)),
    Grande(new BigDecimal(19)),
    Luxo(new BigDecimal(21));

    private BigDecimal valorDiaria;

    ClasseCarro(BigDecimal valorDiaria){
        this.valorDiaria = valorDiaria;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
