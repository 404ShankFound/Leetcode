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
    private ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(a != null && b != null) {
            if(a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if(a != null) {
            curr.next = a;
        } else {
            curr.next = b;
        }
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;

        while(n > 1) {
            int j = 0;
            for(int i = 0; i < n / 2; i++) {
                lists[j++] = merge(lists[i], lists[n - 1 - i]);
            }
            if(n % 2 != 0) {
                lists[j++] = lists[n / 2];
            }
            n = j;
        }
        return lists[0];
    }
}

/*
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
*/