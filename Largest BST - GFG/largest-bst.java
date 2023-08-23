//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int ans;
    static int largestBst(Node root)
    { 
        if(root == null){
            return 0;
        }
        ans = 0;
        TreeNode temp = rec(root);
        return ans;
    }
    static TreeNode rec(Node root){
        if(root == null){
            return new TreeNode(new Node(-1) , Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        TreeNode left = rec(root.left);
        TreeNode right = rec(root.right);
        int min = left.max;
        int max = right.min;
        if(root.data > min && root.data < max){
            min = Math.min(left.min, root.data);
            max = Math.max(right.max, root.data);
            int count = left.count+right.count+1;
            ans = Math.max(ans, count);
            return new TreeNode(root, min, max, count);
        }else{
            return new TreeNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
    }
    
}
class TreeNode{
    Node node;
    int min;
    int max;
    int count;
    TreeNode(Node x, int y, int z, int k){
        node = x;
        min = y;
        max = z;
        count = k;
    }
}