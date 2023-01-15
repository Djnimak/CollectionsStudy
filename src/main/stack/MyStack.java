package main.stack;

public interface MyStack<E>
{
   void push(E value);

   void remove(int index);

   void clear();

   int size();

   E peek();

   E pop();
}
