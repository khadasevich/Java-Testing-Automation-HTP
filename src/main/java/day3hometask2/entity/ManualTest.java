package day3hometask2.entity;

public class ManualTest extends Test {
    private int instability;

    public ManualTest(TestLevel complexity, int instability) {
        super(complexity);
        this.instability = instability;
    }

    @Override
    public int getInstability() {
        return this.instability;
    }
}
