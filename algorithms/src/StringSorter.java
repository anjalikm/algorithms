import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Out;
public class StringSorter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]a = {"anjali", "Kalyan","Aditya","Mihir","Siddhant","Mahajan"};
		//Insertion.sort(a);
		Comparable[]b = { 55, 52, 57, 22, 66, 62, 25, 36, 65, 75};
		//for(int i = 0 ; i < a.length; i++)
			//System.out.println(a[i]);
		MySelectionSort.sort(b);
		
	}

}
