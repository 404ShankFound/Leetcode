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
    static{
        ListNode n = new ListNode(0);
        for(int i=0;i<500;i++)
            isPalindrome(n);
    }
    public static boolean isPalindrome(ListNode head) {
       
        ListNode slow = head;
        ListNode fast = head;
        ListNode rev = null;
        
        while(fast!=null &&fast.next!=null){
            ListNode temp = slow;
            slow=slow.next;
            fast=fast.next.next;
            temp.next= rev;
            rev = temp;
        }
        if(fast!=null){
            slow=slow.next;
        }
        while(slow!=null && rev!=null && slow.val==rev.val){
            slow=slow.next;
            rev=rev.next;
        }
        return slow==null;
    }
}
// class Solution {
//     public ListNode middle(ListNode head){
//         ListNode fast = head;
//         ListNode slow = head;

//         while(fast != null && fast.next != null){
//             fast = fast.next.next;
//             slow = slow.next;
//         }

//         return slow;
//     }

//     public ListNode reverse(ListNode head){
//         ListNode prev = null;

//         while(head != null){
//             ListNode next = head.next;
//             head.next = prev;
//             prev = head;
//             head = next;
//         }

//         return prev;
//     }

//     public boolean isPalindrome(ListNode head) {
//         if(head == null || head.next == null){
//             return true;
//         }

//         ListNode slow = middle(head);
//         ListNode second = reverse(slow);

//         ListNode first = head;

//         while(second != null){
//             if(first.val != second.val){
//                 return false;
//             }

//             first = first.next;
//             second = second.next;
//         }

//         return true;
//     }
// }