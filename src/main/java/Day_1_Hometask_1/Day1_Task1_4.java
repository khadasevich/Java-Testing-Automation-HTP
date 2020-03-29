package Day_1_Hometask_1;

import java.util.Arrays;
import java.util.Scanner;

public class Day1_Task1_4 {

    public static void main(String[] args) {
//        replace items in the array
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input an integer");
        int token = keyboard.nextInt();
        int[] array = new int[token];

        for (int i = 0; i < token; ++i) {
            array[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < array.length; i = i + 2) {
            int temp = array[i];
            int j = i + 1;
            if (j < array.length) {
                array[i] = array[j];
                array[j] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
