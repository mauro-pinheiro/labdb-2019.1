package lab5.xyzrentalcars.relatorio;

import lab5.xyzrentalcars.modelo.entidades.Reserva;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Relatorio {
    public static ClasseCarro comMenosReservas(List<Reserva> reservas){
        List<ClasseCarro> classes = reservas.stream().map(r -> r.getCarro().getClasse()).collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        ClasseCarro minClasse = null;
        for (ClasseCarro classe : ClasseCarro.values()) {
            int freq = Collections.frequency(classes, classe);
            if(freq > 0 && freq < min){
                minClasse = classe;
                min = freq;
            }
        }

        return Objects.requireNonNull(minClasse);
    }
}
