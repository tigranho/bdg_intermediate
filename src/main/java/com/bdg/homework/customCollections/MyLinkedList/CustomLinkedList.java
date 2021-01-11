package com.bdg.homework.customCollections.MyLinkedList;

import java.util.*;

public class CustomLinkedList<E> implements List<E>
{
	private Node headNode;
	private Node tailNode;
	private int size = 0;
 
	
	public CustomLinkedList()
	{
		headNode = null;
		tailNode = null;
	}
	
	@Override
	public boolean add(E e)
	{
		Node new_Node = new Node(e);
		if (headNode == null)
		{
			headNode = new_Node;
			
		}
		else
		{
			tailNode.next = new_Node;
			new_Node.prev = tailNode;
		}
		tailNode = new_Node;
		size++;
		return true;
		
	}
	
	
	public void addFirst(E element)
	{
		Node new_node = new Node(element);
		new_node.next = headNode;
		new_node.prev = null;
		if (headNode != null)
		{
			headNode.prev = new_node;
			headNode      = new_node;
		}
		size++;
		
	}
	
	@Override
	public boolean remove(Object o)
	{
		Node removed_node = headNode;
		while (size-- > 0)
		{
			if (removed_node.data == o)
			{
				removed_node.prev.next = removed_node.next;
				removed_node.prev      = removed_node.prev.prev;
				removed_node.next      = null;
				removed_node.prev      = null;
				size--;
				return true;
			}
			removed_node = removed_node.next;
			
		}
		
		
		return false;
	}
	@Override
	public boolean contains(Object o)
	{
		Node current = headNode;
		
		while (size-- > 0)
		{
			if (current.data == o)
			{
				return true;
			}
			current = current.next;
		}
		
		
		return false;
	}
	
	@Override
	public E get(int index)
	{
		Node result = headNode;
		if (index == 0)
		{
			return (E) headNode.data;
		}
		while (index-- > 0)
		{
			result = result.next;
			
		}
		return (E) result.data;
		
		
	}
	@Override
	public void add(int index, E element)
	{
		Node new_node = new Node(element);
		Node temNode = headNode;
		int sum = 0;
		
		while (temNode.data == null)
		{
			
			if (sum == index)
			{
				new_node.next = new_node;
				
				
			}
			sum++;
			
			temNode = tailNode.next;
		}
	}
	
	public void print()
	{
		Node current = headNode;
		
		while (current != null)
		{
			System.out.println(current.data.toString());
			current = current.next;
		}
		
	}
	
	@Override
	public int size()
	{
		return size;
	}
	
	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}
	

	
	@Override
	public Iterator<E> iterator()
	{
		return null;
	}
	
	@Override
	public <T> T[] toArray(T[] a)
	{
		return null;
	}
	
	
	@Override
	public Object[] toArray()
	{
		return new Object[0];
	}
	
	
	@Override
	public boolean containsAll(Collection<?> c)
	{
		return false;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		return false;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends E> c)
	{
		return false;
	}
	
	@Override
	public boolean removeAll(Collection<?> c)
	{
		return false;
	}
	
	@Override
	public boolean retainAll(Collection<?> c)
	{
		return false;
	}
	
	@Override
	public void clear()
	{
	
	}
	
	
	@Override
	public E set(int index, E element)
	{
		return null;
	}
	
	@Override
	public E remove(int index)
	{
		return null;
	}
	
	@Override
	public int indexOf(Object o)
	{
		return 0;
	}
	
	@Override
	public int lastIndexOf(Object o)
	{
		return 0;
	}
	
	@Override
	public ListIterator<E> listIterator()
	{
		return null;
	}
	
	@Override
	public ListIterator<E> listIterator(int index)
	{
		return null;
	}
	
	@Override
	public List<E> subList(int fromIndex, int toIndex)
	{
		return null;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof CustomLinkedList)) return false;
		CustomLinkedList<?> that = (CustomLinkedList<?>) o;
		return size == that.size && Objects.equals(headNode, that.headNode) && Objects.equals(tailNode, that.tailNode);
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(headNode, tailNode, size);
	}
	
	
	static class Node
	{
		Node next;
		Node prev;
		Object data;
		
		public Node(Object data)
		{
			this.next = null;
			this.prev = null;
			this.data = data;
		}
		
	}
}

