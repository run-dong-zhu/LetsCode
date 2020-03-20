package design_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 460, Level: Hard
 *
 * https://leetcode.com/problems/lfu-cache/
 */
public class LeetCode460_LFUCache {

    /*
    1. Save all key's frequency
    2. Track the size of the all cache
    3. get(key) not exist or frequency++
    4. put(key, value) key exists - modify value, call get(), or add new node, oversize...
     */
    class Node {
        int key;
        int val;
        int count; // visited times
        Node prev;
        Node next;

        public Node(int k, int v) {
            key = k;
            val = v;
            count = 1;
        }
    }

    class DLList {
        Node head;
        Node tail;    
        int len;

        public DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

        public void addHead(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;

            map.put(node.key, node);
            len++;
        }

        public void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            len--;
            map.remove(node.key);
        }

        public void removeTail() {
            Node preTail = tail.prev;
            removeNode(preTail);
        }
    }

    Map<Integer, Node> map;
    Map<Integer, DLList> freq;
    int size, capacity;
    int maxFreq;

    public LeetCode460_LFUCache(int capacity) {
        map = new HashMap<>();
        freq = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        maxFreq = 0;
    }

    public int get(int key) {
        if(map.get(key) == null) {
            return -1;
        }
        Node node = map.get(key);
        int prevFreq = node.count;
        DLList prevList = freq.get(prevFreq);
        prevList.removeNode(node);

        int curFreq = prevFreq + 1;
        maxFreq = Math.max(maxFreq, curFreq);
        DLList curList = freq.getOrDefault(curFreq, new DLList());
        curList.addHead(node);

        freq.put(prevFreq, prevList);
        freq.put(curFreq, curList);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }

        if(map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
            return;
        }

        Node node = new Node(key, value);
        DLList currList = freq.getOrDefault(1, new DLList());
        currList.addHead(node);
        size++;

        if(size > capacity) {
            if(currList.len > 1) {
                currList.removeTail();
            }
            else {
                for(int i = 2; i <= maxFreq; i++) {
                    if(freq.containsKey(i) && freq.get(i).len > 0) {
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }
            size--;
        }
        freq.put(1, currList);
    }

    public static void main(String[] args) {
        LeetCode460_LFUCache cache = new LeetCode460_LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(2, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(1));
    }

}
