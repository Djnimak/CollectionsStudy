package main.collections.hashmap.impl;

import main.collections.hashmap.MyHashMap;

public class MyHashMapImpl<K, V> implements MyHashMap<K, V>
{

   private int size;

   private static final int INITIAL_CAPACITY = 16;

   private final Node<K, V>[] nodeEntry;

   @SuppressWarnings("unchecked")
   public MyHashMapImpl()
   {
      nodeEntry = new Node[INITIAL_CAPACITY];
   }

   private static class Node<K, V>
   {
      K key;

      V value;

      Node<K, V> next;

      Node(K key, V value, Node<K, V> next)
      {
         this.key = key;
         this.value = value;
         this.next = next;
      }
   }

   @Override
   public void put(K key, V value)
   {
      if (key == null)
      {
         return;
      }
      int index = hash(key);

      Node<K, V> newNode = new Node<>(key, value, null);

      if (nodeEntry[index] == null)
      {
         nodeEntry[index] = newNode;
      }
      else
      {
         Node<K, V> previous = null;
         Node<K, V> current = nodeEntry[index];
         while (current != null)
         {
            if (current.key.equals(key))
            {
               current.value = value;
               break;
            }
            previous = current;
            current = current.next;
         }
         if (previous != null)
         {
            previous.next = newNode;
         }
      }
      size++;
   }

   private int hash(K key)
   {
      return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
   }

   @Override
   public void remove(K key)
   {
      if (key == null)
      {
         return;
      }
      int index = hash(key);
      Node<K, V> previous = null;
      Node<K, V> current = nodeEntry[index];
      while (current != null)
      {
         if (current.key.equals(key))
         {
            if (previous == null)
            {
               nodeEntry[index] = current.next;
            }
            else
            {
               previous.next = current.next;
            }
            break;
         }
         previous = current;
         current = current.next;
      }
      size--;
   }

   @Override
   public void clear()
   {
      for (int i = 0; i < nodeEntry.length; i++)
      {
         Node<K, V> previousNode;
         Node<K, V> current = nodeEntry[i];
         while (current != null)
         {
            previousNode = current.next;
            current.value = null;
            current.key = null;
            current.next = null;
            current = previousNode;
         }
         nodeEntry[i] = null;
      }
      size = 0;
   }

   @Override
   public int size()
   {
      return size;
   }

   @Override
   public V get(K key)
   {
      if (key == null)
      {
         return null;
      }
      int index = hash(key);
      V value = null;
      Node<K, V> current = nodeEntry[index];
      while (current != null)
      {
         if (current.key.equals(key))
         {
            value = current.value;
            break;
         }
         current = current.next;
      }
      return value;
   }
}
