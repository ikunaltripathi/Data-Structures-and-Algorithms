package hashing;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//Q - Find Itinerary from a given list of tickets
//Input:
//        "Chennai" -> "Bangalore"
//        "Bombay" -> "Delhi"
//        "Goa"    -> "Chennai"
//        "Delhi"  -> "Goa"
//
//        Output:
//        Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Bangalore,
public class FindItinerary {
    public static void main(String[] args) {
        String[][] arr = {{"Chennai", "Bangalore"},{"Bombay", "Delhi"},{"Goa", "Chennai"},{"Delhi", "Goa"}};
        HashMap<String, String> hm1 = new HashMap<>();
        HashMap<String, String> hm2 = new HashMap<>();
        for (int i = 0; i<arr.length; i++) {
            hm1.put(arr[i][0], arr[i][1]);
            hm2.put(arr[i][1], arr[i][0]);
        }
        String key = "";
        Set<String> s= hm1.keySet();
        for (String v : s) {
            if (!hm2.containsKey(v)) {
                key = v;
                break;
            }
        }
        while (!hm1.isEmpty()) {
            String val = hm1.get(key);
            System.out.println(key + " " + val);
            hm1.remove(key);
            key = val;
        }
    }
}
