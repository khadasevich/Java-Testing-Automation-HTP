package worker;


import entity.BaseTest;
import entity.Result;
import species.Person;

import java.util.Random;

public abstract class Engineer extends Person {

    private final Random rn = new Random();

    private final int skill = rn.nextInt(10) + 1;

    public Result executeTest(BaseTest test) {
        return test.apply(this);
    }

    public int getAnxiety() {
        return 3;
    }

    public int getSkill() {
        return this.skill;
    }
}
