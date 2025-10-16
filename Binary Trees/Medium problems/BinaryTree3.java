
import java.util.ArrayList;

public class BinaryTree3 {
    public boolean isSymmetric(TreeNode root) {
        return isListSymmetric(treeToList(root));
    }

    public static boolean isListSymmetric(ArrayList<Integer> list) {
        // Handle null or empty list immediately
        if (list == null || list.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = list.size() - 1;

        // Iterate until the pointers meet or cross
        while (left < right) {
            // Compare the elements at the two pointers
            if (!list.get(left).equals(list.get(right))) {
                // Mismatch found, it's not symmetrical
                return false;
            }

            // Move pointers inward
            left++;
            right--;
        }

        // If the loop completes, no mismatches were found
        return true;
    }

    public ArrayList<Integer> treeToList(TreeNode node) {
        // Initialize an empty list to hold the results of this subtree.
        ArrayList<Integer> result = new ArrayList<>();

        // Base case: If the current node is null, return the empty list.
        if (node == null) {
            return result;
        }

        // 1. Recursively process the LEFT subtree
        if (node.left != null) {
            // Add all elements from the left subtree's list to the current result list
            result.addAll(treeToList(node.left));
        }

        // 2. Process the ROOT node
        result.add(node.val);

        // 3. Recursively process the RIGHT subtree
        if (node.right != null) {
            // Add all elements from the right subtree's list to the current result list
            result.addAll(treeToList(node.right));
        }

        return result;
    }
}
