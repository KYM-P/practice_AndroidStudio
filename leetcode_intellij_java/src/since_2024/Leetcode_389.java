package since_2024;
/*
Leetcode 389 : 통과, 2ms, 74.44%
 */
public class Leetcode_389 {
    public char findTheDifference(String s, String t) {
        int added_char = 0;
        for(int i = 0; i < t.length(); i++) {
            added_char += t.charAt(i);
        }
        for(int i = 0; i < s.length(); i++) {
            added_char -= s.charAt(i);
        }
        return (char)added_char;
    }
}
