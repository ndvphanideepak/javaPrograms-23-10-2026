package strings;
//https://www.youtube.com/watch?v=UaRbZqAsoco&list=PLFGoYjJG_fqpcoeCZsi_czihPa4GoFtrL&index=21
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class FindDuplicateElementsInAString {
    public static void main(String[] args) {
        String s = "Java is a great language";
        if (s == null)
            return;
        if (s.length() == 1)
            return;
        if (s.isEmpty())
            return;
        char[] words = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character ch : words) {
            if (ch == ' ') { continue; }
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else
                hashMap.put(ch, 1);
        }
      /*  Set<Map.Entry<Character, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + "----->" + entry.getValue());
            }
        }*/
        //using for each:
       /* hashMap.forEach((key, value) -> {
            if (value > 1 && key != ' ') {
                System.out.println(key + "----->" + value);
            }
        });*/

        //using streams and filter:
        hashMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1 && entry.getKey() != ' ')
                .forEach(entry -> System.out.println(entry.getKey() + "----->" + entry.getValue()));
    }
}
