package day3hometask2.entity;

import day3hometask2.worker.AutomationEngineer;
import day3hometask2.worker.Engineer;
import day3hometask2.worker.TestEngineer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public abstract class Test implements Function {
    private int complexity;

    Test(TestLevel complexity) {
        this.complexity = complexity.COMPLEXITY;
    }

    @Override
    public Result apply(Engineer engineer) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName(getClass().getName());
        Object instanceOfTest = getClass().getDeclaredConstructor(TestLevel.class).newInstance(TestLevel.GUI);
        int anxiety = 1;
        Field newField = getClass().getField("instability");
        int instability = (int) newField.get(instanceOfTest);
        if (engineer instanceof TestEngineer && instanceOfTest instanceof AutomatedTest) {
            anxiety = engineer.getAnxiety();
        } else if (engineer instanceof AutomationEngineer && instanceOfTest instanceof ManualTest) {
            anxiety = engineer.getAnxiety();
        }
        int result = anxiety * instability * complexity;
        if (result > 30) {
            return Result.FAILED;
        }
        return Result.PASSED;
    }

}
