package lbbd.lab3.gui.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lbbd.lab3.dao.CidadeDAO;
import lbbd.lab3.dao.FreteDAO;
import lbbd.lab3.dao.CidadeDAO.MaisFretes;
import lbbd.lab3.entidades.Frete;
import lbbd.lab3.infra.Database;

public class FreteApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        TabPane tabPane = new TabPane();

        // Menu Arquivo e seus sub menus
        Menu menuArquivo = new Menu("_Arquivo");

        Menu menuNovo = new Menu("Novo");
        MenuItem menuItemNovoCliente = new MenuItem("Cliente");
        menuItemNovoCliente.setOnAction(e -> {
            Tab clienteTab = new Tab("Cliente", new ClienteForm(false));
            tabPane.getTabs().add(clienteTab);
            tabPane.getSelectionModel().select(clienteTab);
        });
        MenuItem menuItemNovoCidade = new MenuItem("Cidade");
        menuItemNovoCidade.setOnAction(e -> {
            Tab cidadeTab = new Tab("Cidade", new CidadeForm(false));
            tabPane.getTabs().add(cidadeTab);
            tabPane.getSelectionModel().select(cidadeTab);
        });
        MenuItem menuItemNovoFrete = new MenuItem("Frete");
        menuItemNovoFrete.setOnAction(e -> {
            Tab freteTab = new Tab("Frete", new FreteForm(false));
            tabPane.getTabs().add(freteTab);
            tabPane.getSelectionModel().select(freteTab);
        });

        Menu menuAbrir = new Menu("Abrir");
        MenuItem menuItemAbrirCliente = new MenuItem("Cliente");
        menuItemAbrirCliente.setOnAction(e -> {
            Tab clienteTab = new Tab("Cliente", new ClienteForm(true));
            tabPane.getTabs().add(clienteTab);
            tabPane.getSelectionModel().select(clienteTab);
        });
        MenuItem menuItemAbrirCidade = new MenuItem("Cidade");
        menuItemAbrirCidade.setOnAction(e -> {
            Tab cidadeTab = new Tab("Cidade", new CidadeForm(true));
            tabPane.getTabs().add(cidadeTab);
            tabPane.getSelectionModel().select(cidadeTab);
        });
        MenuItem menuItemAbrirFrete = new MenuItem("Frete");
        menuItemAbrirFrete.setOnAction(e -> {
            Tab freteTab = new Tab("Frete", new FreteForm(true));
            tabPane.getTabs().add(freteTab);
            tabPane.getSelectionModel().select(freteTab);
        });

        menuNovo.getItems().addAll(menuItemNovoCidade, menuItemNovoCliente, menuItemNovoFrete);
        menuAbrir.getItems().addAll(menuItemAbrirCidade, menuItemAbrirCliente, menuItemAbrirFrete);

        MenuItem menuItemSair = new MenuItem("Sair");
        menuItemSair.setOnAction(e -> primaryStage.close());

        menuArquivo.getItems().addAll(menuNovo, menuAbrir, new SeparatorMenuItem(), menuItemSair);

        // Menu buscas
        Menu menuBuscas = new Menu("Buscas");
        MenuItem menuItemFretes = new MenuItem("Fretes do Cliente...");
        menuItemFretes.setOnAction(e -> {
            Scene buscaAv = new Scene(new FretesCliente());
            Stage stage2 = new Stage();
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.initStyle(StageStyle.UTILITY);
            stage2.setScene(buscaAv);
            stage2.showAndWait();
        });
        MenuItem menuItemMaior = new MenuItem("Maior valor...");
        menuItemMaior.setOnAction(e -> {
            Stage stage3 = new Stage();
            Frete frete = new FreteDAO(Database.getConexao()).maiorValor();
            FreteForm freteForm = new FreteForm(frete);
            Scene scene = new Scene(freteForm);
            stage3.setTitle("Maior Frete");
            stage3.setScene(scene);
            stage3.sizeToScene();
            stage3.initModality(Modality.APPLICATION_MODAL);
            stage3.initStyle(StageStyle.UTILITY);
            stage3.showAndWait();
        });
        MenuItem menuItemMaisFretes = new MenuItem("Mais Fretes para...");
        menuItemMaisFretes.setOnAction(e -> {
                MaisFretes cidade = new CidadeDAO(Database.getConexao()).cidadeMaisFretes();
                Stage stage4 = new Stage();
                CidadeForm cidadeForm = new CidadeForm(cidade.cidade, cidade.fretes);
                Scene scene = new Scene(cidadeForm);
                stage4.setTitle("Mais fretes para...");
                stage4.setScene(scene);
                stage4.sizeToScene();
                stage4.initModality(Modality.APPLICATION_MODAL);
                stage4.initStyle(StageStyle.UTILITY);
                stage4.showAndWait();
        });

        menuBuscas.getItems().addAll(menuItemFretes, menuItemMaior, menuItemMaisFretes);

        MenuItem menuItemSobre = new MenuItem("Sobre");
        menuItemSobre.setOnAction(e -> {
                Stage stage5 = new Stage();
                Scene scene = new Scene(new SobreForm());
                stage5.setTitle("Sobre");
                stage5.setScene(scene);
                stage5.sizeToScene();
                stage5.initModality(Modality.APPLICATION_MODAL);
                stage5.initStyle(StageStyle.UTILITY);
                stage5.showAndWait();
        });

        root.setCenter(tabPane);
        root.setTop(new MenuBar(menuArquivo, menuBuscas, new Menu("Ajuda", null, menuItemSobre)));
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