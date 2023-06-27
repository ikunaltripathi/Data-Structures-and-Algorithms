package heaps;

import java.util.*;

public class TaskSche {
    public static int leastInterval(char[] tasks, int n) {
        int time = 0;
        Map<Character, Integer> hm = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (char ch : tasks) hm.put(ch, hm.getOrDefault(ch, 0)+1);
        maxHeap.addAll(hm.values());
        while (!maxHeap.isEmpty()) {
            List<Integer> al = new ArrayList<>();
            for (int i = 0; i<n+1 && !maxHeap.isEmpty(); i++) al.add(maxHeap.poll());
            for (int i: al) if (--i > 0) maxHeap.add(i);
            time += maxHeap.isEmpty() ? al.size() : n+1;
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(leastInterval(tasks, 2));
    }
}
