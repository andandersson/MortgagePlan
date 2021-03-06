package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The only purpose of this class is scanning the text-file.
 * Since there are only one method, and the purpose of the class
 * will not change, it is of no reason to create objects outside
 * the class.
 * That is why the only method is static, and the singleton-
 * pattern is being used.
 */
public final class FileUtil {


	/**
	 * A private constructor
	 * for implementing the singleton-pattern
	 */
	private FileUtil(){
	}

	/**
	 * This method is scanning the text-file, and storing it in
	 * a List.
	 */
	public static List<String> getLines(String filepath) throws FileNotFoundException{
		Scanner scan;
		String temp;
		String tempChar;
		List dataList = new ArrayList<>();
			scan = new Scanner(new File(filepath));
			scan.useDelimiter("\n");
			scan.hasNextLine();
			scan.next();
			while (scan.hasNext()) {
				temp = scan.next();
				if (temp.isBlank()) {
					break;
				}
				char ch = temp.charAt(0);
				tempChar = String.valueOf(ch);
				dataList.add(temp);
			}
			scan.close();
		return dataList;
	}
}
