package Graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

class DijkastraSP {
	private double[]distTo; // shortest known distance to vertex from source
	private DirectedEdge[]edgeTo; // last shorted edge to vertex which is on the shortest path
	private PriorityQueue<Item> PQ; // to choose the next vertex with min dist from source
	
	public DijkastraSP(WeightedEdgeDigraph WG, int s){
		distTo = new double[WG.V()];
		edgeTo = new DirectedEdge[WG.V()];
		
		PQ = new PriorityQueue<Item>(WG.V(),new WeightComparator());
		
		for(int i = 0 ; i < WG.V();i++){
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		PQ.add(new Item(s,0.0));
		
		while(!PQ.isEmpty()){
			Item item = PQ.remove();
			for(DirectedEdge de : WG.adj(item.vertex)){
				relax(de);
			}
			
		}
		
		
	}
	
	public void relax(DirectedEdge de){
		int v = de.from();
		int w = de.to();
		if(distTo[w] > distTo[v] + de.weight())
			distTo[w] = distTo[v] + de.weight();
		edgeTo[w] = de;
		//PQ.remove(new Item(w,distTo[w]));
		//PQ.add(new Item(w,))
	}
	private class Item {
		int vertex;
		double weight;
		
		public Item(int v, double w){
			this.vertex = v;
			this.weight = w;
		}
	}
	
	
	private class WeightComparator implements Comparator<Item>{

		@Override
		
		public int compare(Item current, Item that) {
		
		
			// TODO Auto-generated method stub
			if ((current.weight - that.weight) < 0.0)
				return 1;
			else if((current.weight - that.weight) > 0.0)
				return -1;
			else 
				return 0;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
