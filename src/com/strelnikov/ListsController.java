package com.strelnikov;


import com.strelnikov.models.Animal;
import com.strelnikov.models.Employee;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Function;

/**
 * Controller of the animal and employee lists.
 */
public class ListsController {
    
    /** Input file with animals list. */
    private final String FILE_ANIMALS = "Animals.txt";
    /** Input file with employees list. */
    private final String FILE_EMPLOYEES = "Employees.txt";
    /** Creating new animal's list. */
    private ArrayList <Animal> animalList = new ArrayList();
    /** Creating new employee's list. */
    private ArrayList <Employee> employeeList = new ArrayList();
    
    /**
     * @throws java.io.IOException
     */
    public ListsController () throws IOException {
        animalList = getListFromFile(FILE_ANIMALS, Animal::fromString);
        employeeList = getListFromFile(FILE_EMPLOYEES, Employee::fromString);
    }
    
    /** 
     * Creating new list out file.
     * @throws java.io.IOException 
     */
    private <T> ArrayList<T> getListFromFile(String urlString,
            Function<String[], T> createObjectFromString) throws FileNotFoundException {
        ArrayList<T> list = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(urlString));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (list.isEmpty()) {
                    list.add(createObjectFromString.apply(line.split(",")));
                } else {
                    for (Iterator <T> i = list.iterator(); i.hasNext();) {
                        if (createObjectFromString.apply(line.split(",")).equals(i.next())) {
                            createObjectFromString = null;
                            break;
                        }
                    }
                    if (createObjectFromString != null) {
                        list.add(createObjectFromString.apply(line.split(",")));
                    } 
                }
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    /** Writing animal's list in file. */
    public void writeListToFile() {
        try (FileWriter writer = new FileWriter(FILE_ANIMALS)) {
            for (Iterator <Animal> i = animalList.iterator(); i.hasNext();) {
                writer.write(i.next().toString() + "\n");
            }
            writer.flush();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    /** 
     * Checking new animal's list item on correctness. 
     * @param line
     * @return
     */
    public boolean isCorrectlyItemInput(String line) {
        String string[] = line.split(",");
        if(string.length != 8)
            return false;
        if (!string[0].matches("^-?\\d+$") || !string[3].matches("^-?\\d+$") 
                || !string[7].matches("^-?\\d+$")) {
            return false;
        }
        if (Integer.parseInt(string[0]) <= 0 || Integer.parseInt(string[3]) <= 0 
                || Integer.parseInt(string[7]) <= 0) {
            return false;
        }
        if (!isStingWithoutNumeral(string[1]) || !isStingWithoutNumeral(string[2])
                || !isStingWithoutNumeral(string[4]) || string[5].matches("[-+]?\\d+") 
                || !isStingWithoutNumeral(string[6])) {
            return false;
        }
        if (!string[6].equals("yes") && !string[6].equals("no")) {
            return false;
        }
        return true;
    }
    
    /** 
     * Checking string on correctness.
     * @param line
     * @return 
     */
    public boolean isStingWithoutNumeral(String line) {
        char[] symbols = line.toCharArray();   
        String validationString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";  
        for(char c : symbols) {
            if (validationString.indexOf(c) == -1) {
                return false;
            }
        } 
        return true;
    }
     
    /** 
     * Entering new item to animal's list.
     * @param line 
     */
    public void enterNewItem(String line) {
        try {
            Animal animal = new Animal(line.split(","));
            if (animalList.isEmpty()) {
                animalList.add(animal);
            }
            else {
                for (Iterator <Animal> i = animalList.iterator(); i.hasNext();) {
                    if (animal.equals(i.next())) {
                        animal = null;
                        break;
                    }
                }
                if (animal != null) {
                    animalList.add(animal);
                    writeListToFile();
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Searching animal list item by id. 
     * @param id
     * @return  
     */
    public boolean searchItem(int id) {
        if (id <= 0) return false;
        for (Iterator <Animal> i = animalList.iterator(); i.hasNext();) {
            if (i.next().getId() == id) return true;
        }
        return false;
    }
    
    /** 
     * Removing item from animal's list.
     * @param id 
     */
    public void removeItem(int id) {
        try {
            if (animalList.isEmpty()) {
                return;
            }
            int index = 0;
            for (Iterator <Animal> i = animalList.iterator(); i.hasNext();) {
                if (i.next().getId() == id) {
                    animalList.remove(index);
                    writeListToFile();
                    return; 
                }
                else index++;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /** 
     * Editing animal's list item.
     * @param id
     * @param line
     */
    public void changeItem(int id, String line) {
        try {
            if (animalList.isEmpty()) {
                return;
            }
            Animal animal = new Animal(line.split(","));
            int index = 0;
            for (Iterator <Animal> i = animalList.iterator(); i.hasNext();) {
                if (i.next().getId() == id) {
                    animalList.remove(index);
                    animalList.add(index, animal);
                    writeListToFile();
                    return; 
                }
                else index++;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /** Sorting animal list and employee list. */
    public void sortLists() {
        try {
            Collections.sort(animalList, (a1, a2) -> a1.getCost() - a2.getCost());
            Collections.sort(employeeList, (e1, e2) -> e1.getPost().compareTo(e2.getPost()));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    } 
    
    /** 
     * Printing animal list.
     * @return  
     */
    public String printAnimalList() {
        String line = "";
        try {
            line = animalList.stream().map((itemOfList) -> itemOfList + "\n").
                    reduce(line, String::concat);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return line;
    }
    
    /** 
     * Printing employee list.
     * @return  
     */
    public String printEmployeeList() {
        String line = "";
        try {
            line = employeeList.stream().map((itemOfList) -> itemOfList + "\n").
                    reduce(line, String::concat);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return line;
    }
}