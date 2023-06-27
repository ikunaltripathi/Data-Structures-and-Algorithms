package backtracking;

import java.util.ArrayList;

public class kPartitions {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i<3; i++) {
            ans.add(new ArrayList<>());
        }
        solution(1,4,3,0,ans);
    }

    private static void solution(int j, int n, int k, int filledSets, ArrayList<ArrayList<Integer>> ans) {
        if (j>n) {
            if (filledSets == k) {
                for (ArrayList<Integer> sets : ans) {
                    System.out.print(sets + "  ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i< ans.size(); i++) {
            if ((ans.get(i)).size() > 0) {
                ans.get(i).add(j);
                solution (j+1, n , k, filledSets, ans);
                ans.get(i).remove(ans.get(i).size()-1);
            }
            else {
                ans.get(i).add(j);
                solution (j+1, n , k, filledSets+1, ans);
                ans.get(i).remove(ans.get(i).size()-1);
                break;
            }
        }
    }
}
