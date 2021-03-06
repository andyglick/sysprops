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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import be.redlab.sysprops.printer.SysoMapPrinter;

/**
 * @author redlab
 *
 */
public class Locales {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		new Locales().print();
	}

	/**
	 *
	 */
	public void print() {
		SysoMapPrinter sysoMapPrinter = new SysoMapPrinter();
		Locale[] availableLocales = Locale.getAvailableLocales();
		Map<String, String> m = new HashMap<String, String>();
		System.out.println("Locale_Country codes      | country (language) in English and in it's own locale");
		for (Locale l : availableLocales) {
			m.put(l.getLanguage() + "_" + l.getCountry(), l.getDisplayCountry()
					+ " (" + l.getDisplayLanguage() + ") or (" + l.getDisplayCountry(l) + " (" + l.getDisplayLanguage(l) + "))");
		}
		sysoMapPrinter.print(m);
	}

}
