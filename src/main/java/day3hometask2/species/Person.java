package day3hometask2.species;

public class Person extends Human {

    private String name;
    private String surName;

    public void setNames(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    private String getFirstName() {
        return this.name;
    }

    private String getLastName() {
        return this.surName;
    }

    public void nameSurname() {
        System.out.println("My Name is " + getFirstName() + ". My surname is " + getLastName());
    }
}
