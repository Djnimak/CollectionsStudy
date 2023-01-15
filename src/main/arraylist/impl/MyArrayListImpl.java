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
      this(10);
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
   public boolean add(E value)
   {
      ensureCapacity(arrayList.length + 1);
      arrayList[this.size++] = value;
      return true;
   }

   private void ensureCapacity(int neededCapacity)
   {
      if (neededCapacity > arrayList.length)
      {
         Object[] oldArray = arrayList;
         int newSize = this.size + 1;
         arrayList = Arrays.copyOf(oldArray, newSize);
      }
   }


   @Override
   public E remove(int index)
   {
     Objects.checkIndex(index, size);
     E removed = arrayList(index);
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
     arrayList = newArray;
     size = newArray.length;
     return removed;
   }

   @Override
   public void clear()
   {
      arrayList = new Object[0];
      size = 0;
   }

   @Override
   public int size()
   {
      return size;
   }

   @Override
   public E get(int index)
   {
      Objects.checkIndex(index, size);
      return arrayList(index);
   }

   @SuppressWarnings("unchecked")
   private E arrayList(int index)
   {
      return (E) arrayList[index];
   }
}
