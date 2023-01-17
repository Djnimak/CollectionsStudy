package main.hashmap;

public interface MyHashMap<K, V>
{
   void put(K key, V value);

   void remove(K key);

   void clear();

   int size();

   V get(K key);
}
