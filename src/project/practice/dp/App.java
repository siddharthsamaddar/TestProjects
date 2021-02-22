package project.practice.dp;
/*
In this repo, there are 3 different kinds of implementations of common software-intensive problems (Grid Traveler, Sum Problems and Construct Problems):

Naive implementation;
Dynamic implementation with memoization;
Dynamic implementation with tabulation.

The study was guided by this class - https://www.youtube.com/watch?v=oBt53YbR9Kk using JavaScript, and have tried to implement the same problems with Java.
*/

import java.util.Arrays;

public class App {

    static final GridTraveler gt = new GridTraveler();
    static final Sum s = new Sum();
    static final Construct c = new Construct();

    public static void main(String[] args) {
        gridTraveler();
        canSum();
        howSum();
        bestSum();
        canConstruct();
        countConstruct();
        allConstruct();
    }

    private static void gridTraveler() {
        System.out.println("\nNaive traveling solution:");
        System.out.println("For 2x2 Grid = " + gt.naiveTravel(2, 2));
        System.out.println("For 2x3 Grid = " + gt.naiveTravel(2, 3));
        System.out.println("For 3x3 Grid = " + gt.naiveTravel(3, 3));

        System.out.println("\nDynamic traveling with memoization solution:");
        System.out.println("For 2x2 Grid = " + gt.dynamicTravelMemo(2, 2));
        System.out.println("For 2x3 Grid = " + gt.dynamicTravelMemo(2, 3));
        System.out.println("For 3x3 Grid = " + gt.dynamicTravelMemo(3, 3));
        System.out.println("For 18x18 Grid = " + gt.dynamicTravelMemo(18, 18));

        System.out.println("\nDynamic traveling with tabulation solution:");
        System.out.println("For 2x2 Grid = " + gt.dynamicTravelTabular(2, 2));
        System.out.println("For 2x3 Grid = " + gt.dynamicTravelTabular(2, 3));
        System.out.println("For 3x3 Grid = " + gt.dynamicTravelTabular(3, 3));
        System.out.println("For 18x18 Grid = " + gt.dynamicTravelTabular(18, 18));
    }

    private static void canSum() {
        System.out.println("\nNaive can sum:");
        System.out.println("To reach 7 with 2, 3 -> " + s.naiveCanSum(7, Arrays.asList(2, 3)));
        System.out.println("To reach 7 with 5, 3, 4, 7 -> " + s.naiveCanSum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println("To reach 7 with 2, 4 -> " + s.naiveCanSum(7, Arrays.asList(2, 4)));
        System.out.println("To reach 8 with 2, 3, 5 -> " + s.naiveCanSum(8, Arrays.asList(2, 3, 5)));
        // System.out.println("To reach 300 with 7, 14 -> "+s.naiveCanSum(300, Arrays.asList(7,14)));

        System.out.println("\nDynamic can sum with memoization:");
        System.out.println("To reach 7 with 2, 3 -> " + s.dynamicCanSum(7, Arrays.asList(2, 3)));
        System.out.println("To reach 7 with 5, 3, 4, 7 -> " + s.dynamicCanSum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println("To reach 7 with 2, 4 -> " + s.dynamicCanSum(7, Arrays.asList(2, 4)));
        System.out.println("To reach 8 with 2, 3, 5 -> " + s.dynamicCanSum(8, Arrays.asList(2, 3, 5)));
        System.out.println("To reach 300 with 7, 14 -> " + s.dynamicCanSum(300, Arrays.asList(7, 14)));

        System.out.println("\nDynamic can sum with tabulation:");
        System.out.println("To reach 7 with 2, 3 -> " + s.dynamicCanSumTabular(7, Arrays.asList(2, 3)));
        System.out.println("To reach 7 with 5, 3, 4, 7 -> " + s.dynamicCanSumTabular(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println("To reach 7 with 2, 4 -> " + s.dynamicCanSumTabular(7, Arrays.asList(2, 4)));
        System.out.println("To reach 8 with 2, 3, 5 -> " + s.dynamicCanSumTabular(8, Arrays.asList(2, 3, 5)));
        System.out.println("To reach 300 with 7, 14 -> " + s.dynamicCanSumTabular(300, Arrays.asList(7, 14)));
    }

    private static void howSum() {
        Sum s = new Sum();
        System.out.println("\nNaive how sum:");
        System.out.println("To reach 7 with 2, 3 -> " + s.naiveHowSum(7, Arrays.asList(2, 3)));
        System.out.println("To reach 7 with 5, 3, 4, 7 -> " + s.naiveHowSum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println("To reach 7 with 2, 4 -> " + s.naiveHowSum(7, Arrays.asList(2, 4)));
        System.out.println("To reach 8 with 2, 3, 5 -> " + s.naiveHowSum(8, Arrays.asList(2, 3, 5)));
        // System.out.println("To reach 300 with 7, 14 -> "+s.naiveHowSum(300, Arrays.asList(7,14)));

        System.out.println("\nDynamic how sum with memoization:");
        System.out.println("To reach 7 with 2, 3 -> " + s.dynamicHowSumMemo(7, Arrays.asList(2, 3)));
        System.out.println("To reach 7 with 5, 3, 4, 7 -> " + s.dynamicHowSumMemo(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println("To reach 7 with 2, 4 -> " + s.dynamicHowSumMemo(7, Arrays.asList(2, 4)));
        System.out.println("To reach 8 with 2, 3, 5 -> " + s.dynamicHowSumMemo(8, Arrays.asList(2, 3, 5)));
        System.out.println("To reach 300 with 7, 14 -> " + s.dynamicHowSumMemo(300, Arrays.asList(7, 14)));

        System.out.println("\nDynamic how sum with tabulation:");
        System.out.println("To reach 7 with 2, 3 -> " + s.dynamicHowSumTabular(7, Arrays.asList(2, 3)));
        System.out.println("To reach 7 with 5, 3, 4, 7 -> " + s.dynamicHowSumTabular(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println("To reach 7 with 2, 4 -> " + s.dynamicHowSumTabular(7, Arrays.asList(2, 4)));
        System.out.println("To reach 8 with 2, 3, 5 -> " + s.dynamicHowSumTabular(8, Arrays.asList(2, 3, 5)));
        System.out.println("To reach 300 with 7, 14 -> " + s.dynamicHowSumTabular(300, Arrays.asList(7, 14)));
    }

    private static void bestSum() {
        Sum s = new Sum();
        System.out.println("\nNaive can sum:");
        System.out.println("To reach 7 with 5, 3, 4, 7 -> " + s.naiveBestSum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println("To reach 8 with 3, 5 -> " + s.naiveBestSum(8, Arrays.asList(3, 5)));
        System.out.println("To reach 8 with 1, 4, 5 -> " + s.naiveBestSum(8, Arrays.asList(1, 4, 5)));
        // System.out.println("To reach 100 with 1, 2, 5, 25 -> "+s.naiveBestSum(100, Arrays.asList(1,2,5,25)));

        System.out.println("\nDynamic best sum with memoization:");
        System.out.println("To reach 7 with 5, 3, 4, 7 -> " + s.dynamicBestMemo(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println("To reach 8 with 3, 5 -> " + s.dynamicBestMemo(8, Arrays.asList(3, 5)));
        System.out.println("To reach 8 with 1, 4, 5 -> " + s.dynamicBestMemo(8, Arrays.asList(1, 4, 5)));
        System.out.println("To reach 100 with 1, 2, 5, 25 -> " + s.dynamicBestMemo(100, Arrays.asList(1, 2, 5, 25)));

        System.out.println("\nDynamic best sum with tabulation:");
        System.out.println("To reach 7 with 5, 3, 4, 7 -> " + s.dynamicBestSumTabular(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println("To reach 8 with 3, 5 -> " + s.dynamicBestSumTabular(8, Arrays.asList(3, 5)));
        System.out.println("To reach 8 with 1, 4, 5 -> " + s.dynamicBestSumTabular(8, Arrays.asList(1, 4, 5)));
        System.out.println("To reach 100 with 1, 2, 5, 25 -> " + s.dynamicBestSumTabular(100, Arrays.asList(1, 2, 5, 25)));
    }

    private static void canConstruct() {
        System.out.println("\nNaive construct:");
        System.out.println("To get skate from sk, ate -> " + c.naiveCanConstruct("skate", Arrays.asList("sk", "ate")));
        System.out.println("To get abcdef from ab, cd, abc, bc, de, ef -> " + c.naiveCanConstruct("abcdef", Arrays.asList("ab", "cd", "abc", "bc", "de", "ef")));
        System.out.println("To get abcdef from ab, cd, abc, bc, f -> " + c.naiveCanConstruct("abcdef", Arrays.asList("ab", "cd", "abc", "bc", "f")));

        System.out.println("\nDynamic construct with memoization:");
        System.out.println("To get skate from sk, ate -> " + c.dynamicCanConstructMemo("skate", Arrays.asList("sk", "ate")));
        System.out.println("To get abcdef from ab, cd, abc, bc, de, ef -> " + c.dynamicCanConstructMemo("abcdef", Arrays.asList("ab", "cd", "abc", "bc", "de", "ef")));
        System.out.println("To get abcdef from ab, cd, abc, bc, f -> " + c.dynamicCanConstructMemo("abcdef", Arrays.asList("ab", "cd", "abc", "bc", "f")));
        System.out.println("To get eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef from e, ee, eee, eeee, eeeeee, eeeeeee, eeeeeeee -> " + c.dynamicCanConstructMemo(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                Arrays.asList("e", "ee", "eee", "eeee", "eeeeee", "eeeeeee", "eeeeeeee")));

        System.out.println("\nDynamic construct with tabulation:");
        System.out.println("To get skate from sk, ate -> " + c.dynamicCanConstructTabular("skate", Arrays.asList("sk", "ate")));
        System.out.println("To get abcdef from ab, cd, abc, bc, de, ef -> " + c.dynamicCanConstructTabular("abcdef", Arrays.asList("ab", "cd", "abc", "bc", "de", "ef")));
        System.out.println("To get abcdef from ab, cd, abc, bc, f -> " + c.dynamicCanConstructTabular("abcdef", Arrays.asList("ab", "cd", "abc", "bc", "f")));
        System.out.println("To get eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef from e, ee, eee, eeee, eeeeee, eeeeeee, eeeeeeee -> " + c.dynamicCanConstructTabular(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                Arrays.asList("e", "ee", "eee", "eeee", "eeeeee", "eeeeeee", "eeeeeeee")));
    }

    private static void countConstruct() {
        System.out.println("\nNaive construct:");
        System.out.println("To get purple from purp, p, ur, le, purpl -> " + c.naiveCountConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println("To get abcdef from ab, abc, cd, def, abcd -> " + c.naiveCountConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println("To get skateboard from bo, rd, ate, t, ska, sk, boar -> " + c.naiveCountConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println("To get enterapotentpot from a, p, ent, enter, ot, o, t -> " + c.naiveCountConstruct("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));

        System.out.println("\nDynamic construct with memoization:");
        System.out.println("To get purple from purp, p, ur, le, purpl -> " + c.dynamicCountConstructMemo("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println("To get abcdef from ab, abc, cd, def, abcd -> " + c.dynamicCountConstructMemo("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println("To get skateboard from bo, rd, ate, t, ska, sk, boar -> " + c.dynamicCountConstructMemo("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println("To get enterapotentpot from a, p, ent, enter, ot, o, t -> " + c.dynamicCountConstructMemo("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
        System.out.println("To get eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef from e, ee, eee, eeee, eeeeee, eeeeeee, eeeeeeee -> " + c.dynamicCountConstructMemo(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                Arrays.asList("e", "ee", "eee", "eeee", "eeeeee", "eeeeeee", "eeeeeeee")));

        System.out.println("\nDynamic construct with tabulation:");
        System.out.println("To get purple from purp, p, ur, le, purpl -> " + c.dynamicCountConstructTabular("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println("To get abcdef from ab, abc, cd, def, abcd -> " + c.dynamicCountConstructTabular("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println("To get skateboard from bo, rd, ate, t, ska, sk, boar -> " + c.dynamicCountConstructTabular("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println("To get enterapotentpot from a, p, ent, enter, ot, o, t -> " + c.dynamicCountConstructTabular("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
        System.out.println("To get eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef from e, ee, eee, eeee, eeeeee, eeeeeee, eeeeeeee -> " + c.dynamicCountConstructMemo(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                Arrays.asList("e", "ee", "eee", "eeee", "eeeeee", "eeeeeee", "eeeeeeee")));
    }

    private static void allConstruct() {
        Construct c = new Construct();
        System.out.println("\nNaive construct:");
        System.out.println("To get purple from purp, p, ur, le, purpl -> " + c.naiveAllConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println("To get abcdef from ab, abc, cd, def, abcd -> " + c.naiveAllConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println("To get skateboard from bo, rd, ate, t, ska, sk, boar -> " + c.naiveAllConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println("To get enterapotentpot from a, p, ent, enter, ot, o, t -> " + c.naiveAllConstruct("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));

        System.out.println("\nDynamic construct with memoization:");
        System.out.println("To get purple from purp, p, ur, le, purpl -> " + c.dynamicAllConstructMemo("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println("To get abcdef from ab, abc, cd, def, abcd -> " + c.dynamicAllConstructMemo("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println("To get skateboard from bo, rd, ate, t, ska, sk, boar -> " + c.dynamicAllConstructMemo("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println("To get enterapotentpot from a, p, ent, enter, ot, o, t -> " + c.dynamicAllConstructMemo("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
        System.out.println("To get eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef from e, ee, eee, eeee, eeeeee, eeeeeee, eeeeeeee -> " + c.dynamicAllConstructMemo(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                Arrays.asList("e", "ee", "eee", "eeee", "eeeeee", "eeeeeee", "eeeeeeee")));

        System.out.println("\nDynamic construct with tabulation:");
        System.out.println("To get purple from purp, p, ur, le, purpl -> " + c.dynamicAllConstructTabular("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println("To get abcdef from ab, abc, cd, def, abcd -> " + c.dynamicAllConstructTabular("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println("To get skateboard from bo, rd, ate, t, ska, sk, boar -> " + c.dynamicAllConstructTabular("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println("To get enterapotentpot from a, p, ent, enter, ot, o, t -> " + c.dynamicAllConstructTabular("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
        System.out.println("To get eeeeeeeeeeeeeeeeeeeef from e, ee, eee, eeee, eeeeee, eeeeeee, eeeeeeee -> " + c.dynamicAllConstructTabular(
                "eeeeeeeeeeeeeeeeeeeef",
                Arrays.asList("e", "ee", "eee", "eeee", "eeeeee", "eeeeeee", "eeeeeeee")));
    }
}