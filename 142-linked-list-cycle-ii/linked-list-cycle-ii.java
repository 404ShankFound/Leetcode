/*
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){ // for straight chained list
            slow = slow.next;  
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){  // for straight chained list
            return null;
        }

        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;  // equivalent to return slow;
    }
}
*/
public class Solution {
public ListNode detectCycle(ListNode head) {
    HashSet<ListNode> set = new HashSet<>();

    while(head != null){
        if(set.contains(head)){
            return head;
        }

        set.add(head);
        head = head.next;
    }

    return null;
}}