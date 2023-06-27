package recursion;

public class removeAFromString {
    public static void main(String[] args) {
        String str = "baccad";
        String result = "";
      removeA(str, result);
//        System.out.println(removeAWoutVar(str));
    }

    private static void removeA(String A, String result) {
        if (A.isEmpty()) {
            System.out.println(result);
            return;
        }
        if (A.charAt(0) != 'a') {
            result += A.charAt(0);
        }
        removeA(A.substring(1), result);
    }
    private static String removeAWoutVar(String A) { 
        if (A.length() == 0) return A;
        if (A.charAt(0) != 'a') {
            return A.charAt(0) + removeAWoutVar(A.substring(1));
        }
        else {
            return  removeAWoutVar(A.substring(1));
        }

    }


}
