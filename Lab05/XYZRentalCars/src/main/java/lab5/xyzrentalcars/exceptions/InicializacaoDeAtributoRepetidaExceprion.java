package lab5.xyzrentalcars.exceptions;

public class InicializacaoDeAtributoRepetidaExceprion extends RuntimeException {
    public InicializacaoDeAtributoRepetidaExceprion(String attName){
        super("Atributo " + attName + "nao pode ser inicializado novamente");
    }
}
