
import javax.swing.tree.TreeNode;

public class maxDepth {
    public int maxDepth(TreeNode root) {
        int cnt = 0;
        return maxDepthGenerator(root, cnt);
    }

    public int maxDepthGenerator(TreeNode root, int cnt) {
        if (root == null)
            return cnt;

        cnt++;
        int leftDepth = maxDepthGenerator(root.left, cnt);
        int rightDepth = maxDepthGenerator(root.right, cnt);

        return Math.max(leftDepth, rightDepth);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;

        if (p.val == q.val)
            return (isSameTree(p.left, q.left) == true && isSameTree(p.right, q.right) == true);
        // else part
        return false;
    }

    public boolean isBalanced(TreeNode root) {
        return (-1 != isBalancedChecker(root));
    }

    public int isBalancedChecker(TreeNode node) {
        if (node == null)
            return 0;

        int leftDepth = isBalancedChecker(node.left);
        int rightDepth = isBalancedChecker(node.right);

        if (leftDepth == -1 || rightDepth == -1)
            return -1;
        if (Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        diameterOfBinaryTreeGenerator(root);
        return maxDiameter;
    }

    public int diameterOfBinaryTreeGenerator(TreeNode node) {
        if (node == null)
            return 0;

        int leftDepth = diameterOfBinaryTreeGenerator(node.left);
        int rightDepth = diameterOfBinaryTreeGenerator(node.right);

        if (leftDepth + rightDepth > maxDiameter)
            maxDiameter = leftDepth + rightDepth;
        return Math.max(leftDepth, rightDepth) + 1;
    }

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumGenerator(root);
        return maxPathSum;
    }

    public int maxPathSumGenerator(TreeNode node) {
        if (node == null)
            return 0;

        // If the path sum from a child is negative, discard it by taking 0
        int leftDepthVal = Math.max(0, maxPathSumGenerator(node.left));
        int rightDepthVal = Math.max(0, maxPathSumGenerator(node.right));

        // Update the global maximum path sum
        if (leftDepthVal + rightDepthVal + node.val > maxPathSum) {
            maxPathSum = leftDepthVal + rightDepthVal + node.val;
        }

        // Return the maximum gain this node can add to its parent
        return (Math.max(leftDepthVal, rightDepthVal) + node.val);
    }
}
