import java.util.*;

import edu.princeton.cs.algs4.*;
public class Board {

		private int blocks[][];
		private int N;
		private int []blankPos = new int[2];
	    public Board(int[][] blocks) {
	    	// construct a board from an N-by-N array of blocks
	    	N = blocks.length;
	    	//System.out.println("N:"+N);
	    	this.blocks = new int [N][N];
	    	for(int i =0; i < N; i++){
	    		for(int j = 0; j < N; j++)
	    			this.blocks[i][j] = blocks[i][j];
	    	}
	    	
	    	
	    }
	    
	    private void getBlankPos(){
	    	for(int i = 0 ;i < N; i++)
	    		for(int j = 0; j < N ; j++){
	    			if(blocks[i][j] == 0){
	    				blankPos[0] = i;
	    				blankPos[1] = j;
	    				break;
	    			}
	    		}
	    }
	    
	    public int dimension(){   
	    	// board dimension N
	    	return N;
	    }
	    public int hamming() {                  // number of blocks out of place
	    	
	    	int hamming = 0;
	    	int index = 1;
	    	for(int i = 0; i < N; i++){
	    		for(int j = 0; j < N; j++){
	    			if(blocks[i][j] != index)
	    				hamming++;
	    			index++;
	    		}
	    	}
	    	//no calculation for blank square
	    	hamming--;
	    	return hamming;
	   
	    }
	    public int manhattan(){            // sum of Manhattan distances between blocks and goal
	    	int manhattan = 0;
	    	for(int i =0; i < N; i++){
	    		for(int j =0; j < N; j++){
	    			int value = blocks[i][j];
	    			if(value != 0) {
	    				int targetX = ( value - 1) / N;
	    				int targetY = (value -1) % N;
	    				int dx = targetX - i;
	    				int dy = targetY - j;
	    				manhattan = manhattan + Math.abs(dx)+ Math.abs(dy);
	    			}
	    		}
	    	}
	    	return manhattan;
	    }
	    public boolean isGoal()  {              // is this board the goal board?
	    	int number = 1;
	    	
	    	for(int i = 0; i < N ; i++){
	    		for(int j =0 ;j < N ; j++){
	    			if( i == N-1 && j == N-1){
	    				if(blocks[i][j] != 0)
	    				return false;
	    			}
	    			else
	    			{
	    				if(blocks[i][j] != number )
	    				return false;
	    			}
	    			number++;
	    		}
	    	}
	    	return true;		
	    		
	    }
	   // public Board twin()                    // a board that is obtained by exchanging any pair of blocks
	    public boolean equals(Object y){   
	    	// does this board equal y?
	    	if( y == null)
	    		return false;
	    	Board that = (Board)y;
	    	
	    	for(int i = 0; i < N; i ++){
	    		for(int j = 0; j < N; j++){
	    			if(this.blocks[i][j] != that.blocks[i][j]){
	    				return false;
	    			}
	    				
	    		}
	    	}
	    	return true;
	    		
	    }

	    public Iterable<Board> neighbors() {    // all neighboring boards
	    	
	    	getBlankPos();
	    	//System.out.println("Blank is at "+ blankPos[0] + " " +blankPos[1]);
	    	int [][] tempBlocks = new int[N][N]; 
	    	//System.out.println("neighbor:\n" + this.toString());
	    	ArrayList<Board> neighbors = new ArrayList<Board>();
	    	//copy the current block 
	    	for(int i = 0 ;i < N; i++)
	    		for(int j = 0 ; j < N; j++)
	    			tempBlocks[i][j] = this.blocks[i][j];
	    	// swap upper row element
	    	// neighbor 1
	    	
	    	int swapI = blankPos[0] - 1;
	    	if(swapI < N && swapI >= 0){
	    		//System.out.println("swpiing with upper  element");
	    		tempBlocks[blankPos[0]][blankPos[1]] = tempBlocks[swapI][blankPos[1]];
	    		tempBlocks[swapI][blankPos[1]] = 0;
	    		Board b = new Board(tempBlocks);
	    		neighbors.add(b);
	    		//swap back to current board
	    		tempBlocks[swapI][blankPos[1]] = tempBlocks[blankPos[0]][blankPos[1]];
	    		tempBlocks[blankPos[0]][blankPos[1]] = 0;
	        }
	    	//swap lower row element
	    	//neighbor 2
	    	
	    	swapI = blankPos[0] + 1;
	    	if(swapI < N && swapI >= 0){
	    		//System.out.println("swpiing with lower element");
	    		tempBlocks[blankPos[0]][blankPos[1]] = tempBlocks[swapI][blankPos[1]];
	    		tempBlocks[swapI][blankPos[1]] = 0;
	    		Board b = new Board(tempBlocks);
	    		//System.out.println(b.toString());
	    		neighbors.add(b);
	    		//swap back to current board
	    		tempBlocks[swapI][blankPos[1]] = tempBlocks[blankPos[0]][blankPos[1]];
	    		tempBlocks[blankPos[0]][blankPos[1]] = 0;
	    	}
	  
	    	//swap with left column element
	    	//neighbor 3
	    	int swapJ = blankPos[1] - 1;
	    	if(swapJ < N && swapJ >= 0){
	    		//System.out.println("swpiing with left  element");
	    		tempBlocks[blankPos[0]][blankPos[1]] = tempBlocks[blankPos[0]][swapJ];
	    		tempBlocks[blankPos[0]][swapJ] = 0;
	    		Board b = new Board(tempBlocks);
	    		//System.out.println(b.toString());
	    		neighbors.add(b);
	    		//System.out.println(b.toString());
	    		//swap back to current board
	    		tempBlocks[blankPos[0]][swapJ] = tempBlocks[blankPos[0]][blankPos[1]];
	    		tempBlocks[blankPos[0]][blankPos[1]] = 0;
	    	}
	    	
	    	//swap with right column element
	    	//neighbor4
	    	swapJ = blankPos[1] + 1;
	    	if(swapJ < N && swapJ >= 0){
	    		//System.out.println("swpiing with right  element");
	    		tempBlocks[blankPos[0]][blankPos[1]] = tempBlocks[blankPos[0]][swapJ];
	    		tempBlocks[blankPos[0]][swapJ] = 0;
	    		Board b = new Board(tempBlocks);
	    		//System.out.println(b.toString());
	    		neighbors.add(b);
	    		//System.out.println(b.toString());
	    		//swap back to current board
	    		tempBlocks[blankPos[0]][swapJ] = tempBlocks[blankPos[0]][blankPos[1]];
	    		tempBlocks[blankPos[0]][blankPos[1]] = 0;
	    	}
	    	//for(int i = 0 ; i < neighbors.size(); i++)
	    	//	System.out.println(neighbors.get(i).toString());
	    	return neighbors;
	    }
	    	
	   public String toString() {              // string representation of this board (in the output format specified below)
		 
			    StringBuilder s = new StringBuilder();
			    //s.append(N + "\n");
			    for (int i = 0; i < N; i++) {
			        for (int j = 0; j < N; j++) {
			            s.append(String.format("%2d ", blocks[i][j]));
			        }
			        s.append("\n");
			    }
			    return s.toString();
			}
	  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { {1,0,3},
						{4,2,6},
						{7,8,5}
		};
		Board initial = new Board(arr);
		System.out.println(initial.toString());
		System.out.println("hamming"+initial.hamming());
		System.out.println("man:"+initial.manhattan());
		Iterable<Board> cur_nbrs = initial.neighbors();
		Iterator<Board> itr = cur_nbrs.iterator();
		while(itr.hasNext()){
			Board b = itr.next();
			//System.out.println(b.toString());
		}
		 
	}

}
