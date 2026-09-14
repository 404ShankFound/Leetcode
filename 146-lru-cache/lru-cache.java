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

// ================= LRU CACHE — MISTAKES TO REMEMBER =================
//
// 1. LRU needs BOTH:
//    HashMap + Doubly Linked List
//
//    HashMap → quickly find node using key → O(1)
//    DLL     → quickly remove/move node → O(1)
//
// ---------------------------------------------------------------
//
// 2. Node must store BOTH key and value.
//
//    key = identifier used in HashMap
//    val = actual cached value
//
//    Example:
//    put(10, 500)
//
//    Node:
//    key = 10
//    val = 500
//
//    IMPORTANT:
//    We need key while evicting:
//    map.remove(lru.key);
//
// ---------------------------------------------------------------
//
// 3. Use prev AND next.
//
//    Singly LL:
//    A → B → C
//
//    Not enough because removing B requires finding A.
//
//    Doubly LL:
//    A ⇄ B ⇄ C
//
//    Now B can be removed directly in O(1).
//
// ---------------------------------------------------------------
//
// 4. Use dummy HEAD and TAIL.
//
//    Initially:
//
//    HEAD ⇄ TAIL
//
//    HEAD.next = LRU
//    TAIL.prev = MRU
//
//    Our convention:
//
//    HEAD → LRU
//    TAIL → MRU
//
//    More precisely:
//    head.next = LRU node
//    tail.prev = MRU node
//
// ---------------------------------------------------------------
//
// 5. ADD always happens just BEFORE TAIL.
//
//    HEAD ⇄ A ⇄ B ⇄ TAIL
//
//    add(C)
//
//    HEAD ⇄ A ⇄ B ⇄ C ⇄ TAIL
//                         ↑
//                        MRU
//
//    So remember:
//
//    ADD  → TAIL
//    REMOVE → HEAD (when evicting)
//
// ---------------------------------------------------------------
//
// 6. Don't confuse TAIL with tail.prev.
//
//    tail itself is a dummy node.
//
//    Actual MRU = tail.prev
//
//    Actual LRU = head.next
//
// ---------------------------------------------------------------
//
// 7. add() looks complicated, but it only means:
//
//    oldLast ⇄ newNode ⇄ TAIL
//
//    Code:
//
//    n.prev = tail.prev;
//    n.next = tail;
//
//    tail.prev.next = n;
//    tail.prev = n;
//
//    Easier way to remember:
//
//    last = tail.prev;
//
//    last.next = n;
//    n.prev = last;
//    n.next = tail;
//    tail.prev = n;
//
// ---------------------------------------------------------------
//
// 8. remove() simply connects the neighbours.
//
//    BEFORE:
//
//    A ⇄ N ⇄ B
//
//    Code:
//
//    n.prev.next = n.next;
//    n.next.prev = n.prev;
//
//    AFTER:
//
//    A ⇄ B
//
// ---------------------------------------------------------------
//
// 9. get(key):
//
//    FIRST check if key exists.
//
//    if (!map.containsKey(key))
//        return -1;
//
//    Otherwise:
//
//    n = map.get(key);
//    value = n.val;
//
//    remove(n);
//    add(n);
//
//    return value;
//
//    WHY remove + add?
//
//    Because GET means the node was recently used,
//    so it becomes MRU.
//
// ---------------------------------------------------------------
//
// 10. Don't forget return -1.
//
//    map.get(key) can return null.
//
//    WRONG:
//
//    ListNode n = map.get(key);
//    int value = n.val;       // NullPointerException
//
//    CORRECT:
//
//    if (!map.containsKey(key))
//        return -1;
//
// ---------------------------------------------------------------
//
// 11. put(existing key, value):
//
//    Don't treat it as a completely new cache entry.
//
//    Example:
//
//    put(10, 500)
//    put(10, 700)
//
//    Size should remain the SAME.
//
//    Also 10 becomes MRU.
//
//    Logic:
//
//    old = map.get(key);
//    update value
//    remove(old)
//    add(old)
//
// ---------------------------------------------------------------
//
// 12. If creating a NEW node for an existing key:
//
//    map.put(key, newNode)
//    remove(old)
//    add(newNode)
//
//    OR simpler:
//
//    old.val = value;
//    remove(old);
//    add(old);
//
//    The second approach avoids creating another node.
//
// ---------------------------------------------------------------
//
// 13. Capacity check — classic mistake:
//
//    If capacity = 2:
//
//    after first insertion → size = 1
//    after second insertion → size = 2  ← STILL VALID
//
//    So DON'T do:
//
//    if (cnt < cap)   // can cause mistake at exactly capacity
//
//    Better:
//
//    add first, then:
//
//    if (map.size() > cap)
//        evict LRU;
//
//    OR:
//
//    if (map.size() < cap)
//        add
//    else
//        evict + add
//
// ---------------------------------------------------------------
//
// 14. You don't actually need cnt.
//
//    HashMap already knows the number of entries:
//
//    map.size()
//
//    So:
//
//    if (map.size() > cap)
//
//    is usually cleaner than maintaining:
//
//    cnt++
//    cnt--
//
//    This avoids count-related bugs.
//
// ---------------------------------------------------------------
//
// 15. VERY IMPORTANT while evicting:
//
//    Remove from BOTH DLL AND HashMap.
//
//    WRONG:
//
//    remove(head.next);
//
//    This removes it from the linked list,
//    BUT the HashMap still contains it.
//
//    CORRECT:
//
//    ListNode lru = head.next;
//
//    map.remove(lru.key);
//    remove(lru);
//
// ---------------------------------------------------------------
//
// 16. When adding a new node after eviction,
//    DON'T forget map.put().
//
//    WRONG:
//
//    remove(lru);
//    add(n);
//
//    Node exists in DLL but NOT in HashMap.
//
//    CORRECT:
//
//    remove(lru);
//    map.remove(lru.key);
//
//    map.put(key, n);
//    add(n);
//
// ---------------------------------------------------------------
//
// 17. Don't accidentally remove HEAD itself.
//
//    HEAD is a dummy node.
//
//    Actual LRU:
//
//    head.next
//
//    Similarly, don't use tail as the MRU.
//
//    Actual MRU:
//
//    tail.prev
//
// ---------------------------------------------------------------
//
// 18. HashMap syntax:
//
//    WRONG:
//    map.contains(key)
//
//    CORRECT:
//    map.containsKey(key)
//
//    Because we're checking whether a KEY exists.
//
// ---------------------------------------------------------------
//
// 19. Map and HEAD/TAIL must be CLASS VARIABLES.
//
//    WRONG:
//
//    constructor {
//        Map map = new HashMap();
//        ListNode head = ...;
//        ListNode tail = ...;
//    }
//
//    Then get()/put() cannot access them.
//
//    CORRECT:
//
//    class LRUCache {
//
//        Map<Integer,ListNode> map = new HashMap<>();
//        ListNode head, tail;
//
// ---------------------------------------------------------------
//
// 20. Constructor must connect dummy nodes:
//
//    head = new ListNode(-1, -1);
//    tail = new ListNode(-1, -1);
//
//    head.next = tail;
//    tail.prev = head;
//
//    Otherwise:
//
//    HEAD     TAIL
//
//    They are not connected.
//
// ---------------------------------------------------------------
//
// 21. Constructor argument order MUST be consistent.
//
//    If Node constructor is:
//
//    ListNode(int key, int val)
//
//    then:
//
//    new ListNode(key, value)
//
//    NOT:
//
//    new ListNode(value, key)
//
// ---------------------------------------------------------------
//
// 22. Core mental picture:
//
//    HEAD ⇄ LRU ⇄ ... ⇄ MRU ⇄ TAIL
//
//    head.next = LRU
//    tail.prev = MRU
//
//    get()  → move node to MRU
//    put()  → add/update as MRU
//    full   → remove LRU
//
// ---------------------------------------------------------------
//
// 23. FINAL ALGORITHM:
//
//    GET:
//
//    key absent?
//        → return -1
//
//    key present?
//        → get node from map
//        → remove node
//        → add node at tail
//        → return value
//
//    PUT:
//
//    key already exists?
//        → update value
//        → remove old position
//        → add at tail
//
//    new key?
//        → add to map
//        → add at tail
//
//        capacity exceeded?
//            → remove head.next
//            → remove its key from map
//
// ---------------------------------------------------------------
//
// 24. COMPLEXITY:
//
//    get() → O(1)
//    put() → O(1)
//    space → O(capacity)
//
//    WHY?
//
//    HashMap lookup = O(1)
//    DLL remove    = O(1)
//    DLL add       = O(1)
//
// ===============================================================

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */