package com.strelnikov.console;

import com.strelnikov.ListsController;
import java.io.IOException;


/**
 * Controller of the application.
 */
public class ConsoleController {
    
    /** Creating view of the application. */
    private ConsoleView consoleView = new ConsoleView();
    /** Object to handle animal and employee lists. */
    private ListsController list;
    
    public ConsoleController() throws IOException {
        this.list = new ListsController();
        menu();
    }
    
    /** Main console menu. */
    public void menu() {
        try {
            consoleView.printMenu();
            String selection = "1";
            while (!MainMenu.getInstance(selection).equals(MainMenu.EXIT)) {
                consoleView.printMenuEnterMessage();
                selection = consoleView.StringInput();
                switch (MainMenu.getInstance(selection)) {
                    case ADD_ANIMAL: enterNewItem();
                    break;
                    case REMOVE_ANIMAL: removeItem();
                    break;
                    case CHANGE_ANIMAL: changeItem();
                    break;
                    case PRINT_ANIMAL_LIST: System.out.println(list.printAnimalList());
                    break;
                    case PRINS_SORTED_LISTS: printSortedLists(); 
                    break;
                    case MENU: consoleView.printMenu();
                    break;
                    case EXIT: return;
                    default: break;
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }  
    }
     
    /** Entering new item to animal's list. */
    public void enterNewItem() {
        consoleView.printItemForm();
        try {
            String line = consoleView.StringInput();
            String string[] = line.split(",");
            if (list.isCorrectlyItemInput(line)) {
                if (list.searchItem(Integer.parseInt(string[0]))) {
                    consoleView.printCopyError();
                } else {
                    list.enterNewItem(line);
                    consoleView.printAddItemMessage();
                }  
            } else {
                consoleView.printIncorrectlyEnteringError();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /** Removing item from animal's list. */
    public void removeItem() {
        consoleView.printIdToRemoveMessage();
        try {
            int id = consoleView.NumberInput();
            if (id <= 0) {
                consoleView.printNotFoundError();
                return;
            }
            if (list.searchItem(id)) {
                list.removeItem(id);
                consoleView.printRemoveItemMessage();
            } else {
                consoleView.printNotFoundError();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /** Editing animal's list item. */
    public void changeItem() {
        consoleView.printIdToChangeMessage();
        try {
            int id = consoleView.NumberInput();
            if (!list.searchItem(id)) {
                consoleView.printNotFoundError();
                return;
            }
            consoleView.printItemForm();
            String line = consoleView.StringInput();
            if (list.isCorrectlyItemInput(line)) {
                list.changeItem(id, line);
                consoleView.printEditItemMessage();
            } else {
                consoleView.printIncorrectlyEnteringError();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /** Sorting and output animal list and employee list. */
    public void printSortedLists() {
        try {
            list.sortLists();
            System.out.println("Animal list:");
            System.out.println(list.printAnimalList());
            System.out.println("Employee list:");
            System.out.println(list.printEmployeeList());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    } 
}