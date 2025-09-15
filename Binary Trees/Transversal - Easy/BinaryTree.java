import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        boolean letTest = false;
        
        root.left = new Node(13);
        root.right = new Node(14);
        root.left.left = new Node(15);

        inorderIterative2(root);
            // System.out.println("\n inorder :");
            // inorderTransverse(root);
            
            // System.out.println("\n inorder interative :");
            // inorderIterative(root);

        if(letTest)
        {
            System.out.println("preorder :");
            preorderTransverse(root);
            System.out.println("\n inorder :");
            inorderTransverse(root);
            System.out.println("\n postorder :");
            postorderTransverse(root);
            System.out.println("level vise travelsal");
            levelOrderTraversel(root);
        }

    }

    private static void levelOrderTraversel(Node root){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.println(currentNode.data);

            if(currentNode.left != null)queue.add(currentNode.left);
            if(currentNode.right != null)queue.add(currentNode.right);

        }
    }

    private static void preorderIterative(Node root){ 
        if (root == null) return;   // edge case

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            Node curr = st.pop();
            System.out.println(curr.data);

            // Push right child first so that left is processed first
        }
    }

    private static void inorderIterative2(Node root){ 
        if (root == null) return;   // edge case

        Stack<Node> st = new Stack<>();
        int last_printed = 0;
        st.push(root);

        while(!st.isEmpty()){
            Node curr = st.pop();
            // System.out.println(curr.data);
            if(curr.left == null && curr.right == null ){
                System.out.println(curr.data);
                last_printed = curr.data;

                // if(!st.isEmpty())System.out.println(st.pop().data);
            }
            else{
                if(curr.left.data == last_printed)System.out.println("test " +curr.data);
                else{
                    if(curr.right != null)st.push(curr.right);
                    st.push(curr);
                    if(curr.left != null ) st.push(curr.left); 
                    System.out.println("test 2 " + curr.left.data + " " + curr.data + " " + curr.right.data);      
                }
            }
        }
    }

    private static void inorderIterative(Node root){
        Stack<Node> st = new Stack<>();

        st.push(root);
        while(!st.isEmpty()){
            Node currentNode = st.pop();
            
            
            if(currentNode.right != null)st.push(currentNode.right);
            if(currentNode.left != null)st.push(currentNode.left);

            while(currentNode.left !=null){
                st.push(currentNode.right);
            }
            System.out.println(st.pop().data + " ");
            currentNode = st.pop();
            System.out.println(currentNode.data);  
            if(currentNode.right != null)st.push(currentNode.right);
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
