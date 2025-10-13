class BST {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) { //iterative
            while (root != null && root.val != val) {
                root = val < root.val ? root.left : root.right;
            }
            return root;
        }
    }

    public TreeNode searchBST1(TreeNode root, int val) {    //recursive
        if (root == null || root.val == val) {  
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
