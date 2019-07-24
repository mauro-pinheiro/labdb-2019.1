package lab5.xyzrentalcars.exceptions;

public class InicializacaoDeAtributoRepetidaExceprion extends IllegalArgumentException {
    public InicializacaoDeAtributoRepetidaExceprion(String attName){
        super("Atributo " + attName + " nao pode ser inicializado novamente");
    }
}
