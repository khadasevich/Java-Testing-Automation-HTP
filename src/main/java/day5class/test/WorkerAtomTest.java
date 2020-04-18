package day5class.test;

import day3hometask2.worker.AutomationEngineer;
import day3hometask2.worker.Engineer;
import day3hometask2.worker.TestEngineer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class WorkerAtomTest {

    private Engineer engineer;

    public WorkerAtomTest (Engineer engineer){
        this.engineer = engineer;
    }

    @Parameterized.Parameters
    public static Collection<Engineer[]> primeNumbers(){
        return Arrays.asList(new Engineer[][]{
                {new TestEngineer()},
                {new AutomationEngineer()}
        });
    }

    @Test
    public void engineerAnxietyTest() {
        Engineer engineer = new TestEngineer();
        assertEquals("Engineer's anxiety is not expected!", 3, engineer.getAnxiety());
    }

    @Test
    public void engineerSkillTest() {
        boolean checkSkill = true;
        if (engineer.getAnxiety() < 0 | engineer.getAnxiety() > 10) {
            checkSkill = false;
        }
        assertTrue("Engineer's skill is not expected!", checkSkill);
    }
}

