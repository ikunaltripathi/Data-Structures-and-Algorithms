package Graph;
import java.util.*;

class DisjointSet {
    List<Integer> size, parent;

    DisjointSet(int n) {
        size = new ArrayList<>();
        parent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    int findUP(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        int num = findUP(parent.get(node));
        parent.set(node, num);
        return num;
    }

    void unionSize(int x, int y) {
        int uP1 = findUP(x);
        int uP2 = findUP(y);
        if (uP1 == uP2) return;
        if (size.get(uP1) < size.get(uP2)) {
            parent.set(uP1, uP2);
            size.set(uP2, size.get(uP1) + size.get(uP2));
        } else {
            parent.set(uP2, uP1);
            size.set(uP1, size.get(uP1) + size.get(uP2));
        }
    }
}

public class MakingLargeIsland {
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        Map<Integer, Integer> hm = new HashMap<>();
        int counter = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hm.put(counter++, grid[i][j]);
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int rRow = delRow[k] + i;
                        int rCol = delCol[k] + j;
                        if (rRow >= 0 && rCol >= 0 && rRow < n && rCol < n && grid[rRow][rCol] == 1) {
                            ds.unionSize(counter - 1, rRow * n + rCol);
                        }
                    }
                }
            }
        }

        int ans = 0;
        int[] parents = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            int up = ds.findUP(i);
            parents[up]++;
            ans = Math.max(parents[up], ans);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int curr = 1;
                    Set<Integer> hs = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int rRow = delRow[k] + i;
                        int rCol = delCol[k] + j;
                        if (rRow >= 0 && rCol >= 0 && rRow < n && rCol < n && grid[rRow][rCol] == 1 && !hs.contains(ds.findUP(rRow * n + rCol))) {
                            curr += parents[ds.findUP(rRow * n + rCol)];
                            hs.add(ds.findUP(rRow * n + rCol));
                        }
                    }
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1}, {1, 0}};
        System.out.println(largestIsland((arr)));
    }
}
// afdasfasf