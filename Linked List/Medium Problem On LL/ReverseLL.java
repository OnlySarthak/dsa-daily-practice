import java.util.Stack;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    // insert before head
    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

public class ReverseLL {
    private ListNode newHead; // make it instance-level, not static

    public static ListNode reverseList3(ListNode currNode) {
        // recursive way...by me

        // base case
        if (currNode.next.next == null) { // reverse last two nodes and send last node as head
            currNode.next.next = currNode;
            ListNode lastNode = currNode.next;
            currNode.next = null;
            return lastNode;
        }

        // get last node as a head
        ListNode lastNode = reverseList3(currNode.next);
        ListNode iterNode = lastNode;

        // iter till last node as a head till to tail
        while (iterNode.next != null)
            iterNode = iterNode.next;

        // update tail and joint last node as a last tail node
        currNode.next = null;
        iterNode.next = currNode;

        // return last node as a head
        return lastNode;
    }

    public static ListNode reverseList2(ListNode currNode, ListNode prevNode) {
        // recursive way...by me
        if (currNode.next == null) {
            currNode.next = prevNode;
            return currNode;
        }

        ListNode lastNode = reverseList2(currNode.next, currNode);

        currNode.next = prevNode;

        return lastNode;
    }

    // helper to print a list from a node
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test 1: 1 -> 2 -> 3
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        System.out.print("Original list: ");
        printList(n1);

        // ListNode returned = reverseList2(n1, null);

        System.out.print("Returned node as head: ");
        printList(reverseList3(n1));

    }

    private ListNode engine(ListNode node) {
        if (node.next.next == null) {
            // store new reversed list head in somewhere(in global variable)
            newHead = node.next;
            node.next.next = node;
            return node;
        }
        ListNode nextNode = engine(node.next);
        nextNode.next = node;
        return node;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode lastNode = engine(head);
        lastNode.next = null;
        return newHead;
    }

    public ListNode reverseList0(ListNode head) { // brute forse | stack based
        if (head == null || head.next == null)
            return head;

        ListNode iterNode = head;
        Stack<Integer> s = new Stack<>();

        while (iterNode != null) {
            s.push(iterNode.data);
            iterNode = iterNode.next;
        }

        iterNode = head;
        while (iterNode != null) {
            iterNode.data = s.pop();
            iterNode = iterNode.next;
        }

        return head;
    }

    public static ListNode reverseList4(ListNode head) {
        //standard soln | by striver
        // base case: empty or single node
        if (head == null || head.next == null)
            return head;

        // reverse rest of the list
        ListNode newHead = reverseList(head.next);

        // current node's next should point back to current
        head.next.next = head;
        head.next = null;

        return newHead;
    }

}