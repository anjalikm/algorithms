
public class Mergesort {
	int x[];
	int aux[];
	int N;
	public Mergesort(int a[]){
		x = a;
		aux = new int[a.length];
		N = a.length;
	}
	
	public void sort(){
		int i,   //index for the first subfile
		j,		 //index for the second subfile
		k,		 // index for the aux file
		u1,l1,u2,l2, //lower and upper bounds of 2 subfiles to be merged
		size;          // size of the subfiles starting with 1
		size = 1;
		
		while(size < N){
			//initialize lower index of the first file 
			l1 = 0;
			k = 0;
			while(l1 + size < N) {//check if there are 2 subfiles
				//compute remaining indices
				l2 = l1 + size;
				u1 = l2-1;
				u2 = (l2+size-1 < N) ? l2 + size -1 : N-1;
				
				//scan through the subfiles and merge into a sorted file -aux
				for(i = l1, j =l2; i <= u1 && j <= u2; k++){
					if(x[i] < x[j])
						aux[k] = x[i++];
					else
						aux[k] = x[j++];
				}
				// insert remaining portion of file
				for(; i<=u1;k++)
					aux[k] = x[i++];
				for(;j<=u2; k++)
					aux[k] = x[j++];
				
				//advance l1 to start of the next pair of subfile
				l1 = u2+1;
			}
			//copy remaining single file
			for(i = l1; k < N; i++)
				aux[k++] = x[i];
			
			//copy aux into array
			for(i = 0; i < N; i++)
				x[i] = aux[i];
			size = size * 2;
			}
			printarray();
		}
			
	public void printarray(){
		for(int i:x){
            System.out.print(i);
            System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] input = {24,2,45,20,56,75,2,56,99,53,12};
	        Mergesort sorter = new Mergesort(input);
	        sorter.sort();
	}

}
