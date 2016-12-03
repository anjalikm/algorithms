
public class ShortestPath {
	private final int INFINITY  = 100;
	private final int MAXNODES = 4;
	private final int MEMBER = 1;
	private final int NONMEMBER = 0;
	
	public int shortPath(int [][]weight,int s, int t, int precede[]){
		
		int [] distance = new int[MAXNODES]; // shortest distance to i from s 
		int [] perm = new int[MAXNODES];   // set of nodes whose minimal distance from s is known
		int current;  // the node most recently added to perm
		int smalldist, newdist,k,dc;
		//initialization - distance of all nodes from s is initialized to INIFINITY
		// all the nodes are NONMEMBER of perm
		for(int i = 0 ; i < MAXNODES; i++){
			distance[i] = INFINITY;
			perm[i] = NONMEMBER;
		}
		
		// node s is the starting node
		current = s;
		perm[s] = MEMBER;
		k = s; // to keep track of node with min dist path till k which becomes next current
		while(current != t) {
			smalldist = INFINITY;
			dc = distance[current];
			//recalculate min distance for all successor of current
			for(int i = 0; i < MAXNODES; i++){
				if(perm[i] == NONMEMBER){
					newdist = dc + weight[current][i];
					if(newdist < smalldist){
						smalldist = newdist;
						precede[i] = current;
					}
				}
				//determine shortest distance so far 
				if(distance[i] < smalldist){
					smalldist = distance[i];
					k = i;
				}
			}
			current = k;
			perm[current] = MEMBER;
		}
		return distance[t];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
