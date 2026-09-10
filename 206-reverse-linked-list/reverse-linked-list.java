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

//iterative:

/*
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev=null;
        ListNode curr=head;
        ListNode next=curr; //if it will be next = curr.next then when while loop ends at curr=null, then while assigning next it will be null.next thus NullPTRException

        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
*/

//recursive:

class Solution{
    public ListNode reverseList(ListNode head){
        //Base case: 0 node / 1 node
        if(head==null||head.next==null){
            return head;
        }
        ListNode newh = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newh;
    }
}

