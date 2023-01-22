package main.stack.impl;

import main.arraylist.MyArrayList;
import main.arraylist.impl.MyArrayListImpl;
import main.stack.MyStack;

public class MyStackImpl<E> implements MyStack<E>
{
   private final MyArrayList<E> myStack;

   public MyStackImpl()
   {
      myStack = new MyArrayListImpl<>();
   }

   @Override
   public void push(E value)
   {
      myStack.add(value);
   }

   @Override
   public void remove(int index)
   {
      myStack.remove(index);
   }

   @Override
   public void clear()
   {
      myStack.clear();
   }

   @Override
   public int size()
   {
      return myStack.size();
   }

   @Override
   public E peek()
   {
      return myStack.get(myStack.size() - 1);
   }

   @Override
   public E pop()
   {
      E removed = peek();
      remove(myStack.size() - 1);
      return removed;
   }
}
