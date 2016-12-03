
public class MySelectionSort {

	public static void sort(Comparable[] a)
	{
		int N = a.length;
		int ex = 0;
		for(int i = 0; i < N; i++)
		{
			int min = i;
			for(int j = i+1; j < N; j++)
				if(less(a[j], a[min]))
					min = j;
			exch(a, i, min);
			for(int k = 0 ; k < N; k ++)
				System.out.print(a[k]+" ");
			System.out.println();
		}
		
		//for(int i = 0 ; i < N; i++)
			//System.out.println(a[i]);
			
	}
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[]a, int i , int j)
	{
		Comparable temp = a[i];
		//System.out.println(":" +temp);
		a[i] = a[j];
		
		a[j] = temp;
	}

}
