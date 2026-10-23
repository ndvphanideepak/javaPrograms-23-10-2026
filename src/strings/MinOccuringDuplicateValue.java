package strings;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class MinOccuringDuplicateValue {
    public static void main(String[] args) {
        String s = "Java is a great language  ";
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
        int minCount = Integer.MAX_VALUE;
// First loop: Find the minimum frequency among duplicate characters
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1 && entry.getValue() < minCount) {
                minCount = entry.getValue();
            }
        }
// Second loop: Print all characters having that minimum frequency
        if (minCount != Integer.MAX_VALUE) {
            for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == minCount) {
                    System.out.println(entry.getKey() + "----->" + entry.getValue());
                }
            }
        }
        //using java 8:
        //print all minimum occuring chracters
       /* hashMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .forEach(entry ->
                        System.out.println(entry.getKey() + "----->" + entry.getValue()));*/
        //print only minimum occuring duplicates
        int minmCount = hashMap.values().stream()
                .filter(count -> count > 1)
                .min(Integer::compareTo)
                .orElse(0);
        hashMap.entrySet().stream()
                .filter(entry -> entry.getValue() == minmCount && minmCount > 0)
                .forEach(entry ->
                        System.out.println(entry.getKey() + "----->" + entry.getValue()));
    }
}
