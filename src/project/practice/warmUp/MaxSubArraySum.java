package project.practice.warmUp;

/*
Kadane's Algorithm
Given an array arr of N integers.
Find the contiguous sub-array with maximum sum.

Example 1:
Input:
N = 5
arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which
is a contiguous subarray.

Example 2:
Input:
N = 4
arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1
of element (-1)

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10^6
-10^7 ≤ A[i] <= 10^7
*/
public class MaxSubArraySum {
    static int maxSum(int[] numbers) {
        int maxSoFar = 0, current_max = 0;
        for (int num : numbers) {
            current_max = Math.max(num, current_max + num);
            maxSoFar = Math.max(maxSoFar, current_max);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println("Max sub-array sum for elements (-2, -3, 4, -1, -2, 1, 5, -3) = "
                + maxSum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }
}