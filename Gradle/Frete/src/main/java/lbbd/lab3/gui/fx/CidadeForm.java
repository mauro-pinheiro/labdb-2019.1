package lbbd.lab3.gui.fx;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import lbbd.lab3.dao.CidadeDAO;
import lbbd.lab3.entidades.Cidade;
import lbbd.lab3.infra.Database;

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
        init(readOnly);
    }

    public CidadeForm(Cidade cidade, int fretes){
        init(true);
        getButton("Ação").setDisable(true);
        getTextField("Código").setText(""+cidade.getCodigo_cidade());
        abrir(null);
        lbFeedback.setText("Tem " + fretes + " fretes");
        setReadOnly(true);
        getTextField("Código").setEditable(false);
    }

    private void init(boolean readOnly){
        this.addAllLabels("Código","Nome", "Uf", "Taxa");
        this.addAllTextFields("Código","Nome", "Uf", "Taxa");
        this.addButton("Ação");
        this.setReadOnly(readOnly);

        ColumnConstraints coluna1 = new ColumnConstraints(75);
        ColumnConstraints coluna2 = new ColumnConstraints(100);
        GridPane gridPane = new GridPane();
        Button btAcao = getButton("Ação");
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
        TextField tfCodigo = getTextField("Código");
        TextField tfNome = getTextField("Nome");
        TextField tfUf = getTextField("Uf");
        TextField tfTaxa = getTextField("Taxa");

        CidadeDAO dao = new CidadeDAO(Database.getConexao());
        Cidade cliente = new Cidade(tfNome.getText(), tfUf.getText(), Float.parseFloat(tfTaxa.getText()));
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
            TextField tfCodigo = getTextField("Código");
            TextField tfNome = getTextField("Nome");
            TextField tfUf = getTextField("Uf");
            TextField tfTaxa = getTextField("Taxa");
            int cod = Integer.parseInt(tfCodigo.getText());
            CidadeDAO dao = new CidadeDAO(Database.getConexao());
            Cidade cidade = dao.buscaPor(cod);
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