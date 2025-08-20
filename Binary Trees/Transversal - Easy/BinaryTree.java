import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public Node(int data, Node right){
        this.data = data;
        this.left = null;
        this.right = right;
    }
    public Node(Node left, int data){
        this.data = data;
        this.left = left;
        this.right = null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(11);
        
        root.left = new Node(13);
        root.right = new Node(14);

        root.left.left = new Node(15);

        // System.out.println("preorder :");
        // preorderTransverse(root);
        // System.out.println("\n inorder :");
        // inorderTransverse(root);
        // System.out.println("\n postorder :");
        // postorderTransverse(root);

        System.out.println("level vise travelsal");
        levelOrderTraversel(root);
    }

    private static void levelOrderTraversel(Node root){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.println(currentNode.data);

            if(currentNode.left != null)queue.offer(currentNode.left);
            if(currentNode.right != null)queue.offer(currentNode.right);
        }
    }

    private static void inorderTransverse(Node node){
        if(node==null)return;

        preorderTransverse(node.left);

        System.out.print(node.data + " ");

        preorderTransverse(node.right);
    }
    private static void postorderTransverse(Node node){
        if(node==null)return;
        
        preorderTransverse(node.left);
        preorderTransverse(node.right);

        System.out.print(node.data + " ");
    }
    private static void preorderTransverse(Node node){
        if(node==null)return;

        System.out.print(node.data + " ");

        preorderTransverse(node.left);
        preorderTransverse(node.right);
    }
}
