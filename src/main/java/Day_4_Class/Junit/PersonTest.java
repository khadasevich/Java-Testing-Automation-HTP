package Day_4_Class.Junit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PersonTest {

    @Test
    public void personAgeTest(){
        Person person = new Person(25);
        assertEquals("Person age is not expected!", person.getAge(), 25);
    }

    @Test
    public void personAgeTestSecond(){
        Person person = new Person(25);
        assertEquals("Person age is not expected!", person.getAge(), 26);
    }
}
