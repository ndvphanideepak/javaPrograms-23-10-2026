package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {
        String input = "abcabcdbb";

        int length = lengthOfLongestSubString(input);

        System.out.println("Longest substring length: " + length);
    }

    public static int lengthOfLongestSubString(String str) {

        int start = 0;
        int maxLength = 0;
        int longestStart = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {

            char curr = str.charAt(end);

            if (map.containsKey(curr)) {
                start = Math.max(start, map.get(curr) + 1);
            }

            map.put(curr, end);

            int currentLength = end - start + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestStart = start;
            }
        }

        String longestSubstring =
                str.substring(longestStart, longestStart + maxLength);

        System.out.println("Longest substring: " + longestSubstring);

        return maxLength;
    }
}
