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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first=head;
        for(int i=1;i<k;i++){
            first=first.next;
        }

        ListNode fast=first;
        ListNode slow=head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;

        }
        int temp = first.val;
        first.val = slow.val;
        slow.val = temp;

        return head;
       
        
    }
}