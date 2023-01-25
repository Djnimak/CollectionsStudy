package main.file.userjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import main.file.ReadFileUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserToJson
{
   private UserToJson(){}

   private static final String FILE = "resources/users.txt";

   private static final String JSON_FILE = "resources/users.json";

   private static final String LINE_SEPARATOR = "\\r\\n?|\\n";

   public static void convertFileToJson() throws IOException
   {
      List<String> userFile = Arrays.stream(ReadFileUtil.readFile(FILE).split(LINE_SEPARATOR))
         .skip(1)
         .collect(Collectors.toList());

      List<User> users = new ArrayList<>();
      for (String user : userFile)
      {
         String[] arrayOfUsers = user.split(" ");
         users.add(new User(arrayOfUsers[0], Integer.parseInt(arrayOfUsers[1])));
      }

      Path path = Paths.get(JSON_FILE);

      try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8))
      {
         Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

         JsonElement tree = gson.toJsonTree(users);
         gson.toJson(tree, writer);
      }

   }
}
