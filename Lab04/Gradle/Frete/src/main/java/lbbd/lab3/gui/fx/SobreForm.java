package lbbd.lab3.gui.fx;

import javafx.scene.control.TextArea;

public class SobreForm extends TextArea{
    public SobreForm(){
        setEditable(false);
        setWrapText(true);
        setText("Aplicativo Frete desenvolvido por Mauro Pinheiro aluno do"
        + "curso de sistemas de informção do ifma para ser apresenta a cadeira"
        + "de laboratório de banco de dadeos");
    }
}