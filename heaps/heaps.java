package heaps;

import java.util.PriorityQueue;
import java.util.*;

public class heaps {
        public static boolean isNStraightHand(int[] hand, int groupSize) {
            if (hand.length%groupSize != 0 || hand.length == 0 || hand == null) return false;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int i : hand) minHeap.add(i);
            while(!minHeap.isEmpty()) {
                List<Integer> al = new ArrayList<>();
                int ele = minHeap.poll();
                for (int i = 0; i<groupSize-1; i++) {
                    while (!minHeap.isEmpty() && minHeap.peek() < ele+1) al.add(minHeap.poll());
                    if (minHeap.isEmpty() || minHeap.peek() != ele+1) return false;
                    minHeap.poll();
                    ele++;
                }
                // if (minHeap.size() != groupSize) return false;
                for (int i: al) minHeap.add(i);
            }
            return true;
        }

    public static void main(String[] args) {
            int[] h = {1,2,3,6,2,3,4,7,8};
        System.out.println(isNStraightHand(h,3));
    }
}
