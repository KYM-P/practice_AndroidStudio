package since_2024;
/*
Leetcode 1456 : 통과, 9ms, 95.47%
 */
public class Leetcode_1456 {
    public int maxVowels(String s, int k) {
        int answer = 0;
        int count = 0;
        int start_index = 0;
        boolean[] vowel_index = new boolean[s.length()];
        for(int end_index = 0; end_index < k; end_index++) {
            char c = s.charAt(end_index);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) {
                vowel_index[end_index] = true;
                count++;
            }
        }
        answer = count;
        for(int end_index = k; end_index < s.length(); end_index++) {
            char c = s.charAt(end_index);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) {
                vowel_index[end_index] = true;
                count++;
            }
            if(vowel_index[start_index])count--;
            start_index++;
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
