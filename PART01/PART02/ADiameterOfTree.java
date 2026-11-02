import java.util.*;

public class ADiameterOfTree {
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
     // make an height function 
     public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
     }
     // to calc diameter we need a function 
     public static  int diameter(Node root) {
            // base case 
           if(root == null){
            return 0;
           }
           // har node pr four values ko calc krna -> lh,ld , rh, rd
           int leftDiam = diameter(root.left);  // diameter ko call
           int leftHt = height(root.left);  // height ko call  
           int rightDiam = diameter(root.right);
           int rightHt = height(root.right);

           // ab hume self diameter calc krni hogi
           int selfDiam = leftHt + rightHt + 1;

           return Math.max(selfDiam, Math.max(leftDiam, rightDiam)); // yahn pehle left, right m max aayega then self m se max jo hoga wo return
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
         
        System.out.println(diameter(root));
    }
}
// here t.c is O(n^2) 
// hr node pr jana to linear time hi h but har node pr jate huye bar bar node ki height 2 baar calc kr rhe h to n nodes pr jake kr rhe isliye n*n
// har node pe to O(n)hi
// we use  2nd approach not this