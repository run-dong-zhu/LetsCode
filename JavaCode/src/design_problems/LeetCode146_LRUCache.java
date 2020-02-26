package design_problems;

import java.util.Hashtable;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 146, Level: Medium
 */
public class LeetCode146_LRUCache {
    
    class DoubleLinkedList {
        int key;
        int val;
        DoubleLinkedList pre;
        DoubleLinkedList post;
    }
    
    private Hashtable<Integer, DoubleLinkedList> table = new Hashtable<>();
    private int count;
    private int capacity;
    private DoubleLinkedList head, tail;
    
    private void add(DoubleLinkedList node) {
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;
    }
    
    private void remove(DoubleLinkedList node) {
        DoubleLinkedList pre = node.pre;
        DoubleLinkedList post = node.post;
        
        pre.post = post;
        post.pre = pre;
    }
    
    private void moveToHead(DoubleLinkedList node) {
        this.remove(node);
        this.add(node);
    }
    
    private DoubleLinkedList popTail() {
        DoubleLinkedList res = tail.pre;
        this.remove(res);
        return res;
    }
    
    public LeetCode146_LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DoubleLinkedList();
        head.pre = null;
        
        tail = new DoubleLinkedList();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DoubleLinkedList node = table.get(key);
        
        if(node == null) {
            return -1;
        }
        
        this.moveToHead(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        DoubleLinkedList node = table.get(key);
        
        if(node == null) {
            DoubleLinkedList newNode = new DoubleLinkedList();
            newNode.key = key;
            newNode.val = value;
            
            this.table.put(key, newNode);
            this.add(newNode);
            
            count++;
            
            if(count > capacity) {
                DoubleLinkedList tail = this.popTail();
                this.table.remove(tail.key);
                --count;
            }
        }
        else {
            node.val = value;
            this.moveToHead(node);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
