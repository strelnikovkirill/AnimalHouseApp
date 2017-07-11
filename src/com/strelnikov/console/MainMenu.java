package com.strelnikov.console;

/**
 * Enum selection console menu.
 */
public enum MainMenu {
    
    /** Selector to addition new animal list item. */
    ADD_ANIMAL(1),
    /** Selector to removing animal list item. */
    REMOVE_ANIMAL(2),
    /** Selector to changing animal list item. */
    CHANGE_ANIMAL(3),
    /** Selector to animal list printing. */
    PRINT_ANIMAL_LIST(4),
    /** Selector to sorted lists printing. */
    PRINS_SORTED_LISTS(5),
    /** Selector to menu items printing. */
    MENU(6),
    /** Selector to exiting out application. */
    EXIT(7);
    /** Choice to main menu items. */
    private int selection;

    /**
     * @param selection
     */
    private MainMenu(int selection) {
        this.selection = selection;
    }

    /**
     * Assigning selection values.
     * @param selection
     * @return 
     */
    public static MainMenu getInstance(String selection) {
        switch(selection) {
            case "1":
                return ADD_ANIMAL;
            case "2":
                return REMOVE_ANIMAL;
            case "3":
                return CHANGE_ANIMAL;
            case "4":
                return PRINT_ANIMAL_LIST;
            case "5":
                return PRINS_SORTED_LISTS;
            case "6":
                return MENU;
            case "7":
                return EXIT;
            default:
                return null;
        }
    }
}