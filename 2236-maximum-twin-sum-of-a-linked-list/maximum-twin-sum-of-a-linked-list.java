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
    public int pairSum(ListNode head) {
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        // Step 3: Calculate the maximum twin sum
        int max = 0;
        ListNode firstHalf = head;
        ListNode secondHalf = prev; // This is now the head of the reversed second half
        
        while (secondHalf != null) {
            int sum = firstHalf.val + secondHalf.val;
            max = Math.max(max, sum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return max;
    }
}
/*
class Solution {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr=head;
        int n = 0;
        while(curr!=null){
            n++;
            list.add(curr.val);
            curr=curr.next;
        }
        int sum=0;
        int max=0;
        for(int i=0; i<=(n/2-1); i++){
            sum=list.get(i)+list.get(n-1-i);
            max=Math.max(sum,max);
        }
        return max;
    }
}

The two-pointer method beats the ArrayList method due to three main hidden bottlenecks:1. The Cost of Dynamic Resizing (The Biggest Culprit)When you create List<Integer> list = new ArrayList<>();, Java creates a small internal array with a default size (usually room for just 10 elements).As your while loop runs and adds thousands of items, that small array fills up.When it gets full, Java has to pause your code, create a brand-new, larger array, copy every single item from the old array into the new one, and then delete the old one.This dynamic resizing and data copying happens multiple times for large inputs, slowing your runtime significantly.2. Auto-Boxing (Object Overhead)Your linked list stores primitive numbers (ListNode.val is an int). However, a Java ArrayList cannot hold primitives; it can only hold objects.When you call list.add(curr.val), Java silently converts your lightweight int into a heavy Integer object. This hidden process is called auto-boxing.Creating thousands of new Integer objects on the fly wastes precious CPU cycles.The two-pointer method bypasses this entirely because it reads the raw int values directly from the nodes without creating any objects.3. Garbage CollectionBecause the ArrayList version allocates a lot of memory for the list and all those boxed Integer objects, it leaves behind a massive trail of temporary data.Java's Garbage Collector has to actively jump in, pause or throttle your program, and clean up that deleted memory.The two-pointer method uses \(O(1)\) auxiliary space. It uses almost zero extra memory, meaning the Garbage Collector has absolutely nothing to clean up
*/

/*
Fast Size Retrieval:
The traversal or access in List and even the myList.size() method is also an O(1) operation. 
Java keeps track of the element count in an internal integer variable. It simply returns that number instantly without counting the items.
The LinkedList Exception:
The O(1) rule applies to ArrayList, which is the most common list type. 
However, if you are using a LinkedList, the time complexity depends on how it is built:Standard Java LinkedList: It takes O(1) time because Java uses a doubly-linked list that keeps a direct pointer to the last node.
Generic Linked Lists: If you were to write a basic singly-linked list yourself from scratch, finding the last element would require looping through every node, making it O(n) time.
*/

