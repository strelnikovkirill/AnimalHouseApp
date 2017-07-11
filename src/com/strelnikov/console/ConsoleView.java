package com.strelnikov.console;

import java.util.Scanner;

/**
 * Console view of the application.
 */
public class ConsoleView {
    
    /** Printing main menu. */
    public void printMenu() {
        System.out.println("1 - Add new animal");
        System.out.println("2 - Remove animal");
        System.out.println("3 - Change information about animal");
        System.out.println("4 - Print animal list");
        System.out.println("5 - Print sorted animal list and employee list");
        System.out.println("6 - View menu");
        System.out.println("7 - Exit");
    }
    
    /** Printing by new animal list item addition. */
    public void printAddItemMessage() {
        System.out.println("New item successfully added!");
    }
    
    /** Printing by animal list item changing. */
    public void printEditItemMessage() {
        System.out.println("Item successfully changed!");
    }
    
    /** Printing by animal list item removing. */
    public void printRemoveItemMessage() {
        System.out.println("Item successfully removed!");
    }
    
    /** Printing by menu items selection. */
    public void printMenuEnterMessage() {
        System.out.print("Please, enter the number of steps: ");
    }
    
    /** Error message by entering. */
    public void printIncorrectlyEnteringError() {
        System.out.println("Error! Incorrectly entering!");
    }
    
    /** Error message by items copy. */
    public void printCopyError() {
        System.out.println("This item already exist!");
    }
    
    /** Printing by item id entering for removing. */
    public void printIdToRemoveMessage() {
        System.out.print("Please, enter ID number of item to remove: ");
    }
    
    /** Printing by item id entering for changing. */
    public void printIdToChangeMessage() {
        System.out.print("Please, enter ID number of item to change: ");
    }
    
    /** Error message then list is empty. */
    public void printEmptyListError() {
        System.out.println("Animal list is empty!");
    }
    
    /** Printing by item parameters entering. */
    public void printItemToChangeMessage() {
        System.out.print("Please, enter new information of item: "
                    + "to change: ");
    }
    
    /** Error message then item not found. */
    public void printNotFoundError() {
        System.out.println("Sorry, this item not found!");
    }
    
    /** Printing item example form. */
    public void printItemForm() {
        System.out.println("Input format: Id,Nickname,Kind,Age,Apecies,"
                + "Name and phone number of last owner,vaccinated,cost.\n"
                + "(Example: '13,Shaggy,dog,1,poodle,Jim 126847,yes,1200')");
        System.out.print("Please, enter item correctly: ");
    }

    /** 
     * Id number input.
     * @return 
     */
    public int NumberInput() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }
    
    /** 
     * Menu item or animal parameters string input.
     * @return  
     */
    public String StringInput() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }
}