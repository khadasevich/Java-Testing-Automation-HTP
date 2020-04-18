package day5class.test;

import day3hometask2.entity.AutomatedTest;
import day3hometask2.entity.ManualTest;
import day3hometask2.entity.BaseTest;
import day3hometask2.entity.Result;
import day3hometask2.entity.TestLevel;
import day3hometask2.worker.AutomationEngineer;
import day3hometask2.worker.Engineer;
import day3hometask2.worker.TestEngineer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ExecutionTests {

    private Engineer engineer;
    private BaseTest someTest;
    private Result expected;

    public ExecutionTests(Engineer engineer, BaseTest test, Result expected){
        this.engineer = engineer;
        this.someTest = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][]{
                {new TestEngineer(), new ManualTest(TestLevel.API, 1), Result.PASSED},
                {new AutomationEngineer(), new AutomatedTest(TestLevel.API, 1), Result.PASSED},
                {new TestEngineer(), new AutomatedTest(TestLevel.GUI, 10), Result.FAILED}

        });
    }

    @Test
    public void engineerManTest() {
        assertEquals("Result is not expected!", expected, engineer.executeTest(someTest));
    }
}
