package org.java8StreamQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

       // 4) How do you find frequency of each element in an array or a list?
        List<String>stringOfWords=Arrays.asList("kartik","kanishk","kartik","abhay","shubham","preet","abhishek");
        Map<String,Long>frequentWords=stringOfWords.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(frequentWords);
        System.out.println("---------------------");
        System.out.println("          ");

       // 5) How do you sort the given list of decimals in reverse order?
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("----------------------");
        System.out.println("                ");

       //6) Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String newString=listOfStrings.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(newString);
        System.out.println("-------------------------");
        System.out.println("                ");

       //7) From the given list of integers, print the numbers which are multiples of 5?
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        List<Integer>listOfMultiple5=listOfInteger.stream().filter(i->i%5==0).collect(Collectors.toList());
        System.out.println("multiple of 5 are "+listOfMultiple5);
        System.out.println("--------------------------");
        System.out.println("               ");

       //8)  Given a list of integers, find maximum and minimum of those numbers?
        List<Integer> listOfIntegerForMaxAndMin = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        int max=listOfIntegerForMaxAndMin.stream().max(Comparator.naturalOrder()).get();
        int min=listOfIntegerForMaxAndMin.stream().min(Comparator.naturalOrder()).get();
        System.out.println("The max number is "+max);
        System.out.println("--------------------------");
        System.out.println("               ");
        System.out.println("the min number is "+min);
        System.out.println("--------------------------");
        System.out.println("               ");

       //9)How do you merge two unsorted arrays into single sorted array using Java 8 streams?
        int[] a = new int[] {4, 2, 7, 1};

        int[] b = new int[] {8, 3, 9, 5};
        int[] c= IntStream.concat(Arrays.stream(a),Arrays.stream(b)).sorted().toArray();
        System.out.println("Array after concatination is "+Arrays.toString(c));
        System.out.println("---------------------------");
        System.out.println("                 ");
    }
}
