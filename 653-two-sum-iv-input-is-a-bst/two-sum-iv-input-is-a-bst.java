/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    boolean flag=true;
    public BSTIterator(TreeNode root,boolean flag) {
        this.flag=flag;
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp=st.pop();
        if(flag==true) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void pushAll(TreeNode node){

       while(node!=null){
        st.push(node);
        if(flag==false){
            
            node=node.right;
        }else{
              
              node=node.left;
        }
      
       }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        boolean flag=false;
        BSTIterator l=new BSTIterator(root,true);
        BSTIterator r=new BSTIterator(root,false);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==k){
                return true;
            }else if(i+j<k){
                i=l.next();
            }else{
                j=r.next();
            }
        }
        return false;





    }
}