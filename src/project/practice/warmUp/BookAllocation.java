package project.practice.warmUp;

/*Allocate minimum number of pages
        You are given N number of books. Every ith book has Ai number of pages.
        You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value.

        Each book will be allocated to exactly one student. Each student has to be allocated at least one book.

        Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

        Example 1:

        Input:
        N = 4
        A[] = {12,34,67,90}
        M = 2
        Output: 113
        Explanation:
        Allocation can be done in following ways:
        {12} and {34, 67, 90} Maximum Pages = 191
        {12, 34} and {67, 90} Maximum Pages = 157
        {12, 34, 67} and {90}  Maximum Pages =113
        Therefore, the minimum of these cases is
        113, which is selected as the output.
        Example 2:

        Input:
        N = 3
        A[] = {15,17,20}
        M = 2
        Output: 32
        Explanation: Allocation is done as
        {15,17} and {20}
        Your Task:
        Complete findPages() function that takes a, n, and m as arguments and returns the expected answer.

        Expected Time Complexity : O(NlogN)
        Expected Auxiliary Space : O(1)

        Constraints:
        1 <= N <= 10^5
        1 <= A [ i ] <= 10^6
        1 <= M <= 10^5
*/
import java.util.Scanner;

class BookAllocation {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0)
        {
            int n=sc.nextInt();
            int[] a =new int[n];

            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            int m=sc.nextInt();
            System.out.println(findPages(a,n,m));
        }
    }

    @SuppressWarnings("WeakerAccess")
    public static boolean minSumOfGroups(int[] a, int n, int m, int assumedSum){
        //Will try to accommodate the elements of input array and check their sum to the assumed sum for m elements in the group
        int currentSum=0,group=1;
        for(int i = 0; i < n; i++) {
            if (a[i] > assumedSum) {
                return false;
            }
            else if (a[i] + currentSum > assumedSum) {
                currentSum = a[i];
                group++;
                if (group > m) {
                    return false;
                }
            }
            else {
                currentSum += a[i];
            }
        }
        return true;
    }

    @SuppressWarnings("WeakerAccess")
    public static int findPages(int[]a, int n, int m)
    {
        if(n<m) {
            return -1;
        }
        int end=0,start=0;
        for(int i=0; i<n; i++) {
            end+=a[i];
        }
        int ans = end;
        //binary search for minimising the sum of groups
        while(start<=end){
            int mid = (start + end) / 2;
            if(minSumOfGroups(a,n,m,mid)){
                ans = Math.min(ans, mid);
                end= mid - 1;
            }
            else{
                start=mid + 1;
            }
        }
        return ans;
    }
}
