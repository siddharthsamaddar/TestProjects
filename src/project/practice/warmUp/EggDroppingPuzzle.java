package project.practice.warmUp;
/*
Egg Dropping Puzzle

Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break.
You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.
There are few rules given below.

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.

Example 1:

Input:
N = 2, K = 10
Output: 4

Example 2:

Input:
N = 3, K = 5
Output: 3

Complete the function eggDrop() which takes two positive integer N and K as input parameters
and returns the minimum number of attempts you need in order to find the critical floor.

Expected Time Complexity : O(N*K)
Expected Auxiliary Space: O(N*K)

Constraints:
1<=N<=10
1<=K<=50
*/

import java.util.HashMap;
import java.util.Map;

public class EggDroppingPuzzle {
    static int eggDrop(int N, int K) {
        return eggDrop(N, K, new HashMap<>());
    }

    static int eggDrop(int eggs, int floors, Map<String, Integer> memo) {
        String key = eggs + "," + floors;
        if (memo.containsKey(key)) return memo.get(key);
        if (eggs == 1 || floors == 0 || floors == 1) return floors;

        int highestSafeFloor = Integer.MAX_VALUE;
        for (int floor = 1; floor <= floors; floor++)
            highestSafeFloor = Math.min(highestSafeFloor,
                    1 + Math.max(eggDrop(eggs - 1, floor - 1, memo), eggDrop(eggs, floors - floor, memo)));

        memo.put(key, highestSafeFloor);
        return highestSafeFloor;
    }

    public static void main(String[] args) {
        System.out.println("For Eggs N = 2 and Floors K = 36 -> " + eggDrop(2, 36));
    }
}