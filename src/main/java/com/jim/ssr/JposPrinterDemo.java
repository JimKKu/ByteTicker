package com.jim.ssr;// usage instructions
// 1. compile from command line - javac -encoding utf-8 -classpath JposPrinterSDK.jar JposPrinterDemo.java
// 2. execute from command line - java -classpath .;JposPrinterSDK.jar JposPrinterDemo

import net.jposprinter.Sdk;
import sun.security.action.GetPropertyAction;

import java.nio.charset.Charset;
import java.security.AccessController;

public class JposPrinterDemo {
    private static volatile Charset defaultCharset;
    private static final String demo="重庆二两面\n--------------------------------\n流水号：0088\n类型：堂食\n结账时间：2024年4月7日\n";
    public void runTest(String[] args) {
        System.out.println("JposPrinterDemo Start ...");
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        //sdk.pioOpen("com1","9600",3000);//com1 ,9600/19200/38400/115200
        //sdk.pioOpen("tcp:192.168.123.100","",3000);//tcp:192.168.123.100
//         sdk.twobarCodes(demo, Charset.defaultCharset());
        sdk.pioWritePort(demo.getBytes());
        sdk.pioWritePort("\n\n\n\n\n\n".getBytes());
        sdk.selectCutPagerModerAndCutPager(0);
        sdk.pioClose();
        System.out.println("JposPrinterDemo finished.");
    }

    public static void main(String[] args) {
        new JposPrinterDemo().runTest(args);
    }


//    public static Charset defaultCharset() {
//        if (defaultCharset == null) {
//            synchronized (Charset.class) {
//                String csn = AccessController.doPrivileged(
//                        new GetPropertyAction("file.encoding"));
//                Charset cs = lookup(csn);
//                if (cs != null)
//                    defaultCharset = cs;
//                else
//                    defaultCharset = forName("UTF-8");
//            }
//        }
//        return defaultCharset;
//    }

}
