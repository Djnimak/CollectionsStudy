package main.arraylist;

public interface MyArrayList<E>
{
   boolean add(E value);

   E remove(int index);

   void clear();

   int size();

   E get(int index);
}
