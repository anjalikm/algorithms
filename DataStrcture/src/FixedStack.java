
public class FixedStack<Item>{
	
	private Item a[];
	private int max;
	private int top;
	public FixedStack(int capacity){
		 a = (Item[]) new Object[capacity];  
		top = 0;
		
	}
	
	public void push(Item item){
		if(isFull()){
			System.out.println("stack is full");
			return;
		}
		else
			a[top++] = item;
	}
	public Item pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		else
			return a[--top];
	}
	private boolean isEmpty(){
		return(top == 0);
	}
	private boolean isFull(){
		return(top == a.length);
	}
	public void printstack(){
		for(int i = top-1; i >=0; i--)
			System.out.println(a[i]);
	}
	
	public static void main(String []args){
		FixedStack<Integer> stack = new FixedStack<Integer>(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.printstack();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}
