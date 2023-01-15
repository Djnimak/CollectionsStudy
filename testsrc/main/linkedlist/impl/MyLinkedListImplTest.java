package main.linkedlist.impl;

import main.linkedlist.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListImplTest
{

   private MyLinkedList<Integer> myLinkedList;

   @BeforeEach
   void setUp()
   {
      myLinkedList = new MyLinkedListImpl<>();
   }

   @Test
   void shouldAddElementsWhenOfIntegerType()
   {
      myLinkedList.add(1);
      myLinkedList.add(2);
      myLinkedList.add(3);
      myLinkedList.add(4);
      myLinkedList.add(5);

      assertEquals(5, myLinkedList.size());
   }

   @Test
   void shouldRemoveElementFromSpecifiedPosition()
   {
      myLinkedList.add(1);
      myLinkedList.add(2);
      myLinkedList.add(3);
      myLinkedList.add(4);
      myLinkedList.add(5);
      myLinkedList.add(6);

      myLinkedList.remove(0);
      myLinkedList.remove(1);
      myLinkedList.remove(3);

      assertEquals(3, myLinkedList.size());
   }

   @Test
   void shouldClearAllElements()
   {
      myLinkedList.add(1);
      myLinkedList.add(2);
      myLinkedList.add(3);
      myLinkedList.add(4);
      myLinkedList.add(5);

      myLinkedList.clear();

      assertEquals(0, myLinkedList.size());
   }

   @Test
   void shouldReturnSizeOfCollection()
   {
      assertEquals(0, myLinkedList.size());
   }

   @Test
   void shouldReturnElementInSpecifiedPosition()
   {
      myLinkedList.add(1);
      myLinkedList.add(2);
      myLinkedList.add(3);
      myLinkedList.add(4);
      myLinkedList.add(5);

      assertEquals(3, myLinkedList.get(2));
   }

   @Test
   void shouldThrowExceptionWhenIndexOutOfBounce()
   {
      assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(2));
   }
}