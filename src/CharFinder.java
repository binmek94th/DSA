import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public Character firstRepeatedCharacter(String input){
        Set<Character> chars = new HashSet<>();

        for(var element : input.toCharArray()) {
            var check = chars.add(element);
            if (!check) return element;
        }
        return Character.MIN_VALUE;
    }
    public  Character firstNonRepeating(String input){
        Map<Character, Integer> map = new HashMap<>();

        var chars = input.toCharArray();
        for (var ch : chars) {
            var count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        for (var ch: chars){
            if (map.get(ch) == 1)
                return ch;
        }

        return Character.MIN_VALUE;
    }
}
