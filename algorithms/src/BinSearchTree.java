
public class BinSearchTree< Key extends Comparable<Key>, Value> {

	/**
	 * @param args
	 */
	private Node root;
	private class Node {
		private Key key;
		private Value value;
		Node left,right;
		public Node(Key key, Value value){
			this.key = key;
			this.value = value;
		}
	}
	public void put(Key key, Value value)
	{
		root = put(root, key, value);
	}
	
	private Node put(Node node, Key key, Value value)
	{
		if(node == null){
			System.out.println("creating root");
			return new Node(key,value);
		}
		int cmp = key.compareTo(node.key);
		if(cmp < 0) {
			System.out.println("going to left");
			node.left = put(node.left, key, value);
			}
		else if(cmp > 0){
			System.out.println("going to right");
			node.right = put(node.right, key,value);
		}
		else 
			node.value = value;
		return node;
	}
	public void inorder()
	{
		inorder(root);
	}
	private void inorder(Node tree)
	{
		if(tree!= null){
			inorder(tree.left);
			System.out.println(tree.key);
			inorder(tree.right);
		}
		
	}
	public Key findMinKey()
	{
		Node node = root;
		Node p = null;
		while(node!= null){
			p = node;
			node = node.left;
		}
		if(p == null){
			System.out.println("tree is null");
			return null;
		}
		return p.key;
		
	}
	public void delete(Key key){
		// p => node to be deleted
		//rp => to that will replace the deleted nodep p
		//q => p' father
		
		//1. find the node to be deleted
		Node p = root;
		Node q = null;
		Node rp = null;
		Node f = null; //father of rp
		Node s = null; // left son of rp
		
		while(p !=null && p.key.equals(key)){
			q = p;
			int cmp = key.compareTo(p.key);
			if(cmp < 0)
				p = p.left;
			else
				p = p.right;
		}
		if( p ==null) // key not found
			return;
		
		//if found handle 3 cases
		//if p has a right son only
		if(p.left == null)
			rp = p.right;
		else if(p.right == null)
			rp = p.left;
		else { // p has right and left subtrees/sons
			//set rp to inorder successor of p as the inorder successor will be the min node in p's right subtree.
			 f = p;
			 rp = p.right;
			 s = rp.left;
			 while(s != null){
				 f = rp;
				 rp = s;
				 s = rp.left;
			 }
			 // now rp is inorder successor of p
			 if(f!=p) {
				 // replace rp with its right son
				 f.left = rp.right;
				 //point rp to p's right;
				 rp.right = p.right;
			 }
			 
			 
		}
		
		
			
		
	}
	private Node findMinNode(Node tree)
	{
		Node p = tree;
		Node q = null;
		if(tree == null)
			return null;
		while(p != null){
			q = p;
			p = p.left;
		}
		return q;
			
		
	}
	public Value get(Key key)
	{
		Node node = root;
		while(node != null){
			int cmp = key.compareTo(node.key);
			if(cmp < 0)
				node = node.left;
			else if(cmp > 0)
				node = node.right;
			else
				return node.value;
		}
		System.out.println("not found");
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinSearchTree BST = new BinSearchTree();
		System.out.println("min Key:"+BST.findMinKey());
		BST.put('A', 30);
		BST.put('Z', 10);
		BST.put('E', 90);
		BST.put('K', 60);
		BST.put('W', 33);
		BST.put('B', 12);
		BST.put('M', 56);
		BST.put('S', 77);
		BST.inorder();
		System.out.println("Z:"+BST.get('Z'));
		System.out.println("z:"+BST.get('z'));
		System.out.println("min Key:"+BST.findMinKey());
		
		
	}

}
