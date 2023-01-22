package main.arraylist.impl;

import main.arraylist.MyArrayList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayListImpl<E> implements MyArrayList<E>
{
   private static final Object[] EMPTY_COLLECTION = {};
   private static final Integer DEFAULT_CAPACITY = 10;
   private Object[] arrayList;
   private int size;

   public MyArrayListImpl()
   {
      arrayList = new Object[DEFAULT_CAPACITY];
   }

   public MyArrayListImpl(int initialCapacity)
   {
      if (initialCapacity > 0)
      {
         arrayList = new Object[initialCapacity];
      }
      else if (initialCapacity == 0)
      {
         arrayList = EMPTY_COLLECTION;
      }
      else
      {
         throw new IllegalArgumentException("Incorrect initial capacity: " + initialCapacity);
      }
   }

   @Override
   public void add(E value)
   {
      ensureCapacity(size + 1);
      arrayList[size++] = value;
   }

   private void ensureCapacity(int neededCapacity)
   {
      if (arrayList.length == 0)
      {
         arrayList = new Object[DEFAULT_CAPACITY];
      }
      else if (neededCapacity > arrayList.length)
      {
         int newSize = arrayList.length * 2;
         arrayList = Arrays.copyOf(arrayList, newSize);
      }
   }


   @Override
   public void remove(int index)
   {
     Objects.checkIndex(index, size);
     int numberOfElements = arrayList.length - index - 1;
     System.arraycopy(arrayList, index + 1, arrayList, index, numberOfElements);
     size--;
   }

   @Override
   public void clear()
   {
      arrayList = Arrays.copyOf(new Object[0], arrayList.length);
      size = 0;
   }

   @Override
   public int size()
   {
      return size;
   }

   @Override
   @SuppressWarnings("unchecked")
   public E get(int index)
   {
      Objects.checkIndex(index, size);
      return (E) arrayList[index];
   }
}
