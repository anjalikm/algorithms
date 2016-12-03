package practice;

public class LinkedListStack {
	
	private class Node{
		String item;
		Node next;
	}
	private Node first;
	public LinkedListStack()
	{
		this.first = null;
	}
	public boolean isEmpty()
	{
		return(this.first == null);
	}
	public void push(String item)
	{
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	public String pop()
	{
		String item = first.item;
		first = first.next;
		return item;
	}
	public void printStack()
	{
		Node n = first;
	 while(n != null){
		 System.out.print(n.item +" ");
		 n = n.next;
	 }
	}
	
	public static void main(String args[])
	{
		LinkedListStack linkstack = new LinkedListStack();
		linkstack.push("first");
		linkstack.push("second");
		linkstack.push("third");
		linkstack.printStack();
		System.out.println("popped:"+linkstack.pop());
		linkstack.printStack();
		
	}
}
