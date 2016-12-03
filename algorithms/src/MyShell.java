
public class MyShell {
	
	public static void sort(Comparable[]a)
	{
		int N = a.length;
		int h = 1;
		while(h<N/3) h = 3*h+1;
		while(h >= 1)
		{
			//h-sort the array
			for(int i = h ;i < N; i++)
			{
				for(int j = i; j >= h && less(a[j],a[j-h]); j = j -h )
					exch(a, j , j-h);
			}
			h = h /3;
		}
		for(int i = 0; i < N; i++)
			System.out.println(a[i]);
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[]a, int i , int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = a[i];
	}

}
