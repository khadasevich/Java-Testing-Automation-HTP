package Day_3_Hometask_2;

public class Person extends Human {

    private String name;
    private String surName;

    public void setNames(String name, String surName)
    {
        this.name = name;
        this.surName = surName;
    }

    public void nameSurname () {
        System.out.println("My Name is " + name + ". My surname is " + surName);
    }
}
