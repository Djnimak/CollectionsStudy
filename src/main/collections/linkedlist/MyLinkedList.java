package main.collections.linkedlist;

public interface MyLinkedList<E>
{
   void add(E value);

   E remove(int index);

   void clear();

   int size();

   E get(int index);
}
