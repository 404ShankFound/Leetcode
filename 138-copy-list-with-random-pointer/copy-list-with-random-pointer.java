class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;

        // Create copies
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        // Set next and random
        while (curr != null) {
            //NewNode.next = map.get(OldNode.next)
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}