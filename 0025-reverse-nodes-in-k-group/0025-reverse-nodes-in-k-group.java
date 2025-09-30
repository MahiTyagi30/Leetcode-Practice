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
    public static ListNode getKthNode(ListNode temp,int k){
        k--;
        while(k>0&&temp!=null){
            temp=temp.next;
            k--;
        }
        return temp;
    }
     public ListNode reverse(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
    ListNode temp=head;
       ListNode prevLast=null;
       while(temp!=null){
        ListNode kthNode=getKthNode(temp,k);
        if(kthNode==null){
            if(prevLast!=null){
                prevLast.next=temp;
                break;
            }

        }
        ListNode next=kthNode.next;
        kthNode.next=null;
        reverse(temp);
        if(temp==head){
            head=kthNode;
        }
        else{
            prevLast.next=kthNode;
        }

prevLast=temp;
temp=next;
       }
       return head;
    }
}