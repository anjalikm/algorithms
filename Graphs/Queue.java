package Graphs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> {
	Node first, last;
	int N;
	
	public Queue(){
		first = null; 
		last = null;
		N = 0;
	}
	
	public boolean isEmpty()
	{
		return(first == null);
	}
	
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		
		Node oldLast = last;
		last = new Node<Item>(item);
		// check if this is the first node to be inserted into the queue
		if(first == null)
			first = last;
		else
			//previous nodes existed in the queue
			oldLast.next = last;
		
		N++;
	}
	
	public Item dequeue(){
		if(isEmpty())  throw new NoSuchElementException("Queue underflow");
		Item item = (Item)first.item;
		first = first.next;
		//check if the removed item was the last one
		if(first == null)
			last = null;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator(){
		return new queueIterator(first);
	}
	private class Node<Item>{
		Item item;
		Node next;
		
		public Node(Item item){
			this.item = item;
			this.next = null;
		}
	}
	
	private class queueIterator<Item> implements Iterator<Item>{
		private Node<Item>current;
		
		public queueIterator(Node<Item> first){
			this.current = first;
		}
		
		public boolean hasNext(){
			return this.current != null;
		}
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
