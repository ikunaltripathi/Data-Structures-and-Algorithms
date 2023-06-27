package strings;

import java.util.Scanner;

public class swap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        int start = 0;
        int end = str.length()-1;
        while (start<end){
            if (!(Character.isDigit(str.charAt(start))) && ! (Character.isDigit(str.charAt(end)))) {
                str = str.substring(0,start) + str.charAt(end) + str.substring(start+1, end) + str.charAt(start) + str.substring(end+1);
                start++;
                end--;
            }
            if(Character.isDigit(str.charAt(start))) start++;
            if(Character.isDigit(str.charAt(end))) end--;
        }
        System.out.println(str);
    }
}

//  TestCase : a1b2igh3
//  Output   : h1g2iba3
