class Solution {
    public ListNode sortList(ListNode head) {
         if (head == null || head.next == null) {
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
         // Step 2: Sort each half recursively
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // Step 3: Merge two sorted halves
        return mergeTwoLists(l1, l2);

        
       
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode dummy = new ListNode(); 
        ListNode current = dummy;

        ListNode c1 = list1;
        ListNode c2 = list2;

        
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                current.next = c1;
                c1 = c1.next;
            } else {
                current.next = c2;
                c2 = c2.next;
            }
            current = current.next;
        }

       
        if (c1 != null) {
            current.next = c1;
        } else {
            current.next = c2;
        }

       
        return dummy.next;
        
    }
}