package main.file;

import java.util.List;

public class TelephoneNumberReader
{
   private TelephoneNumberReader(){}

   private static final String PHONE_NUMBER_FILE = "resources/phoneNumbers.txt";

   private static final String REGULAR_NUMBER = "(\\(\\d{3}\\) |\\d{3}-)\\d{3}-\\d{4}";

   public static void showValidPhoneNumbers()
   {
      List<String> phoneNumbers = List.of(ReadFileUtil.readFile(PHONE_NUMBER_FILE)
         .split(System.lineSeparator()));
      for (String phone : phoneNumbers)
      {
         if (phone.matches(REGULAR_NUMBER))
         {
            System.out.println(phone);
         }
      }
   }
}
