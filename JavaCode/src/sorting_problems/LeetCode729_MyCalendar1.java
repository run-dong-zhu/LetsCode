package sorting_problems;

import java.util.TreeMap;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 729, Level: Medium
 * 
 * https://leetcode.com/problems/my-calendar-i/
 */
public class LeetCode729_MyCalendar1 {
    
    TreeMap<Integer, Integer> singleBook;
    
    public LeetCode729_MyCalendar1() {
        singleBook = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer lower = singleBook.lowerKey(end);
        if(lower == null || singleBook.get(lower) <= start) {
            singleBook.put(start, end);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode729_MyCalendar1 obj = new LeetCode729_MyCalendar1();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(20, 35));
    }

}
