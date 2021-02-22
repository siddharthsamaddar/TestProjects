package project.practice.dp;
/*
We are traveling on a 2D grid. We begin on the top left corner and our goal is to travel to the bottom-right corner.
We may only move either down or right at a time.
In how many ways can we travel to the goal on a grid with dimensions m*n ?
Write a function gridTraveler(m,n) that calculates the same.
*/

import java.util.HashMap;

public class GridTraveler {

    /*
     * GRID TRAVELER NAIVE IMPLEMENTATION
     */
    public int naiveTravel(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        return naiveTravel(m - 1, n) + naiveTravel(m, n - 1);
    }

    /*
     * GRID TRAVELER DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public Long dynamicTravelMemo(int m, int n) {
        return dynamicTravelMemo(m, n, new HashMap<>());
    }

    private Long dynamicTravelMemo(int m, int n, HashMap<String, Long> memo) {
        if (m == 0 || n == 0) {
            return 0L;
        }
        if (m == 1 && n == 1) {
            return 1L;
        }
        String key = m > n ? n + "-" + m : m + "-" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Long value = dynamicTravelMemo(m - 1, n, memo) + dynamicTravelMemo(m, n - 1, memo);
        memo.put(key, value);
        return value;
    }

    /*
     * GRID TRAVELER DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public Long dynamicTravelTabular(int m, int n) {
        Long[][] table = new Long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = 0L;
            }
        }
        table[0][0] = 1L;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Long value = table[i][j];
                if (i < m - 1) {
                    table[i + 1][j] += value;
                }
                if (j < n - 1) {
                    table[i][j + 1] += value;
                }
            }
        }
        return table[m - 1][n - 1];
    }
}