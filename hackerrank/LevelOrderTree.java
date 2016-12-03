 void LevelOrder(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
       ArrayList<Integer> visited = new ArrayList<Integer>();
       visited.add(root.data);
       System.out.print(root.data+" ");
       while(!q.isEmpty()){
           Node current = q.remove();
           ArrayList<Node> sons = new ArrayList<Node>();
           if(current.left != null)
             sons.add(current.left);
           if(current.right != null)
            sons.add(current.right);
           for(Node son : sons){
               if(!visited.contains(son.data)){
                   System.out.print(son.data+" ");
                   visited.add(son.data);
                   q.add(son);
               }
           }
           
       }
      
    }