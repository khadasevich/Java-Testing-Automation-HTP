package Day_3_Hometask_2;

public class Demo {
    public static void main(String[] args) {
        ManualEngineer toster = new ManualEngineer();
        toster.setNames("Aliaksei", "Khadasevich");
        toster.setAge(29.5);
        System.out.println("Do you speak?");
        toster.voice();
        System.out.println("What's you name?");
        toster.nameSurname();
        System.out.println("Do you have experience in code writing?");
        toster.inventCode();
        System.out.println("What else you can do?");
        toster.executeTests();
    }
}
