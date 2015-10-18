package median;

import static median.MedianUtils.checkInputArray;
import static median.MedianUtils.checkInputString;
import static median.MedianUtils.stringToArray;
import static writer.Writer.close;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import writer.Writer;

public class Median {

	public static void main(String[] args) throws IOException {
		Writer.start(Median.class);
	}

	public static void processTask(Scanner inputer, PrintWriter outputer) {
		System.out
				.println("Введите два отсортированных числовых массива одинаковой длины:");
		final String a = inputer.nextLine();
		final String b = inputer.nextLine();

		try {
			checkInputString(a);
			checkInputString(b);

			String[] stringA = a.split(" ");
			String[] stringB = b.split(" ");

			double[] arrayA = stringToArray(stringA);
			double[] arrayB = stringToArray(stringB);

			outputer.write(searchMedian(arrayA, arrayB) + "");

			close();

		} catch (Exception e) {
			close();
		}
	}

	public static double searchMedian(final double[] a, final double[] b)
			throws FileNotFoundException {

		checkInputArray(a, b);

		final int length = a.length;

		if (1 >= length) {
			return (a[0] + b[0]) / 2.0;
		}
		if (b[0] >= a[length - 1]) {
			return (a[length - 1] + b[0]) / 2.0;
		}
		if (a[0] >= b[length - 1]) {
			return (b[length - 1] + a[0]) / 2.0;
		}
		if (Arrays.equals(a, b)) {
			return ((a[length / 2] + a[(length - 1) / 2]) / 2.0);
		}

		double prev = a[0];
		double next = a[0];

		for (int i = 0, j = 0; i < length & j < length & (i + j) <= length;) {
			prev = next;
			if (a[i] == b[j]) {
				next = a[i];
				i++;
			} else if (a[i] < b[j]) {
				next = a[i];
				i++;
			} else if (a[i] > b[j]) {
				next = b[j];
				j++;
			}
		}
		return (next + (double) prev) / 2.0;
	}
}
