package main.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy
{

   private StreamStudy(){}

   public static void printOddIndexNames(List<String> names)
   {
      String oddNames = names.stream()
         .filter(name -> names.indexOf(name) % 2 != 0)
         .map(name -> names.indexOf(name) + ". " + name)
         .collect(Collectors.joining(", "));

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
         .flatMap(number -> Arrays.stream(number.split(", ")))
         .sorted(Comparator.comparingInt(Integer::parseInt))
         .collect(Collectors.joining(", "));

      System.out.println(numbers);
   }

   public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
   {
      Iterator<T> secondIterator = second.iterator();
      return first.flatMap(
         firstElement -> secondIterator.hasNext() ? Stream.of(firstElement, secondIterator.next()) :
            Stream.empty());
   }

   public static Stream<Long> generateUnlimitedRandomNumbers(long a, long c, long m)
{
   return Stream.iterate(1L, seed -> (a * seed + c) % m);
}
}
