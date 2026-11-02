
import java.util.*;

public class FTransformOfSumTree {  //O(n)
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
     public static int transform(Node root) {
        if(root == null) {
            return 0;
        }

       int leftChild =  transform(root.left);
       int rightChild = transform(root.right);

       int data = root.data; // root k left ka data tab milega jb wo null na ho
       

       int newLeft = root.left == null ? 0 : root.left.data; //null hai to 0 ho jaegi nhi to root k left k data k equal
       int newRight = root.right == null ? 0 : root.right.data;

       root.data = newLeft + leftChild + newRight + rightChild;// new left val + old left val  +  root right ki new right val +  root right ki old right val
       return data;
     }
     //preorder function
     public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
     }
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \  / \
            4  5  6  7  

            expected sum tree
             
                27
               /  \
              9    13
             / \   / \
            0  0  0   0
         */
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transform(root);
        preorder(root); // updated root

    }
}
