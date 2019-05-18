package lbbd.lab3.gui.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FreteApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        TabPane tabPane = new TabPane();

        Menu menuArquivo = new Menu("Arquivo");
        
        Menu menuNovo = new Menu("Novo");
        MenuItem menuItemNovoCliente = new MenuItem("Cliente");
        menuItemNovoCliente.setOnAction(e -> {
            var clienteTab = new Tab("Cliente", new ClienteForm(false));
            tabPane.getTabs().add(clienteTab);
            tabPane.getSelectionModel().select(clienteTab);
        });
        MenuItem menuItemNovoCidade = new MenuItem("Cidade");
        menuItemNovoCidade.setOnAction(e -> {
            var cidadeTab = new Tab("Cidade", new CidadeForm(false));
            tabPane.getTabs().add(cidadeTab);
            tabPane.getSelectionModel().select(cidadeTab);
        });
        MenuItem menuItemNovoFrete = new MenuItem("Frete");
        menuItemNovoFrete.setOnAction(e -> {
            var freteTab = new Tab("Frete", new FreteForm(false));
            tabPane.getTabs().add(freteTab);
            tabPane.getSelectionModel().select(freteTab);
        });
        
        Menu menuAbrir = new Menu("Abrir");
        MenuItem menuItemAbrirCliente = new MenuItem("Cliente");
        menuItemAbrirCliente.setOnAction(e -> {
            var clienteTab = new Tab("Cliente", new ClienteForm(true));
            tabPane.getTabs().add(clienteTab);
            tabPane.getSelectionModel().select(clienteTab);
        });
        MenuItem menuItemAbrirCidade = new MenuItem("Cidade");
        menuItemAbrirCidade.setOnAction(e -> {
            var cidadeTab = new Tab("Cidade", new CidadeForm(true));
            tabPane.getTabs().add(cidadeTab);
            tabPane.getSelectionModel().select(cidadeTab);
        });
        MenuItem menuItemAbrirFrete = new MenuItem("Frete");
        menuItemAbrirFrete.setOnAction(e -> {
            var freteTab = new Tab("Frete", new FreteForm(true));
            tabPane.getTabs().add(freteTab);
            tabPane.getSelectionModel().select(freteTab);
        });

        menuNovo.getItems().addAll(menuItemNovoCidade, menuItemNovoCliente, menuItemNovoFrete);
        menuAbrir.getItems().addAll(menuItemAbrirCidade, menuItemAbrirCliente, menuItemAbrirFrete);

        menuArquivo.getItems().addAll(menuNovo, menuAbrir);

        root.setCenter(tabPane);
        root.setTop(new MenuBar(menuArquivo));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplicativo Frete");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public void run(String args[]){
        Application.launch(args);
    }
}