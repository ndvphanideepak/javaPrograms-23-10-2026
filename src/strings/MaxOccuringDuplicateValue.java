package strings;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class MaxOccuringDuplicateValue {
    public static void main(String[] args) {
        String s = "Java is a great language";
        if (s == null || s.length() <= 1)
            return;
        char[] words = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character ch : words) {
            // Ignore spaces
            if (ch == ' ') {
                continue;
            }
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = hashMap.entrySet();
        char maxChar = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        System.out.println(maxChar + "----->" + maxCount);
        //using java 8:
        hashMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println(entry.getKey() + "----->" + entry.getValue()));
    }
}



