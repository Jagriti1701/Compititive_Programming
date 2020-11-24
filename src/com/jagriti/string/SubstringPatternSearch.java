package com.jagriti.string;

//This algorithm finds all occurrences of a pattern in a text in linear time.
// Let length of text be n and of pattern be m, then total time taken is O(m + n) with linear space complexity.
// Now we can see that both time and space complexity is same as KMP algorithm but this algorithm is Simpler to understand.
// In this algorithm, we construct a Z array.
//What is Z Array?
//For a string str[0..n-1], Z array is of same length as string.
// An element Z[i] of Z array stores length of the longest substring starting from str[i] which is
// also a prefix of str[0..n-1]. The first entry of Z array is meaning less as complete string is
// always prefix of itself.
//Example:
//        Index            0   1   2   3   4   5   6   7   8   9  10  11
//        Text             a   a   b   c   a   a   b   x   a   a   a   z
//        Z values         X   1   0   0   3   1   0   0   2   2   1   0
public class SubstringPatternSearch {

    public static void main(String args[])
    {
        String s="AABACAADAABAABA";
        String pat="AABA";

        printOut(prepareZArr(s,pat),pat.length());
    }

    public static int[] prepareZArr(String s, String pat)
    {
        String str2=pat+"$"+s;
        int n=str2.length();
        int Z[]=new int[n];
        // [L,R] make a window which matches with
        // prefix of s
        int L = 0, R = 0;

        for(int i = 1; i < n; ++i) {

            // if i>R nothing matches so we will calculate.
            // Z[i] using naive way.
            if(i > R){

                L = R = i;

                // R-L = 0 in starting, so it will start
                // checking from 0'th index. For example,
                // for "ababab" and i = 1, the value of R
                // remains 0 and Z[i] becomes 0. For string
                // "aaaaaa" and i = 1, Z[i] and R become 5

                while(R < n && str2.charAt(R - L) == str2.charAt(R))
                    R++;

                Z[i] = R - L;
                R--;

            }
            else{

                // k = i-L so k corresponds to number which
                // matches in [L,R] interval.
                int k = i - L;

                // if Z[k] is less than remaining interval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3, R = 5
                // and L = 2
                if(Z[k] < R - i + 1)
                    Z[i] = Z[k];

                    // For example str = "aaaaaa" and i = 2, R is 5,
                    // L is 0
                else{


                    // else start from R and check manually
                    L = i;
                    while(R < n && str2.charAt(R - L) == str2.charAt(R))
                        R++;

                    Z[i] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }

    public static void printOut(int z[], int patLen)
    {
        // now looping through Z array for matching condition
        for(int i = 0; i < z.length; ++i){

            // if Z[i] (matched region) is equal to pattern
            // length we got the pattern

            if(z[i] == patLen){
                System.out.println("Pattern found at index "
                        + (i - patLen - 1));
            }
        }
    }

}
