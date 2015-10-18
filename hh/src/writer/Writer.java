package writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Writer {

	public final static String inputFileName = "input.txt";
	public final static String outputFileName = "output.txt";

	public static <T> void start(Class<T> clazz) {
		try {
			Method searchMethod = clazz.getMethod("processTask",
					new Class<?>[] { Scanner.class, PrintWriter.class });
			searchMethod.invoke(clazz, getInputer(), getOutputer());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static boolean isInputFileExists() {
		return (new File(inputFileName).exists());
	}

	public static Scanner getInputer() throws FileNotFoundException {
		if (isInputFileExists()) {
			return new Scanner(new FileInputStream(inputFileName));
		}
		return new Scanner(new InputStreamReader(System.in));
	}

	public static PrintWriter instance = null;

	public static PrintWriter getOutputer() throws FileNotFoundException {
		if (instance == null) {
			if (isInputFileExists()) {
				return instance = new PrintWriter(new FileOutputStream(
						outputFileName));
			}
			return instance = new PrintWriter(
					new OutputStreamWriter(System.out));
		}
		return instance;
	}

	public static void close() {
		try {
			System.out.println("");
			System.out.println("Программа завершилась.");
			getInputer().close();
			getOutputer().close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
