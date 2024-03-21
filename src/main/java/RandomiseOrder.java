import java.util.*;

public class RandomiseOrder {

    public static String random(String text){
        List<Character> textAsCharacters = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            textAsCharacters.add(text.charAt(i));
        }
        Collections.shuffle(textAsCharacters);
        StringBuilder sb = new StringBuilder();
        for (Character character : textAsCharacters) {
            sb.append(character);
        }
        return sb.toString();
    }
}
