package day4hometask3.tests;

import day3hometask2.worker.Engineer;
import day3hometask2.worker.TestEngineer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WorkerTests {
    @Test
    public void engineerAnxietyTest() {
        Engineer engineer = new TestEngineer();
        assertEquals("Engineer's anxiety is not expected!", engineer.getAnxiety(), 3);
    }

    @Test
    public void engineerSkillTest() {
        Engineer engineer = new TestEngineer();
        boolean checkSkill = true;
        if (engineer.getAnxiety() < 0 | engineer.getAnxiety() > 10) {
            checkSkill = false;
        }
        assertTrue("Engineer's skill is not expected!", checkSkill);
    }
}
