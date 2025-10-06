import java.util.HashSet;

class ListNode {
    int data;
    ListNode next;

    ListNode(int d) {
        data = d;
        next = null;
    }
}

class loopInLL {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            // if we already saw this node, cycle exists
            if (visited.contains(temp)) {
                return true;
            }
            // add as visited
            visited.add(temp);

            temp = temp.next;
        }

        // reached end -> no cycle
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next; // move 1 step
            hare = hare.next.next; // move 2 steps

            if (tortoise == hare) { // they meet -> cycle
                return true;
            }
        }

        return false; // hare reached null -> no cycle
    }

    public static void main(String[] args) {

        // create list: 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // create cycle: tail (-4) points back to node with value 2
        head.next.next.next.next = head.next; // cycle at index 1

        // test
        boolean hasCycle = hasCycle2(head);
        System.out.println("Has cycle? " + hasCycle);
    }

    // detect loop starting point

    public ListNode detectCycleBrute(ListNode head) { // brute
        if (head == null || head.next == null)
            return null;

        // Step 1: detect cycle
        ListNode slow = head, fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle)
            return null;

        // Step 2: find cycle length
        int length = 1;
        ListNode temp = slow.next;
        while (temp != slow) {
            temp = temp.next;
            length++;
        }

        // Step 3: brute force each node
        ListNode curr = head;
        while (curr != null) {
            ListNode ptr = slow;
            int steps = 0;
            while (steps < length) {
                if (ptr == curr)
                    return curr; // cycle start
                ptr = ptr.next;
                steps++;
            }
            curr = curr.next;
        }

        return null; // shouldn’t happen
    }

    public static ListNode detectCycleBrute1(ListNode head) {   //optimal | only few changes in floyd's algo
        if (head == null || head.next == null)
            return null;

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {         
            tortoise = tortoise.next; // move 1 step
            hare = hare.next.next; // move 2 steps
            
            if (tortoise == hare) { 
                //only this is new part in floyd's tortoise and hare algo...
                ListNode ptr1 = head;
                ListNode ptr2 = tortoise; // slow and fast met
                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1;
                //ending of new part
            }
        }

        return null; 
    }

}