
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;         // empty list is palindrome
        if(head.next == null) return true;    // single node is palindrome

        return (engine(head,head)==null)?false:true;
    }

    public ListNode engine(ListNode node, ListNode head){
        if(node.next == null){
            // System.out.println(node.val + " " + head.val);
            if(node.val == head.val)return head.next;
            return null;
        }
        ListNode oppositeNode = engine(node.next,head);
        if(oppositeNode == null)return null;
        
        if(node.val == oppositeNode.val){
            if(oppositeNode.next != null)return oppositeNode.next;
            return oppositeNode;
        }

        return null;
    }
    
}

public class checkPalindrom {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);

        Solution solution = new Solution();
        boolean isPalindrome = solution.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}


class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle using fast & slow pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half in-place
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // 3. Compare first half and reversed second half
        ListNode p1 = head, p2 = prev;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}