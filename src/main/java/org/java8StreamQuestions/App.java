package org.java8StreamQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        List<Integer> listOfInteger = Arrays.asList(71, 45, 87, 90);
        Map<Boolean, List<Integer>> listOfOddEvenNumberMap = listOfInteger.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        Set<Map.Entry<Boolean, List<Integer>>> entrySet = listOfOddEvenNumberMap.entrySet();
        for (Map.Entry<Boolean, List<Integer>> entry : entrySet) {
            System.out.println("------------------");
            if (entry.getKey()) {
                System.out.println("Even Numbers");
            } else {
                System.out.println("Odd Numbers");
            }
            System.out.println("------------------");


            List<Integer> list = entry.getValue();

            for (int i : list) {
                System.out.println(i);
            }
        }
    }
}
