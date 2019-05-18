package lbbd.lab3.gui.fx;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public abstract class Formulario extends HBox {
    private Map<String, TextField> textFields = new LinkedHashMap<>();
    private Map<String, Label> labels = new LinkedHashMap<>();
    private Map<String, Button> buttons = new LinkedHashMap<>();

    private boolean readOnly;

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean read){
        readOnly = read;
        textFields.forEach((key, value) -> value.setEditable(!readOnly));
    }

    public TextField getTextField(String name) {
        return textFields.get(name);
    }

    public Collection<TextField> getTextFields() {
        return textFields.values();
    }

    public void addTextField(String nome, TextField field){
        textFields.put(nome, field);
        field.setEditable(!readOnly);
    }

    public void addTextField(String nome){
        addTextField(nome, new TextField());
    }

    public void addAllTextFields(String... nomes) {
        for(String nome : nomes){
            addTextField(nome);
        }
    }

    public Label getLabel(String nome){
        return labels.get(nome);
    }

    public Collection<Label> getLabels(){
        return labels.values();
    }

    public void addLabel(String nome, Label label){
        labels.put(nome, label);
    }

    public void addAllLabels(String... nomes) {
        for(String nome : nomes){
            addLabel(nome);
        }
    }

    public void addLabel(String nome){
        addLabel(nome, new Label(nome));
    }

    public Button getButton(String nome){
        return buttons.get(nome);
    }

    public Collection<Button> getButtons(){
        return buttons.values();
    }

    public void addButton(String nome, Button button){
        buttons.put(nome, button);
    }

    public void addButton(String nome){
        addButton(nome, new Button(nome));
    }

    public void addAllButtons(String... nomes) {
        for(String nome : nomes){
            addButton(nome);
        }
    }

    public abstract void salvar(ActionEvent e);

    public abstract void abrir(ActionEvent e);
}