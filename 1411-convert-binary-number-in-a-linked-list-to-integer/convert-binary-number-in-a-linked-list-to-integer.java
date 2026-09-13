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
    public int getDecimalValue(ListNode head) {
        int num = 0;

        while(head != null){
            num = (num << 1) | head.val;
            head = head.next;
        }

        return num;
    }
}

/*
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public int getDecimalValue(ListNode head) {
        ListNode curr = reverse(head);
        int num = 0;
        int exp = 0;
        while (curr != null) {
            if (curr.val == 1) {
                num += Math.pow(2, exp);
            }
            exp++;
            curr = curr.next;
        }
        return num;
    }
}

class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;

        while(head != null){
            num = num * 2 + head.val;
            head = head.next;
        }

        return num;
    }
}
*/