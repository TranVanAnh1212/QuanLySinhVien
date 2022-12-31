package Files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import Model.Student2611;

public class writeToFile2611 {
	private static String fileName = "Student.txt";
	
	public static void write ( ArrayList<Student2611> arrStu) {
		try {
			BufferedWriter writer = new BufferedWriter( new FileWriter(fileName));
			for (Student2611 sv : arrStu) {
				String obj = sv.toString();
				writer.write(obj);
				writer.newLine();
			}
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
