package ifma.edu.mauro.lbbd.lab3.gui.fx;

import ifma.edu.mauro.lbbd.lab3.dao.ClienteDAO;
import ifma.edu.mauro.lbbd.lab3.entidades.Cliente;
import ifma.edu.mauro.lbbd.lab3.infra.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ClienteForm extends VBox {

    private Label lbCodigo = new Label("Código");
    private Label lbNome = new Label("Nome");
    private Label lbEndereco = new Label("Endereço");
    private Label lbTelefone = new Label("Telefone");

    private Label lbCodigoError = new Label("");

    private TextField tfCodigo = new TextField();
    private TextField tfNome = new TextField();
    private TextField tfEndereco = new TextField();
    private TextField tfTelefone = new TextField();

    private Button btnCadastrar = new Button("Salvar");
    private Button btnLimpar = new Button("Limpar");

    private GridPane gridPane = new GridPane();
    private HBox buttonBox = new HBox(5);

    private boolean novo;

    private void setEditaveis(){
        tfCodigo.setEditable(!novo);
        tfNome.setEditable(novo);
        tfEndereco.setEditable(novo);
        tfTelefone.setEditable(novo);
    }

    public ClienteForm(boolean n) {
        novo = n;
        setEditaveis();
        btnLimpar.setOnAction(e -> {
            gridPane.getChildren().filtered(c -> c instanceof TextField).forEach(c -> {
                if(((TextField) c).isEditable())
                    ((TextField)c).setText("");
            });
        });
        btnCadastrar.setOnAction(new acaoSalvarCliente());

        if(!novo){
            btnCadastrar.setText("Abrir");
            btnCadastrar.setOnAction(new acaoAbrirCliente());
        }

        ColumnConstraints coluna1 = new ColumnConstraints(75);
        ColumnConstraints coluna2 = new ColumnConstraints(100);
        ColumnConstraints coluna3 = new ColumnConstraints(75,150,300);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.getColumnConstraints().addAll(coluna1, coluna2, coluna3);

        GridPane.setHalignment(lbCodigo, HPos.LEFT);
        GridPane.setHalignment(lbNome, HPos.LEFT);
        GridPane.setHalignment(lbEndereco, HPos.LEFT);
        GridPane.setHalignment(lbTelefone, HPos.LEFT);

        GridPane.setHalignment(tfCodigo, HPos.RIGHT);
        GridPane.setHalignment(tfNome, HPos.RIGHT);
        GridPane.setHalignment(tfEndereco, HPos.RIGHT);
        GridPane.setHalignment(tfTelefone, HPos.RIGHT);

        GridPane.setHalignment(lbCodigoError, HPos.LEFT);

        gridPane.addColumn(0,   lbCodigo,
                                lbNome,
                                lbEndereco,
                                lbTelefone);

        gridPane.addColumn(1,   tfCodigo,
                                tfNome,
                                tfEndereco,
                                tfTelefone);

        gridPane.addColumn(2, lbCodigoError);
                                                                
        buttonBox.getChildren().addAll(btnCadastrar, btnLimpar);

        this.setSpacing(5);
        this.setPadding(new Insets(10));
        this.getChildren().addAll(gridPane, buttonBox);
    }

    private class acaoSalvarCliente implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            ClienteDAO dao = new ClienteDAO(Database.getConexao());
            Cliente cliente = new Cliente(tfNome.getText(), tfEndereco.getText(), tfTelefone.getText());
            if (tfCodigo.getText().isBlank()) {
                cliente = dao.salva(cliente);
                tfCodigo.setText("" + cliente.getCodigo_cliente());
                lbCodigoError.setText("Salvo");
            } else {
                cliente.setCodigo_cliente(Integer.parseInt(tfCodigo.getText()));
                cliente = dao.atualizar(cliente);
                lbCodigoError.setText("Atualizado");
            }
        }
    }

    private class acaoAbrirCliente implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            try{
                int cod = Integer.parseInt(tfCodigo.getText());
                ClienteDAO dao = new ClienteDAO(Database.getConexao());
                Cliente cliente = dao.buscaPor(cod);
                tfNome.setText(cliente.getNome());
                tfEndereco.setText(cliente.getEndereco());
                tfTelefone.setText(cliente.getTelefone());
                btnCadastrar.setText("Salvar");
                btnCadastrar.setOnAction(new acaoSalvarCliente());
                novo = true;
                setEditaveis();
                lbCodigoError.setText("Sucesso");
            }catch(NumberFormatException ex){
                lbCodigoError.setText("Código Invalido");
                throw new RuntimeException(ex.getMessage());
            } catch (NullPointerException ex) {
                lbCodigoError.setText("Cliente nao encontrado");
                throw new RuntimeException(ex.getMessage());
            }
        }

    }

}