package day4hometask3.tests;

import day3hometask2.species.Human;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import day3hometask2.species.Person;

public class SpeciesTests {
    @Test
    public void personNameTest(){
        Person person = new Person();
        person.setNames("Alex", "Khadasevich");
        assertEquals("Person's name is not expected!", person.getFirstName(), "Alex");
    }

    @Test
    public void personSurnameTest(){
        Person person = new Person();
        person.setNames("Alex", "Khadasevich");
        assertEquals("Person's surname is not expected!", person.getLastName(), "Khadasevich");
    }

    @Test
    public void humanAgeTest(){
        Human human = new Human();
        human.setAge(29);
        assertEquals("Human's age is not expected!",29, human.getAge(), 0);
    }
}
