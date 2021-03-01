
import application.FileUtil;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.List;
import static org.junit.Assert.assertTrue;

/**
 * This class is providing test-methods for testing the logic
 * in the FileUtil-class.
 */
public class FileUtilTest {
	private List<String> testList;

	/**
	 * This method is testing the parsing of the text-file, as well
	 * as assuring that it is done correctly, by checking an example-line.
	 */
	@Test
	public void testGetLines() throws FileNotFoundException {
		testList = FileUtil.getLines("src/main/resources/prospects.txt");
		assertTrue(testList.get(0).equals("Juha,1000,5,2"));	
	}
}
