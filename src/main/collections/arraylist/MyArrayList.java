package main.collections.arraylist;

public interface MyArrayList<E>
{
   void add(E value);

   void remove(int index);

   void clear();

   int size();

   E get(int index);
}
