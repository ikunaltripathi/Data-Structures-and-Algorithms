package bit_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<String> AllPossibleStrings(String s)
    {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        // Code here
        List<String> res = new ArrayList<String>();
        for (int i = 0; i<(1<<arr.length); i++) {
            String x = "";
            for (int j = 0; j<arr.length; j++) {
                int d = i & (1<<j);
                if (d > 0) x += arr[j];
            }
            res.add(x);
        }
        return res;
    }
}
