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
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
       ListNode t1=l1;
       ListNode t2=l2;
       int c=0;
       while(t1!=null||t2!=null||c==1){
        int s=0;
        if(t1!=null){
            s=s+t1.val;
            t1=t1.next;
        }
        if(t2!=null){
            s=s+t2.val;
            t2=t2.next;
        }
        s=s+c;
        c=s/10;
        ListNode nodee=new ListNode(s%10);
        temp.next =nodee;
        temp=temp.next;

       }
      return dummy.next;
    }
}