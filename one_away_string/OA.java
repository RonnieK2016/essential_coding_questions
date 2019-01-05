public class OA {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println(isOneAway("abcde", "abcd"));  // should return true
        System.out.println(isOneAway("abde", "abcde"));  // should return true
        System.out.println(isOneAway("a", "a"));  // should return true
        System.out.println(isOneAway("abcdef", "abqdef"));  // should return true
        System.out.println(isOneAway("abcdef", "abccef"));  // should return true
        System.out.println(isOneAway("abcdef", "abcde"));  // should return true
        System.out.println(isOneAway("aaa", "abc"));  // should return false
        System.out.println(isOneAway("abcde", "abc"));  // should return false
        System.out.println(isOneAway("abc", "abcde"));  // should return false
        System.out.println(isOneAway("abc", "bcc"));  // should return false
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {
        if(Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }        
        
        boolean equal = s1.length() == s2.length();
        
        if(s1.length() < s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        
        char[] ar1 = s1.toCharArray();
        char[] ar2 = s2.toCharArray();
        int idx1 = 0;
        int idx2 = 0;
        int difCount = 0;
        while(idx1 < ar1.length && idx2 < ar2.length) {
            if(ar1[idx1] != ar2[idx2]) {
                if(!equal) {
                    idx1++;
                }
                else {
                    idx1++;
                    idx2++;
                }
                difCount++;
                continue;
            }
            idx1++;
            idx2++;
        }        
        
        return difCount < 1;
    }
}
