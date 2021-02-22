package project.practice.dp;
/*
Write a function that accepts a target string and an array of strings.
Can Construct: if a word can be created given a list of strings;
Count Construct: how many different ways a word can be created given a list of strings;
All Constructs: the function should return a 2D array containing all the ways that the target can be constructed by concatenating elements of the wordBank array.
We may re-use elements of wordBank as many times as needed.
*/

import java.util.*;
import java.util.stream.Collectors;

/*
    Verify if is possible to target word be constructed by concatenating elements of the string array.
*/

public class Construct {

    /*
      ===============================================================
                              CAN CONSTRUCT
                             decision problem
      ===============================================================
     */

    /*
     * CAN CONSTRUCT NAIVE IMPLEMENTATION
     */
    public boolean naiveCanConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) {
            return true;
        }
        for (String subWord : wordBank) {
            if (!target.startsWith(subWord)) {
                continue;
            }
            if (naiveCanConstruct(target.replaceFirst(subWord, ""), wordBank)) {
                return true;
            }
        }
        return false;
    }

    /*
     * CAN CONSTRUCT DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public boolean dynamicCanConstructMemo(String target, List<String> wordBank) {
        return dynamicCanConstructMemo(target, wordBank, new HashMap<>());
    }

    private boolean dynamicCanConstructMemo(String target, List<String> wordBank, HashMap<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return true;
        }
        for (String subWord : wordBank) {
            if (!target.startsWith(subWord)) {
                continue;
            }
            if (dynamicCanConstructMemo(target.replaceFirst(subWord, ""), wordBank, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    /*
     * CAN CONSTRUCT DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public boolean dynamicCanConstructTabular(String target, List<String> wordBank) {
        List<Boolean> table = new ArrayList<>();
        table.add(true);
        for (int i = 0; i < target.length(); i++) {
            table.add(false);
        }

        for (int i = 0; i < target.length(); i++) {
            if (!table.get(i)) {
                continue;
            }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (word.startsWith(prefix)) {
                    table.set(i + prefix.length(), true);
                }
                if (table.get(target.length())) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * ===============================================================
     * COUNT CONSTRUCT
     * combinatorics problem
     * ===============================================================
     */

    public int naiveCountConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) {
            return 1;
        }
        int sum = 0;
        for (String prefix : wordBank) {
            if (!target.startsWith(prefix)) {
                continue;
            }
            sum += naiveCountConstruct(target.replaceFirst(prefix, ""), wordBank);
        }
        return sum;
    }

    /*
     * HOW COUNT DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public Integer dynamicCountConstructMemo(String target, List<String> wordBank) {
        return dynamicCountConstructMemo(target, wordBank, new HashMap<>());
    }

    private Integer dynamicCountConstructMemo(String target, List<String> wordBank, HashMap<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return 1;
        }
        Integer sum = 0;
        for (String prefix : wordBank) {
            if (!target.startsWith(prefix)) {
                continue;
            }
            sum += dynamicCountConstructMemo(target.replaceFirst(prefix, ""), wordBank, memo);
        }
        memo.put(target, sum);
        return sum;
    }

    /*
     * HOW COUNT DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public Integer dynamicCountConstructTabular(String target, List<String> wordBank) {
        List<Integer> table = new ArrayList<>();
        table.add(1);
        for (int i = 0; i < target.length(); i++) {
            table.add(0);
        }

        for (int i = 0; i < target.length(); i++) {
            if (table.get(i) == 0) {
                continue;
            }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (word.startsWith(prefix)) {
                    table.set(
                            i + prefix.length(),
                            table.get(i) + table.get(i + prefix.length())
                    );
                }
            }
        }
        return table.get(target.length());
    }

    /*
      ===============================================================
                             ALL CONSTRUCTS
                           optimization problem
      ===============================================================
     */

    /*
     * ALL CONSTRUCTS NAIVE IMPLEMENTATION
     */
    public List<List<String>> naiveAllConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) {
            return Collections.singletonList(new ArrayList<>());
        }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : wordBank) {
            if (target.startsWith(prefix)) {
                List<List<String>> suffixWays = naiveAllConstruct(target.replaceFirst(prefix, ""), wordBank);
                suffixWays.forEach(a -> a.add(0, prefix));
                result.addAll(suffixWays);
            }
        }
        return result;
    }

    /**
     * ALL CONSTRUCTS DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public List<List<String>> dynamicAllConstructMemo(String target, List<String> wordBank) {
        return dynamicAllConstructMemo(target, wordBank, new HashMap<>());
    }

    private List<List<String>> dynamicAllConstructMemo(String target, List<String> wordBank, HashMap<String, List<List<String>>> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return Collections.singletonList(new ArrayList<>());
        }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : wordBank) {
            if (target.startsWith(prefix)) {
                List<List<String>> suffixWays = dynamicAllConstructMemo(target.replaceFirst(prefix, ""), wordBank, memo)
                        .stream()
                        .map(ArrayList::new)
                        .collect(Collectors.toList());
                suffixWays.forEach(a -> a.add(0, prefix));
                result.addAll(suffixWays);
            }
        }
        memo.put(target, result);
        return result;
    }

    /*
     * ALL CONSTRUCTS DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public List<List<String>> dynamicAllConstructTabular(String target, List<String> wordBank) {
        List<List<List<String>>> table = new ArrayList<>();
        for (int i = 0; i <= target.length(); i++) {
            table.add(new ArrayList<>());
        }
        table.get(0).add(new ArrayList<>());

        for (int i = 0; i <= target.length(); i++) {
            if (table.get(i).isEmpty()) {
                continue;
            }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (!word.startsWith(prefix)) {
                    continue;
                }
                List<List<String>> current = table.get(i)
                        .stream()
                        .map(ArrayList::new)
                        .collect(Collectors.toList());
                current.forEach(arr -> arr.add(prefix));
                table.get(i + prefix.length()).addAll(current);
            }
        }
        return table.get(target.length());
    }

}