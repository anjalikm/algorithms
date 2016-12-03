import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;



public class Solver {
	private int MAX = 400;
	private int moves;
	private Board initial;
	private Board current;
	private PriorityQueue<Node> PQ;
	private Comparator<Node> comparator = new PriorityComparator();
    public Solver(Board initial)  {         // find a solution to the initial board (using the A* algorithm)
    	moves = 0;
    	
    	this.initial = initial;
    	this.current = initial;
    	PQ = new PriorityQueue<Node>(MAX,comparator);
    	//System.out.println(current.toString());
    	PQ.add(new Node(this.initial, initial.manhattan(), 0, null))	;
    	
    	//Node cur_node = PQ.poll();
    	//System.out.println("polled node:"+cur_node.gameBoard.toString());
    	//Iterable<Board> cur_nbrs = cur_node.gameBoard.neighbors();
		//Iterator<Board> itr = cur_nbrs.iterator();
		//while(itr.hasNext()){
		//	Board b = itr.next();
		//	System.out.println(b.toString());
		//}
    	solve();
    }
    private void solve()
    {
    	while(!current.isGoal()){
    	//for(int i = 0 ; i < 5; i++){
    		Node cur_search_node = PQ.remove();
    		current = cur_search_node.gameBoard;
    		System.out.println("Current search node:" + cur_search_node.moves);
    		System.out.println(current.toString());
    		int new_moves = cur_search_node.moves + 1;
    		int p = cur_search_node.priority;
    		Iterable<Board> cur_nbrs = current.neighbors();
    		Iterator<Board> itr = cur_nbrs.iterator();
    	
    		while(itr.hasNext()){
    			Board b = itr.next();
    			//System.out.println("Neighbors:");
    			if(!b.equals(cur_search_node.prevGameBoard)){
    				//System.out.println("manhattan:" + b.manhattan());
    				//System.out.println(b.toString());
    				PQ.offer(new Node(b,b.manhattan(),new_moves, current));
    			}
    		}
    	}
    	System.out.println("Found the anser!");
    }
    public  class PriorityComparator implements Comparator<Node> {
    	public int compare(Node n1, Node n2){
    		return((n1.priority + n1.moves) - (n2.priority+n2.moves));
    		//return (n2.priority - n1.priority);
    	}
    }
   private class Node {
   	Board gameBoard;
   	int priority;
   	int moves;
   	Board prevGameBoard;
   	 public Node(Board gb, int p,int m, Board pgb)
   	    {
   	    	gameBoard = gb;
   	    	priority = p;
   	    	moves = m;
   	    	prevGameBoard = pgb;
   	    			
   	    }
   }
   
   /* public boolean isSolvable()            // is the initial board solvable?
    public int moves()                     // min number of moves to solve initial board; -1 if unsolvable
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable*/
    public static void main(String[] args) { // solve a slider puzzle (given below)
    
    	int arr[][] = { {0,1,3},
    					{4,2,5},
    					{7,8,6}
    				};
    Board initial = new Board(arr);
    Solver solver = new Solver(initial);
    }
}
