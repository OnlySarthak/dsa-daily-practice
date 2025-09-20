import java.util.Stack;

public class ReverseLL {
    private ListNode newHead; // make it instance-level, not static

    private ListNode engine(ListNode node) {
        if (node.next.next == null) {
            newHead = node.next;
            node.next.next = node;
            return node;
        }
        ListNode nextNode = engine(node.next);
        nextNode.next = node;
        return node;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode lastNode = engine(head);
        lastNode.next = null;
        return newHead;
    }

    public ListNode reverseList0(ListNode head) {        //brute forse
        if(head == null || head.next ==  null)return head;

        ListNode iterNode = head;
        Stack<Integer> s = new Stack<>();

        while(iterNode != null){
            s.push(iterNode.val);
            iterNode = iterNode.next;
        }

        iterNode = head;
        while(iterNode != null){
            iterNode.val = s.pop();
            iterNode = iterNode.next;
        }

        return head; 
    }
}