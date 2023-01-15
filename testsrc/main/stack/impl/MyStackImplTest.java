package main.stack.impl;

import main.stack.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackImplTest
{
   private MyStack<Integer> myStack;

   @BeforeEach
   void setUp()
   {
      myStack = new MyStackImpl<>();
   }

   @Test
   void shouldAddElementAtTheEnd()
   {
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);

      assertEquals(3, myStack.peek());
   }

   @Test
   void shouldRemoveElementAtSpecifiedPosition()
   {
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);

      myStack.remove(1);

      assertEquals(2, myStack.size());
   }

   @Test
   void shouldRemoveAllElements()
   {
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);

      myStack.clear();

      assertEquals(0, myStack.size());
   }

   @Test
   void shouldReturnSizeOfCollection()
   {
      assertEquals(0, myStack.size());
   }

   @Test
   void shouldReturnLastElementOfCollection()
   {
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);

      assertEquals(3, myStack.peek());
   }

   @Test
   void shouldReturnAndRemoveLastElementOfCollection()
   {
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);

      assertEquals(3, myStack.pop());
      assertEquals(2, myStack.size());
   }
}