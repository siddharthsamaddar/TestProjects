package project.practice.warmUp;

/*
Rabin-Karp Algorithm for Pattern Searching
hash( txt[s+1 .. s+m] ) = ( d ( hash( txt[s .. s+m-1]) – txt[s]*h ) + txt[s + m] ) mod q
hash( txt[s .. s+m-1] ) : Hash value at shift s.
hash( txt[s+1 .. s+m] ) : Hash value at next shift (or shift s+1)
d: Number of characters in the alphabet
q: A prime number
h: d^(m-1)

How does the above expression work?

This is simple mathematics, we compute decimal value of current window from previous window.
For example pattern length is 3 and string is “23456”
You compute the value of first window (which is “234”) as 234.
How how will you compute value of next window “345”? You will do (234 – 2*100)*10 + 5 and get 345.

Problem :
Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.
Examples:

Input:  txt[] = "THIS IS A TEST TEXT"
        pat[] = "TEST"
Output: Pattern found at index 10

Input:  txt[] =  "AABAACAADAABAABA"
        pat[] =  "AABA"
Output: Pattern found at index 0
        Pattern found at index 9
        Pattern found at index 12
 */

public class SearchPattern_RabinKarpHashing {
    //Using mod element to compute hash function as 101 and total count of ASCII alphabets 256 as d
    private static final int q = 101, d = 256;

    @SuppressWarnings("WeakerAccess")
    public static void search(String txt, String pat){
        int n = txt.length(), m = pat.length(), h=1;

        //Computing hash factor for pattern window
        for(int i = 0; i < m-1; i++)
            h = (h*d)%q;

        //Computing hash of text t and pattern p
        int t=0,p=0;
        for (int i = 0; i < m; i++){
            t = (t*d + txt.charAt(i))%q;
            p = (p*d + pat.charAt(i))%q;
        }

        //Check the hash values and computing next frames
        for (int i = 0,j; i <= n-m ; i++){
            if(p == t){
                for(j = 0; j < m; j++)
                    if(pat.charAt(j) != txt.charAt(i + j))
                        break;

                    if(j==m)
                        System.out.println("Pattern fount at index "+i);
            }

            //Compute hash for txt t, by shifting to next window
            if(i < n-m)
                //For eg. compute value of next window “345” from "23456"? You will do (234 – 2*100)*10 + 5 and get 345.
                t = ((t - txt.charAt(i)* h) * d + txt.charAt(i + m)) % q;
            //Adjust -ve hash value
            if(t < 0)
                t+=q;
        }
    }
    public static void main(String[] args)
    {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        search(txt, pat);
    }
}