package ifma.edu.mauro.lbbd.lab3.gui.fx;

import ifma.edu.mauro.lbbd.lab3.dao.CidadeDAO;
import ifma.edu.mauro.lbbd.lab3.entidades.Cidade;
import ifma.edu.mauro.lbbd.lab3.infra.Database;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class CidadeForm extends Formulario {
    private Label lbFeedback = new Label("");

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

    public CidadeForm(boolean readOnly) {
        this.addAllLabels("Código","Nome", "Uf", "Taxa");
        this.addAllTextFields("Código","Nome", "Uf", "Taxa");
        this.addButton("Ação");
        this.setReadOnly(readOnly);

        var coluna1 = new ColumnConstraints(75);
        var coluna2 = new ColumnConstraints(100);
        var gridPane = new GridPane();
        var btAcao = getButton("Ação");
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.getColumnConstraints().addAll(coluna1, coluna2);

        getLabels().forEach(lb -> GridPane.setHalignment(lb, HPos.LEFT));
        getTextFields().forEach(tf -> GridPane.setHalignment(tf, HPos.RIGHT));
        gridPane.addColumn(0, getLabels().toArray(new Label[0]));
        gridPane.addColumn(1, getTextFields().toArray(new TextField[0]));

        GridPane.setHalignment(btAcao, HPos.RIGHT);
        GridPane.setHalignment(lbFeedback, HPos.LEFT);
        gridPane.addColumn(0, btAcao);
        gridPane.addColumn(1, lbFeedback);

        // this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.getChildren().addAll(gridPane);
    }

    @Override
    public void salvar(ActionEvent e) {
        var tfCodigo = getTextField("Código");
        var tfNome = getTextField("Nome");
        var tfUf = getTextField("Uf");
        var tfTaxa = getTextField("Taxa");

        var dao = new CidadeDAO(Database.getConexao());
        var cliente = new Cidade(tfNome.getText(), tfUf.getText(), Float.parseFloat(tfTaxa.getText()));
        if (tfCodigo.getText().isBlank()) {
            cliente = dao.salva(cliente);
            tfCodigo.setText("" + cliente.getCodigo_cidade());
            lbFeedback.setText("Salvo");
        } else {
            cliente.setCodigo_cidade(Integer.parseInt(tfCodigo.getText()));
            cliente = dao.atualizar(cliente);
            lbFeedback.setText("Atualizado");
        }
    }

    @Override
    public void abrir(ActionEvent e) {
        try {
            var tfCodigo = getTextField("Código");
            var tfNome = getTextField("Nome");
            var tfUf = getTextField("Uf");
            var tfTaxa = getTextField("Taxa");
            var cod = Integer.parseInt(tfCodigo.getText());
            var dao = new CidadeDAO(Database.getConexao());
            var cidade = dao.buscaPor(cod);
            if (cidade == null) {
                lbFeedback.setText("Cliente não encontrado");
            } else {
                tfNome.setText(cidade.getNome());
                tfUf.setText(cidade.getUf());
                tfTaxa.setText(""+cidade.getTaxa());
                lbFeedback.setText("Sucesso");
                setReadOnly(false);
            }
        } catch (NumberFormatException ex) {
            lbFeedback.setText("Código Inválido");
            throw new RuntimeException(ex.getMessage());
        }
    }
}