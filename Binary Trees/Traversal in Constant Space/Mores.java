package Binary Trees.Traversal in Constant Space;

public class Mores {
    public static void morrisPreorderTraversal(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {   
                //no left, normal condition, preint curr then move to right
                System.out.print(current.val + " ");
                current = current.right;
            } 
            else {
                //has left, find the rightmost node of left subtree
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    //make current as right child of predecessor
                    predecessor.right = current;
                    System.out.print(current.val + " ");
                    current = current.left;     //move to the left..finish
                } 
                //left subtree is already visited, revert the changes
                else {
                    //we left predecessor at the rightmost node of left subtree
                    // and it was pointing to current
                    // so we need to revert it back to null and print current,  
                    predecessor.right = null;
                    current = current.right;    //move to the right
                }
            }
        }
    }
    public static void morrisInorderTraversal(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {   
                //no left, normal condition, preint curr then move to right
                System.out.print(current.val + " ");
                current = current.right;
            } 
            else {
                //has left, find the rightmost node of left subtree
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    //make current as right child of predecessor
                    predecessor.right = current;
                    current = current.left;     //move to the left..finish
                } 
                //left subtree is already visited, revert the changes
                else {
                    //we left predecessor at the rightmost node of left subtree
                    // and it was pointing to current
                    // so we need to revert it back to null and print current,  
                    predecessor.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;    //move to the right
                }
            }
        }
    }
}
