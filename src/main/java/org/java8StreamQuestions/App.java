package org.java8StreamQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
      //  1) Given a list of integers, separate odd and even numbers?
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
     //  2) How do you remove duplicate elements from a list using Java 8 streams?
        List<Integer>duplicateList=Arrays.asList(30,30,45,89,45);
        List<Integer>uniqueList=duplicateList.stream().distinct().collect(Collectors.toList());
        System.out.println("the array list without duplication is :"+uniqueList+"  ");
        System.out.println("-------------------");
        System.out.println("        ");

     // 3) How do you find frequency of each character in a string using Java 8 streams?
        String inputString = "Java Concept Of The Day";
        Map<Character,Long>frequencyMap=inputString.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("the frequency of the string is "+frequencyMap+"   ");
        System.out.println("--------------------");
        System.out.println("           ");

    }
}
