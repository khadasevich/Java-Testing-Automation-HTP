package day3hometask2.entity;

public enum TestLevel {
    UNIT(1), API(3), GUI(9);
    public final int COMPLEXITY;

    TestLevel(int complexity) {
        COMPLEXITY = complexity;
    }
}
