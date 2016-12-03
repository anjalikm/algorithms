package practice;
public class Stack {
    private int MAX = 20;
    private int[] stack = new int[20];
    private int top = 0;
    
    public Stack()
    {
        //this.stack = stack;
        this.top = 0;
    }
    public boolean isEmpty(){
        if(this.top == 0)
        	return true;
        else
        	return false;
    }
    public void push(int item){
       
        this.stack[this.top] = item;
        System.out.println("pushed:"+ item);
        this.top++;
        System.out.println("stack has " + this.top + "items now");
    }
    
    public int pop(){
    	if(!isEmpty())
    	{
    		int item = this.stack[this.top-1];
    		this.top--;
    		return item;
    	}
    	else
    		return -1;
        
    }
    public void printStack()
    {
    	System.out.println("top"+ this.top);
    	for(int i = 0; i<=this.top-1; i++)
    		System.out.println(this.stack[i]);
    }

    
    public static void main(String args[]){
    	
       	
    	Stack stack = new Stack();
    	stack.printStack();
    	stack.push(10);
    	stack.push(20);
    	stack.push(30);
    	stack.push(40);
    	
    	stack.printStack();
    	System.out.println(stack.pop());
    	stack.printStack();
    	
}
}