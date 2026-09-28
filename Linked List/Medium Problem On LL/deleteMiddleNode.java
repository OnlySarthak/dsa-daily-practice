/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null)return null;
        
        ListNode i = head.next.next, preMid = head;
        int ctr = 1;

        while(i!=null){
            if(  ctr % 2 == 0  ){
                preMid = preMid.next;
            }
            i = i.next;
            ctr++;
        }

        preMid.next = preMid.next.next;
        return head;
    }
}