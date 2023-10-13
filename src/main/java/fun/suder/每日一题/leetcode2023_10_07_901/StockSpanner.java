package fun.suder.每日一题.leetcode2023_10_07_901;

import java.util.*;

class StockSpanner {
    Deque <int[]> deque;
    int idx;

    public StockSpanner() {
        deque = new ArrayDeque<>();
        deque.push(new int[]{-1, Integer.MAX_VALUE});
        idx = 0;
    }

    public int next(int price) {
        while(!deque.isEmpty() && price >= deque.peek()[1]){
            deque.pop();
        }

        int ret = idx - deque.peek()[0];
        deque.push(new int[] {idx, price});
        idx++;

        return ret;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */