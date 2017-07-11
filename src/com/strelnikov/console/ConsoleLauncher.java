package com.strelnikov.console;

import com.strelnikov.Launchable;
import java.io.IOException;

/**
 * A class for launching the console 
 * version of the application.
 */
public class ConsoleLauncher implements Launchable {
    /**
     * Launches the console controller.
     */
    @Override
    public void launch() {
        try {
            new ConsoleController();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}