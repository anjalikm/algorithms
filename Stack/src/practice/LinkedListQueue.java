package practice;

public class LinkedListQueue {
	
	private class Node {
		String item;
		Node next;
	}
	
	private Node first = null;
	private Node last = null;
	
	public boolean isEmpty(){
		return(first == null);
	}
	
	public void enqueue(String item)
	{
		Node oldLast = this.last;
		this.last = new Node();
		this.last.item = item;
		this.last.next = null;
		if(isEmpty())
			first = last;
		else
			oldLast.next = this.last;
	}
	
	public String dequeue()
	{
		String item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		return item;
			
	}
}
