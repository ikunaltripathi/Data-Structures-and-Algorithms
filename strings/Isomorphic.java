package strings;

public class Isomorphic {
    public static void main(String[] args) {
        String s = "egg";
        String t = "fdd";
        System.out.println(isIsomorphic(s,t));
    }
        public static boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;
            char[] values = new char[256];
            for (char ch : values) ch = ' ';
            for (int i = 0; i<s.length(); i++) {
                if (values[s.charAt(i)] != ' ') {
                    if (values[s.charAt(i)] != t.charAt(i)) return false;
                }
                else values[s.charAt(i)] = t.charAt(i);;
            }
            return true;
        }
}
