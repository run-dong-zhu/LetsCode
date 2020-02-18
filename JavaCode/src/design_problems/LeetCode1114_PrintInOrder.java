package design_problems;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 1114, Level: Easy
 * 
 * https://leetcode.com/problems/print-in-order/
 */
public class LeetCode1114_PrintInOrder {
    
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);
    
    Semaphore run2, run3;
    
    LeetCode1114_PrintInOrder() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }
    
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
//        firstJobDone.incrementAndGet();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        run2.acquire();
        printSecond.run();
//        secondJobDone.incrementAndGet();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        run3.acquire();
        printThird.run();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
