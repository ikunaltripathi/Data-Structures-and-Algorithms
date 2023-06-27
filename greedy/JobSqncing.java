package greedy;

import java.util.Arrays;

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
public class JobSqncing {
    public static void main(String[] args) {
        Job[]  arr= new Job[4];
        Job a1 = new Job(1,4,20);
        Job a2 = new Job(2,1,10);
        Job a3 = new Job(3,1,40);
        Job a4 = new Job(4,1,30);
        arr[0] = a1;
        arr[1] = a2;
        arr[2] = a3;
        arr[3] = a4;
        System.out.println(Arrays.toString(JobScheduling(arr, 4)));
    }
        //Function to find the maximum profit and the number of jobs done.
        static int[] JobScheduling(Job arr[], int n) {
            // Your code here
            Arrays.sort(arr, (a, b) -> b.profit - a.profit);
            int max = -1;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i].deadline);
            }
            int[] jobs = new int[max];
            Arrays.fill(jobs, -1);
            int res = 0, count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = arr[i].deadline; j > 0; j--) {
                    if (jobs[j] == -1) {
                        jobs[j] = arr[i].id;
                        res += arr[i].profit;
                        count++;
                        break;
                    }
                }
            }
            return new int[]{count, res};
        }
}
