package Graphs;

class DirectedEdge {
	private int v;
	private final int w;
	private final double weight;
	
	public DirectedEdge(int v, int w, double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
		
	}
	public String toString(){
		return(v + "->" + w + " " + weight);
	}
	public int to(){
		return w;
	}
	public int from(){
		return v;
	}
	public double weight(){
		return weight;
	}
}
