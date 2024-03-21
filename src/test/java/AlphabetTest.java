import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetTest {
    private static final int length = 10;
    private String result;

    @Test
    void testGeneratingUpperLettersLength(){
        result = Alphabet.generate(length, "upperLetters");
        assertEquals(length, result.length());
        assertTrue(result.matches("[A-Z]+"));
    }

    @Test
    void testGeneratingLowerLettersLength(){
        result = Alphabet.generate(length, "lowerLetters");
        assertEquals(length,result.length());
        assertTrue(result.matches("[a-z]+"));
    }

    @Test
    void testGeneratingNumbersLength(){
        result = Alphabet.generate(length,"numbers");
        assertEquals(length,result.length());
        assertTrue(result.matches("[0-9]+"));
    }

    @Test
    void testGeneratingSymbols(){
        result = Alphabet.generate(length,"symbols");
        assertEquals(length,result.length());
        assertTrue(result.matches("[!-/]+"));
    }
}