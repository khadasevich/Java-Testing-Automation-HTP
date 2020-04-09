package day3hometask2.entity;

public class ManualTest extends Test {
    public int instability;

    public ManualTest(TestLevel complexity) {
        super(complexity);
        this.instability = 3;
    }

    public int getInstability() {
        return this.instability;
    }
}
