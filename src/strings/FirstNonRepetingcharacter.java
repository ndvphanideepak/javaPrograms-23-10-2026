package strings;
import java.util.HashMap;
import java.util.Map;
//https://www.youtube.com/watch?v=RJ9huDP_jeM&t=1s
public class FirstNonRepetingcharacter {
    public static void main(String[] args) {
        String input = "AABCDBECF";

        for (int i = 0; i < input.length(); i++) {

            boolean unique = true;

            for (int j = 0; j < input.length(); j++) {

                if (i != j && input.charAt(i) == input.charAt(j)) {
                    unique = false;
                    break;
                }
            }

            if (unique) {
                System.out.println("First non-repeating character: "
                        + input.charAt(i));
                break;
            }
        }

        //Approch-2:
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        System.out.println(map);

        for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {

            if (entrySet.getValue() == 1) {
                System.out.println(entrySet.getKey());
                break;
            }
        }
    }
}
