package day3hometask2.entity;

import day3hometask2.worker.AutomationEngineer;
import day3hometask2.worker.Engineer;
import day3hometask2.worker.TestEngineer;

public abstract class Test implements Function<Engineer, Result> {
    private final int complexity;
    private int anxiety = 1;
    private final int instability;

    Test(TestLevel complexity, int instability) {
        this.complexity = complexity.COMPLEXITY;
        if (instability <= 0) {
            this.instability = 0;
        } else this.instability = Math.min(instability, 10);
    }

    @Override
    public Result apply(Engineer engineer) {
        int skill = engineer.getSkill();
        if (engineer instanceof TestEngineer && this instanceof AutomatedTest) {
            anxiety = engineer.getAnxiety();
        } else if (engineer instanceof AutomationEngineer && this instanceof ManualTest) {
            anxiety = engineer.getAnxiety();
        }
        int result = (anxiety * instability * complexity)/skill;
        if (result > 30) {
            return Result.FAILED;
        }
        return Result.PASSED;
    }

    public int getComplexity() {
        return this.complexity;
    }

    public int getInstability() {
        return this.instability;
    }

}
