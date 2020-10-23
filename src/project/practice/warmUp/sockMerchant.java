package project.practice.warmUp;

/*
  Problem :
  John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
  For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
  Function Description
  Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.
  sockMerchant has the following parameter(s):
  n: the number of socks in the pile
  ar: the colors of each sock
  Input Format
  The first line contains an integer , the number of socks represented in .
  The second line contains  space-separated integers describing the colors  of the socks in the pile.
  Constraints
  1<=n<=100
  1<=ar[i]<=100 where 0<=i<n
  Output Format
  Return the total number of matching pairs of socks that John can sell.
  Sample Input
  9
  10 20 20 10 10 30 50 10 20
  Sample Output
  3
 */

import java.util.Scanner;

public class sockMerchant {

    private static final Scanner scanner = new Scanner(System.in);

    private static int noOfPairs(int n, int[] ar) {
        int res = 0;
        if (n < 2) return 0;
        //let's go old school bogo to have a sorted array
        int temp;
        boolean swapped;
        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    temp = ar[j + 1];
                    ar[j + 1] = ar[j];
                    ar[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        // let's find us out our right pair
        for (int j = 0; j < n - 1; )
            if (ar[j] == ar[j + 1]) {
                res++;
                j += 2;
            } else j++;
        return res;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        int[] ar = new int[n];
        String[] arItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        System.out.println(noOfPairs(n, ar));
        scanner.close();
    }

}
