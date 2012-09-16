package be.redlab.sysprops;

import be.redlab.sysprops.printer.SysoMapPrinter;

/**
 *
 */
public class SystemProperties {

	public static void main(final String[] args) {
		SysoMapPrinter printer = new SysoMapPrinter();
		System.out.println("##########   System.getProperties();  ##########");
		printer.print(System.getProperties());
		System.out.println("##########  System.getenv();  ##########");
		printer.print(System.getenv());
	}


}
