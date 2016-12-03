package Graphs;

import java.util.ArrayList;

class WeightedEdgeDigraph {
	private final int v;
	private ArrayList<DirectedEdge>[] adj;
	public WeightedEdgeDigraph(int v){System.out.println(v);;
		this.v = v;
		adj = new ArrayList[v];
		//adj[2] = new ArrayList<DirectedEdge>();
		for(int i = 0 ; i < v; i++){
			adj[i] = new ArrayList<DirectedEdge>();
		}
	}
	
	public int V(){
		return v;
	}
	
	public int E(){
		int count = 0;
		for(int i = 0 ;i < v; i++){
			count = count + adj[v].size();
		}
		return count;
	}
	
	public void AddEdge(DirectedEdge e){
		int v = e.from();
		adj[v].add(e);
	}
	
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeightedEdgeDigraph WG = new WeightedEdgeDigraph(8);
		WG.AddEdge(new DirectedEdge(0,1,5.0));
		WG.AddEdge(new DirectedEdge(0,4,9.0));
		WG.AddEdge(new DirectedEdge(0,7,8.0));
		WG.AddEdge(new DirectedEdge(1,2,12.0));
		WG.AddEdge(new DirectedEdge(1,3,15.0));
		WG.AddEdge(new DirectedEdge(1,7,4.0));
		WG.AddEdge(new DirectedEdge(2,3,3.0));
		WG.AddEdge(new DirectedEdge(2,6,11.0));
		WG.AddEdge(new DirectedEdge(3,6,9.0));
		WG.AddEdge(new DirectedEdge(4,5,4.0));
		WG.AddEdge(new DirectedEdge(4,6,20.0));
		WG.AddEdge(new DirectedEdge(4,7,5.0));
		WG.AddEdge(new DirectedEdge(5,2,1.0));
		WG.AddEdge(new DirectedEdge(5,6,13.0));
		WG.AddEdge(new DirectedEdge(7,5,6.0));
		WG.AddEdge(new DirectedEdge(7,2,7.0));
		
		for(int i = 0 ; i < WG.V(); i++){
			for(DirectedEdge de : WG.adj(i)){
				System.out.println(de.toString());
			}
		}
		
		

	}

}
