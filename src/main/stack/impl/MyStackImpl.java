package main.stack.impl;

import main.arraylist.MyArrayList;
import main.arraylist.impl.MyArrayListImpl;
import main.stack.MyStack;

public class MyStackImpl<E> implements MyStack<E>
{
   private MyArrayList<E> myStack;

   private int size;

   public MyStackImpl()
   {
      myStack = new MyArrayListImpl<>();
   }

   @Override
   public void push(E value)
   {
      myStack.add(value);
      size++;
   }

   @Override
   public void remove(int index)
   {
      myStack.remove(index);
      size--;
   }

   @Override
   public void clear()
   {
      myStack = new MyArrayListImpl<>(0);
      size = 0;
   }

   @Override
   public int size()
   {
      return size;
   }

   @Override
   public E peek()
   {
      return myStack.get(myStack.size() - 1);
   }

   @Override
   public E pop()
   {
      E removed = myStack.get(myStack.size() - 1);
      myStack.remove(myStack.size() - 1);
      size--;
      return removed;
   }
}
