package day4hometask3.tests;

import day3hometask2.entity.AutomatedTest;
import day3hometask2.entity.ManualTest;
import day3hometask2.entity.Result;
import day3hometask2.entity.TestLevel;
import day3hometask2.worker.AutomationEngineer;
import day3hometask2.worker.Engineer;
import day3hometask2.worker.TestEngineer;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class EntityTests {
    @Test
    public void testInstability() {
        ManualTest manualTest = new ManualTest(TestLevel.API, 4);
        assertEquals("Instability of test is not expected!", 4, manualTest.getInstability());
    }

    @Test
    public void testComplexity() {
        AutomatedTest automatedTest = new AutomatedTest(TestLevel.UNIT, 4);
        assertEquals("Complexity of test is not expected!", 1, automatedTest.getComplexity());
    }

    @Test
    public void unitComplexityTest() {
        int unitComplexity = TestLevel.UNIT.COMPLEXITY;
        assertEquals("Complexity is not expected!", 1, unitComplexity);
    }

    @Test
    public void apiComplexityTest() {
        int apiComplexity = TestLevel.API.COMPLEXITY;
        assertEquals("Complexity is not expected!", 3, apiComplexity);
    }

    @Test
    public void guiComplexityTest() {
        int guiComplexity = TestLevel.GUI.COMPLEXITY;
        assertEquals("Complexity is not expected!", 9, guiComplexity);
    }

    @Test
    public void defaultAnxietyTest() throws NoSuchFieldException, IllegalAccessException {
        ManualTest manualTest = new ManualTest(TestLevel.GUI, 4);
        Engineer manualEngineer = new TestEngineer();
        manualEngineer.executeTest(manualTest);
        Field anxiety = manualTest.getClass().getSuperclass().getDeclaredField("anxiety");
        anxiety.setAccessible(true);
        int valueOfAnxiety = (int) anxiety.get(manualTest);
        assertEquals("Anxiety is not expected!", 1, valueOfAnxiety);
    }

    @Test
    public void manTestAutoEngineerTest() throws NoSuchFieldException, IllegalAccessException {
        ManualTest manualTest = new ManualTest(TestLevel.GUI, 4);
        Engineer automationEngineer = new AutomationEngineer();
        automationEngineer.executeTest(manualTest);
        Field anxiety = manualTest.getClass().getSuperclass().getDeclaredField("anxiety");
        anxiety.setAccessible(true);
        int valueOfAnxiety = (int) anxiety.get(manualTest);
        assertEquals("Anxiety is not expected!", 3, valueOfAnxiety);
    }

    @Test
    public void autoTestManualEngineerTest() throws NoSuchFieldException, IllegalAccessException {
        AutomatedTest automatedTest = new AutomatedTest(TestLevel.GUI, 4);
        Engineer manualEngineer = new TestEngineer();
        manualEngineer.executeTest(automatedTest);
        Field anxiety = automatedTest.getClass().getSuperclass().getDeclaredField("anxiety");
        anxiety.setAccessible(true);
        int valueOfAnxiety = (int) anxiety.get(automatedTest);
        assertEquals("Anxiety is not expected!", 3, valueOfAnxiety);
    }

    @Test
    public void passResultTest() {
        ManualTest manualTest = new ManualTest(TestLevel.UNIT, 4);
        Engineer manualEngineer = new TestEngineer();
        Result resultOfTest = manualEngineer.executeTest(manualTest);
        assertEquals("Result is not expected!", resultOfTest, Result.PASSED);
    }

    @Test
    public void failResultTest() {
        ManualTest manualTest = new ManualTest(TestLevel.GUI, 4);
        Engineer manualEngineer = new TestEngineer();
        Result resultOfTest = manualEngineer.executeTest(manualTest);
        assertEquals("Result is not expected!", resultOfTest, Result.FAILED);
    }
}
