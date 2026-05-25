import java.util.*;

class Bucket {

    List<Integer> set;

    public Bucket() {
        set = new LinkedList<>();
    }

    public void add(int key) {
        if (!set.contains(key)) {
            set.add(key);
        }
    }

    public void remove(int key) {
        set.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        return set.contains(key);
    }
}

class MyHashSet {

    Bucket[] buckets;
    int size = 1009;

    public MyHashSet() {
        this.buckets = new Bucket[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new Bucket();
        }
    }
    
    public void add(int key) {
        int idx = key % 111;
        buckets[idx].add(key);
    }
    
    public void remove(int key) {
        int idx = key % 111;
        buckets[idx].remove(key); 
    }
    
    public boolean contains(int key) {
        int idx = key % 111;
        return buckets[idx].contains(key); 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */