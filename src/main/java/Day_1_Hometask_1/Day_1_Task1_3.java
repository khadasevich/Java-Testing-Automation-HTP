package Day_1_Hometask_1;

import java.util.Scanner;

public class Day_1_Task1_3 {

    public static void main(String[] args) {
//        for looping from 0 to 20, return even numbers that are > 10
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input an integer");
        int token = keyboard.nextInt();
        int[] array = new int[token];

        for (int i = 0; i < token; ++i) {
            array[i] = (int) (Math.random() * 100);
        }

        for (int j = 0; j < array.length; j++) {
            if (array[j] > 10 && array[j] < 20 && array[j] % 2 == 0) {
                System.out.println(array[j]);
            }
        }
    }
}
