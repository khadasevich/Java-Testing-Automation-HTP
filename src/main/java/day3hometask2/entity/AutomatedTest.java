package day3hometask2.entity;

public class AutomatedTest extends Test {
    public int instability;

    public AutomatedTest(TestLevel complexity) {
        super(complexity);
        int instability = 4;
    }

    public int getInstability() {
        return this.instability;
    }
}
