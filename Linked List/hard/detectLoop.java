class Solution {
    public boolean hasCycle(ListNode head) {
         if (head == null || head.next == null) return false;

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;         // move 1 step
            hare = hare.next.next;           // move 2 steps

            if (tortoise == hare) {          // they meet -> cycle
                return true;
            }
        }

        return false;  // hare reached null -> no cycle
    }
}

class Solution2 { //length of loop
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next; // move 1 step
            hare = hare.next.next; // move 2 steps

            if (tortoise == hare) { // they meet -> cycle
                ListNode ptr1 = head;
                ListNode ptr2 = tortoise; // slow and fast met
                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1;
            }
        }

        return null; // hare reached null -> no cycle
    }
}