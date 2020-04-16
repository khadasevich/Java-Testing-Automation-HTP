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
        assertEquals("Complexity is not expected!", 1, TestLevel.UNIT.COMPLEXITY);
    }

    @Test
    public void apiComplexityTest() {
        assertEquals("Complexity is not expected!", 3, TestLevel.API.COMPLEXITY);
    }

    @Test
    public void guiComplexityTest() {
        assertEquals("Complexity is not expected!", 9, TestLevel.GUI.COMPLEXITY);
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
    public void manEngineerManTest() {
        ManualTest manualTest = new ManualTest(TestLevel.UNIT, 4);
        Engineer manualEngineer = new TestEngineer();
        Result resultOfTest = manualEngineer.executeTest(manualTest);
        assertEquals("Result is not expected!", Result.PASSED, resultOfTest);
    }

    @Test
    public void autoEngineerAutoTest() {
        AutomatedTest autoTest = new AutomatedTest(TestLevel.GUI, 10);
        Engineer autoEngineer = new AutomationEngineer();
        Result resultOfTest = autoEngineer.executeTest(autoTest);
        assertEquals("Result is not expected!", Result.PASSED, resultOfTest);
    }

    @Test
    public void failResultTest() throws NoSuchFieldException, IllegalAccessException {
        AutomatedTest autoTest = new AutomatedTest(TestLevel.GUI, 10);
        Engineer manEngineer = new TestEngineer();
        Field anxiety = autoTest.getClass().getSuperclass().getDeclaredField("anxiety");
        anxiety.setAccessible(true);
        anxiety.set(autoTest, 100);
        Result resultOfTest = manEngineer.executeTest(autoTest);
        assertEquals("Result is not expected!", Result.FAILED, resultOfTest);
    }

    @Test
    public void zeroInstability() {
        AutomatedTest autoTest = new AutomatedTest(TestLevel.GUI, 0);
        assertEquals("Instability is not expected!", 0, autoTest.getInstability());
    }

    @Test
    public void standInstability() {
        AutomatedTest autoTest = new AutomatedTest(TestLevel.GUI, 1);
        assertEquals("Instability is not expected!", 1, autoTest.getInstability());
    }

    @Test
    public void maxInstability() {
        AutomatedTest autoTest = new AutomatedTest(TestLevel.GUI, 11);
        assertEquals("Instability is not expected!", 10, autoTest.getInstability());
    }
}
