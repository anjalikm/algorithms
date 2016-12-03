package Graphs;

import java.util.ArrayList;

public class WeightedEdgeGraph {
	private ArrayList<Edge>[] adj;
	private int V;
	public WeightedEdgeGraph(int v){
		this.V = v;
		for(int i = 0; i < v; i++){
			adj[i] = new ArrayList<Edge>();
		}
	}
	public int V(){
		return V;
	}
	public void addEdge(Edge e){
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}
	//return all the edges in graph
	public Iterable<Edge> edges(){
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 0 ;i < V; i++){
			edges.addAll(adj[i]);
		}
		return edges;
	}
	//return all the edges from vertex v 
	public Iterable<Edge> adj(int v){
		return adj[v];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
