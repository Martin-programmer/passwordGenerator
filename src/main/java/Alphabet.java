import java.util.Random;

public class Alphabet {

    public static String generate(int length, String type){
        String output = "";
        switch (type){
            case "upperLetters":
                output = generateData(length,65,90);
                break;
            case "lowerLetters":
                output = generateData(length,97,122);
                break;
            case "numbers":
                output = generateData(length,48,57);
                break;
            case "symbols":
                output = generateData(length,33,47);
                break;
        }
        return output;
    }

    private static String generateData(int length, int min, int max){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomValue = random.nextInt(max - min) + min;
            sb.append((char) randomValue);
        }
        return sb.toString();
    }

}
