package lbbd.lab3.gui.fx;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import lbbd.lab3.dao.ClienteDAO;
import lbbd.lab3.entidades.Cliente;
import lbbd.lab3.infra.Database;

public class ClienteForm extends Formulario {
    Label lbFeedback = new Label("");

    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        getTextField("Código").setEditable(readOnly);
        if (isReadOnly()) {
            getButton("Ação").setText("Abrir");
            getButton("Ação").setOnAction(e -> abrir(e));
        } else {
            getButton("Ação").setText("Salvar");
            getButton("Ação").setOnAction(e -> salvar(e));
        }
    }

    public ClienteForm(boolean readOnly) {
        this.addAllLabels("Código", "Nome", "Endereço", "Telefone");
        this.addAllTextFields("Código", "Nome", "Endereço", "Telefone");
        this.addButton("Ação");
        this.setReadOnly(readOnly);

        GridPane gridPane = new GridPane();
        Button btAcao = getButton("Ação");
        ColumnConstraints coluna1 = new ColumnConstraints(75);
        ColumnConstraints coluna2 = new ColumnConstraints(100);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.getColumnConstraints().addAll(coluna1, coluna2);

        getLabels().forEach(label -> GridPane.setHalignment(label, HPos.LEFT));
        getTextFields().forEach(textField -> GridPane.setHalignment(textField, HPos.RIGHT));
        GridPane.setHalignment(lbFeedback, HPos.LEFT);
        GridPane.setHalignment(btAcao, HPos.RIGHT);
        gridPane.addColumn(0, getLabels().toArray(new Label[0]));
        gridPane.addColumn(0, btAcao);

        gridPane.addColumn(1, getTextFields().toArray(new TextField[0]));
        gridPane.addColumn(1, lbFeedback);

        // this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.getChildren().addAll(gridPane);
    }

    @Override
    public void salvar(ActionEvent event) {
        TextField tfCodigo = getTextField("Código");
        TextField tfNome = getTextField("Nome");
        TextField tfEndereco = getTextField("Endereço");
        TextField tfTelefone = getTextField("Telefone");

        ClienteDAO dao = new ClienteDAO(Database.getConexao());
        Cliente cliente = new Cliente(tfNome.getText(), tfEndereco.getText(), tfTelefone.getText());
        if (tfCodigo.getText().equals("")) {
            cliente = dao.salva(cliente);
            tfCodigo.setText("" + cliente.getCodigo_cliente());
            lbFeedback.setText("Salvo");
        } else {
            cliente.setCodigo_cliente(Integer.parseInt(tfCodigo.getText()));
            cliente = dao.atualizar(cliente);
            lbFeedback.setText("Atualizado");
        }
    }

    @Override
    public void abrir(ActionEvent event) {
        try {
            TextField tfCodigo = getTextField("Código");
            TextField tfNome = getTextField("Nome");
            TextField tfEndereco = getTextField("Endereço");
            TextField tfTelefone = getTextField("Telefone");
            int cod = Integer.parseInt(tfCodigo.getText());
            ClienteDAO dao = new ClienteDAO(Database.getConexao());
            Cliente cliente = dao.buscaPor(cod);
            if (cliente == null) {
                lbFeedback.setText("Cliente nao encontrado");
            } else {
                tfNome.setText(cliente.getNome());
                tfEndereco.setText(cliente.getEndereco());
                tfTelefone.setText(cliente.getTelefone());
                lbFeedback.setText("Sucesso");
                setReadOnly(false);
            }
        } catch (NumberFormatException ex) {
            lbFeedback.setText("Código Inválido");
            throw new RuntimeException(ex.getMessage());
        }
    }

}