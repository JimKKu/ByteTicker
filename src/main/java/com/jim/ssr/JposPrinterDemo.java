//package com.jim.ssr;// usage instructions
//// 1. compile from command line - javac -encoding utf-8 -classpath JposPrinterSDK.jar JposPrinterDemo.java
//// 2. execute from command line - java -classpath .;JposPrinterSDK.jar JposPrinterDemo
//
//import com.jim.ssr.entity.OrderDetail;
//import com.jim.ssr.entity.vo.OrderVO;
//import net.jposprinter.Sdk;
//import sun.security.action.GetPropertyAction;
//
//import java.nio.charset.Charset;
//import java.security.AccessController;
//import java.util.List;
//
//public class JposPrinterDemo {
//
//    private static final String b0 = "";
//    private static final String b1 = " ";
//    private static final String b2 = b1 + b1;
//    private static final String b3 = b2 + b1;
//    private static final String b4 = b2 + b2;
//    private static final String b5 = b4 + b1;
//    private static final String b6 = b4 + b2;
//    private static final String b7 = b4 + b3;
//    private static final String b8 = b4 + b4;
//    private static final String b9 = b8 + b1;
//    private static final String b10 = b8 + b2;
//    private static final String b11 = b10 + b1;
//    private static final String b12 = b10 + b2;
//    private static final String b13 = b10 + b3;
//    private static final String b14 = b10 + b4;
//    private static final String b15 = b10 + b5;
//    private static final String b16 = b10 + b6;
//    private static final String b17 = b10 + b7;
//    private static final String b18 = b10 + b8;
//    private static final String b19 = b10 + b9;
//    private static final String b20 = b10 + b10;
//    private static final String b21 = b20 + b1;
//    private static final String b22 = b20 + b2;
//    private static final String b23 = b20 + b3;
//    private static final String b24 = b20 + b4;
//    private static final String b25 = b20 + b5;
//    private static final String demo="���������";
//    public void runTest(OrderVO vo) {
//        System.out.println("JposPrinterDemo Start ...");
//        Sdk sdk =new Sdk();
////        sdk.pioOpen("com1","9600",3000);//com1 ,9600/19200/38400/115200
//        sdk.pioOpen("usb","",3000);//usb
//
//        sdk.selectAlignment(1);
//        sdk.selectCharacterSize(022022);
//        sdk.selectOrCancelInvertPrintModel(0);
//        sdk.pioWritePort(demo.getBytes());
//        // ����
//        sdk.printAndFeedLine();
//        sdk.printAndFeedLine();
//
//        // ����
//        sdk.selectAlignment(1);
//        // �����С
//        sdk.selectCharacterSize(022022);
//        // ����
//        sdk.selectOrCancelInvertPrintModel(1);
//        sdk.pioWritePort("0022".getBytes());
//        sdk.printAndFeedLine();
//        sdk.printAndFeedLine();
//
//
//        // ����
//        sdk.selectAlignment(0);
//        // �����С
//        sdk.selectCharacterSize(000000);
//        // ����
//        sdk.selectOrCancelInvertPrintModel(0);
//        sdk.pioWritePort("��������:10022".getBytes());
//        // ����
//        sdk.printAndFeedLine();
//        sdk.pioWritePort("�µ�ʱ��:2024-04-08 21:59:14".getBytes());
//        sdk.printAndFeedLine();
////
////        // ����
//        sdk.pioWritePort("--------------------------------".getBytes());
//        sdk.printAndFeedLine();
//        sdk.pioWritePort("Ʒ��                   ���� С��".getBytes());
//        sdk.pioWritePort(buildMenu(vo.getOrderList()).getBytes());
//        sdk.printAndFeedLine();
//        sdk.pioWritePort("--------------------------------".getBytes());
//        sdk.printAndFeedLine();
//        sdk.pioWritePort("��ע:��Ҫ��С���Ҫ��ˡ�΢��".getBytes());
//        sdk.printAndFeedLine();
//        sdk.selectCharacterSize(122122);
//        sdk.pioWritePort("Ӧ�ս��:22".getBytes());
//        sdk.printAndFeedLine();
//
//
//
//        sdk.pioWritePort("\n\n\n\n".getBytes());
//        sdk.selectCutPagerModerAndCutPager(0);
//
//
//
//
//        sdk.pioClose();
//        System.out.println("JposPrinterDemo finished.");
//    }
//
//    public static String buildMenu(List<OrderDetail> details) {
//        StringBuilder sb = new StringBuilder();
//        for (OrderDetail detail : details) {
//            sb.append(getName(detail.getName1(),detail.getName2(),detail.getSize()))
//                    .append(getNum(detail.getNum()))
//                    .append(getPrice(detail.getPrice()))
//                    .append("\n");
//        }
//        return sb.toString();
//    }
//
//    public static int strLen(String str) {
//        int sum = 0;
//        String len = "";
//        char[] c = str.toCharArray();
//        for (char value : c) {
//            len = Integer.toBinaryString(value);
//            if (len.length() > 8) {
//                sum += 2;
//            } else {
//                sum += 1;
//            }
//        }
//        return sum;
//    }
//
//    public static int strLen(int num) {
//        return String.valueOf(num).length();
//    }
//
//    // ����ֻ���������Ӹ��۸����Բ�Ҫ����1000Ԫ/��
//    public static String getPrice(int price) {
//        int len = strLen(price);
//        switch (len) {
//            case 1:
//                return b2 + price;
//            case 2:
//                return b1 + price;
//            case 3:
//                return b0 + price;
//            default:
//                return b2 + "0";
//        }
//    }
//
//    public static String getNum(int num) {
//        int len = strLen(num);
//        switch (len) {
//            case 1:
//                return b1 + num + b1;
//            case 2:
//                return b1 + num;
//            default:
//                return b0 + num;
//        }
//    }
//
//    public static String getName(String name1,String name2,int size) {
//        // TODO ƴ���ַ��� �ܳ���26λ��ĩβ�ÿո��루32-3-3��
//        String x = "";
//        switch (size) {
//            case 1:
//                x = "(С)";
//                break;
//            case 2:
//                x = "(��)";
//                break;
//        }
//        String name = name1 + "-" + name2 + x;
//        int len = strLen(name);
//        switch (len){
//            case 1:
//                return name + b25;
//            case 2:
//                return name + b24;
//            case 3:
//                return name + b23;
//            case 4:
//                return name + b22;
//            case 5:
//                return name + b21;
//            case 6:
//                return name + b20;
//            case 7:
//                return name + b19;
//            case 8:
//                return name + b18;
//            case 9:
//                return name + b17;
//            case 10:
//                return name + b16;
//            case 11:
//                return name + b15;
//            case 12:
//                return name + b14;
//            case 13:
//                return name + b13;
//            case 14:
//                return name + b12;
//            case 15:
//                return name + b11;
//            case 16:
//                return name + b10;
//            case 17:
//                return name + b9;
//            case 18:
//                return name + b8;
//            case 19:
//                return name + b7;
//            case 20:
//                return name + b6;
//            case 21:
//                return name + b5;
//            case 22:
//                return name + b4;
//            case 23:
//                return name + b3;
//            case 24:
//                return name + b2;
//            case 25:
//                return name + b1;
//            default:
//                return name + b0;
//        }
//    }
//
//
//
//    public static void NOTE() {
//
//        /**
//         * �ո�:-:���� = 1:1:2
//         */
//
//        Sdk sdk = new Sdk();
//        /**
//         * ���ֶ��뷽ʽ
//         * 0������
//         * 1������
//         * 2������
//         */
//        sdk.selectAlignment(1);
//        /**
//         * ���ø߶ȿ�ȣ���Χ0~255  0~3λΪ�߶ȣ�4~6λΪ���
//         */
//        sdk.selectCharacterSize(030030);
//        /**
//         * ����,0������1����
//         */
//        sdk.selectOrCancelInvertPrintModel(0);
//    }
//
//    public static void main(String[] args) {
////        new JposPrinterDemo().runTest(args);
//
////        String str="���Ǻ�����()ssxcc";
////        System.out.println(strLen(str));
////        int count = 0;
////        char[] c = str.toCharArray();
////        for(int i = 0; i < c.length; i ++)
////        {
////            String len = Integer.toBinaryString(c[i]);
////            System.out.println(len);
////            if(len.length() > 8)
////                count ++;
////        }
////        System.out.println(count);
//
//
//
//        // ��ȡ�۸����
//        System.out.println(getPrice(2));
//        System.out.println(getPrice(12));
//        System.out.println(getPrice(120));
//        System.out.println(getNum(1));
//        System.out.println(getNum(11));
//        System.out.println(getNum(111));
//
//    }
//
//
//}
