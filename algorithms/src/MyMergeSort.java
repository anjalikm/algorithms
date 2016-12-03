
public class MyMergeSort {
	
	static Comparable[]aux;
	static int iteration = 0;

	private static void merge(Comparable[]a , Comparable[] aux, int low, int mid,int high)
	{
		for(int k = 0; k <= high; k++)
			aux[k] = a[k];
		
		int i = low, j = mid+1;
		for(int k = low ; k <= high; k++){
			if(i > mid) a[k] = aux[j++];
			else if(j> high) a[k] = aux[i++];
			else if(less(a[i],a[j])) a[k] = aux[i++];
			else a[k] = aux[j++];
			
		}
		for(int p = 0; p < a.length; p++)
			System.out.print(a[p] + " ");
		iteration++;
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}

	private static void sort(Comparable [] a, Comparable[] aux,int low, int high)
	{
		System.out.println("iteration:"+ iteration);
		
		
		if(high <= low) return;
		int mid = low +(high - low)/2;
		sort(a,aux,low,mid);
		sort(a,aux,mid+1,high);
		merge(a,aux,low,mid,high);
	}
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length];
		sort(a,aux, 0, a.length-1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable a[] = {93, 31 ,54 ,47, 22, 28, 65, 15 ,83 ,23, 79 ,74 };
		MyMergeSort.sort(a);
	}

}
