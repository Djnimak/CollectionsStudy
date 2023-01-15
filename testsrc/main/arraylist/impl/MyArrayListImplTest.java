package main.arraylist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListImplTest
{
   private MyArrayListImpl<Integer> myArrayList;

   @BeforeEach
   void setUp()
   {
       myArrayList = new MyArrayListImpl<>();
   }

   @Test
   void shouldCreateArrayListIfCapacityIsZero()
   {
      myArrayList = new MyArrayListImpl<>(0);

      assertEquals(0, myArrayList.size());
   }

   @Test
   void shouldThrowExceptionWhenCapacityIsNegative()
   {
      assertThrows(IllegalArgumentException.class,
         () -> myArrayList = new MyArrayListImpl<>(-1));
   }

   @Test
   void shouldAddElementsWhenOfIntegerType()
   {
       myArrayList.add(1);
       myArrayList.add(2);
       myArrayList.add(3);
       myArrayList.add(4);
       myArrayList.add(5);
       myArrayList.add(6);

       assertEquals(6, myArrayList.size());
   }

   @Test
   void shouldRemoveElementFromSpecifiedPosition()
   {
       myArrayList.add(1);
       myArrayList.add(2);
       myArrayList.add(3);
       myArrayList.add(4);
       myArrayList.add(5);
       myArrayList.add(6);
       myArrayList.remove(0);

       assertEquals(5, myArrayList.size());
   }

   @Test
   void shouldClearAllElements()
   {
       myArrayList.add(1);
       myArrayList.add(2);
       myArrayList.add(3);
       myArrayList.add(4);
       myArrayList.add(5);
       myArrayList.add(6);
       myArrayList.clear();

       assertEquals(0, myArrayList.size());
   }

   @Test
   void shouldReturnSizeOfCollection()
   {
      assertEquals(0, myArrayList.size());
   }

   @Test
   void shouldReturnElementInSpecifiedPosition()
   {
       myArrayList.add(1);
       myArrayList.add(2);
       myArrayList.add(3);
       myArrayList.add(4);
       myArrayList.add(5);
       myArrayList.add(6);

       assertEquals(1, myArrayList.get(0));
   }
}