import org.junit.Test;

import static org.junit.Assert.assertEquals;
import RLE.Algorithm;

public class test {

    @Test
    public void encode() {

        assertEquals("4:a3:b", Algorithm.encode("aaaabbb"));
        assertEquals("2:t[hyp5]2:h", Algorithm.encode("tthyp5hh"));
        assertEquals("4:45:p3: 4:1", Algorithm.encode("4444ppppp   1111"));

    }
    @Test
    public void decode() {
        assertEquals("aaaabbb", Algorithm.decode("4:a3:b"));
        assertEquals("4444ppppp   1111", Algorithm.decode("4:45:p3: 4:1"));
    }

}
