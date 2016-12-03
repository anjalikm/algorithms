package Graphs;

class Edge implements Comparable<Edge> {
	private int v;
	private int w;
	private int weight;
	public Edge(int v, int w, int weight){
		this.v = v;
		this.w= w;
		this.weight = weight;
	}
	
	public int other(int vertex){
		if(vertex == v) return w;
		return v;
		
	}
	
	public int either(){
		return v;
	}
	
	public int compareTo(Edge that){
		if(this.weight < that.weight) return -1;
		else if(this.weight > that.weight) return 1;
		else return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
