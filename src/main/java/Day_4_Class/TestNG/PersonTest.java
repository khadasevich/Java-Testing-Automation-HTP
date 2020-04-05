package Day_4_Class.TestNG;

import Day_4_Class.Junit.Person;
import org.testng.annotations.*;
import org.testng.AssertJUnit;


public class PersonTest {

    @Test
    public void personAgeTest(){
        Person person = new Person(25);
        AssertJUnit.assertEquals("Person age is not expected!", person.getAge(), 25);
    }

    @Test
    public void personAgeTestSecond(){
        Person person = new Person(25);
        AssertJUnit.assertEquals("Person age is not expected!", person.getAge(), 26);
    }
}
