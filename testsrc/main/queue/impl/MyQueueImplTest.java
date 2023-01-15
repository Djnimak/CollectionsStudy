package main.queue.impl;

import main.queue.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueImplTest
{
   private MyQueue<Integer> myQueue;

   @BeforeEach
   void setUp()
   {
      myQueue = new MyQueueImpl<>();
   }

   @Test
   void shouldAddElementsAnTheEnd()
   {
      myQueue.add(1);
      myQueue.add(2);
      myQueue.add(3);

      assertEquals(3, myQueue.size());
   }

   @Test
   void shouldClearAllElements()
   {
      myQueue.add(1);
      myQueue.add(2);
      myQueue.add(3);

      myQueue.clear();

      assertEquals(0, myQueue.size());
   }

   @Test
   void shouldReturnSizeOfCollection()
   {
      assertEquals(0, myQueue.size());
   }

   @Test
   void shouldReturnFirstElement()
   {
      myQueue.add(1);
      myQueue.add(2);
      myQueue.add(3);

      assertEquals(1, myQueue.peek());
   }

   @Test
   void shouldRemoveFirstElement()
   {
      myQueue.add(1);
      myQueue.add(2);
      myQueue.add(3);

      Integer removed = myQueue.poll();

      assertEquals(1, removed);
      assertEquals(2, myQueue.size());
   }
}