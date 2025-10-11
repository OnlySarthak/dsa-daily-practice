package Binary Trees.Medium problems;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTree2 {
    private static void verticalOrderTraversal(Node root) {
        if (root == null)
            return;

        HashMap<Integer, HashMap<Integer, ArrayList>> HM = new HashMap<>();

        verticalOrderTraversal(root, 0, 0, HM);

        
    }

    private static void verticalOrderTraversal1(Node node, int col, int row, 
        HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> hm) {

        if (node == null) return;

        hm.putIfAbsent(col, new HashMap<>());
        hm.get(col).putIfAbsent(row, new ArrayList<>());
        hm.get(col).get(row).add(node.data);

        verticalOrderTraversal1(node.left, col - 1, row + 1, hm);
        verticalOrderTraversal1(node.right, col + 1, row + 1, hm);
    }
}
