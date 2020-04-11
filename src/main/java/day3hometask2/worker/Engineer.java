package day3hometask2.worker;

import day3hometask2.entity.Result;
import day3hometask2.entity.Test;
import day3hometask2.species.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Random;

public abstract class Engineer extends Person {

    private Random rn = new Random();

    private int anxiety = 3;
    private int skill = rn.nextInt(10) + 1;

    public Result executeTest(Test test) {
        return test.apply(this);
    }

    public int getAnxiety() {
        return this.anxiety;
    }

    public int getSkill() {
        return this.skill;
    }
}
