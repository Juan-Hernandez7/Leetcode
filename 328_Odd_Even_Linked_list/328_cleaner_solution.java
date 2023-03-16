//Still gas O(n) runtime and O(1) space
//However lines of code have been reduced
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode odd = head;

        ListNode even_head = head.next;
        ListNode even = even_head;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next; 
            even.next = odd.next;
            even = even.next;

        }

        odd.next = even_head;
        
        
        return head;
    }