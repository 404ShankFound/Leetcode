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
/*
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
    }
}
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt=0;
        if(head==null){
            return head;
        }

        ListNode prev, curr;
        curr = head;

        while(curr!=null){
            cnt++;
            curr = curr.next;
        }

        curr = head;
        prev = null;
        int count=0;

        while(count < cnt-n){
            prev = curr;
            curr = curr.next;
            count++;
        }

        if(prev==null){
            return head.next;
        }

        prev.next = curr.next;

        return head;
    }
}