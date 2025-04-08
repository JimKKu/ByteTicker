// usage instructions
// 1. compile from command line - javac -encoding utf-8 -classpath JposPrinterSDK.jar JposPrinterDemo.java
// 2. execute from command line - java -classpath .;JposPrinterSDK.jar JposPrinterDemo

import net.jposprinter.Sdk;
import java.nio.charset.Charset;

public class JposPrinterDemo {
	private static final String demo="我是Jim.kk\n";
	public void runTest(String[] args) {
		System.out.println("JposPrinterDemo Start ...");
		Sdk sdk =new Sdk();
		sdk.pioOpen("usb","",3000);//usb
		//sdk.pioOpen("com1","9600",3000);//com1 ,9600/19200/38400/115200
		//sdk.pioOpen("tcp:192.168.123.100","",3000);//tcp:192.168.123.100
		// sdk.twobarCodes(demo, Charset.defaultCharset());
		sdk.pioWritePort(demo.getBytes());
		sdk.pioWritePort("\n\n\n\n\n\n".getBytes());
		sdk.selectCutPagerModerAndCutPager(0);
		sdk.pioClose();
		System.out.println("JposPrinterDemo finished.");
	}

	public static void main(String[] args) {
		new JposPrinterDemo().runTest(args);
	}
}
