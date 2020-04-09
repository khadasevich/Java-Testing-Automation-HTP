package day1hometask1;

import java.util.Arrays;
import java.util.Scanner;

public class Day1_Task1_5 {

    public static void main(String[] args) {
//  change place of items in array
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input an integer");
        int token = keyboard.nextInt();
        int[] array = new int[token];

        for (int i = 0; i < token; ++i) {
            array[i] = (int) (Math.random() * 100);
        }
        int size = array.length;
        for (int i = 0; i < 2; i++) {
            int temp = array[size - 1];
            for (int j = size - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}

