package species;

public class Human {

    private double age;

    public void setAge(double age) {
        this.age = age;
    }

    public double getAge() {
        return this.age;
    }

    public void voice() {
        System.out.println("I can speak. My age is " + age);
    }
}
