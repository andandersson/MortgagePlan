

import application.FileUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FileUtilTest {
	private List<String> testList;
	
	@Test
	public void testGetLines() {
		testList = FileUtil.getLines("resources/prospects.txt");
		assertTrue(testList.get(0).equals("Juha,1000,5,2"));	
	}
}
