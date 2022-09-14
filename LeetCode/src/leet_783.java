class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
    	 this.val = val;
         this.left = left;
         this.right = right;
         }
 }

class Solution {
	int result = Integer.MAX_VALUE;
	Integer cmp = null;
    public int minDiffInBST(TreeNode root) {
        if(root.left != null)
        	minDiffInBST(root.left);
        if(cmp != null)
        	result = Math.min(result,root.val - cmp);
        cmp = root.val;
        if(root.right != null)
        	minDiffInBST(root.right);
        return result;
    }
}