package project.practice.Lex;

import java.util.Scanner;

public class seqReverse {

    public static void main(String[] args) {

        String n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to be reversed : ");
        n = scanner.nextLine();
        System.out.println("The reverse of the string is : " + reverse(n));

    }

    private static String reverse(String n) {

        StringBuilder rev = new StringBuilder();
        char[] num = n.toCharArray();
        for (int i = num.length - 1; i >= 0; i--) {
            rev.append(num[i]);
        }
        return rev.toString();
    }


}
