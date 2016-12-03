
public class MyBinHeap<Key extends Comparable <Key>> {

	/**
	 * @param args
	 */
	
	private Key pq[];
	private int N;
	
	public MyBinHeap(int capacity)
	{
		pq = ( Key[]) new Comparable[capacity +1];
		
	}
	public boolean isEmpty()
	{
		return (N == 0);
	}
	
	public void insert(Key key)
	{
		pq[++N] = key;
		swim(N);
	}
	
	private void swim(int k)
	{
		while(k > 1 && less(k/2,k)){
			exch(k,k/2);
			k = k / 2;
		}
		
	}
	public Key delMax()
	{
		Key keyMax = pq[1];
		exch(1,N);
		N--;
		pq[N+1] = null;
		sink(1);
		return keyMax;
	}
	private void sink(int k)
	{
		while(k * 2 <= N)
		{
			int j = k * 2;
			if( j < N && less(j,j+1)) j++;
			if(!less(k, j)) break;
			exch(k,j);
			k = j;
		}
	}
	private void exch(int i, int j)
	{
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	private boolean less(int i, int j)
	{
		return (pq[i].compareTo(pq[j]) < 0);
	}
	public void display()
	{
		System.out.println();
		for(int i = 1; i <= N; i++)
			System.out.print(" "+pq[i]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyBinHeap heap1 = new MyBinHeap(8);
		heap1.insert(25);
		heap1.insert(57);
		heap1.insert(48);
		heap1.insert(37);
		heap1.insert(12);
		heap1.insert(92);
		heap1.insert(86);
		heap1.insert(33);
		heap1.display();
		System.out.println(heap1.delMax());
		heap1.display();
		System.out.println(heap1.delMax());
		heap1.display();
		

	}

}
