import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author the-markussohn
 *         2018-05-04.
 */
public class StringCalculatorTest {

    private StringCalculator sc;

    @Before
    public void setUp() throws Exception {
        sc = new StringCalculator();
    }

    @Test
    public void emptyStringReturnsZero() throws Exception {
        assertEquals(0, sc.calculateSum(""));
    }

    @Test
    public void singleNumberReturnsValue() throws Exception {
        assertEquals(1, sc.calculateSum("1"));
    }

    @Test
    public void twoNumbersCommaDelimitedReturnSum() throws Exception {
        assertEquals(2, sc.calculateSum("1,1"));
    }

    @Test
    public void twoNumbersNewLineDelimitedReturnSum() throws Exception {
        assertEquals(2, sc.calculateSum("1\n1"));
    }

    @Test
    public void differentDelimitersReturnSum() throws Exception {
        assertEquals(6, sc.calculateSum("1\n2,3"));
    }
}
