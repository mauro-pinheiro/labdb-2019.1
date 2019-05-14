package ifma.edu.mauro.lbbd.lab3.gui.fx;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

public class ClienteForm extends VBox {
    private Label lbNome = new Label("Nome");
    private Label lbEndereco = new Label("Endereco");
    private Label lbTelefone = new Label("Telefone");
    
    private TextField tfNome = new TextField();
    private TextField tfEndereco = new TextField();
    private TextField tfTelefone = new TextField();

    private Button btnCadastrar = new Button("Cadastrar");
    private Button btnLimpar = new Button("Limpar");

    private GridPane pane = new GridPane();
    private HBox buttonBox = new HBox(5);

    public ClienteForm() {
        btnLimpar.setOnAction(e -> {
            tfNome.setText("");
            tfEndereco.setText("");
            tfTelefone.setText("");
            Alert alerta = new Alert(AlertType.INFORMATION, "Campos Limpos");
            alerta.setTitle("Limpar");
            alerta.initStyle(StageStyle.UTILITY);
            alerta.showAndWait();
        });

        ColumnConstraints coluna1 = new ColumnConstraints(75);
        ColumnConstraints coluna2 = new ColumnConstraints(100);
        pane.setHgap(5);
        pane.setVgap(5);
        pane.getColumnConstraints().addAll(coluna1,coluna2);

        GridPane.setHalignment(lbNome, HPos.LEFT);
        pane.add(lbNome, 0, 0);

        GridPane.setHalignment(lbEndereco, HPos.LEFT);
        pane.add(lbEndereco,0,1);

        GridPane.setHalignment(lbTelefone, HPos.LEFT);
        pane.add(lbTelefone,0,2);

        GridPane.setHalignment(tfNome, HPos.RIGHT);
        pane.add(tfNome,1,0);

        GridPane.setHalignment(tfEndereco, HPos.RIGHT);
        pane.add(tfEndereco,1,1);

        GridPane.setHalignment(tfTelefone, HPos.RIGHT);
        pane.add(tfTelefone,1,2);

        buttonBox.getChildren().addAll(btnCadastrar, btnLimpar);

        this.setSpacing(5);
        this.setPadding(new Insets(10));
        this.getChildren().addAll(pane,buttonBox);


    }
    
}