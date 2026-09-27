class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = null;
        ListNode head = null;
        int carry = 0;

        // Loop while BOTH have nodes
        while (l1 != null || l2 != null) {
            // Safely get values (0 if a list has run out of nodes)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = carry + val1 + val2;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }

            ListNode n = new ListNode(sum, null); 

            // Post-processing
            if (i == null) {
                i = n;
                head = n;
            } else {
                i.next = n;
                i = n;
            }

            // Safely advance pointers
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Final carry check at the very end (e.g., 5 + 5 = 10)
        if (carry > 0) {
            ListNode n = new ListNode(carry, null); 
            i.next = n;
        }

        return head;
    }
}

public class addTwoNumber {
    
}
