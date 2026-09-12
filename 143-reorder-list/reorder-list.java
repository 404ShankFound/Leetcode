class Solution {
    public void reorderList(ListNode head) {
         if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;

        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        second = prev;

        ListNode first = head;

        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}
// class Solution {
//     private ListNode rev(ListNode head) {
//         ListNode prev = null;

//         while(head != null) {
//             ListNode temp = head.next;
//             head.next = prev;
//             prev = head;
//             head = temp;
//         }

//         return prev;
//     }

//     public void reorderList(ListNode head) {
//         if(head == null || head.next == null) {
//             return;
//         }

//         ListNode slow = head;
//         ListNode fast = head;

//         while(fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         ListNode head2 = slow.next;
//         slow.next = null;

//         head2 = rev(head2);

//         ListNode curr = head;
//         ListNode temp;

//         while(head2 != null) {
//             temp = curr.next;
//             curr.next = head2;
//             head2 = head2.next;
//             curr.next.next = temp;
//             curr = temp;
//         }
//     }
// }
// class Solution {
//     private ListNode rev(ListNode head) {
//         if(head == null || head.next == null) {
//             return head;
//         }

//         ListNode newHead = rev(head.next);
//         head.next.next = head;
//         head.next = null;

//         return newHead;
//     }

//     private ListNode aftermiddle(ListNode head) {
//         ListNode fast = head;
//         ListNode slow = head;

//         while(fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;
//         }

//         return slow.next;
//     }

//     public void reorderList(ListNode head) {
//         if(head == null || head.next == null || head.next.next == null) {
//             return;
//         }

//         ListNode head2 = aftermiddle(head);
//         ListNode mid = head;

//         while(mid.next != head2) {
//             mid = mid.next;
//         }

//         mid.next = null;

//         head2 = rev(head2);

//         ListNode curr = head;
//         ListNode temp;

//         while(head2 != null) {
//             temp = curr.next;
//             curr.next = head2;
//             head2 = head2.next;
//             curr.next.next = temp;
//             curr = temp;
//         }
//     }
// }