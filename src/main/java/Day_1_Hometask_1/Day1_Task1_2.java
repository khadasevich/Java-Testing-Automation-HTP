package Day_1_Hometask_1;

import java.util.Scanner;

public class Day1_Task1_2 {

    public static void main(String[] args) {
//        While looping from 0 to 25, return each value with space concatenated
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input an integer");
        int token = keyboard.nextInt();
        int j = 0;
        int[] array = new int[token];

        for (int i = 0; i < token; ++i) {
            array[i] = (int) (Math.random() * 100);
        }
        while (j < array.length) {
            if (array[j] < 26) {
                System.out.print(Integer.toString(array[j]) + ' ');
            }
            j++;
        }
    }
}
