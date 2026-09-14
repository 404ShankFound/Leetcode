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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minheap.add(lists[i]);
            }
        }
        while (!minheap.isEmpty()) {
            ListNode e = minheap.poll();
            curr.next = e;
            curr = curr.next;
            if (e.next != null) {
                minheap.add(e.next);
            }
        }
        return head.next;
    }
}