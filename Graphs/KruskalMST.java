package Graphs;

import java.util.PriorityQueue;

class KruskalMST {
	Queue<Edge> mst = new Queue<Edge>();
	public KruskalMST(WeightedEdgeGraph G){
		
		//insert all the edges of G in to a priority queue
		PriorityQueue<Edge> PQ = new PriorityQueue<Edge>(); 
		for( Edge edge : G.edges()){
			PQ.add(edge);
		}
		//mainina unionfind structure to track connected components
		UnionFind UF = new UnionFind(G.V());
		// remove the edges from priority queue in asceinding order 
		// and add that edge if it does not create a cycle in mst
		//any mst will have V-1 edges with total vertices V in graph
		while(!PQ.isEmpty() && mst.size() < G.V() -1 ){
			Edge e = PQ.remove();
			int v = e.either();
			int w = e.other(v);
			if(!UF.connected(v, w)){
				//if not creating a cycle
				UF.union(v, w);
				mst.enqueue(e);
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}

}
