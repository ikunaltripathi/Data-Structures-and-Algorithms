package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class AlienDict {
    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        System.out.println(findOrder(dict, 5, 4));
    }
    public static String findOrder(String[] dict, int N, int K)
    {
        // Write your code here
        boolean[] vis=new boolean[K];
        Stack<Integer> s = new Stack<>();
        // create Adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<K; i++) {
            ArrayList<Integer> al=new ArrayList<>();
            adj.add(al);
        }


        for (int i=0; i<dict.length; i++) {
            char ch = dict[i].charAt(0);
            ArrayList<Integer> al = adj.get(ch-97);
            for (int j = i+1; j<dict.length; j++) {
                if ((int) dict[j].charAt(0) != (int) ch) {
                    if (al.size() > 0 && al.get(al.size() - 1) != dict[j].charAt(0)) {
                        al.add(dict[j].charAt(0) - 97);
                    }
                    else if (al.size()==0) al.add(dict[j].charAt(0)-97);
                }
            }
            //Comparing with same -> got the range
            int end=0;
            for (int j=i+1; j<dict.length; j++) {
                if (dict[j].charAt(0) != dict[i].charAt(0)) {
                    end=j-1;
                    break;
                }
            }
            for (int k=i; k<end; k++) {
                for (int j=k+1; j<=end; j++) {
                    String a = dict[k];
                    String b = dict[j];
                    int index = 0;
                    while (index<a.length() && index<b.length() && a.charAt(index) == b.charAt(index)) {
                        index++;
                    }
                    if (index<a.length() && index<b.length()) {
                        ArrayList<Integer> temp = adj.get(a.charAt(index)-97);
                        temp.add(b.charAt(index)-97);
                    }
                }
            }
        }
        for (ArrayList<Integer> al : adj) {
            for (int i : al) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        for (int i=0; i<K; i++) {
            if (!vis[i]) {
                vis[i]=true;
                topoSort(i, vis, s, adj);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append((char)(97 + s.pop()));
        }
        return sb.toString();
    }

    public static void topoSort(int src, boolean[] vis, Stack<Integer> s, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> al = adj.get(src);
        for (int i=0; i<al.size(); i++) {
            if (!vis[al.get(i)]) {
                vis[al.get(i)] = true;
                topoSort(al.get(i), vis, s, adj);
            }
        }
        s.push(src);
    }
}


