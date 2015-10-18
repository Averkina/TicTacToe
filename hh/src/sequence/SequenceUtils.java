package sequence;

import static writer.Writer.getOutputer;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SequenceUtils {
	public static void checkSequence(final String inputSequence)
			throws FileNotFoundException {

		if (inputSequence.length() < 1) {
			getOutputer().write("Ошибка! Строка не может быть пустой.");
			throw new IllegalArgumentException();
		}

		Pattern patternD = Pattern.compile("\\D");
		Matcher matcherD = patternD.matcher(inputSequence);
		if (matcherD.find()) {
			getOutputer().write("Ошибка! Строка может содеражть только цифры.");
			throw new IllegalArgumentException();
		}

		Pattern patternS = Pattern.compile("\\s");
		Matcher matcherS = patternS.matcher(inputSequence);
		if (matcherS.find()) {
			getOutputer().write("Ошибка! Строка не может содеражть пробелы.");
			throw new IllegalArgumentException();
		}
	}
}