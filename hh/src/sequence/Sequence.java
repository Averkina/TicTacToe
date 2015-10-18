package sequence;

import static sequence.SequenceUtils.checkSequence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

import writer.Writer;

public class Sequence {

	public static void main(String[] args) throws IOException {
		Writer.start(Sequence.class);
	}

	public static void processTask(Scanner inputer, PrintWriter outputer) {
		try {
			System.out.println("Введите цифровую последовательность:");
			final String inputSequence = inputer.nextLine();
			outputer.print(findNumberOfOccurrence(inputSequence));

		} catch (FileNotFoundException e) {
			Writer.close();
			e.printStackTrace();
		}

		Writer.close();
	}

	public static int findNumberOfOccurrence(final String inputSequence)
			throws FileNotFoundException {
		StringBuilder generateSequence = new StringBuilder();

		checkSequence(inputSequence);

		BigInteger increment = new BigInteger("0");
		BigInteger index = new BigInteger("1");
		BigInteger sizeCut = new BigInteger("0");

		for (;; index = index.add(BigInteger.ONE)) {
			generateSequence = generateSequence.append(index);
			if (generateSequence.length() > 100) {
				sizeCut = new BigInteger(
						(generateSequence.length() - inputSequence.length())
								+ "");
				increment = increment.add(new BigInteger(sizeCut + ""));
				generateSequence = generateSequence.delete(0,
						sizeCut.intValue());
			}
			if (generateSequence.toString().contains(inputSequence)) {
				return generateSequence.indexOf(inputSequence) + 1
						+ increment.intValue();
			}
		}
	}
}
