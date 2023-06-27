package bit_manipulation;

class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {
        int len = a.length();
        int len2 = b.length();
        String res = "";
        int carry = 0;
        for (int i = len2-1; i>=0; i--)
        {
            if ((a.charAt(i) == '1') && (b.charAt(i) == '1'))
            {
                if (carry == 1) res += "1";
                else res += "0";
                carry = 1;
            }
            else if ((a.charAt(i) == '0') && (b.charAt(i) == '0'))
            {
                if (carry == 1) res += "1";
                else res += "0";
                carry = 0;
            }
            else {
                if (carry == 1) res += "0";
                else res += "1";
            }
        }
        for (int i = len - len2 - 1; i>=0; i--)
        {
            if (a.charAt(i) == '1')
            {
                if (i == 0 && carry == 1) res += "01";
                else if (carry == 1) res += "0";
                else
                {
                    res+= String.valueOf(a.charAt(i));
                    carry = 0;
                }
            }

        }
        StringBuilder in = new StringBuilder();
        in.append(res);
        in.reverse();
        res = in.toString();
        return res;
    }
}