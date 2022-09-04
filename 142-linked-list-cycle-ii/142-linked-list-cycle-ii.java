/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // find the intersection
        ListNode p=cycle(head);
        if(p==null)return null;
        ListNode curr=head;
        while(curr!=p){// calculating the distance by moving both pointers forward
            p=p.next;
            curr=curr.next;
        }
        return p;
    }
    public ListNode cycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return slow;
            }
        }
        return null;
    }
}