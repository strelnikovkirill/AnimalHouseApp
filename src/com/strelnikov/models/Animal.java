package com.strelnikov.models;

/**
 * Animal of a animal house.
 */
public class Animal  {
    
    /** Animal's id number. */
    private int id;
    /** Animal's nickname. */
    private String nickname;
    /** Animal's kind. */
    private String kind;
    /** Animal's age. */
    private int age;
    /** Animal's species. */
    private String species;
    /** Information about last owner animal's (name, phone). */
    private String lastOwner;
    /** Means if a animal is vaccinate. */
    private String vaccinated;
    /** Cost of the animal's for a month. */
    private int cost;
    
    /**
     * @param string the command line arguments.
     */
    public Animal (String[] string) {
        this.id = Integer.parseInt(string[0]);
        this.nickname = string[1];
        this.kind = string[2];
        this.age = Integer.parseInt(string[3]);
        this.species = string[4];
        this.lastOwner = string[5];
        this.vaccinated = string[6];
        this.cost = Integer.parseInt(string[7]);
    }
    
    public int getId() {
        return id;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public String getKind() {
        return kind;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getSpecies() {
        return species;
    }
    
    public String getLastOwner() {
        return lastOwner;
    }
    
    public boolean isVaccinated() {
        return vaccinated.equals("yes");
    }
    
    public int getCost() {
        return cost;
    }
    
    public static Animal fromString(String[] string) {
        return new Animal(string);
    }
    
    @Override
    public String toString() {
        return  id + "," + nickname + "," + kind + "," + age + "," + species
                + "," + lastOwner + "," + vaccinated + "," + cost;
    }

    /**
     * @param object the command line arguments.
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Animal)) return false;
        Animal animalClassObject = (Animal)object;
        return (id == animalClassObject.getId());
    }
    
    /**
     * @return 
     */
    @Override
    public int hashCode() {
        return getId();
    }
}