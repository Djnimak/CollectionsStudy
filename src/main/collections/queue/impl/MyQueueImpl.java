package main.collections.queue.impl;

import main.collections.queue.MyQueue;

import java.util.Objects;

public class MyQueueImpl<E> implements MyQueue<E>
{
   private Node<E> first;

   private Node<E> last;

   private int size;

   private static class Node<E>
   {
      E element;
      Node<E> next;
      Node<E> prev;

      Node(Node<E> prev, E element, Node<E> next)
      {
         this.element = element;
         this.next = next;
         this.prev = prev;
      }
   }

   @Override
   public void add(E value)
   {
      Node<E> lastNode = last;
      Node<E> newNode = new Node<>(lastNode, value, null);
      last = newNode;
      if(Objects.isNull(lastNode))
      {
         first = newNode;
      }
      else
      {
         lastNode.next = newNode;
      }
      size++;
   }

   @Override
   public void clear()
   {
      for (Node<E> f = first; f != null;)
      {
         Node<E> next = f.next;
         f.prev = null;
         f.next = null;
         f.element = null;
         f = next;
      }
      first = last = null;
      size = 0;
   }

   @Override
   public int size()
   {
      return size;
   }

   @Override
   public E peek()
   {
      return first.element;
   }

   @Override
   public E poll()
   {
      Node<E> removedNode = first;
      E element = removedNode.element;
      first = removedNode.next;
      removedNode.prev = null;
      removedNode.next = null;
      removedNode.element = null;
      size--;
      return element;
   }
}
