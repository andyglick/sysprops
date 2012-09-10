package be.redlab.sysprops;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 *
 */
public class SystemProperties {

	public static void main(final String[] args) {
		SystemProperties sp = new SystemProperties();
		System.out.println("##########   System.getProperties();  ##########");
		sp.print(System.getProperties());
		System.out.println("##########  System.getenv();  ##########");
		sp.print(System.getenv());
	}

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
				out = String.format("%-40s | %s", e.getKey(), e.getValue());
			} else {
				out = new StringBuffer().append(e.getKey()).append(" | ").append(e.getValue()).toString();
			}
			System.out.println(out);
		}
	}
}
