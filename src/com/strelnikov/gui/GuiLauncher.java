package com.strelnikov.gui;

import com.strelnikov.Launchable;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A class for launching the FX version of the application.
 */
public class GuiLauncher extends Application implements Launchable {
    
    /** Object to navigate between scenes. */
    private static Navigation navigation;
    
    /** 
     * Return scene to navigation.
     * @return
     */
    public static Navigation getNavigation()
    {
        return navigation;
    }
    
    /** 
     * Initializing main window to start.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        try { 
            navigation = new Navigation(primaryStage);
            primaryStage.setWidth(500);
            primaryStage.setHeight(450);
            primaryStage.setTitle("Animal House Application");
            primaryStage.show();
            GuiLauncher.getNavigation().load(MenuManagerController.URL_FXML).show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /** Start the FX version of the application. */
    @Override
    public void launch() {
        GuiLauncher.launch((String) null);
    }
}