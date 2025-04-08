package com.jim.ssr;// usage instructions
// 1. compile from command line - javac -encoding utf-8 -classpath JposPrinterSDK.jar JposPrinterDemo.java
// 2. execute from command line - java -classpath .;JposPrinterSDK.jar JposPrinterDemo

import net.jposprinter.Sdk;
import sun.security.action.GetPropertyAction;

import java.nio.charset.Charset;
import java.security.AccessController;

public class JposPrinterDemo {
    private static volatile Charset defaultCharset;
    private static final String demo="重庆二两面JJB";
    public void runTest(String[] args) {
        System.out.println("JposPrinterDemo Start ...");
        Sdk sdk =new Sdk();
//        sdk.pioOpen("com1","9600",3000);//com1 ,9600/19200/38400/115200
        sdk.pioOpen("usb","",3000);//usb
        sdk.setCharRightSpace(15);
        sdk.setAbsolutePrintPosition(15,10);
        sdk.setDefultLineSpacing();
        sdk.setLineSpaceing(10);
        sdk.setPrintAreaUnderPageModel(10,10,10,10,0,0,0,0);
        sdk.setRelativeHorizontalPrintPosition(10,10);
        sdk.setAbsolutePositionUnderPageModel(10,10);
        sdk.setLeftSpace(10,10);
        sdk.setHorizontalAndVerticalMoveUnit(0,0);
        sdk.setPrintAreaWidth(28,28);
        sdk.setVerticalRelativePositionUnderPageModel(10,10);
        sdk.setBarcodeHeight(10);
        sdk.setBarcodeWidth(11);
        // 字体大小
        sdk.setChineseCharacterModel(10);
        // margin-left/right
        sdk.setChineseCharLeftAndRightSpace(10,10);
        sdk.setsTheNumberOfColumnsOfTheDataAreaForPDF417(10);
        sdk.setsTheNumberOfRowsOfTheDataAreaForPDF417(10);
        sdk.setsTheModuleWidthOfPDF417(10);
        sdk.setsTheModuleHeightForPDF417(10);
        sdk.setsTheErrorCorrectionLevelForPDF417(10,10);
        sdk.setsTheSizeOfTheQRCodeSymbolModule(10);
        sdk.setsTheErrorCorrectionLevelForQRCodeSymbol(10);
//
//        sdk.pioOpen("tcp:192.168.123.100","",3000);//tcp:192.168.123.100
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


}
