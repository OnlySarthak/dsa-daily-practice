import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(11);
        boolean letTest = false;

        root.left = new Node(13);
        root.right = new Node(14);
        root.left.left = new Node(15);

        root.right.right = new Node(16);
        root.right.right.right = new Node(17);

        if (letTest) {
            System.out.println("preorder :");
            preorderTransverse(root);
            System.out.println("\n inorder :");
            inorderTransverse(root);
            System.out.println("\n postorder :");
            postorderTransverse(root);
            System.out.println("\nlevel order :");
            levelOrderTraversel(root);
        }
    }

    private static int heightBFS(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int height = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes in this level
            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            height++; // after finishing one level
        }

        return height;
    }

    private static int height(Node node) {
        if (node == null)
            return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private static void postorderItertive(Node root) {
        if (root == null)
            return;

        Stack<Node> st = new Stack<>();
        Stack<Node> printingOrderStack = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();
            printingOrderStack.push(curr);

            if (curr.left != null)
                st.push(curr.left);
            if (curr.right != null)
                st.push(curr.right);
        }

        while (!printingOrderStack.isEmpty()) {
            System.out.println(printingOrderStack.pop().data);
        }
    }

    private static void levelOrderTraversel(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.data);

            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
    }

    private static void preorderIterative(Node root) {
        if (root == null)
            return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.println(curr.data);

            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);
        }
    }

    private static void inorderIterative(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.println(curr.data);
            curr = curr.right;
        }
    }

    private static void inorderTransverse(Node node) {
        if (node == null)
            return;
        inorderTransverse(node.left);
        System.out.print(node.data + " ");
        inorderTransverse(node.right);
    }

    private static void postorderTransverse(Node node) {
        if (node == null)
            return;
        postorderTransverse(node.left);
        postorderTransverse(node.right);
        System.out.print(node.data + " ");
    }

    private static void preorderTransverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorderTransverse(node.left);
        preorderTransverse(node.right);
    }
}
