import java.util.*;
public class BSecondApproach {
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
      public static  int diameter2(Node root) {
            // base case 
           if(root == null){
            return 0;
           }
           // har node pr four values ko calc krna -> lh,ld , rh, rd
           int leftDiam = diameter2(root.left);  // diameter ko call
           int leftHt = height(root.left);  // height ko call  
           int rightDiam = diameter2(root.right);
           int rightHt = height(root.right);

           // ab hume self diameter calc krni hogi
           int selfDiam = leftHt + rightHt + 1;

           return Math.max(selfDiam, Math.max(leftDiam, rightDiam)); // yahn pehle left, right m max aayega then self m se max jo hoga wo return
     }
     static class Info {
        int diam;
        int ht;

        // constructor
        public Info(int diam, int ht) {
               this.diam = diam;
               this.ht = ht;
        }
     }
     public static Info diameter(Node root) {
        if(root == null){
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        // to calc diameter
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
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
         
        System.out.println(diameter(root).diam);  // yhn hum diam ki jagh ht ko bhi calc kr skte
    }
}
