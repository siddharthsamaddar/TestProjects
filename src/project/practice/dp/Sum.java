package project.practice.dp;
/*
Write a function that takes in a targetSum and an array of numbers as arguments.
Can Sum: can sum numbers from the list to achieve the target number;
How Sum: a sequence of numbers to be added to achieve a target number;
Best Sum : The function should return an array containing the shortest combination of numbers that adds up to exactly the targetSum.
If there is a tie for the shortest combination, we can return any one the shortest.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sum {

    /*
     * CAN SUM NAIVE IMPLEMENTATION
     */
    public boolean naiveCanSum(int targetSum, List<Integer> numbers) {
        if (targetSum < 0) {
            return false;
        }
        if (targetSum == 0) {
            return true;
        }
        for (Integer value : numbers) {
            if (naiveCanSum(targetSum - value, numbers)) {
                return true;
            }
        }
        return false;
    }

    /*
     * CAN SUM DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public boolean dynamicCanSum(int targetSum, List<Integer> numbers) {
        return dynamicCanSum(targetSum, numbers, new HashMap<>());
    }

    private boolean dynamicCanSum(int targetSum, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum < 0) {
            return false;
        }
        if (targetSum == 0) {
            return true;
        }
        for (Integer value : numbers) {
            if (dynamicCanSum(targetSum - value, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    /*
     * CAN SUM DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public boolean dynamicCanSumTabular(int targetSum, List<Integer> numbers) {
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;
        for (int i = 0; i < targetSum; i++) {
            for (Integer number : numbers) {
                if (table[i] && i + number <= targetSum) {
                    table[i + number] = true;
                }
            }
        }
        return table[targetSum];
    }

    /*
     * HOW SUM NAIVE IMPLEMENTATION
     */
    public List<Integer> naiveHowSum(int targetSum, List<Integer> numbers) {
        if (targetSum < 0) {
            return null;
        }
        if (targetSum == 0) {
            return (new ArrayList<>());
        }
        for (Integer value : numbers) {
            List<Integer> result = naiveHowSum(targetSum - value, numbers);
            if (result != null) {
                result.add(0, value);
                return result;
            }
        }
        return null;
    }

    /*
     * HOW SUM DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public List<Integer> dynamicHowSumMemo(int targetSum, List<Integer> numbers) {
        return dynamicHowSumMemo(targetSum, numbers, new HashMap<>());
    }

    private List<Integer> dynamicHowSumMemo(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum < 0) {
            return null;
        }
        if (targetSum == 0) {
            return (new ArrayList<>());
        }

        for (Integer value : numbers) {
            List<Integer> result = dynamicHowSumMemo(targetSum - value, numbers, memo);
            if (result != null) {
                result.add(0, value);
                memo.put(targetSum, result);
                return result;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    /*
     * HOW SUM DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public List<Integer> dynamicHowSumTabular(int targetSum, List<Integer> numbers) {
        List<List<Integer>> table = new ArrayList<>();
        table.add(new ArrayList<>());
        for (int i = 0; i < targetSum; i++) {
            table.add(null);
        }

        for (int i = 0; i <= targetSum; i++) {
            for (Integer number : numbers) {
                int index = i + number;
                if (index > targetSum || table.get(i) == null) {
                    continue;
                }
                List<Integer> list = new ArrayList<>(table.get(i));
                list.add(0, number);
                if (index == targetSum) {
                    return list;
                }
                table.set(index, list);
            }
        }
        return null;
    }

    /*
     * BEST SUM NAIVE IMPLEMENTATION
     */
    public List<Integer> naiveBestSum(int targetSum, List<Integer> numbers) {
        if (targetSum < 0) {
            return null;
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        List<Integer> shortest = null;
        for (Integer value : numbers) {
            List<Integer> combination = naiveBestSum(targetSum - value, numbers);
            if (combination != null) {
                combination.add(0, value);
                if (shortest == null || shortest.size() > combination.size()) {
                    shortest = combination;
                }
            }
        }
        return shortest;
    }

    /*
     * BEST SUM DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public List<Integer> dynamicBestMemo(int targetSum, List<Integer> numbers) {
        return dynamicBestSumMemo(targetSum, numbers, new HashMap<>());
    }

    private List<Integer> dynamicBestSumMemo(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum < 0) {
            return null;
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        List<Integer> shortest = null;
        for (Integer value : numbers) {
            List<Integer> combination = dynamicBestSumMemo(targetSum - value, numbers, memo);
            if (combination != null) {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                list.addAll(combination);
                if (shortest == null || shortest.size() > list.size()) {
                    shortest = list;
                }
            }
        }
        memo.put(targetSum, shortest);
        return shortest;
    }

    /*
     * BEST SUM DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public List<Integer> dynamicBestSumTabular(int targetSum, List<Integer> numbers) {
        List<List<Integer>> table = new ArrayList<>();
        table.add(new ArrayList<>());
        for (int i = 0; i < targetSum; i++) {
            table.add(null);
        }
        for (int i = 0; i <= targetSum; i++) {
            for (Integer number : numbers) {
                int index = i + number;
                if (index > targetSum || table.get(i) == null) {
                    continue;
                }
                List<Integer> list = new ArrayList<>(table.get(i));
                list.add(0, number);
                if (table.get(index) == null || table.get(index).size() > list.size()) {
                    table.set(index, list);
                }
            }
        }
        return table.get(targetSum);
    }
}