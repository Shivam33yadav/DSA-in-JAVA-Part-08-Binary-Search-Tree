import java.util.*;  // important 
public class DTopViewOfATree {  // check correction  ans should be 42137
     static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
             this.left = null;
             this.right = null;
        }
     }
     static class Info{
        Node node;
        int hd; // horizontal distance

        public Info(Node node, int hd) { // constructor
            this.node = node;
            this.hd = hd;

        }
     }
     public static void TopView(Node root) {
        //Level Order
        Queue<Info> q = new LinkedList<>(); // for level order traversal
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0)); //  by default root ka horiz dis 0 hi hota h
        q.add(null);

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else{
               if(!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
               }
               if(curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
               }
               if(curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd +1);
               }
            }

        }
        //print topview
        for(int i =0; i<=max; i++) {
                  System.out.println(map.get(i).data+" ");
        }
        System.out.println();

     }
    public static void main(String[] args) {
         /* 
                    1
                  /  \
                  2   3
                 / \  / \
                4  5  6  7 
        */
       Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        TopView(root);
         
    }
}
 