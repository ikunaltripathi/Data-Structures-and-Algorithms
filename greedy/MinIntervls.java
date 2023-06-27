package greedy;

import java.util.Arrays;

public class MinIntervls {
    public static void main(String[] args) {
        int[][] intervals = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) ->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res = 0, i = 1;
        int end = intervals[0][1];
        while (i < intervals.length) {
            if (intervals[i][0] >= end) end = intervals[i][1];
            else {
                if (i != intervals.length-1 && intervals[i][1] <= intervals[i+1][0]) {
                    end = intervals[i][1];
                }
                res++;
            }
            i++;
        }
        return res;
    }
}
