public class BTSIterator {

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BSTIterator {
    private TreeNode current, lastLeft = null;

    public BSTIterator(TreeNode root) {
        BTSIteratorHelper(root);
        while (root.left != null) {
            root = root.left;
        }
        current = root;
    }

    private void BTSIteratorHelper(TreeNode node) {
        if (node == null)
            return;
        TreeNode predecessor = node.left;
        if (predecessor != null) {
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }
            predecessor.right = node;
        }

        if (node.left != null)
            BTSIteratorHelper(node.left);
        if (node.right != null)
            BTSIteratorHelper(node.right);

        return;
    }

    public int next() {
        int val = current.val;
        if(current.left != null){
            current = current.left;
        }
        else if(checkIfRightMostPointerOfLeftNodeIsInLoop(TreeNode current)==true){         //if the left node's rightmost node's right pointer is null, then go left
            current = current.right;
        }
        else {
            //go right and then 
            //cut the left node's rightmost node's right pointer to null
            
            while (predecessor.right != null && predecessor.right != current) {
                predecessor = predecessor.right;
            }
            predecessor.right = null;

            current = current.right;
        }
        return val;
    }

    private boolean checkIfRightMostPointerOfLeftNodeIsInLoop(TreeNode node) {
        TreeNode predecessor = node.left;
        while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
        }
        if (predecessor.right == node) {
            return true;
        }
        return false;
    }
    private boolean cutRightMostPointerOfLeftNodeLoop(TreeNode node) {
        TreeNode predecessor = node.left;
        while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
        }
        if (predecessor.right == node) {
            predecessor.right = null;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return current != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
