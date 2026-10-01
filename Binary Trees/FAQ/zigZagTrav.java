package Binary Trees.FAQ;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // Stack 1: For levels moving Left to Right
        Stack<TreeNode> currentLevel = new Stack<>();
        // Stack 2: For levels moving Right to Left
        Stack<TreeNode> nextLevel = new Stack<>();

        currentLevel.push(root);
        boolean isLeftToRight = true;

        while (!currentLevel.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            
            // Process all nodes currently in the active stack
            while (!currentLevel.isEmpty()) {
                TreeNode node = currentLevel.pop();
                levelValues.add(node.val);

                if (isLeftToRight) {
                    // Push Left first, then Right. 
                    // When popped from nextLevel, Right will come out first.
                    if (node.left != null) nextLevel.push(node.left);
                    if (node.right != null) nextLevel.push(node.right);
                } else {
                    // Push Right first, then Left.
                    // When popped from nextLevel, Left will come out first.
                    if (node.right != null) nextLevel.push(node.right);
                    if (node.left != null) nextLevel.push(node.left);
                }
            }

            result.add(levelValues);
            
            // Swap the stacks for the next level
            currentLevel = nextLevel;
            nextLevel = new Stack<>();
            
            // Flip the direction
            isLeftToRight = !isLeftToRight;
        }

        return result;
    }
}

public class zigZagTrav {
    
}
