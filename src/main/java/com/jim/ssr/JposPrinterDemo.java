package com.jim.ssr;// usage instructions
// 1. compile from command line - javac -encoding utf-8 -classpath JposPrinterSDK.jar JposPrinterDemo.java
// 2. execute from command line - java -classpath .;JposPrinterSDK.jar JposPrinterDemo

import net.jposprinter.Sdk;
import sun.security.action.GetPropertyAction;

import java.nio.charset.Charset;
import java.security.AccessController;

public class JposPrinterDemo {

    private static final String b0 = "";
    private static final String b1 = " ";
    private static final String b2 = "  ";
    private static final String b3 = "   ";
    private static final String b4 = "    ";
    private static final String b5 = "     ";
    private static final String b6 = "      ";
    private static final String b7 = "       ";
    private static final String b8 = "        ";
    private static final String b9 = "         ";
    private static final String b10 = "          ";
    private static final String b11 = "           ";
    private static final String b12 = "            ";
    private static volatile Charset defaultCharset;
    private static final String demo="���������";
    public void runTest(String[] args) {
        System.out.println("JposPrinterDemo Start ...");
        Sdk sdk =new Sdk();
//        sdk.pioOpen("com1","9600",3000);//com1 ,9600/19200/38400/115200
        sdk.pioOpen("usb","",3000);//usb

        sdk.selectAlignment(1);
        sdk.selectCharacterSize(022022);
        sdk.selectOrCancelInvertPrintModel(0);
        sdk.pioWritePort(demo.getBytes());
        // ����
        sdk.printAndFeedLine();
        sdk.printAndFeedLine();

        // ����
        sdk.selectAlignment(1);
        // �����С
        sdk.selectCharacterSize(022022);
        // ����
        sdk.selectOrCancelInvertPrintModel(1);
        sdk.pioWritePort("0022".getBytes());
        sdk.printAndFeedLine();
        sdk.printAndFeedLine();


        // ����
        sdk.selectAlignment(0);
        // �����С
        sdk.selectCharacterSize(000000);
        // ����
        sdk.selectOrCancelInvertPrintModel(0);
        sdk.pioWritePort("��������:10022".getBytes());
        // ����
        sdk.printAndFeedLine();
        sdk.pioWritePort("�µ�ʱ��:2024-04-08 21:59:14".getBytes());
        sdk.printAndFeedLine();
//
//        // ����
        sdk.pioWritePort("--------------------------------".getBytes());
        sdk.printAndFeedLine();
        sdk.pioWritePort("Ʒ��                   ���� С��".getBytes());
        sdk.printAndFeedLine();
        sdk.pioWritePort("--------------------------------".getBytes());
        sdk.printAndFeedLine();
        sdk.pioWritePort("��ע:��Ҫ��С���Ҫ��ˡ�΢��".getBytes());
        sdk.printAndFeedLine();
        sdk.selectCharacterSize(122122);
        sdk.pioWritePort("Ӧ�ս��:22".getBytes());
        sdk.printAndFeedLine();



        sdk.pioWritePort("\n\n\n\n".getBytes());
        sdk.selectCutPagerModerAndCutPager(0);




        sdk.pioClose();
        System.out.println("JposPrinterDemo finished.");
    }


    public static int strLen(String str) {
        int sum = 0;
        String len = "";
        char[] c = str.toCharArray();
        for (char value : c) {
            len = Integer.toBinaryString(value);
            if (len.length() > 8) {
                sum += 2;
            } else {
                sum += 1;
            }
        }
        return sum;
    }

    public static int strLen(int num) {
        return strLen(String.valueOf(num));
    }

    // ����ֻ���������Ӹ��۸����Բ�Ҫ����1000Ԫ/��
    public static String getPrice(int price) {
        int len = strLen(price);
        switch (len) {
            case 1:
                return b2 + price;
            case 2:
                return b1 + price;
            case 3:
                return b0 + price;
            default:
                return b2 + "0";
        }
    }

    public static String getNum(int num) {
        int len = strLen(num);
        switch (len) {
            case 1:
                return b1 + num + b1;
            case 2:
                return b1 + num;
            default:
                return b0 + num;
        }
    }

    public static String getName(String n1,String n2,String n3) {
        // TODO ƴ���ַ��� �ܳ���26λ��ĩβ�ÿո��루32-3-3��
        return "";
    }


    public static void NOTE() {

        /**
         * �ո�:-:���� = 1:1:2
         */

        Sdk sdk = new Sdk();
        /**
         * ���ֶ��뷽ʽ
         * 0������
         * 1������
         * 2������
         */
        sdk.selectAlignment(1);
        /**
         * ���ø߶ȿ�ȣ���Χ0~255  0~3λΪ�߶ȣ�4~6λΪ���
         */
        sdk.selectCharacterSize(030030);
        /**
         * ����,0������1����
         */
        sdk.selectOrCancelInvertPrintModel(0);
    }

    public static void main(String[] args) {
//        new JposPrinterDemo().runTest(args);

//        String str="���Ǻ�����()ssxcc";
//        System.out.println(strLen(str));
//        int count = 0;
//        char[] c = str.toCharArray();
//        for(int i = 0; i < c.length; i ++)
//        {
//            String len = Integer.toBinaryString(c[i]);
//            System.out.println(len);
//            if(len.length() > 8)
//                count ++;
//        }
//        System.out.println(count);



        // ��ȡ�۸����
        System.out.println(getPrice(2));
        System.out.println(getPrice(12));
        System.out.println(getPrice(120));
        System.out.println(getNum(1));
        System.out.println(getNum(11));
        System.out.println(getNum(111));

    }


}
