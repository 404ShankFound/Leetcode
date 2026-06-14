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

/*
Fast Size Retrieval:
The traversal or access in List and even the myList.size() method is also an O(1) operation. 
Java keeps track of the element count in an internal integer variable. It simply returns that number instantly without counting the items.
The LinkedList Exception:
The O(1) rule applies to ArrayList, which is the most common list type. 
However, if you are using a LinkedList, the time complexity depends on how it is built:Standard Java LinkedList: It takes O(1) time because Java uses a doubly-linked list that keeps a direct pointer to the last node.
Generic Linked Lists: If you were to write a basic singly-linked list yourself from scratch, finding the last element would require looping through every node, making it O(n) time.
*/

