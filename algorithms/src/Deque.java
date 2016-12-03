import java.util.Iterator;
import java.util.NoSuchElementException;



public class Deque<Item> implements Iterable<Item> {
		private class Node{
			Item item;
			Node next;
			Node previous;
		}
		Node first, last;
		private int N;
		
		   public Deque()
		   {
			   // construct an empty deque
			   first = null;
			   N = 0;
		   }
		   
		   public boolean isEmpty()
		   {
			   // is the deque empty?
			   return (first == null);
		   }
		   
		   public int size()
		   { 
		   // return the number of items on the deque
			   return N;
		   }
		   public void addFirst(Item item)          // add the item to the front
		   {
			   checkNull(item);
			   
			   Node newfirst = new Node();
			   newfirst.item = item;
			   if(isEmpty()){
				   first = newfirst;
				   last = newfirst;
			   }
			   else{
				   first.previous = newfirst;
				   newfirst.next = first;
				   first = newfirst;
			   }
			   N++;
				   
		   }
			   
		   public void addLast(Item item)           // add the item to the end
		   {
			   checkNull(item);
			   Node newlast = new Node();
			   newlast.item = item;
			   if(isEmpty()){
				   last = newlast;
				   first = newlast;
			   }
			   else{
				   last.next = newlast;
				   newlast.previous = last;
				   last = newlast;
			   }
				 
			   N++;
		   }
		   public Item removeFirst()                // remove and return the item from the front
		   {
			   if(isEmpty())
				   throw new java.util.NoSuchElementException("empty deque");
			   Item item = first.item;
			   first = first.next;
			   
			   if(isEmpty())
				   last = null;
			   else
				   first.previous = null;   // if the new first is not null
			   N--;
			   return item;
			   
		   }
		   public Item removeLast()                 // remove and return the item from the end
		   {
			   if(isEmpty())
				   throw new java.util.NoSuchElementException("empty deque");
			   Item item = last.item;
			   //check if last is the only node in the deque
			   if(N == 1 ){
				   last = null;
				   first = null;
			   }
			   else{
				   last = last.previous;
				   last.next = null;
			   }
			   N--;
			   return item;
		   }
			   
		
	private void checkNull(Item item)
	{
		if (item == null)
			throw new java.lang.NullPointerException("null item");
		
	}
    // return an iterator over items in order from front to end
	  
	public Iterator<Item> iterator()  { return new ListIterator();  }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> d = new Deque<Integer>();
		d.addFirst(5);
		d.addFirst(4);
		d.addFirst(3);
		d.addFirst(2);
		d.addFirst(1);
		d.addLast(6);
		System.out.println("size:"+ d.size());
		d.addLast(7);
		d.addLast(8);
		d.addLast(9);
		d.addLast(10);
		System.out.println(d.removeFirst());
		System.out.println(d.removeFirst());
		System.out.println(d.removeFirst());
		System.out.println(d.removeFirst());
		System.out.println("size:"+ d.size());
		System.out.println(d.removeFirst());
		System.out.println(d.removeLast());
		System.out.println(d.removeLast());
		System.out.println(d.removeLast());
		System.out.println(d.removeLast());
		System.out.println(d.removeLast());
		System.out.println("size:"+ d.size());
		//System.out.println(d.removeFirst());
		
		Deque<String> d2 = new Deque<String>();
		d2.addFirst("Kalyan");
		d2.addLast("Anjali");
		d2.addFirst("Sid");
		d2.addFirst("Aditya");
		d2.addLast("Mihir");
		Iterator it1 = d2.iterator();
		for(String i : d2)
			System.out.println(i);
		System.out.println("Size:"+d2.size());
		System.out.println(d2.removeLast());
		System.out.println(d2.removeLast());
		for(String i : d2)
			System.out.println(i);
		System.out.println(d2.removeLast());
		System.out.println(d2.removeFirst());
		System.out.println(d2.removeLast());
		//System.out.println(d2.removeFirst());
		

		

	}

}
