package main.hashmap.impl;

import main.hashmap.MyHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapImplTest
{
   private MyHashMap<String, String> myHashMap;

   @BeforeEach
   void setUp()
   {
      myHashMap = new MyHashMapImpl<>();
   }

   @Test
   void shouldAddElement()
   {
      myHashMap.put("Hello", "World");
      myHashMap.put("John", "Snow");

      assertEquals(2, myHashMap.size());
   }

   @Test
   void shouldRemoveElement()
   {
      myHashMap.put("Hello", "World");
      myHashMap.put("John", "Snow");

      myHashMap.remove("John");

      assertEquals(1, myHashMap.size());
   }

   @Test
   void shouldDeleteAllElements()
   {
      myHashMap.put("Hello", "World");
      myHashMap.put("John", "Snow");

      myHashMap.clear();

      assertEquals(0, myHashMap.size());
   }

   @Test
   void shouldReturnSize()
   {
      assertEquals(0, myHashMap.size());
   }

   @Test
   void shouldReturnValueByKey()
   {
      myHashMap.put("Hello", "World");
      myHashMap.put("John", "Snow");

      assertEquals("Snow", myHashMap.get("John"));
   }

   @Test
   void shouldOverrideValueIfTheSameKey()
   {
      myHashMap.put("Hello", "World");
      myHashMap.put("John", "Snow");
      myHashMap.put("John", "Doe");

      assertEquals("Doe", myHashMap.get("John"));
   }

   @Test
   void shouldNotAddElementIfKeyIsNull()
   {
      myHashMap.put(null, "Snow");

      assertEquals(0, myHashMap.size());
   }

   @Test
   void shouldNotRemoveElementIfKeyIsNull()
   {
      myHashMap.put("Hello", "World");
      myHashMap.put("John", "Snow");
      myHashMap.remove(null);

      assertEquals(2, myHashMap.size());
   }

   @Test
   void shouldReturnNullValueElementIfKeyIsNull()
   {
      myHashMap.put("Hello", "World");
      myHashMap.put("John", "Snow");

      assertNull(myHashMap.get(null));
   }
}