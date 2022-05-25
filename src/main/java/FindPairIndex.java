import java.util.HashMap;
import java.util.Map;

public class FindPairIndex {
    public static void findChar(String[] inputChars) {
        Map<String, Integer> mapCharsIndex = new HashMap<>();
        for (int i = 0; i < inputChars.length; i++) {
            String sortedLine = inputChars[i].chars()
                    .sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            if (!mapCharsIndex.containsKey(sortedLine)) {
                mapCharsIndex.put(sortedLine, i);
            } else {
                System.out.println(sortedLine + " = " + mapCharsIndex.remove(sortedLine) + ", " + i);
            }
        }
    }
}
