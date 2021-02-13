package project.practice.warmUp;
/*
We are traveling on a 2D grid. We begin on the top left corner and our goal is to travel to the bottom-right corner.
We may only move either down or right at a time.
In how many ways can we travel to the goal on a grid with dimensions m*n ?
Write a function gridTraveler(m,n) that calculates the same.
*/
//import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class GridTravelerMemoization {

    static final Map<String, Long> memo = new HashMap<>();

    static long gridTraveler(int m, int n) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        long result = gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Number of ways can we travel to the goal on a grid with dimensions");
        System.out.println("1x1 = " + gridTraveler(1, 1));
        System.out.println("2x3 = " + gridTraveler(2, 3));
        System.out.println("3x2 = " + gridTraveler(3, 2));
        System.out.println("3x3 = " + gridTraveler(3, 3));
        System.out.println("18x18 = " + gridTraveler(18, 18));
/*
        Scanner s = new Scanner(System.in);
        //Get co-ordinates of the grid
        System.out.println("Enter the co-ordinates");
        System.out.print("X = ");
        int x= s.nextInt();
        System.out.print("Y = ");
        int y= s.nextInt();
        System.out.print("Number of ways can we travel to the goal on a grid with dimensions "+x+"x"+y+" = "+gridTraveler(x,y));
*/
    }
}
