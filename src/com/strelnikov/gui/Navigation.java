package com.strelnikov.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class to control of navigation.
 */
public class Navigation {

    /** Object to set scene. */
    private final Stage stage;
    /** Object to set view by showing. */
    private final Scene scene;

    /**
     * @param stage
     */
    public Navigation(Stage stage) {
        this.stage = stage;
        scene = new Scene(new Pane());
        stage.setScene(scene);
    }

    /** 
     * Loading FXML scene by URL address.
     * @param urlString
     * @return
     */
    public ViewController load (String urlString) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(urlString));
            Node root = fxmlLoader.load();
            ViewController viewController = fxmlLoader.getController();
            viewController.setView(root);
            return viewController;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Showing scene.
     * @param viewController  
     */
    public void show(ViewController viewController) {
        try {
            scene.setRoot((Parent) viewController.getView());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}