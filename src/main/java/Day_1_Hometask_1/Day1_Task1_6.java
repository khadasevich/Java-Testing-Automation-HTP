package Day_1_Hometask_1;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day1_Task1_6 {

    public static void main(String[] args) {
//  Make List From array filter and sort it
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input an integer");
        int token = keyboard.nextInt();
        int[] array = new int[token];

        for (int i = 0; i < token; ++i) {
            array[i] = (int) (Math.random() * 100);
        }
        List<Integer> ints = IntStream.of(array).boxed().collect(Collectors.toList());
        Predicate<Integer> streamsPredicate = item -> item % 2 == 0 && item > 10 && item <= 20;

        List<Integer> even = ints.stream()
                .filter(streamsPredicate)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(even);
    }
}

