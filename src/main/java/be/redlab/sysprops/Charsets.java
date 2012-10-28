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

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

import be.redlab.sysprops.printer.SysoMapPrinter;

/**
 * @author redlab
 *
 */
public class Charsets {

	public static void main(final String[] args) {
		new Charsets().print();
	}

	/**
	 *
	 */
	public void print() {
		SysoMapPrinter sysoMapPrinter = new SysoMapPrinter();
		SortedMap<String, Charset> availableLocales = Charset.availableCharsets();
		Map<String, Object> m = new HashMap<String, Object>();
		for (final Entry<String, Charset> l : availableLocales.entrySet()) {
			final Charset value = l.getValue();
			m.put(l.getKey(), new Object() {
				@Override
				public String toString() {
					return "Displayname: " + value.displayName() + " | Aliases: " + Arrays.toString(value.aliases().toArray());
				}
			});
		}
		sysoMapPrinter.print(m);
	}
}
