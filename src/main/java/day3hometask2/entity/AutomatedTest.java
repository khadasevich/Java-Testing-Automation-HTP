package day3hometask2.entity;

public class AutomatedTest extends Test {
    private int instability;

    public AutomatedTest(TestLevel complexity, int instability) {
        super(complexity);
        this.instability = instability;
    }

    @Override
    public int getInstability() {
        return this.instability;
    }
}
