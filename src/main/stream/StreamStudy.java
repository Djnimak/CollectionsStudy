package main.stream;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy
{
   public static void printOddIndexNames(List<String> names)
   {
      String oddNames = names.stream()
         .filter(name -> names.indexOf(name) % 2 != 0)
         .map(name -> names.indexOf(name) + ". " + name)
         .collect(Collectors.joining(", "));

//      String oddNames = names.stream()
//         .filter(name -> Integer.parseInt(name.substring(0, 1)) % 2 != 0)
//         .collect(Collectors.joining(", "));

      System.out.println(oddNames);
   }

   public static List<String> printInUpperCase(List<String> words)
   {
      return words.stream()
         .map(String::toUpperCase)
         .sorted(Comparator.reverseOrder())
         .collect(Collectors.toList());
   }

   public static void stringToNumbers(String[] nums)
   {
      String numbers = Arrays.stream(nums)
         .map(num -> num.split(", "))
         .flatMap(Arrays::stream)
         .map(Integer::parseInt)
         .sorted()
         .map(String::valueOf)
         .collect(Collectors.joining(", "));

      System.out.println(numbers);
   }

//   public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
//   {
//      Stream<T> result =
//   }

   public static void generateUnlimitedRandomNumbers(int a, int c, int m)
   {
      Stream<Integer> iterate = Stream.iterate(1, seed -> (a * seed + c) % m);
      iterate.forEach(System.out::println);
   }
}
