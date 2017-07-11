package com.strelnikov.gui;

import java.io.IOException;

import com.strelnikov.ListsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Controller of the print manager view.
 */
public class PrintManagerController extends ViewController {
    
    /** URL of the print manager view FXML file. */
    public static String URL_FXML = "PrintManager.fxml";
    /** Object to handle animal and employee lists. */
    private ListsController list;
    
    /** 
     * Constructor of class, here create animal and employee lists.
     * @throws java.io.IOException 
     */
    public PrintManagerController() throws IOException {
        this.list = new ListsController();
    }
    
    /** Text to output animal list. */
    @FXML
    Text animalListText;
    /** Text to output employee list. */
    @FXML
    Text employeeListText;
    
    /**
     * Printing animal list.
     * @param event
     */
    @FXML
    protected void printAnimalList(ActionEvent event) {
        employeeListText.setText("");
        animalListText.setText(list.printAnimalList());
        animalListText.getText();
    }
    
    /**
     * Printing animal and employee lists.
     * @param event
     */
    @FXML
    protected void printSortedLists(ActionEvent event) {
        list.sortLists();
        animalListText.setText(list.printAnimalList());
        animalListText.getText();
        employeeListText.setText(list.printEmployeeList());
        employeeListText.getText();
    }

    /** 
     * Return to main menu.
     * @param event 
     */
    @FXML
    protected void backToMenu(ActionEvent event) {
        GuiLauncher.getNavigation().load(MenuManagerController.URL_FXML).show();
    }
}