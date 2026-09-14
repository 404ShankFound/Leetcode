class ListNode{
    int val;
    int key;
    ListNode next=null;
    ListNode prev=null;
    public ListNode(int key, int val){
        this.val = val;
        this.key = key;
    }
}

class LRUCache {

    int cap;
    int cnt=0;
    Map<Integer,ListNode> map = new HashMap<>();
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        cap = capacity;
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void add(ListNode n){ // tail.prev --> n --> tail
        n.next = tail;
        n.prev = tail.prev;
        tail.prev.next = n;
        tail.prev = n;
    }

    public void remove(ListNode n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }    

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        ListNode n = map.get(key);
        int value = n.val;
        remove(n);
        add(n);
        return value;
    }
    
    public void put(int key, int value) {

        ListNode n = new ListNode(key,value);

        if(map.containsKey(key)){

            ListNode old = map.get(key);

            map.put(key,n);

            remove(old);
            add(n);

        }
        else{

            cnt++;

            if(cnt <= cap){

                map.put(key,n);
                add(n);

            }
            else{

                map.remove(head.next.key);
                remove(head.next);

                cnt--;

                map.put(key,n);
                add(n);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */