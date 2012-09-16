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
package be.redlab.sysprops.printer;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author redlab
 *
 */
public class SysoMapPrinter {

	/**
	 *
	 */
	public void print(final Map<? extends Object, ? extends Object> map) {
		TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(new Comparator<Object>() {

			public int compare(final Object o1, final Object o2) {
				if (o1 instanceof String && o2 instanceof String) {
					return ((String) o1).compareTo((String) o2);
				} else {
					return 0;
				}

			}
		});
		treeMap.putAll(map);
		for (Entry<Object, Object> e : treeMap.entrySet()) {
			String out;
			if (e.getKey().toString().length() <= 40) {
				out = String.format("%-" + "40" + "s | %s", e.getKey(), e.getValue());
			} else {
				out = new StringBuffer().append(e.getKey()).append(" | ").append(e.getValue()).toString();
			}
			System.out.println(out);
		}
	}
}
