class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // insert next prev
    Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    // insert next
    Node(int data, Node next) {
        this.data = data;
        this.prev = null;
        this.next = next;
    }
}

public class DoublyLinkedList {

    public static void main(String[] args) {
        int[] arr = { 11, 23, 24 };
        Node head = convertArr2DLL(arr, arr.length);

        Print(head);
        head = reverse2(head);
        Print(head);
    }

    private static Node reverse(Node head){
        if(head == null || head.next==null)return head;

        Node iterNode = head;

        while(iterNode != null){
            Node temp = iterNode.next;
            iterNode.next = iterNode.prev;
            iterNode.prev = temp;

            if(iterNode.prev == null)return iterNode;
            iterNode = iterNode.prev;
        }

        return head;
    }

    private static Node reverse2(Node head){        //by striver
        if(head == null || head.next==null)return head;

        Node iterNode = head, prev = null;

        while(iterNode != null){
            prev = iterNode.prev;

            iterNode.prev = iterNode.next;
            iterNode.next = prev;

            //go forward
            iterNode = iterNode.prev;
        }
        return prev.prev;
    }

    private static Node insertHead(Node head, int val) {
        Node newHead = new Node(val, head);
        if (head != null) head.prev = newHead;
        return newHead;
    }

    private static Node insertTail(Node head, int val) {
        if (head == null) return new Node(val);

        Node iterNode = head;
        while (iterNode.next != null)
            iterNode = iterNode.next;
        iterNode.next = new Node(val, iterNode, null);
        return head;
    }

    private static Node insertK(Node head, int k, int val) {
        if (head == null) {
            if (k == 1)
                return new Node(val);
            return null;
        }
        if (k == 1)
            return insertHead(head, val);

        // main logic
        Node iterNode = head;
        int ctr = 1;

        while (iterNode != null) {
            if ((ctr + 1) == k) {
                Node newNode = new Node(val, iterNode, iterNode.next);
                iterNode.next = newNode;
                if(newNode.next != null ) newNode.next.prev = newNode;
                break;
            }
            ctr++;
            iterNode = iterNode.next;
        }

        return head;
    }

    private static void Print(Node head) {
        if (head == null) {
            System.out.println("length is 0");
            return;
        }

        Node iterNode = head;
        int ctr = 0;

        while (iterNode != null) {
            ctr++;
            System.out.print(iterNode.data + " ");
            iterNode = iterNode.next;
        }
        System.out.println("length is " + ctr);
    }

    private static Node convertArr2DLL(int[] arr, int n) {
        if (n == 0)
            return null;

        Node head = new Node(arr[0]);

        Node iterNode = head;
        for (int i = 1; i < n; i++) {
            Node NewNode = new Node(arr[i], iterNode, null);
            iterNode.next = NewNode;
            iterNode = NewNode;
        }
        return head;
    }

    private static Node removeHead(Node head) {
        if (head == null)return null;
        if (head.next == null)return null; // only 1 node

        head = head.next;
        head.prev = null;
        return head;
    }

    private static Node removeTail(Node head) {
        if (head == null || head.next == null) return null;
        
        Node iterNode = head;
        while (iterNode.next != null) {     //go to last element
            iterNode = iterNode.next;
        }
        iterNode.prev.next = null;
        return head;
    }

    private static Node removerK(Node head, int k) {
        if (head == null)
            return head;
        if (k == 1) {
            return removeHead(head);
        }

        Node iterNode = head, prev = null;
        int cnt = 0;

        while (iterNode != null) {
            cnt++;
            if (cnt == k) {
                if(iterNode.next == null)return removeTail(head);

                Node next = iterNode.next;
                prev.next = next;
                if(next != null)next.prev = prev;

                return head;
            }
            prev = iterNode;
            iterNode = iterNode.next;
        }
        return head;
    }
}