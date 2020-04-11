package day3hometask2.entity;

import day3hometask2.worker.AutomationEngineer;
import day3hometask2.worker.Engineer;
import day3hometask2.worker.TestEngineer;

public abstract class Test implements Function<Engineer, Result> {
    private int complexity;

    Test(TestLevel complexity) {
        this.complexity = complexity.COMPLEXITY;
    }

    protected abstract int getInstability();

    @Override
    public Result apply(Engineer engineer) {
        int anxiety = 1;
        int instability = this.getInstability();
        if (engineer instanceof TestEngineer && this instanceof AutomatedTest) {
            anxiety = engineer.getAnxiety();
        } else if (engineer instanceof AutomationEngineer && this instanceof ManualTest) {
            anxiety = engineer.getAnxiety();
        }
        int result = anxiety * instability * complexity;
        if (result > 30) {
            return Result.FAILED;
        }
        return Result.PASSED;
    }

    public int getComplexity() {
        return this.complexity;
    }

}
