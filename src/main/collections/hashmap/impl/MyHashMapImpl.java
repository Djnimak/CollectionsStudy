package main.collections.hashmap.impl;

import main.collections.hashmap.MyHashMap;

import java.util.Arrays;

public class MyHashMapImpl<K, V> implements MyHashMap<K, V>
{

   private int size;

   private int capacity = 16;

   private static final float LOAD_FACTOR = 0.75f;

   private Node<K, V>[] nodeEntry;

   @SuppressWarnings("unchecked")
   public MyHashMapImpl()
   {
      nodeEntry = new Node[capacity];
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
      if (size > capacity * LOAD_FACTOR)
      {
         resize();
      }
      addElement(key, value);
      size++;
   }

   private void addElement(K key, V value)
   {
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
               return;
            }
            previous = current;
            current = current.next;
         }
         if (previous != null)
         {
            previous.next = newNode;
         }
      }
   }

   @SuppressWarnings("unchecked")
   private void resize()
   {
      capacity *= 2;
      Node<K, V>[] oldTable = Arrays.copyOf(nodeEntry, nodeEntry.length);
      nodeEntry = new Node[capacity];
      for(Node<K, V> node : oldTable)
      {
         while (node != null)
         {
            addElement(node.key, node.value);
            node = node.next;
         }
      }
   }

   @SuppressWarnings("java:S2676")
   private int hash(K key)
   {
      return Math.abs(key.hashCode()) % capacity;
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
      for (int i = 0; i < capacity; i++)
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
