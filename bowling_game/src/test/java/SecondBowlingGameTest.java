import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author the-markussohn
 *         2018-05-04.
 */
public class SecondBowlingGameTest {

    private SecondGame sg;

    @Before
    public void setUp() throws Exception {
        sg = new SecondGame();
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            sg.roll(pins);
        }
    }

    private void rollSpare() {
        sg.roll(6);
        sg.roll(4);
    }

    private void rollStrike() {
        sg.roll(10);
    }

    @Test
    public void gutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, sg.score());
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, sg.score());
    }

    @Test
    public void oneSpare() throws Exception {
        rollSpare();
        sg.roll(3);
        rollMany(17, 0);
        assertEquals(16, sg.score());
    }

    @Test
    public void oneStrike() throws Exception {
        rollStrike();
        sg.roll(2);
        sg.roll(7);
        rollMany(16, 0);
        assertEquals(28,  sg.score());
    }

    @Test
    public void perfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, sg.score());
    }
}
