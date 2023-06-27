package recursion;

public class countDiceRolls {

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1,6,4));
    }
        public static int numRollsToTarget(int n, int k, int target) {
            return helper (0, target, k);
        }

        public static int helper (int p, int target, int face) {
            if (target == 0) {
                return 1;
            }
            int count = 0;
            for (int i = 1; i<= face && i<= target; i++) {
                count +=  helper (p+i, target - i, face);
            }
            return count;
        }
}

//package com.kunal.strings;
//
//        import java.util.ArrayList;
//
//public class Dice {
//    public static void main(String[] args) {
//        dice("", 4);
//        System.out.println(diceRet("", 4));
//    }
//
//    static void dice(String p, int target) {
//        if (target == 0) {
//            System.out.println(p);
//            return;
//        }
//
//        for (int i = 1; i <= 6 && i <= target; i++) {
//            dice(p + i, target - i);
//        }
//    }
//
//    static ArrayList<String> diceRet(String p, int target) {
//        if (target == 0) {
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 1; i <= 6 && i <= target; i++) {
//            list.addAll(diceRet(p + i, target - i));
//        }
//        return list;
//    }
//
//    static void diceFace(String p, int target, int face) {
//        if (target == 0) {
//            System.out.println(p);
//            return;
//        }
//
//        for (int i = 1; i <= face && i <= target; i++) {
//            diceFace(p + i, target - i, face);
//        }
//    }
//
//    static ArrayList<String> diceFaceRet(String p, int target, int face) {
//        if (target == 0) {
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 1; i <= face && i <= target; i++) {
//            list.addAll(diceFaceRet(p + i, target - i, face));
//        }
//        return list;
//    }
//
//}