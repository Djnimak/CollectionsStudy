package main.linkedlist.impl;

import main.linkedlist.MyLinkedList;

import java.util.Objects;

public class MyLinkedListImpl<E> implements MyLinkedList<E>
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
   public E remove(int index)
   {
      checkIndex(index);
      Node<E> removedNode = getNode(index);
      E element = removedNode.element;
      Node<E> previous = removedNode.prev;
      Node<E> next = removedNode.next;

      if (Objects.isNull(previous))
      {
         first = next;
      }
      else
      {
         previous.next = next;
         removedNode.prev = null;
      }

      if (Objects.isNull(next))
      {
         last = previous;
      }
      else
      {
         next.prev = previous;
         removedNode.next = null;
      }
      removedNode.element = null;
      size--;
      return element;
   }

   private void checkIndex(int index)
   {
      if(index < 0 || index >= size)
         throw new IndexOutOfBoundsException(index);
   }

   private Node<E> getNode(int index)
   {
      Node<E> node = first;
      for (int i = 0; i < index; i++)
      {
         node = node.next;
      }
      return node;
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
   public E get(int index)
   {
      checkIndex(index);
      return getNode(index).element;
   }
}
