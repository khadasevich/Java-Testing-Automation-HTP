package day3hometask2.worker;

import day3hometask2.entity.Result;
import day3hometask2.entity.Test;
import day3hometask2.species.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public abstract class Engineer extends Person {

    private Random rn = new Random();

    private int anxiety = 3;
    int skill = rn.nextInt(10) + 1;

    public Result executeTest(Test test) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, ClassNotFoundException, InstantiationException {
        Object instanceOfExecutor = Class.forName(getClass().getName()).newInstance();
        Method instanceMethod = test.getClass().getSuperclass().getMethod("apply", Engineer.class);
        return (Result) instanceMethod.invoke(test, instanceOfExecutor);
    }

    public int getAnxiety() {
        return this.anxiety;
    }
}
