package ifma.edu.mauro.lbbd.lab3.gui.fx;

import ifma.edu.mauro.lbbd.lab3.dao.CidadeDAO;
import ifma.edu.mauro.lbbd.lab3.dao.ClienteDAO;
import ifma.edu.mauro.lbbd.lab3.dao.FreteDAO;
import ifma.edu.mauro.lbbd.lab3.entidades.Frete;
import ifma.edu.mauro.lbbd.lab3.infra.Database;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class FreteForm extends Formulario {
    private Label lbFeedback = new Label();
    
    private Label lbCliente_id = new Label("Id Cliente");
    private Label lbCidade = new Label("Cidade");
    private Label lbDescricao = new Label("Descrição");

    private TextField tfCliente_id = new TextField();
    private ComboBox<String> cbCidade = new ComboBox<>();
    private TextArea taDescricao = new TextArea();

    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        this.getTextField("Código").setEditable(readOnly);
        this.getTextField("Taxa").setEditable(false);
        this.getTextField("Valor").setEditable(false);
        this.getTextField("Cliente").setEditable(false);
        tfCliente_id.setEditable(!readOnly);
        cbCidade.setEditable(!readOnly);
        taDescricao.setEditable(!readOnly);
        if (isReadOnly()) {
            getButton("Ação").setText("Abrir");
            getButton("Ação").setOnAction(e -> abrir(e));
        } else {
            getButton("Ação").setText("Salvar");
            getButton("Ação").setOnAction(e -> salvar(e));
        }
    }

    public FreteForm(boolean readOnly){
        this.addAllLabels("Código","Cliente","Taxa","Peso","Valor");
        this.addAllTextFields("Código","Cliente","Taxa","Peso","Valor");
        this.addButton("Ação");
        setReadOnly(readOnly);

        getTextField("Peso").textProperty().addListener((observavel, antigo, novo) -> atualizaValor());
        getTextField("Taxa").textProperty().addListener((observavel, antigo, novo) -> atualizaValor());

        var gridPane = new GridPane();
        var btAcao = getButton("Ação");
        var coluna1 = new ColumnConstraints(75);
        var coluna2 = new ColumnConstraints(175);

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

        var gridPane2 = new GridPane();
        var comboItems = new CidadeDAO(Database.getConexao()).getCidadesNames();
        cbCidade.setItems(FXCollections.observableArrayList(comboItems));
        cbCidade.setOnAction(e -> {
            selecionaCidade(e);
        });
        taDescricao.setWrapText(true);
        tfCliente_id.textProperty().addListener(
            (observavel, antigo, novo) -> atualizaCliente()
        );
        gridPane2.setVgap(10);
        gridPane2.setHgap(10);
        gridPane2.getColumnConstraints().addAll(coluna1, coluna2);
        gridPane2.addColumn(0, lbCliente_id, lbCidade, lbDescricao);
        gridPane2.addColumn(1, tfCliente_id, cbCidade, taDescricao);
        gridPane2.getChildren().forEach(control -> {
            if(control instanceof Label)
                GridPane.setHalignment(control, HPos.LEFT);
            else{
                GridPane.setHalignment(control, HPos.RIGHT);
            }
        });

        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.getChildren().addAll(gridPane, gridPane2);
    }

    @Override
    public void salvar(ActionEvent e) {
        var cod_cli = Integer.parseInt(tfCliente_id.getText());
        var cliente = new ClienteDAO(Database.getConexao()).buscaPor(cod_cli);
        var nom_cid = cbCidade.getSelectionModel().getSelectedItem();
        var cidade = new CidadeDAO(Database.getConexao()).buscaPor(nom_cid);
        var peso = Float.parseFloat(getTextField("Peso").getText());
        var descricao = taDescricao.getText();
        var frete = new Frete(cidade, cliente, descricao, peso);
        var dao = new FreteDAO(Database.getConexao());
        frete = dao.salva(frete);
        getTextField("Código").setText(""+frete.getCodigo_frete());
        setReadOnly(true);
        lbFeedback.setText("Salvo");
    }

    @Override
    public void abrir(ActionEvent e) {
        try{
            var codigo = Integer.parseInt(getTextField("Código").getText());
            var dao = new FreteDAO(Database.getConexao());
            var frete = dao.buscaPor(codigo);
            if(frete == null){
                lbFeedback.setText("Frete não encontrado");
            } else {
                getTextField("Código").setText(""+frete.getCodigo_frete());
                getTextField("Cliente").setText(frete.getCliente().getNome());
                getTextField("Taxa").setText(""+frete.getCidade().getTaxa());
                getTextField("Peso").setText(""+frete.getPeso());
                getTextField("Valor").setText(""+frete.getValor());
                tfCliente_id.setText(""+frete.getCliente().getCodigo_cliente());
                cbCidade.getSelectionModel().select(frete.getCidade().getNome());
                taDescricao.setText(frete.getDescricao());
            }
        }catch(NumberFormatException ex){
            lbFeedback.setText("Código Inválido");
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void selecionaCidade(ActionEvent e){
        var cidade = cbCidade.getSelectionModel().getSelectedItem();
        float taxa = new CidadeDAO(Database.getConexao()).getTaxa(cidade);
        getTextField("Taxa").setText("" + taxa);
    }

    public void atualizaValor(){
        var tfPeso = getTextField("Peso").getText();
        var tfTaxa = getTextField("Taxa").getText();
        if(!tfPeso.isBlank() && !tfTaxa.isBlank()){
            var peso = Float.parseFloat(tfPeso);
            var taxa = Float.parseFloat(tfTaxa);
            var valor = Frete.getValor(peso, taxa);
            getTextField("Valor").setText(""+valor);
        } else {
            getTextField("Valor").setText("");
        }
    }

    public void atualizaCliente(){
        if(tfCliente_id.getText().isBlank()){
            getTextField("Cliente").setText("");
        }else{
            var cod = Integer.parseInt(tfCliente_id.getText());
            var nome = new ClienteDAO(Database.getConexao()).getNome(cod);
            if(nome == null){
                lbFeedback.setText("Cliente não encontrado.");
                getTextField("Cliente").setText("");
            } else
                getTextField("Cliente").setText(nome);
        }
    }
    
}