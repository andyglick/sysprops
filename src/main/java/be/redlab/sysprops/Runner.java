/*
 * Copyright 2012 Balder Van Camp
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package be.redlab.sysprops;

/**
 * @author redlab
 *
 */
public class Runner {

	/**
	 *
	 */
	private static final String CHARSETS = "charsets";
	/**
	 *
	 */
	private static final String PROPS = "props";
	/**
	 *
	 */
	private static final String LOCALES = "locales";

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException {
		if (null != args && args.length > 0) {
			boolean printhelp = true;
			for (String arg : args) {
				if (LOCALES.equals(arg)) {
					printLocales();
				} else if (PROPS.equals(arg)) {
					printSystemProperties();
				} else if (CHARSETS.equals(arg)) {
					printCharsets();
				} else if (printhelp) {
					printHelp();
					printhelp = false;
				}
			}
		} else {
			printSystemProperties();
			printLocales();
			printCharsets();
		}
	}

	private static void printHelp() throws InterruptedException {
		StringBuilder buffer = new StringBuilder("Processing help instructions. Hold on. ..................")
				.append(System.getProperty("line.separator"))
				.append("SysProps by redlab. Simple and stupid. But sometimes usefull. See what Java is seeing.")
				.append(System.getProperty("line.separator")).append("commands: ").append(System.getProperty("line.separator"))
				.append(LOCALES).append(System.getProperty("line.separator")).append("\tprints the locales know to the Java Process")
				.append(System.getProperty("line.separator")).append(PROPS).append(System.getProperty("line.separator"))
				.append("\tprints system properties and environment properties").append(System.getProperty("line.separator"))
				.append(CHARSETS).append(System.getProperty("line.separator"))
				.append("\tprints all to Java knonw Charset and their aliasses").append(System.getProperty("line.separator"))
				.append("run without arguments prints all of them.").append(System.getProperty("line.separator"))
				.append("Pipe the output to a file or to your screen with more or less, it can sometimes be a long list.");
		int i = 73;
		for (char c : buffer.toString().toCharArray()) {
			System.out.print(c);
			if (i > 0) {
				Thread.sleep(i--);
			}
		}
	}

	private static void printCharsets() {
		new Charsets().print();
	}

	private static void printLocales() {
		new Locales().print();
	}

	private static void printSystemProperties() {
		new SystemProperties().print();
	}

}
