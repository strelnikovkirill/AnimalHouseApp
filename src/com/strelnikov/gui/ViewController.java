package com.strelnikov.gui;

import javafx.scene.Node;

/**
 * View controller to navigate between scenes.
 */
public class ViewController {

    /** View object. */
    private Node view;

    public Node getView() {
        return view;
    }

    public void setView (Node view) {
        this.view = view;
    }

    /** Scene showing. */
    public void show() {
        GuiLauncher.getNavigation().show(this);
    }
}