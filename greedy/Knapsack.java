//package greedy;
//
//import java.util.Arrays;
//import java.util.Comparator;
//class Item {
//    int value, weight;
//    Item(int x, int y){
//        this.value = x;
//        this.weight = y;
//    }
//}
//
//public class Knapsack {
//    public static void main(String[] args) {
//    Item[] arr = new Item[3];
//        arr[0] = new Item(60,10);
//        arr[1] = new Item(100,20);
//        arr[2] = new Item(120,30);
//        System.out.println(fractionalKnapsack(50, arr, ));
//    }
//        //Function to get the maximum total value in the knapsack.
//        public static double  fractionalKnapsack(int W, Item arr[], int n)
//        {
//            // Your code here
//            double[][] valByW = new double[arr.length][2];
//            for (int i = 0; i<valByW.length; i++) {
//                valByW[i][0] = i;
//                valByW[i][1] = arr[i].value/(double)arr[i].weight;
//            }
//            Arrays.sort(valByW, Comparator.comparingDouble((double[] o) -> o[1]).reversed());
//
//            double res = 0.00;
//            double temp = (double)n;
//            for (int i = 0; i< valByW.length; i++) {
//                double totalWeight = arr[(int)valByW[i][0]].weight;
//                if ( totalWeight <= temp) {
//                    res += totalWeight * valByW[i][1];
//                    temp -= totalWeight;
//                }
//                else {
//                    res += temp * valByW[i][1];
//                }
//            }
//            return res;
//        }
//}
