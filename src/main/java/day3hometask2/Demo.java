package day3hometask2;

import day3hometask2.entity.ManualTest;
import day3hometask2.entity.TestLevel;
import day3hometask2.worker.TestEngineer;

import java.lang.reflect.InvocationTargetException;

public class Demo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        TestEngineer toster = new TestEngineer();
        toster.setNames("Aliaksei", "Khadasevich");
        toster.setAge(29.5);
        ManualTest guiTest = new ManualTest(TestLevel.GUI);
        System.out.println(toster.executeTest(guiTest));
    }
}
