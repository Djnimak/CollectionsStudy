package main.file;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyOfWords
{
   private FrequencyOfWords() {}

   private static final Pattern WORDS_PATTER = Pattern.compile("([a-z]+)");

   private static final String WORDS_FILE = "resources/words.txt";

   public static void displayFrequencyOfWords()
   {
      String words = ReadFileUtil.readFile(WORDS_FILE);

      Matcher matcher = WORDS_PATTER.matcher(words);

      Map<String, Integer> frequencyMap = new HashMap<>();

      while (matcher.find())
      {
         String word = matcher.group();
         if (frequencyMap.containsKey(word))
         {
            frequencyMap.put(word, frequencyMap.get(word) + 1);
         }
         else
         {
            frequencyMap.put(word, 1);
         }
//         frequencyMap.compute(matcher.group(), (key, value) -> (value == null) ? 1 : value + 1);
      }

      int maxValue = 0;
      String maxKey = "";
      while (frequencyMap.size() != 0)
      {
         for (Map.Entry<String, Integer> entry : frequencyMap.entrySet())
         {
            if (entry.getValue() > maxValue)
            {
               maxValue = entry.getValue();
               maxKey = entry.getKey();
            }
         }
         System.out.println(maxKey + " " + maxValue);
         frequencyMap.remove(maxKey);
         maxValue = 0;
      }
   }
}
