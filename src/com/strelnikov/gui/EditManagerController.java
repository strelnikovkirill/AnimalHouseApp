package com.strelnikov.gui;


import java.io.IOException;
import com.strelnikov.ListsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Controller of the edit manager view.
 */
public class EditManagerController extends ViewController {
    
    /** URL of the edit manager view FXML file. */
    public static String URL_FXML = "EditManager.fxml";
    /** Object to handle animal and employee lists. */
    private ListsController list;
    
    /** 
     * Constructor of class, here create animal and employee lists.
     * @throws java.io.IOException 
     */
    public EditManagerController() throws IOException {
        this.list = new ListsController();
    }
    
    /** Text field to input animal id. */
    @FXML 
    TextField idTextField;
    /** Text field to input all animal parameters. */
    @FXML
    TextField parametersTextField;
    /** Text to output info message. */
    @FXML
    Text statusText;
    
    /** 
     * Addition new item to animal's list.
     * @param event
     */
    @FXML
    protected void addAnimal(ActionEvent event) {
        idTextField.clear();
        String line[] = parametersTextField.getText().split(",");
        if (list.isCorrectlyItemInput(parametersTextField.getText())) {
            if (list.searchItem(Integer.parseInt(line[0]))) {
                statusText.setText("This item already exist!");
                statusText.getText();
            } else {
                list.enterNewItem(parametersTextField.getText());
                statusText.setText("New item successfully added!");
                statusText.getText();
                parametersTextField.clear();
            }  
        } else {
            statusText.setText("Error! Incorrectly entering!");
            statusText.getText();
        }
    }
    
    /** 
     * Editing animal's list item.
     * @param event 
     */
    @FXML
    protected void editAnimal(ActionEvent event) {
        if (!idTextField.getText().matches("^-?\\d+$")) {
            statusText.setText("Error! Incorrectly entering!");
            statusText.getText();
            return;
        }
        if (list.searchItem(Integer.parseInt(idTextField.getText()))) {
            if (list.isCorrectlyItemInput(parametersTextField.getText())) {
                list.changeItem(Integer.parseInt(idTextField.getText()),
                        parametersTextField.getText());
                statusText.setText("Item successfully changed!"); 
                statusText.getText();
                idTextField.clear();
                parametersTextField.clear();
            } else {
                statusText.setText("Error! Incorrectly entering!");
                statusText.getText();
            }
        } else {
            statusText.setText("Sorry, this item not found!");
            statusText.getText(); 
        }
    }
    
    /** 
     * Removing item from animal's list.
     * @param event 
     */
    @FXML
    protected void removeAnimal(ActionEvent event) {
        parametersTextField.clear();
        if (!idTextField.getText().matches("^-?\\d+$")) {
            statusText.setText("Error! Incorrectly entering!");
            statusText.getText();
            return;
        }
        if (list.searchItem(Integer.parseInt(idTextField.getText()))) {
            list.removeItem(Integer.parseInt(idTextField.getText()));
            statusText.setText("Item successfully removed!");
            statusText.getText();
            idTextField.clear();
        } else {
            statusText.setText("Sorry, this item not found!");
            statusText.getText();
        }
    }
    
    /** 
     * Return to main menu.
     * @param event 
     */
    @FXML
    protected void backToMenu(ActionEvent event) {
        statusText.setText("");
        GuiLauncher.getNavigation().load(MenuManagerController.URL_FXML).show();
    }
}