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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||left==right){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode bl=dummy;
          int i=1;
          
          while(dummy!=null&&i<left){
           bl=bl.next;
            i++;      
          }
        
           ListNode prev = null;
        ListNode curr = bl.next;
        // int c=right-left;
        // int j=0;

         for (int j = left; j <= right; j++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode start=bl.next;
        bl.next=prev;
        start.next=curr;
        return dummy.next;

    }
}