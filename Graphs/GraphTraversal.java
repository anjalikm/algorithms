package Graphs;

class GraphTraversal {
	
	private boolean []marked;
	private int [] edgeTo;
	private boolean [] markedBFS;
	private int[] edgeToBFS;
	
	GraphTraversal(Graph G){
		
		marked = new boolean [G.V()];
		edgeTo = new int[G.V()];
		markedBFS = new boolean[G.V()];
		edgeToBFS = new int[G.V()];
		
	}
	
	public void BreadthFirstSearch(Graph G, int s){
		
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		markedBFS[s] = true;
		System.out.print(s +"->");
		while(!q.isEmpty()){
			int v = q.dequeue();
			for(int w: G.adj(v)){
				if(!markedBFS[w]){
					q.enqueue(w);
					markedBFS[w] = true;
					System.out.print(w +"->");
					edgeToBFS[w] = v;
				}
			}
		}
		
	}
	public void dfs(Graph G, int v){
		marked[v] = true;
		System.out.println(v + "->");
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
				edgeTo[w] = v;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph(13);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(0, 6);
		G.addEdge(0, 5);
		G.addEdge(4, 6);
		G.addEdge(4, 5);
		G.addEdge(3, 5);
		G.addEdge(7, 8);
		G.addEdge(9, 10);
		G.addEdge(9, 11);
		G.addEdge(9, 12);
		G.addEdge(11,12);
		G.addEdge(3, 4);
		System.out.println("degree of vertex 0:" + G.degree(0));
		System.out.println("Number of edges:" + G.E()/2);
		System.out.println("Number of vertices:" + G.V());
		
		G.printGraph();
		GraphTraversal GS = new GraphTraversal(G);
		GS.dfs(G,0);
		
		System.out.println("breadth first search:");
		GS.BreadthFirstSearch(G, 0);

	}

}
