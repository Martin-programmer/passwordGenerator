import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RandomiseOrderTest {

    @Test
    void testRandomiseLength(){
        String result = RandomiseOrder.random("1234");
        assertEquals(4,result.length());
        assertFalse(Boolean.parseBoolean(result = "1234"));
    }
}