package lbbd.lab3.gui.fx;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import lbbd.lab3.dao.ClienteDAO;
import lbbd.lab3.dao.FreteDAO;
import lbbd.lab3.entidades.Frete;
import lbbd.lab3.infra.Database;

public class FretesCliente extends VBox{
    GridPane gridPane;
    Label lbCliente_ID;
    Label lbCliente_Nome;
    TextField tfCliente_ID;
    TextField tfCliente_Nome;
    TableView<Frete> table;
    
    public FretesCliente(){
        gridPane = new GridPane();
        var coluna1 = new ColumnConstraints(100);
        var coluna2 = new ColumnConstraints(100);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.getColumnConstraints().addAll(coluna1, coluna2);
        this.getChildren().add(gridPane);

        lbCliente_ID = new Label("Código");
        tfCliente_ID = new TextField();
        tfCliente_ID.textProperty().addListener((o,a,n) -> preencheTabela());
        gridPane.addColumn(0, lbCliente_ID, tfCliente_ID);

        lbCliente_Nome = new Label("Nome");
        tfCliente_Nome = new TextField();
        tfCliente_Nome.setEditable(false);
        gridPane.addColumn(1, lbCliente_Nome, tfCliente_Nome);

        table = new TableView<>();
        var tabColuna1 = new TableColumn<Frete, Integer>("Código");
        tabColuna1.setCellValueFactory(new PropertyValueFactory<>("codigo_frete"));
        var tabColuna2 = new TableColumn<Frete, String>("Cidade");
        tabColuna2.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        var tabColuna3 = new TableColumn<Frete, Float>("Peso");
        tabColuna3.setCellValueFactory(new PropertyValueFactory<>("peso"));
        var tabColuna4 = new TableColumn<Frete, Float>("Valor");
        tabColuna4.setCellValueFactory(new PropertyValueFactory<>("valor"));

        table.getColumns().addAll(tabColuna1, tabColuna2, tabColuna3, tabColuna4);

        this.getChildren().add(table);

        this.setSpacing(10);
        this.setPadding(new Insets(10));
    }

    public void preencheTabela(){
        var clienteDao = new ClienteDAO(Database.getConexao());
        var codigo_cliente = Integer.parseInt(tfCliente_ID.getText());
        var cliente = clienteDao.buscaPor(codigo_cliente);
        tfCliente_Nome.setText(cliente.getNome());

        var freteDao = new FreteDAO(Database.getConexao());
        var fretes = freteDao.buscaPor(cliente);

        table.setItems(FXCollections.observableArrayList(fretes));
    }
}