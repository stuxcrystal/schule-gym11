package moe.encode.school.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * My linked list implementation.
 * @author Inf_Q11
 *
 * @param <E>
 */
public class MyLinkedList<E> implements List<E> {
	
	/**
	 * Data structure containing the data.
	 * @author Inf_Q11
	 *
	 * @param <E>
	 */
	private class Node<E> {
		E data;
		Node<E> prev;
		Node<E> next;
	}
	
	/**
	 * Contains the first node.
	 */
	Node<E> first = null;
	
	/**
	 * Contains the last node.
	 */
	Node<E> last = null;
	
	private Node<E> getNodeAt(int index) {
		int i = 0;
		Node<E> current = this.first;
		while (current != null) {
			if (i == index) {
				return current;
			}
			
			i++;
			current = current.next;
		}
		
		throw new ArrayIndexOutOfBoundsException(index);
	}
	
	private Node<E> insertNodeAt(Node<E> prev, E data) {
		Node<E> newNode = new Node<E>();
		newNode.data = data;
		newNode.prev = prev;

		// If prev is null, we assume that we insert at the start.
		if (prev == null) {
			if (this.last != null) {
				newNode.next = this.first;
			}
			
			this.first = newNode;
			
		// If not we insert the node at the given node.
		} else {
			newNode.next = prev.next;
			prev.next = newNode;
		}
		
		// If we insert the node at the end, add the new node to the list.
		if (this.last == prev) {
			this.last = newNode;
		}
		
		return newNode;
	}
	
	private void removeNode(Node<E> node) {
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if (prev != null) {
			prev.next = next;
		}
		if (next != null) {
			next.prev = prev;
		}
		
		if (this.first == node)
			this.first = next;
		if (this.last == node)
			this.last = prev;
	}

	@Override
	public boolean add(E arg0) {
		insertNodeAt(this.last, arg0);
		return true;
	}

	@Override
	public void add(int arg0, E arg1) {
		insertNodeAt(getNodeAt(arg0), arg1);
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		Node<E> cur = this.last;
		for (E elem : arg0){
			cur = insertNodeAt(cur, elem);
		}
		return true;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		Node<E> cur = getNodeAt(arg0);
		
		for (E elem : arg1){
			cur = insertNodeAt(cur, elem);
		}
		return true;
	}

	@Override
	public void clear() {
		this.first = null;
		this.last = null;
		
	}

	@Override
	public boolean contains(Object arg0) {
		return this.indexOf(arg0) != -1;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		for (Object elem : arg0)
			if (!this.contains(elem))
				return false;
		return true;
	}

	@Override
	public E get(int arg0) {
		return this.getNodeAt(arg0).data;
	}

	@Override
	public int indexOf(Object arg0) {
		int index = 0;
		for (E elem : this) {
			if (elem.equals(arg0))
				return index;
			index++;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return this.first == null;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		int index = -1;
		Node<E> cur = this.last;
		while (cur != null) {
			if (arg0.equals(cur.data))
				return this.size()-index;
			cur = cur.prev;
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		Node<E> cur = this.first;
		while (cur != null) {
			if (cur.data.equals(arg0)) {
				this.removeNode(cur);
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	@Override
	public E remove(int arg0) {
		Node<E> rem;
		this.removeNode(rem = this.getNodeAt(arg0));
		return rem.data;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		Node<E> cur = this.first;
		
		while (cur != null) {
			if (arg0.contains(cur.data))
				this.removeNode(cur);
			cur = cur.next;
		}
		
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		int sz = 0;
		Node<E> cur = this.first
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
