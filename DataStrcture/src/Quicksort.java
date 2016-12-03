public class Quicksort{
	int[]array;
	
	public Quicksort(int x[]){
		this.array = x;
	}
	public void sort(int lb, int ub){
	
		if(lb>=ub)
			return; //array is sorted
		printarray();
		int j = partition(lb,ub);
		sort(lb,j-1);
		sort(j+1,ub);
	}
	public void printarray(){
		for(int i:array){
            System.out.print(i);
            System.out.print(" ");
		}
		System.out.println();
	}
	public int partition(int lb, int ub){
		int j;
		int down = lb;
		int up = ub;
		int a = array[lb];
		while(down < up){
			while(array[down] <= a && down < ub)
				down++;
			while(array[up] > a)
				up--;
			if(down < up) {
				//interchange 
				int temp = array[down];
				array[down] = array[up];
				array[up] = temp;
			}
		}
		array[lb] = array[up];
		array[up] = a;
		j = up;
		
		return j;
	}
	public static void main(String []args){
		
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        Quicksort sorter = new Quicksort(input);
        sorter.sort(0,input.length-1);
	}
}



 /*
public class Quicksort {
     
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
  /*          while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        printarray();
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private void printarray(){
    	 for(int i:array){
             System.out.print(i);
             System.out.print(" ");
    	 }
    	 System.out.println();
    }
    public static void main(String a[]){
         
        Quicksort sorter = new Quicksort();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        sorter.sort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
*/