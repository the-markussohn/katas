import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author the-markussohn
 *         2018-05-04.
 */
public class StringCalculator {

    private final String[] delimiters = new String[]{",", "\n"};

    public int calculateSum(String s) {
        return hasLength(s) ? IntStream.of(getNumbersFromString(s)).sum() : 0;
    }

    private int[] getNumbersFromString(String s) {
        return Stream.of(splitString(s)).mapToInt(Integer::parseInt).toArray();
    }

    private String[] splitString(String s) {
        List<String> delimitersInString = findDelimiters(s);
        String splitPattern = getSplitPattern(delimitersInString);
        return s.split(splitPattern);
    }

    private String getSplitPattern(List<String> delimitersInString) {
        StringBuilder splitPattern = new StringBuilder();
        for (int delimiter = 0; delimiter < delimitersInString.size(); delimiter++) {
            splitPattern.append(delimitersInString.get(delimiter));
            if (!isFinalDelimiter(delimitersInString, delimiter))
                splitPattern.append("|");
        }
        return splitPattern.toString();
    }

    private boolean isFinalDelimiter(List<String> delimitersInString, int delimiter) {
        return delimiter == delimitersInString.size() - 1;
    }

    private List<String> findDelimiters(String s) {
        List<String> delimitersInString = new ArrayList<>();
        for (String d : delimiters) {
            if (s.contains(d))
                delimitersInString.add(d);
        }
        return delimitersInString;
    }

    private boolean hasLength(String s) {
        return s != null && !s.isEmpty();
    }
}
