import java.util.NoSuchElementException;

public class linkedListStack<Item>{
	
	private  class Node<Item>{
		private Item item;
		private Node next;
	}
	
	private Node first;
	private int top;
	public linkedListStack(){
		first = null;
		top = 0;
	}
	
	public void push(Item item){
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		top++;
		
	}
	public Item pop(){
		Item item;
		if(isEmpty()){
			throw new NoSuchElementException("stack is empty");
		}
		else{
			item = (Item) first.item;
			first = first.next;
			top--;
		}
		return item;
	}
	private boolean isEmpty(){
		return(first == null);
	}
	
	public void printstack(){
		StringBuffer str = new StringBuffer();
		Node node = first;
		while(node != null){
			str = str.append(" " + node.item);
			node = node.next;
		}
		System.out.println("Stacke contais:"+str);
	}
	
	public static void main(String []args){
		linkedListStack<String> stack = new linkedListStack<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		stack.printstack();
		//stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		//System.out.println(stack.pop());
		//System.out.println(stack.pop());
		
	}
}
