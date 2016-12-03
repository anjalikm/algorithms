
public class ArrayQueue {
	private final int MAXSIZE = 5;
	int queue[] = new int[MAXSIZE];
	int rear, front;
	
	public void ArrayQueue(){
		rear = MAXSIZE -1 ;
		front = MAXSIZE - 1;
	}
	
	private boolean isEmpty(){
		return( rear == front);
	}
	
	public void insert(int item){
		if(rear == MAXSIZE -1)
			rear = 0;
		else
			rear++;
		//check for overflow
		if(rear == front){
			System.out.println("Overflow");
			return;
		}
		queue[rear] = item;
		return;
		
		
	}
	public void printQueue(){
		for(int i = 0 ; i < rear; i++){
			System.out.println(queue[i] + " ");
		}
	}
	public int remove(){
		if(isEmpty()){
			System.out.println("Queue underflow");
			return -1;
		}
		if(front == MAXSIZE -1)
			front = 0;
		else
			front++;
		return queue[front];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue q = new ArrayQueue();
		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.insert(4);
		q.printQueue();
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		
	}

}
