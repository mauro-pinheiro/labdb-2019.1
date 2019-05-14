package ifma.edu.mauro.lbbd.lab3.gui.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FreteApp extends Application {
    Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Menu arquivoMenu = new Menu("Arquivo");

        MenuItem novoCliMenuItem = new MenuItem("Novo Cliente");

        novoCliMenuItem.setOnAction(e -> {
            root.setCenter(new ClienteForm());
            primaryStage.sizeToScene();
        });
        
        root.setTop(menuBar);

        arquivoMenu.getItems().addAll(novoCliMenuItem);

        menuBar.getMenus().addAll(arquivoMenu);

        scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Frete Application");
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    
}