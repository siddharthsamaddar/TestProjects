package project.practice.warmUp;

/*
Minimum number of adjacent swaps to convert a string into its given anagram
Given two strings s1 and s2, the task is to find the minimum number of steps required to convert s1 into s2.
The only operation allowed is to swap adjacent elements in the first string.
Every swap is counted as a single step.

Examples:

Input: s1 = “abcd”, s2 = “cdab”
Output: 4
Swap 2nd and 3rd element, abcd => acbd
Swap 1st and 2nd element, acbd => cabd
Swap 3rd and 4th element, cabd => cadb
Swap 2nd and 3rd element, cadb => cdab
Minimum 4 swaps are required.

Input: s1 = “abcfdegji”, s2 = “fjiacbdge”
Output:17
 */
public class StringAnagram {
    static int minSwaps(char[] s1, char[] s2) {
        int i = 0, j, result = 0;
        while (i < s1.length) {
            j = i;
            while (s1[j] != s2[i]) {
                j++;
            }
            while (i < j) {
                char temp = s1[j];
                s1[j] = s1[j - 1];
                s1[j - 1] = temp;
                j--;
                result++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        String a1 = "abcfdegji";
        String a2 = "fjiacbdge";
        System.out.println(minSwaps(a1.toCharArray(), a2.toCharArray()));
    }
}