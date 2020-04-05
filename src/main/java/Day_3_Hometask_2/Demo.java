package Day_3_Hometask_2;

public class Demo {
//    Comments. Implement interface for ability of user to create code and testing
//    Implement interface for speaking
//    Add default method in speaker (default method allows to not add abstract class to implement interface)
//    Add super to constructors to ancestors
//    Envelope methods, to make any calculations
//
//
//
//
//
//
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
