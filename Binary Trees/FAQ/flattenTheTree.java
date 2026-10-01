package Binary Trees.FAQ;

class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flattenGenerator(root);
    }

    public TreeNode flattenGenerator(TreeNode node){
        if(node.left == null && node.right == null){
            return node;
        }
        
        TreeNode leftEndNode = null;
        if(node.left != null){
            leftEndNode = flattenGenerator(node.left);
            leftEndNode.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        if(node.right != null){
            return flattenGenerator(node.right);
        }
        return leftEndNode;
    }
}
public class flattenTheTree {
    
}
