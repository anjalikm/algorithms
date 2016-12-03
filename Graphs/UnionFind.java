package Graphs;

public class UnionFind {
	private int[] id;
	private int N; // number of total elements
	private int count; // number of connected components
	
	public UnionFind(int n){
		id = new int[n];
		for(int i = 0 ; i < n; i++){
			id[i] = i;
		}
		N = n;
		count = N;
	}
	
	public int find(int p){
		return id[p];
	}
	
	public boolean connected(int p, int q){
		return(find(p) == find(q));
	}
	
	public void union(int p, int q){
		int pId = find(p);
		int qId = find(q);
		// if already in same component
		if(pId == qId) return;
		for(int i = 0 ; i < N; i++){
			if(id[i] == pId)
				id[i] = qId;
		}
		count--;
	}
	public void display(){
		for(int i = 0 ; i < N; i++){
			System.out.println(i +":" + id[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnionFind UF = new UnionFind(10);
		UF.display();
		UF.union(1, 2);
		UF.union(3,2);
		UF.display();
	}

}
