package com.strelnikov.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;

/** 
 * Controller of the main menu manager view.
 */
public class MenuManagerController extends ViewController {

    /** URL of the main menu manager view FXML file. */
    public static String URL_FXML = "MenuManager.fxml";
    
    /** 
     * Opening of the edit manager view.
     * @param event
     */
    @FXML
    protected void openEditor(ActionEvent event) {
        GuiLauncher.getNavigation().load(EditManagerController.URL_FXML).show();
    }
    
    /** 
     * Opening of the print manager view.
     * @param event
     */
    @FXML
    protected void openPrinting(ActionEvent event) {
        GuiLauncher.getNavigation().load(PrintManagerController.URL_FXML).show();
    }
    
    /** 
     * Opening of the info message window.
     * @param event 
     */
    @FXML
    protected void openAbout(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Welcome to Animal House! "
                + "It is a simple client manager.\n"
                + "Here we can create, change, remove animal's list item "
                + "and print full animal and employee lists.\n"
                + "Have a good job!", "About", JOptionPane.INFORMATION_MESSAGE); 
    }
    
    /** 
     * Exiting out FX application.
     * @param event 
     */
    @FXML
    protected void exit(ActionEvent event) {
        Platform.exit();
    }
}