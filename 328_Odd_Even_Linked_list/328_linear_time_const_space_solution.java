class Solution {
    public ListNode oddEvenList(ListNode head) {
        boolean odd = true;
        ListNode curr = head;

        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode odd_head = head;
        ListNode even_head = head.next;
        curr = head.next.next;

        ListNode odd_curr = odd_head;
        ListNode even_curr = even_head;

        while(curr != null){
            if(odd){
                odd_curr.next = curr;
                odd_curr = odd_curr.next; 
            }
            else{
                even_curr.next = curr;
                even_curr = even_curr.next;
            }
            odd = !odd;
            curr = curr.next;

        }

        odd_curr.next = even_head;
        even_curr.next = null;
        
        return head;
    }
}