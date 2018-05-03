import java.util.ArrayList;
import java.util.List;

/**
 * @author the-markussohn
 *         2018-05-03.
 */
public class Game {
    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        int score = 0;
        int firstInFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(firstInFrame)) {
                score += 10 + nextTwoBallsForStrike(firstInFrame);
                firstInFrame++;
            }
            else if (isSpare(firstInFrame)) {
                score += 10 + nextBallForSpare(firstInFrame);
                firstInFrame += 2;
            } else {
                score += twoBallsInFrame(firstInFrame);
                firstInFrame += 2;
            }
        }
        return score;
    }

    private int twoBallsInFrame(int firstInFrame) {
        return rolls.get(firstInFrame) + rolls.get(firstInFrame + 1);
    }

    private Integer nextBallForSpare(int firstInFrame) {
        return rolls.get(firstInFrame + 2);
    }

    private int nextTwoBallsForStrike(int firstInFrame) {
        return rolls.get(firstInFrame + 1) + rolls.get(firstInFrame + 2);
    }

    private boolean isStrike(int firstInFrame) {
        return rolls.get(firstInFrame) == 10;
    }

    private boolean isSpare(int firstInFrame) {
        return twoBallsInFrame(firstInFrame) == 10;
    }
}
