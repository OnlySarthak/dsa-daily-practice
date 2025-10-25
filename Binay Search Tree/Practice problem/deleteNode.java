// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

public class deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        helper_deleteNode(root, root, key);
        return root;
    }

    public void helper_deleteNode(TreeNode curr, TreeNode prev, int key) {
        if (curr == null)
            return;

        if (curr.val == key) {
            TreeNode leftNode = curr.left;
            TreeNode rightNode = curr.right;

            // Handle root case (no previous node)
            if (prev == null) {
                // You’ll have to return new root instead in real delete() function
                System.out.println("Cannot delete root like this directly.");
                return;
            }

            //main part 

            // If we are left child
            if (prev.left == curr) {
                if (leftNode == null) {
                    prev.left = rightNode;
                    return;
                }
                prev.left = leftNode;
                TreeNode temp = leftNode;
                while (temp.right != null)
                    temp = temp.right;
                temp.right = rightNode;
                return;
            }

            // If we are right child
            if (prev.right == curr) {

                //if no left node exit, simply attach right node and done
                if (leftNode == null) {
                    prev.right = rightNode;
                    return;
                }


                prev.right = leftNode;
                TreeNode temp = leftNode;
                while (temp.right != null)  //reach last right node of left subtree
                    temp = temp.right;
                temp.right = rightNode;
                return;
            }
        }

        helper_deleteNode(curr.left, curr, key);
        helper_deleteNode(curr.right, curr, key);
    }

}