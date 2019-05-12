package ifma.edu.mauro.lbbd.lab3.gui.fx;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClienteForm extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label lbNome, lbEndereco, lbTelefone;
        TextField tfNome, tfEndereco, tfTelefone;
        
        Button btnCadastrar = new Button("Cadastrar");
        Button btnLimpar = new Button("Limpar");

        lbNome = new Label("Nome");
        lbEndereco = new Label("Endereco");
        lbTelefone = new Label("Telefone");
        tfNome = new TextField();
        tfEndereco = new TextField();
        tfTelefone = new TextField();

        btnLimpar.setOnAction(e -> {
            tfNome.setText("");
            tfEndereco.setText("");
            tfTelefone.setText("");
            Alert alerta = new Alert(AlertType.INFORMATION, "Campos Limpos");
            alerta.setTitle("Limpar");
            alerta.initStyle(StageStyle.UTILITY);
            alerta.showAndWait();
        });

        GridPane pane = new GridPane();
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

        GridPane.setHalignment(btnCadastrar, HPos.RIGHT);
        pane.add(btnCadastrar,0,3);

        GridPane.setHalignment(btnLimpar, HPos.CENTER);
        pane.add(btnLimpar,1,3);

        BorderPane root = new BorderPane(pane);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);
        stage.setTitle("Cliente");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
    
}