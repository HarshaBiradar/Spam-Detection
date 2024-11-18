/*
public class Horspool
{
    public static int SIZE=500;
    public static int table[]=new int[SIZE];

    public void shifttable(String pattern) {

        int i,j,m;
        char p[] = pattern.toCharArray();
        m=pattern.length();

        for (i=0;i<SIZE;i++)
            table[i]=m;
        for (j=0;j<m-1;j++)
            table[p[j]]=m-1-j;
    }
    public int horspool(String source,String pattern)
    {

        int i,k,pos,m;
        char s[] = source.toCharArray();
        char p[] = pattern.toCharArray();
        m=pattern.length();

        for(i=m-1;i<source.length();)
        {
            k=0;
            while((k<m) && (p[m-1-k] == s[i-k]))
                k++;
            if(k==m)
            {   pos=i-m+2;
                return pos;
            }
            else
                i+=table[s[i]];
        }
        return -1;
    }

    public int execute(String Message,String pattern)
    {
        int pos;
        shifttable(pattern);
        pos = horspool(Message,pattern);


        return pos;
    }

}
*/

import java.util.*;

public class Horspool {

    public static int SIZE = 256; // Adjusted size for ASCII

    public static int table[] = new int[SIZE];

    // Method to create the shift table
    public void shifttable(String pattern) {
        int m = pattern.length();
        char p[] = pattern.toCharArray();

        // Initialize the table with default shift values
        for (int i = 0; i < SIZE; i++) {
            table[i] = m; // Default shift is pattern length
        }

        // Set shifts for characters in the pattern
        for (int j = 0; j < m - 1; j++) {
            table[p[j]] = m - 1 - j;
        }
    }

    // Method that performs the Horspool pattern matching algorithm
    public int horspool(String source, String pattern) {
        int m = pattern.length();
        int n = source.length();
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();

        // Start matching from the end of the pattern
        for (int i = m - 1; i < n;) {
            int k = 0;
            // Compare pattern with source from right to left
            while ((k < m) && (p[m - 1 - k] == s[i - k])) {
                k++;
            }

            // If the entire pattern is matched
            if (k == m) {
                return i - m + 1; // 0-based index
            } else {
                // Shift by the value in the shift table
                i += table[s[i]];
            }
        }

        return -1; // No match found
    }

    // Method to execute pattern matching
    public int execute(String message, String pattern) {
        shifttable(pattern);  // Create shift table for the pattern
        return horspool(message, pattern); // Execute Horspool search
    }

    // Main method for testing
    public static void main(String[] args) {
        Horspool hp = new Horspool();

        // Test case
        String source = "ababcabcabababd";
        String pattern = "ababd";

        int position = hp.execute(source, pattern);

        if (position != -1) {
            System.out.println("Pattern found at position: " + position);
        } else {
            System.out.println("Pattern not found.");
        }
    }
}
