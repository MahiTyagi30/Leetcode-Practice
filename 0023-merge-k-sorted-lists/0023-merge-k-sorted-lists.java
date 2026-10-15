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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        if(lists==null||lists.length==0){
            return null;
        }
        for(ListNode l:lists){
            if(l!=null){
                pq.add(l);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(!pq.isEmpty()){
            ListNode smallest=pq.poll();
            tail.next=smallest;
            tail=tail.next;
            if(smallest.next!=null){
                pq.add(smallest.next);
            }
        }
        return dummy.next;
        
    }
}