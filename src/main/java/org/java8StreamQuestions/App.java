package org.java8StreamQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

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
        int[] c= IntStream.concat(stream(a), stream(b)).sorted().toArray();
        System.out.println("Array after concatination is "+Arrays.toString(c));
        System.out.println("---------------------------");
        System.out.println("                 ");

       //10)How do you merge two unsorted arrays into single sorted array without duplicates?

        int[] d = new int[] {4, 2, 5, 1};
        int[] e = new int[] {8, 1, 9, 5};
        int[] f= IntStream.concat(stream(a), stream(b)).distinct().sorted().toArray();
        System.out.println("Array after concatination is"+Arrays.toString(c));
        System.out.println("------------------------------");
        System.out.println("                   ");

       //11)How do you get three maximum numbers and three minimum numbers from the given list of integers?

        List<Integer> listOfNumbers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("The minimum 3 numbers are from the list is");
        System.out.println("            ");
        System.out.println("-------------------------------");
        listOfNumbers.stream().sorted().limit(3).forEach(System.out::println);
        System.out.println("                   ");
        System.out.println("The maximum 3 numbers are from the list is");
        System.out.println("            ");
        System.out.println("-------------------------------");
        listOfNumbers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
        System.out.println("                   ");

       //12) Java 8 program to check if two strings are anagrams or not?
        String s1="RaceCar";
        String s2="CarRace";
        s1= Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2=Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        if(s1.equals(s2)){
            System.out.println("The two strings are anagram ");
        }
        else{
            System.out.println("The two strings are not anagram");
        }
        System.out.println("                   ");

       //13) Find sum of all digits of a number in Java 8?
        int i = 15623;
        int SumOfInteger= Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("Sum of integer digits are "+SumOfInteger);
        System.out.println("-----------------------");
        System.out.println("                   ");

      //14) Find second largest number in an integer array?
        List<Integer>listOfNum=Arrays.asList(45,78,94,32,24,56);
        Integer secondLargestNumber=listOfNum.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("The second largest number is"+secondLargestNumber);
        System.out.println("-------------------------");
        System.out.println("                   ");

       //15) Given a list of strings, sort them according to increasing order of their length?
        List<String> listOfString = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        listOfString.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        System.out.println("--------------------------");
        System.out.println("                    ");

       //16) Given an integer array, find sum and average of all elements?
        int[] g = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
        int sum=Arrays.stream(g).sum();
        System.out.println(sum);
        System.out.println("--------------------------");
        System.out.println("       ");
        Double average=Arrays.stream(g).average().getAsDouble();
        System.out.println(average);
        System.out.println("--------------------------");
        System.out.println("                     ");
    }
}
