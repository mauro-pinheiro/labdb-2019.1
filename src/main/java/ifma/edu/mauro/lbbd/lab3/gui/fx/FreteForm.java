package ifma.edu.mauro.lbbd.lab3.gui.fx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FreteForm extends VBox{
    private GridPane gridPane = new GridPane();
    private HBox buttonBox = new HBox(5);

    private Label clienteLabel = new Label("Cliente");
    private Label cidadeLabel = new Label("Cidade");
    private Label descricaoLabel = new Label("Descrição");
    private Label pesoLabel = new Label("Peso");
    private Label valorLabel = new Label("Valor");

    private TextField clienteField = new TextField();
    private TextField cidadeField = new TextField();
    private TextArea descArea = new TextArea();
    private TextField pesoField = new TextField();
    private TextField valorField = new TextField();

    private Button cadastrarButton = new Button("Cadastrar");
    private Button limparButton = new Button("Limpar");

    public FreteForm(){
        valorField.setEditable(false);

        ColumnConstraints coluna1 = new ColumnConstraints(100);
        ColumnConstraints coluna2 = new ColumnConstraints(150);

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.getColumnConstraints().addAll(coluna1,coluna2);

        GridPane.setHalignment(clienteLabel, HPos.LEFT);
        GridPane.setHalignment(cidadeLabel, HPos.LEFT);
        GridPane.setHalignment(descricaoLabel, HPos.LEFT);
        GridPane.setHalignment(pesoLabel, HPos.LEFT);
        GridPane.setHalignment(valorLabel, HPos.LEFT);

        gridPane.addColumn(0,   clienteLabel,
                                cidadeLabel,
                                descricaoLabel,
                                pesoLabel,
                                valorLabel);

        GridPane.setHalignment(clienteField, HPos.RIGHT);
        GridPane.setHalignment(cidadeField, HPos.RIGHT);
        GridPane.setHalignment(descArea, HPos.RIGHT);
        GridPane.setHalignment(pesoField, HPos.RIGHT);
        GridPane.setHalignment(valorField, HPos.RIGHT);

        gridPane.addColumn(1,   clienteField,
                                cidadeField,
                                descArea,
                                pesoField,
                                valorField);

        buttonBox.setSpacing(5);
        buttonBox.getChildren().addAll(cadastrarButton,limparButton);
        
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.getChildren().addAll(gridPane, buttonBox);
    }
}