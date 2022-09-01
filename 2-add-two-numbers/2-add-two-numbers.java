
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode head = new ListNode(-1);
        ListNode ptr = head;
        int carry = 0;
        while( (l1!=null || l2!=null) || carry!=0 ){
           int first = l1 == null ? 0 : l1.val;
            int second = l2 == null ? 0 : l2.val;
            int sum = first+second+carry;
            int curr = sum%10;
         // System.out.println(curr);
               carry = sum/10;
            ptr.next = new ListNode(curr);
            ptr = ptr.next;
            if(l1 !=null){
                l1 = l1.next;
            }if(l2!=null){
                l2 = l2.next;
            }
        }
        return head.next;
    } 
}