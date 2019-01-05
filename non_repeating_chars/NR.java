import java.util.HashMap;

public class NR {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println(nonRepeating("abcab")); // should return 'c'
        System.out.println(nonRepeating("abab")); // should return null
        System.out.println(nonRepeating("aabbbc")); // should return 'c'
        System.out.println(nonRepeating("aabbdbc")); // should return 'd'
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {
        int[] chars =  new int[27];
        char[] arr = s.toCharArray();
        for(char ch : arr) {
            chars[ch-'a']++;
        }
        
        for(char ch : arr) {
            if(chars[ch - 'a'] == 1) {
                return ch;
            }
        }
        
        return null;
    }
}
