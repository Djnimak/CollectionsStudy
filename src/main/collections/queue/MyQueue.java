package main.collections.queue;

public interface MyQueue<E>
{
   void add(E value);

   void clear();

   int size();

   E peek();

   E poll();
}
