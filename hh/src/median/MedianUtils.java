package median;

import static writer.Writer.getOutputer;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MedianUtils {

	public static double[] stringToArray(String[] inputStringArray)
			throws FileNotFoundException {

		double[] array = new double[inputStringArray.length];
		int i = 0;

		Locale theLocale = Locale.getDefault();
		NumberFormat numberFormat = DecimalFormat.getInstance(theLocale);
		Number theNumber;

		for (String str : inputStringArray) {
			if (str.contains(".")) {
				str = str.trim().replace(".", ",");
			}
			try {
				theNumber = numberFormat.parse(str.trim());
				array[i] = theNumber.doubleValue();
			} catch (ParseException e) {
				str = str.trim().replaceAll(".", ",");
				try {
					array[i] = Double.valueOf(str);
				} catch (NumberFormatException e2) {
					getOutputer().write(
							"Ошибка! Массив может содеражть только цифры.");
					throw new IllegalArgumentException();
				}
			}
			i++;
		}
		return array;
	}

	public static void checkInputString(final String inputString)
			throws FileNotFoundException {
		if (inputString.trim().length() < 1) {
			getOutputer().write("Ошибка! Массив не может быть пустым.");
			throw new IllegalArgumentException();
		}
	}

	public static void checkInputArray(double[] a, double[] b)
			throws FileNotFoundException {
		if (a.length == 0 || b.length == 0) {
			getOutputer().write("Ошибка! Массив не может быть пустым.");
			throw new IllegalArgumentException();
		}
		if (a.length != b.length) {
			getOutputer().print(
					"Ошибка! Разное количество элементов в массивах.");
			throw new IllegalArgumentException();
		}
		if (!isSorted(a)) {
			getOutputer().write("Ошибка! Первый массив не отсортирован.");
			throw new IllegalArgumentException();
		}
		if (!isSorted(b)) {
			getOutputer().write("Ошибка! Второй массив не отсортирован.");
			throw new IllegalArgumentException();
		}
	}

	public static boolean isSorted(final double[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}
}