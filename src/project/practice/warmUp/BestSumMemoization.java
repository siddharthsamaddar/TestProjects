package project.practice.warmUp;
/*
Write a function bestSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
The function should return an array containing the shortest combination of numbers that adds up to exactly the targetSum.
If there is a tie for the shortest combination, we can return any one the shortest.
*/

import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;

public class BestSumMemoization {
    static int[] bestSum(int targetSum, int[] numbers, Map<Integer, int[]> memo) {

        if (memo.containsKey(targetSum)) return memo.get(targetSum);

        if (targetSum == 0) return new int[]{};
        if (targetSum < 0) return null;

        int[] shortestCombination = null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            int[] remainderCombination = bestSum(remainder, numbers, memo);
            if (remainderCombination != null) {
                int[] combination = insert(remainderCombination, num);
                if (shortestCombination == null || combination.length < shortestCombination.length)
                    shortestCombination = combination;
            }
        }
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }

    static int[] insert(int[] sourceArray, int addElement) {
        int[] destinationArray = Arrays.copyOf(sourceArray, sourceArray.length + 1);
        destinationArray[destinationArray.length - 1] = addElement;
        return destinationArray;
    }

    public static void main(String[] args) {
        System.out.println("The shortest combination of numbers that adds up to exactly the targetSum are as follows -");
        System.out.println("Target Sum = 7 for elements [5,3,4,7] = " + Arrays.toString(bestSum(7, new int[]{5, 3, 4, 7}, new WeakHashMap<>())));
        System.out.println("Target Sum = 8 for elements [2,3,5] = " + Arrays.toString(bestSum(8, new int[]{2, 3, 5}, new WeakHashMap<>())));
        System.out.println("Target Sum = 8 for elements [1,4,5] = " + Arrays.toString(bestSum(8, new int[]{1, 4, 5}, new WeakHashMap<>())));
        System.out.println("Target Sum = 100 for elements [1,2,5,25] = " + Arrays.toString(bestSum(100, new int[]{1, 2, 5, 25}, new WeakHashMap<>())));
    }
}