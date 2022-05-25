import data.OutputConsoleList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FindPairIndexTest {
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private PrintStream consoleReader = new PrintStream(this.baos, true);

    @Before
    public void init() {
        System.setOut(this.consoleReader);
    }

    @Test
    public void matchShortList() {
        String[] inputList = new String[]{"qwe", "wqe", "qwee", "a", "a"};
        FindPairIndex.findChar(inputList);
        String[] actual = this.baos.toString().split("\\r\\n");
        Assert.assertArrayEquals(OutputConsoleList.expectedShortList, actual);
    }

    @Test
    public void matchLongList() {
        String[] inputList = new String[]{"qwe", "wqe", "qwee", "a", "a", "Qwe", "wQe", "", "прр", "пРР", "прр", String.copyValueOf(new char[]{'b', 'c', 'd'}), String.copyValueOf(new char[]{'b', 'c', 'd'}), "cbd"};
        FindPairIndex.findChar(inputList);
        String[] actual = this.baos.toString().split("\\r\\n");
        Assert.assertArrayEquals(OutputConsoleList.expectedLongList, actual);
    }

    @Test(expected = NullPointerException.class)
    public void checkEmptyList() {
        String[] inputList = new String[10];
        FindPairIndex.findChar(inputList);
    }

    @Test(expected = NullPointerException.class)
    public void checkNull() {
        String[] inputList = null;
        FindPairIndex.findChar(inputList);
    }
}
