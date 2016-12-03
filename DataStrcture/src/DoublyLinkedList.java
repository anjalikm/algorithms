
public class DoublyLinkedList<Item> {
	private class Node<Item> {
		Item item;
		Node prev, next;
	}
	private Node first,last;
	public void DoublyLinkedList(){
		first = null;
		last = null;
	}
	
	private boolean isEmpty(){
		return (first == null);
	}
	public void push(Item item){
		Node<Item> newNode = new Node<Item>();
		newNode.item = item;
		if(isEmpty()){
			first = newNode;
			last = newNode;
			System.out.println("first node created");
		}
		else {
			newNode.next = first;
			newNode.prev = null;
			first.prev = newNode;
			first = newNode;
		}
				
	}
	
	public Item pop(){
		if(isEmpty()){
			System.out.println("list is empty");
			return null;
		}
		Item item = (Item)last.item;
		Node<Item>newLast;
		if(last.prev != null)
			newLast.prev = last.prev.prev;
			newLast.next = null;
		last = newLast;
		return item;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		//list.push("a");
		//list.push("b");
		//list.push("c");
		list.push("d");
		System.out.println(list.pop());
		//System.out.println(list.pop());
		//System.out.println(list.pop());
		//System.out.println(list.pop());
		//System.out.println(list.pop());
		
	}

}
