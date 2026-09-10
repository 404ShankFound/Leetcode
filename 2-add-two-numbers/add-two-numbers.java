class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            //carry!=0 

            //If nothing is there to add i.e. both the numbers have ended but we still have carry
            //We must not miss that therefore, carry!=0
            
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            //If in this iteration both LL were null and only carry was there, then carry = (single_digit)/10 = 0 so for next iteration, carry = 0 so then while loop ends
        }
        return head.next;
    }
}
/*
class Solution {
    private int reverse(int num) {
        int r = 0;
        while (num != 0) {
            r = r * 10 + num % 10;
            num /= 10;
        }
        return r;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;

        while (l1 != null) {
            n1 = n1 * 10 + l1.val;
            l1 = l1.next;
        }

        while (l2 != null) {
            n2 = n2 * 10 + l2.val;
            l2 = l2.next;
        }

        int sum = reverse(n1) + reverse(n2);

        ListNode head = new ListNode(0);
        ListNode curr = head;

        if (sum == 0)
            return head;

        while (sum > 0) {
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            sum /= 10;
        }

        return head.next;
    }
}

PROBLEM:
l1 = 9
l2 = 9,999,999,991
Therefore:
9 + 9,999,999,991
= 10,000,000,000
Problem : int overflow
Your original code eventually tries to represent:
10,000,000,000
But Java int can only hold:
-2,147,483,648 to 2,147,483,647
So it cannot represent 9,999,999,991 or 10,000,000,000.
*/
