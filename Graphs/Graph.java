package Graphs;

import java.util.ArrayList;
import java.util.Iterator;

class Graph {
	private int V;
	
	ArrayList []adj;
	
	public Graph(int v){
		this.V = v;
		this.adj =  new ArrayList[v];
		for(int i = 0 ; i < V; i++){
			adj[i] = new ArrayList<Integer>();
		}
	}
		
	public void addEdge(int v, int w){
			adj[v].add(w);
			adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public int degree(int v){
		int degree = 0;
		Iterable itr = adj(v);
		
		Iterator gItr = itr.iterator();
		
		while(gItr.hasNext()){
			gItr.next();
			degree++;
		}
		
		return degree;	
		
	}
	
	public int V(){
		return adj.length;
	}
	
	public int E(){
		int count = 0;
		for(ArrayList edge : adj){
			count = count + edge.size();
		}
		return count;
	}
	
	public void printGraph(){
		for(int v = 0 ; v < V(); v++){
			for(int w : adj(v)){
				System.out.println(w +" -- " + v);
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
		
		
	}

}
