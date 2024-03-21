import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    private Generator generator;
    private String result;

    @BeforeEach
    void setUp(){
        generator = new Generator(10,true
                ,true,true,true);
        result = generator.generate();
    }
    @Test
    void testGeneratorLength(){
        assertEquals(10,result.length());
    }

    @Test
    void testGeneratedValuesHasUpperLetters(){
        boolean hasUppercaseLetters = false;
        for (int i = 0; i < result.length(); i++) {
            if (Character.isLetter(result.charAt(i))){
                if (Character.isUpperCase(result.charAt(i))){
                    hasUppercaseLetters = true;
                    break;
                }
            }
        }
        assertTrue(hasUppercaseLetters);
    }

    @Test
    void testGeneratedValuesHasLowerLetters(){
        boolean hasLowerLetters = false;
        for (int i = 0; i < result.length(); i++) {
            if (Character.isLetter(result.charAt(i))){
                if (Character.isLowerCase(result.charAt(i))){
                    hasLowerLetters = true;
                    break;
                }
            }
        }
        assertTrue(hasLowerLetters);
    }

    @Test
    void testGeneratedValuesHasNumbers(){
        boolean hasNumbers = false;
        for (int i = 0; i < result.length(); i++) {
            if (Character.isDigit(result.charAt(i))){
                hasNumbers = true;
                break;
            }
        }
        assertTrue(hasNumbers);
    }
    @Test
    void testGeneratedValuesHasSymbols(){
        boolean hasSymbols = false;
        for (int i = 0; i < result.length(); i++) {
            if (!(Character.isDigit(result.charAt(i)) && Character.isLetter(result.charAt(i)))){
                hasSymbols = true;
                break;
            }
        }
        assertTrue(hasSymbols);
    }
}