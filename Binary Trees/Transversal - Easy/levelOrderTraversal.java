import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        
        if (root == null) {
            return ans;
        }
        ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        queue.add(root);
        
        while(!queue.isEmpty() ){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
           for(int i= 0; i < size; i++){
               TreeNode currentNode = queue.poll();
               
               if(currentNode.left != null){
                    queue.add(currentNode.left);
                    levelList.add(currentNode.left.val);
               }
               if(currentNode.right != null){
                   queue.add(currentNode.right);
                   levelList.add(currentNode.right.val);
               }
           }
           level++;
           if(!levelList.isEmpty()) {
               ans.add(levelList);
           }

        }

        return ans;
    }

}


public class levelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result); // Output: [[3], [9, 20], [15, 7]]
    }
}
