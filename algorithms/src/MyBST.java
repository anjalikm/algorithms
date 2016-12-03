
public class MyBST< Key extends Comparable<Key>, Value>  {
	private Node root;
	
	private class Node {
		Key key;
		Value value;
		Node left,right;
		public Node(Key key, Value value){
			this.key = key;
			this.value = value;
			
		}
	}
		public void put(Key key, Value value){
			root = put(root,key,value);
		}
		
		private Node put(Node node, Key key, Value value){
			if(node == null){
				System.out.println("Creating the root..");
				return new Node(key,value);
			}
			int cmp = key.compareTo(node.key);
			if(cmp < 0){
				System.out.println("Going to left subtree");
				node.left = put(node.left,key,value);
			}
			else if(cmp > 0){
				System.out.println("going to right subtree");
				node.right = put(node.right,key,value);
			}
			else
				node.value = value;
			return node;
		}
		
		public void inorder(){
			inorder(root);
		}
		private void inorder(Node tree){
			if(tree!=null){
				inorder(tree.left);
				System.out.println(tree.key);
				inorder(tree.right);
			}
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBST bst = new MyBST();
		bst.put('A', 30);
		bst.put('Z', 10);
		bst.put('E', 90);
		bst.put('K', 60);
		bst.put('W', 33);
		bst.put('B', 12);
		bst.put('M', 56);
		bst.put('S', 77);
		bst.inorder();
		
	}

}
