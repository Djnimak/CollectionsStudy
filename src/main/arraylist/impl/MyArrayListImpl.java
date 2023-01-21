package main.arraylist.impl;

import main.arraylist.MyArrayList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayListImpl<E> implements MyArrayList<E>
{
   private static final Object[] EMPTY_COLLECTION = {};
   private Object[] arrayList;
   private int size;

   public MyArrayListImpl()
   {
      arrayList = new Object[10];
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
      if (neededCapacity > arrayList.length)
      {
         int newSize = arrayList.length * 2;
         arrayList = Arrays.copyOf(arrayList, newSize);
      }
   }


   @Override
   @SuppressWarnings("unchecked")
   public E remove(int index)
   {
     Objects.checkIndex(index, size);
     E removed = (E) arrayList[index];
     arrayList[index] = null;
     Object[] newArray = new Object[size - 1];
     int addCount = 0;
      for (Object o : arrayList)
      {
         if (Objects.nonNull(o))
         {
            newArray[addCount] = o;
            addCount++;
         }
      }
     arrayList = Arrays.copyOf(newArray, arrayList.length);
     size--;
     return removed;
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
