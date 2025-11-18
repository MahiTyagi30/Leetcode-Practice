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
       ListNode dummy=new ListNode();
         dummy.next=head;
         ListNode prev=dummy;
         ListNode bf=dummy.next;
         int i=1;
         while(i<left){
            prev=bf;
            bf=bf.next;
            i++;
         }
        ListNode start = bf;   // first node of sublist
    ListNode next = null;
    ListNode prevNode = null;

    // Reverse from left to right
    for (int j = 0; j <= right - left; j++) {
        next = bf.next;
        bf.next = prevNode;
        prevNode = bf;
        bf = next;
    }
         prev.next=prevNode;
         start.next=bf;
         
    return dummy.next;


    }
}