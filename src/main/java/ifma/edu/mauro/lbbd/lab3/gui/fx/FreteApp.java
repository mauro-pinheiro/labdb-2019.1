package ifma.edu.mauro.lbbd.lab3.gui.fx;

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
        TabPane tabPane = new TabPane();
        MenuItem menuItemNovoCliente = new MenuItem("Novo Cliente");
        menuItemNovoCliente.setOnAction(e -> tabPane.getTabs()
                                                    .add(new Tab("Cliente", new ClienteForm(true))));
        MenuItem menuItemNovoFrete = new MenuItem("Novo Frete");
        MenuItem menuItemAbrirCliente = new MenuItem("Abrir Cliente");
        menuItemAbrirCliente.setOnAction(e -> tabPane   .getTabs()
                                                        .add(new Tab("Cliente", new ClienteForm(false))));
        MenuItem menuItemAbrirFrete = new MenuItem("Abrir Frete");
        Menu menuArquivo = new Menu("Arquivo",  null,   menuItemNovoCliente,
                                                        menuItemNovoFrete,
                                                        menuItemAbrirCliente,
                                                        menuItemAbrirFrete);
        MenuBar menuBar = new MenuBar(menuArquivo);
        BorderPane root = new BorderPane(tabPane, menuBar , null, null, null);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplicativo Frete");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

}