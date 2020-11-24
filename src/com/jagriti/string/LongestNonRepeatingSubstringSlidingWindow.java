package com.jagriti.string;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestNonRepeatingSubstringSlidingWindow {

    //Sliding window
    public static int SlidingWindowOptimalSol(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new LinkedHashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
//bruteForce
    public static int lengthOfLongestSubstring(String str) {

        int n=str.length();
        int l,m;
        l=m=0;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                String s=str.substring(i, j);
                if(checkUniqueSubString(s))
                {
                    m=s.length();
                    if(m>l)
                        l=m;
                }
            }
        }
        return l;
    }

    public static boolean checkUniqueSubString(String s)
    {
        HashSet<Character> ch=new HashSet<>();
        for(char c:s.toCharArray())
        {
            if(!ch.add(c))
                return false;
        }
        return true;
    }

    public static void main(String args[])
    {
        String s="abcababbc";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(SlidingWindowOptimalSol(s));
    }
}
