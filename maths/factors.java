package maths;

import java.util.*;

public class factors {
    public static void main(String[] args) {
        int n =  36;
        findfactors(n);
    }

    private static void findfactors(int n) {
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0)
            {
                if (n/i == i)
                {
                    System.out.print(i + " " );
                }
                else {
                    System.out.print(i + " ");
                    arr.add(n/i);
                }
            }
        }
        for (int i = arr.size() - 1; i >=0 ; i--) {
            System.out.print(arr.get(i) + " ");
        }
    }

}
