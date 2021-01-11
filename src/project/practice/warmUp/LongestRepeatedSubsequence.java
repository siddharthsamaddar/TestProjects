package project.practice.warmUp;
/*
Longest Repeated Subsequence

Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
Input: str = "AABEBCDD"
Output: "ABD"

Examples:
Input: str = "aabb"
Output: "ab"

Input: str = "aab"
Output: "a"
The two subsequence are 'a'(first) and 'a'
(second). Note that 'b' cannot be considered
as part of subsequence as it would be at same
index in both.
This problem is just the modification of Longest Common Subsequence problem. The idea is to find the LCS(str, str) where str is the input string with the restriction that when both the characters are same, they shouldn’t be on the same index in the two strings.
 */

import java.util.Scanner;

public class LongestRepeatedSubsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Input String = ");
        String input = s.nextLine();
        System.out.println("Output Subsequence = " + findSubsequence(input));
    }

    @SuppressWarnings("WeakerAccess")
    public static String findSubsequence(String input) {
        int n = input.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (input.charAt(i - 1) == input.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

        int i = n, j = i;
        StringBuilder res = new StringBuilder();
        while (i > 0 && j > 0)
            if (dp[i][j] == 1 + dp[i - 1][j - 1]) {
                res.append(input.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j])
                i--;
            else
                j--;
        StringBuilder ans = new StringBuilder();
        for (int k = res.length() - 1; k >= 0; k--)
            ans.append(res.charAt(k));
        return ans.toString();
    }
}
