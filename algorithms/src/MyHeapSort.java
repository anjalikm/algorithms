
public class MyHeapSort {

	/**
	 * @param args
	 */
	public static void sort(Comparable a[])
	{
		int N = a.length;
		for(int k = N/2; k >=1; k--)
			sink(a,k,N);
		while(N > 1)
		{
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
	private static void sink(Comparable []a, int k, int N)
	{
		while( k * 2 <= N){
			int j = k * 2;
			if( j < N && less(a,j,j+1)) j++;
			if(!less(a,k ,j)) break;
			exch(a,k,j);
			k = j;
		}
			
	}
	private static boolean less(Comparable[]a, int i, int j){
		return(a[i-1].compareTo(a[j-1]) < 0);
	}
	
	private static void exch(Comparable[]a, int i, int j)
	{
		Comparable t = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = t;
	}

	public static void display(Comparable[]a)
	{
		System.out.println();
		for(int i = 0; i < a.length; i++)
			System.out.print(" " + a[i]);
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable a[] = {25,27,48,37,12,92,86,33};
		MyHeapSort.sort(a);
		MyHeapSort.display(a);

	}

}
