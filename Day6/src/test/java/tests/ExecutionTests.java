package tests;

import entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ExecutionTests {

    private final Engineer engineer;
    private final BaseTest someTest;
    private final Result expected;

    public ExecutionTests(Engineer engineer, BaseTest test, Result expected){
        this.engineer = engineer;
        this.someTest = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][]{
                {new AutomationEngineer(), new ManualTest(TestLevel.API, 0), Result.PASSED},
                {new AutomationEngineer(), new AutomatedTest(TestLevel.API, 5), Result.PASSED},
                {new TestEngineer(), new ManualTest(TestLevel.UNIT, 10), Result.PASSED},
                {new AutomationEngineer(), new ManualTest(TestLevel.GUI, 10), Result.PASSED},
                {new TestEngineer(), new AutomatedTest(TestLevel.UNIT, 0), Result.PASSED},
                {new AutomationEngineer(), new ManualTest(TestLevel.UNIT, 5), Result.PASSED},
                {new AutomationEngineer(), new AutomatedTest(TestLevel.GUI, 0), Result.PASSED},
                {new TestEngineer(), new ManualTest(TestLevel.API, 10), Result.PASSED},
                {new TestEngineer(), new ManualTest(TestLevel.GUI, 5), Result.PASSED},
                {new AutomationEngineer(), new AutomatedTest(TestLevel.UNIT, 10), Result.PASSED},
                {new TestEngineer(), new AutomatedTest(TestLevel.GUI, 5), Result.PASSED},
                {new TestEngineer(), new AutomatedTest(TestLevel.API, 10), Result.PASSED},
                {new TestEngineer(), new ManualTest(TestLevel.GUI, 10), Result.PASSED}
        });
    }

    @Test
    public void engineerManTest() {
        assertEquals("Result is not expected!", expected, engineer.executeTest(someTest));
    }
}
