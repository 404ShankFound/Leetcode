// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */

//SPACE OPTIMISED APPROACH: O(1) SPACE AND O(n+m) time complexity
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return head.next;
    }
}

// O(n+m) SPACE AND O(n+m) time complexity
//class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode head = new ListNode(0);
//         ListNode curr = head;
//         if (list1 == null) {
//             if (list2 == null) {
//                 return null;
//             }
//             return list2;
//         }
//         if (list2 == null) {
//             return list1;
//         }
//         while (list1 != null && list2 != null) {
//             if (list1.val < list2.val) {
//                 curr.next = new ListNode(list1.val);
//                 list1 = list1.next;
//             } else {
//                 curr.next = new ListNode(list2.val);
//                 list2 = list2.next;
//             }
//             curr = curr.next;

//         }
//         if (list1 == null) {
//             curr.next = list2;
//         } else {
//             curr.next = list1;
//         }
//         return head.next;
//     }
// }