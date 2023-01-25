package main.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileUtil
{
   private ReadFileUtil() {}

   public static String readFile(String path)
   {
      try
      {
         return Files.readString(Path.of(path));
      }
      catch (IOException e)
      {
         e.printStackTrace();
         return "";
      }
   }
}
