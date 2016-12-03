
public class linkedListQueue<Item> {
	
	private class Node<Item>{
		Item item;
		Node<Item> next;

	}
	Node<Item> first,last;
	private int N; //size of the queue
	public void linkedListQueue(){
		first = null;
		last = null;
		N = 0;
	}
//insert add the end
	public void enqueue(Item item){
		Node<Item> newNode = new Node<Item>();
		newNode.item = item;
		newNode.next = null;
		if(last == null){
			first = newNode;
		}
		else
			last.next = newNode;
		last = newNode;
	}
	
	public void dequeue(){
		Item item;
		if(isEmpty()){
			System.out.println("empty queue");
			return;
		}
		else
		{
			item = first.item;
			first = first.next;
			if(isEmpty()){
				last = null;
			}
			System.out.println("dequeued item:"+ item);
		}
	}
	public boolean isEmpty(){
		return (first == null);
	}
	public void printQueue(){
		Node<Item> current = first;
		StringBuffer str = new StringBuffer();
		while(current != null){
			str.append(current.item);
			current = current.next;
		}
		System.out.println("queue contents:"+ str.reverse());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedListQueue<String> queue = new linkedListQueue<String>();
		queue.printQueue();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}

}
