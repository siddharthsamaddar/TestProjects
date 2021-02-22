package project.practice.warmUp;
/*
Write a function allConstruct(target, wordBank) that accepts a target string and an array of strings.
The function should return a 2D array containing all the ways that the target can be constructed by concatenating elements of the wordBank array.
You may re-use elements of wordBank as many times as needed.
*/

import java.util.WeakHashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllConstructMemoization {
    static List<List<String>> allConstruct(String target, String[] wordBank, Map<String, List<List<String>>> memo) {

        if (memo.containsKey(target)) return memo.get(target);

        //If target is acquirable then return [[]] ie. an empty array inside a list, a boundary condition to start adding eligible elements on our empty array.
        if (target.isEmpty()) return Collections.singletonList(new ArrayList<>());

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                List<List<String>> suffixWays = allConstruct(target.replaceFirst(word, ""), wordBank, memo)
                        .stream()
                        .map(ArrayList::new)
                        .collect(Collectors.toList());
                suffixWays.forEach(a -> a.add(0, word));
                result.addAll(suffixWays);
            }
        }
        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("All the ways that the target can be constructed by concatenating elements of the wordBank array are as follows -");
        System.out.println("\nTarget `purple` with wordBank [purp, p, ur, le, purpl]\n" + Arrays.toString((allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, new WeakHashMap<>())).toArray()));
        System.out.println("\nTarget `abcdef` with wordBank [ab, abc, cd, def, abcd, ef, c]\n" + Arrays.toString((allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}, new WeakHashMap<>())).toArray()));
        System.out.println("\nTarget `skateboard` with wordBank [bo, rd, ate, t, ska, sk, boar]\n" + Arrays.toString((allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new WeakHashMap<>())).toArray()));
        System.out.println("\nTarget `aaaaaaaaaaaaaaaaaaaaaaaaaaz` with wordBank [a, aa, aaa, aaaa, aaaaa]\n" + Arrays.toString((allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaz", new String[]{"a", "aa", "aaa", "aaaa", "aaaaa"}, new WeakHashMap<>())).toArray()));
    }
}