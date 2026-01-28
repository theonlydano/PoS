package _01_Intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _01_Intro {
    public static void main(String[] args) {

        final int SIZE = 100;

        // OLD SCOOL ARRAYs
        int[] numbers = {1, 3, 43, 23, 12, 54, 23};

        for(int i = 0; i<numbers.length; i++){
            System.out.println(
                    String.format("number[%d] = %d]", i, numbers[i])
            );
        }

        // some streaming thing
        Arrays.stream(numbers) // build a stream out of array
                .forEach( // iteration over all elements, terminal operation
                        n -> System.out.println(n) // lambda expression
                );

        // Prepare a List
        Integer[] integers = new Integer[SIZE];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Random().nextInt(-50, 50);
        }

        Stream.of(integers)
                .forEach(
                        System.out::println // Methoden Reference
                );

        // println all even numbers
        List<Integer> result = Stream.of(integers)
                .filter(i -> i % 2 == 0)
                // .toList(); nicht veränderbar
                .collect(Collectors.toList()); // verönderbar

        System.out.println("-------------------------------------------");

        result.stream().forEach(System.out::println);
        result.removeFirst();
        System.out.println("------");
        result.stream().forEach(System.out::println);

        System.out.println("-------------------------------------------");

        // your turn: output all
        // + positive
        // + even
        // + ends with 4
        // numbers

        List<Integer> filtered = Stream.of(integers)
                .filter(i -> i >= 0)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 10 == 4)
                .collect(Collectors.toList());

        Stream.of(filtered).forEach(System.out::println);

        System.out.println("-------------------------------------------");

        List<Integer> listOfIntegers = new ArrayList<>();
        IntStream
                .range(-50, 50) // generate a Integer-list
                .forEach(e -> listOfIntegers.add(e)); // Persistentes Speichern
        System.out.println("Size of: " + listOfIntegers.size());

        System.out.println("-------------------------------------------");

        List<Integer> powerOf2 = listOfIntegers.stream()
                .map(e -> e * e) // intermedial
                .toList(); // immutable | terminal

        powerOf2.stream().forEach(System.out::println);

        List<Float> toFloats = listOfIntegers.stream()
                .map(e -> e * 1.0f) // returns a list of type float
                .toList(); // immutable

        toFloats.stream().forEach(System.out::println);

    }
}
