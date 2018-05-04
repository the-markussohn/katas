import java.util.ArrayList;
import java.util.List;

/**
 * @author the-markussohn
 *         2018-05-04.
 */
public class SecondGame {
    private List<Integer> rolls = new ArrayList<>();
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls.add(currentRoll++, pins);
    }

    @SuppressWarnings("Duplicates")
    public int score() {
        int score = 0;
        int firstInFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(firstInFrame)) {
                score += 10 + nextBallForSpare(firstInFrame);
                firstInFrame += 2;
            } else if (isStrike(firstInFrame)) {
                score += 10 + nextTwoBallsForStrike(firstInFrame);
                firstInFrame++;
            } else {
                score += twoBallsInFrame(firstInFrame);
                firstInFrame += 2;
            }
        }
        return score;
    }

    private int nextTwoBallsForStrike(int firstInFrame) {
        return rolls.get(firstInFrame + 1) + rolls.get(firstInFrame + 2);
    }

    private boolean isStrike(int firstInFrame) {
        return rolls.get(firstInFrame) == 10;
    }

    private Integer nextBallForSpare(int firstInFrame) {
        return rolls.get(firstInFrame + 2);
    }

    private int twoBallsInFrame(int firstInFrame) {
        return rolls.get(firstInFrame) + rolls.get(firstInFrame + 1);
    }

    private boolean isSpare(int firstInFrame) {
        return twoBallsInFrame(firstInFrame) == 10;
    }
}
