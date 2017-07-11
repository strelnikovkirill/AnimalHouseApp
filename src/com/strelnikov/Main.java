package com.strelnikov;

import com.strelnikov.console.ConsoleLauncher;
import com.strelnikov.gui.GuiLauncher;
import java.util.Scanner;

/**
 * Main class of the application.
 */
public class Main {

    /**
     * The entrance point of the application.
     * @param arguments
     */
    public static void main(String[] arguments ) {
        try {
            doMain(arguments);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Represents the functionality of main method.
     * @param arguments
     */
    private static void doMain(String[] arguments) {
        System.out.print("To start application in console mode use parameter \"c\"\n"
                + "To start application in GUI mode use parameter \"g\"\n"
                +"How to start application:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            arguments[0] = scanner.nextLine();
        }
        switch (arguments[0]) {
            case "c":
                new ConsoleLauncher().launch();
                break;
            case "g":
                new GuiLauncher().launch();
                break;
            default:
                System.out.println("Error! Wrong parameter chosen!");
        }
    }
}
