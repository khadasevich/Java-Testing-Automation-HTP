package day3hometask2;

import day3hometask2.entity.ManualTest;
import day3hometask2.entity.TestLevel;
import day3hometask2.worker.AutomationEngineer;

public class Demo {

    public static void main(String[] args) {
        AutomationEngineer toster = new AutomationEngineer();
        toster.setNames("Aliaksei", "Khadasevich");
        toster.setAge(29.5);
        ManualTest guiTest = new ManualTest(TestLevel.GUI, 0);
        System.out.println(toster.executeTest(guiTest));
    }
}
