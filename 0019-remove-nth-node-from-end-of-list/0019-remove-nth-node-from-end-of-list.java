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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if (head == null) return null;
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
          if (n == size) {
            return head.next;
        }
        int a=size-n+1;
            int i=1;
        ListNode curr=head;
        while(i<a-1){
            curr=curr.next;
            i++;
        }
        
        if(curr==null){
            head=head.next;
            return head;
        }
        else{
                    curr.next = curr.next.next;
        return head;
        }

    }
}