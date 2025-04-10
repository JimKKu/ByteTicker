package com.jim.ssr.utils;


import com.jim.ssr.entity.Order;
import com.jim.ssr.entity.OrderDetail;
import com.jim.ssr.entity.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import net.jposprinter.Sdk;
import org.springframework.util.unit.DataUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jim
 * @Description: ��ӡ������
 * TODO ��������������
 */
@Slf4j
public class PrinterUtils {

    private static final String TITLE="���������";

    private static final String LINE = "--------------------------------";
    /* �ո��� */
    private static final String b0 = "";
    private static final String b1 = "-";
    private static final String b2 = b1 + b1;
    private static final String b3 = b2 + b1;
    private static final String b4 = b2 + b2;
    private static final String b5 = b4 + b1;
    private static final String b6 = b4 + b2;
    private static final String b7 = b4 + b3;
    private static final String b8 = b4 + b4;
    private static final String b9 = b8 + b1;
    private static final String b10 = b8 + b2;
    private static final String b11 = b10 + b1;
    private static final String b12 = b10 + b2;
    private static final String b13 = b10 + b3;
    private static final String b14 = b10 + b4;
    private static final String b15 = b10 + b5;
    private static final String b16 = b10 + b6;
    private static final String b17 = b10 + b7;
    private static final String b18 = b10 + b8;
    private static final String b19 = b10 + b9;
    private static final String b20 = b10 + b10;
    private static final String b21 = b20 + b1;
    private static final String b22 = b20 + b2;
    private static final String b23 = b20 + b3;
    private static final String b24 = b20 + b4;
    private static final String b25 = b20 + b5;



    public static void print(OrderVO vo) {

        /* ����: �ն���� */
        doTest(vo);

    }


    private static void doPrint(OrderVO vo) {
        log.info("--��ʼ��ӡ");
        Sdk sdk =new Sdk();

        /** USB ���� */
        sdk.pioOpen("usb","",3000);

        /* ҳͷ���� */
        sdk.pioWritePort("\n\n\n\n".getBytes());

        /** ������ʽ */
        sdk.selectAlignment(1);
        sdk.selectCharacterSize(022022);
        sdk.selectOrCancelInvertPrintModel(0);

        /* ��ӡ���� */
        sdk.pioWritePort(TITLE.getBytes());

        /* ������ */
        sdk.printAndFeedLine();
        sdk.printAndFeedLine();

        /** ������ʽ */
        sdk.selectAlignment(1);
        sdk.selectCharacterSize(022022);
        sdk.selectOrCancelInvertPrintModel(1);
        /* ��ӡ��ˮ�� */
        sdk.pioWritePort(getSerialNumber(vo.getNum()).getBytes());

        /** ������ʽ */
        sdk.printAndFeedLine();
        sdk.printAndFeedLine();
        sdk.selectAlignment(0);
        sdk.selectCharacterSize(000000);
        sdk.selectOrCancelInvertPrintModel(0);


        /* ��ӡ����ˮ�� */
        sdk.pioWritePort(("��������:"+vo.getNum()).getBytes());
        /* ���� */
        sdk.printAndFeedLine();
        /* ʱ�� */
        sdk.pioWritePort(("�µ�ʱ��:"+DateUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss")).getBytes());

        /* ���� */
        sdk.printAndFeedLine();

        // �ָ���
        sdk.pioWritePort(LINE.getBytes());
        sdk.printAndFeedLine();
        /* menu title */
        sdk.pioWritePort("Ʒ��                   ���� С��".getBytes());
        /* menu list */
        sdk.pioWritePort(buildMenu(vo.getOrderList()).getBytes());
        /* ���� */
        // sdk.printAndFeedLine();
        /* �ָ��� */
        sdk.pioWritePort(LINE.getBytes());
        /* ���� */
        sdk.printAndFeedLine();
        /* ��ע��Ϣ */
        sdk.pioWritePort(("��ע:"+getComment(vo.getComment())).getBytes());
        /* ���� */
        sdk.printAndFeedLine();
        sdk.selectCharacterSize(122122);
        /* Ӧ�ս�� */
        sdk.pioWritePort(("Ӧ�ս��:"+vo.getPrice()).getBytes());
        /* ���� */
        sdk.printAndFeedLine();

        sdk.pioWritePort("\n\n\n\n\n\n".getBytes());
        sdk.selectCutPagerModerAndCutPager(0);

        sdk.pioClose();
        log.info("--������ӡ");
    }

    private static void doTest(OrderVO vo) {
        log.info("--��ʼ��ӡ");


        System.out.println("\n\n\n");
        /* ��ӡ���� */
        System.out.println(TITLE);
        /* ��ӡ��ˮ�� */
        System.out.println(getSerialNumber(vo.getNum()));
        /* ��ӡ����ˮ�� */
        System.out.println(("��������:"+vo.getNum()));
        /* ʱ�� */
        System.out.println("�µ�ʱ��:"+DateUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss"));
        // �ָ���
        System.out.println(LINE);
        /* menu title */
        System.out.println("Ʒ��" + b19 + "����" + b1 + "С��");
        /* menu list */
        System.out.println(buildMenu(vo.getOrderList()));
        /* �ָ��� */
        System.out.println(LINE);
        /* ��ע��Ϣ */
        System.out.println(("��ע:"+getComment(vo.getComment())));
        /* Ӧ�ս�� */
        System.out.println(("Ӧ�ս��:"+vo.getPrice()));
        System.out.println("\n\n\n\n\n\n");
        log.info("--������ӡ");
    }


    private static String buildMenu(List<OrderDetail> details) {
        StringBuilder sb = new StringBuilder();
        for (OrderDetail detail : details) {
            sb.append(getName(detail.getName1(),detail.getName2(),detail.getSize()))
                    .append(getNum(detail.getNum()))
                    .append(getPrice(detail.getPrice()))
                    .append("\n");
        }
        return sb.toString();
    }

    private static int strLen(String str) {
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

    private static String getSerialNumber(int num) {
        return String.valueOf(num).substring(1);
    }

    private static int strLen(int num) {
        return String.valueOf(num).length();
    }

    // ����ֻ���������Ӹ��۸����Բ�Ҫ����1000Ԫ/��
    private static String getPrice(int price) {
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


    /**
     * ����
     * @param num
     * @return
     */
    private static String getNum(int num) {
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

    private static String getName(String name1,String name2,int size) {
        // TODO ƴ���ַ��� �ܳ���26λ��ĩβ�ÿո��루32-3-3��
        String x = "";
        switch (size) {
            case 1:
                x = "(С)";
                break;
            case 2:
                x = "(��)";
                break;
        }
        String name;
        if(name2 != null && !"".equals(name2)) {
            name = name1 + "-" + name2 + x;
        } else {
            name = name1 + x;
        }
        int len = strLen(name);
        switch (len){
            case 1:
                return name + b25;
            case 2:
                return name + b24;
            case 3:
                return name + b23;
            case 4:
                return name + b22;
            case 5:
                return name + b21;
            case 6:
                return name + b20;
            case 7:
                return name + b19;
            case 8:
                return name + b18;
            case 9:
                return name + b17;
            case 10:
                return name + b16;
            case 11:
                return name + b15;
            case 12:
                return name + b14;
            case 13:
                return name + b13;
            case 14:
                return name + b12;
            case 15:
                return name + b11;
            case 16:
                return name + b10;
            case 17:
                return name + b9;
            case 18:
                return name + b8;
            case 19:
                return name + b7;
            case 20:
                return name + b6;
            case 21:
                return name + b5;
            case 22:
                return name + b4;
            case 23:
                return name + b3;
            case 24:
                return name + b2;
            case 25:
                return name + b1;
            default:
                return name + b0;
        }
    }




    private static String getComment(String str) {
        if(str.endsWith("��")) {
            return str.substring(0,str.length() - 1);
        }
        return str;
    }















    public static void main(String[] args)  {
        /* ------ ��ӡ���� ------ */
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        String str = "���������123\n";
        // ����
        sdk.setLeftSpace(4,0);
        sdk.setHorizontalAndVerticalMoveUnit(10,10);
        // �����С
//        sdk.setChineseCharacterModel(8);
        // margin-left/right
        sdk.setChineseCharLeftAndRightSpace(1,0);
        sdk.selectCharacterSize(012012);
        sdk.selectOrCancelInvertPrintModel(1);
        sdk.pioWritePort(str.getBytes());
//        NUM(10023);
        /* ���� */
        sdk.pioWritePort("\n\n\n".getBytes());

        sdk.pioClose();

    }
//
//    /**
//     * ��ӡ���⣨���ּӴ֣�
//     * 1. ����
//     */
//    public static void TITLE1() {
//        String str = "���������\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.setLeftSpace(7,0);
//        sdk.setHorizontalAndVerticalMoveUnit(10,10);
//        sdk.setBarcodeHeight(10);
//        sdk.setBarcodeWidth(10);
//        // �����С
//        sdk.setChineseCharacterModel(8);
//        // margin-left/right
//        sdk.setChineseCharLeftAndRightSpace(0,0);
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }
//
//    /**
//     * �����⣨С�ֺţ�
//     * 1. ף���ò����
//     */
//    public static void TITLE2(){
//        String str = "ף���ò����\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.setLeftSpace(6,0);
//        sdk.setHorizontalAndVerticalMoveUnit(10,10);
//        sdk.setBarcodeHeight(1);
//        sdk.setBarcodeWidth(1);
//        // �����С
//        sdk.setChineseCharacterModel(1);
//        // margin-left/right
//        sdk.setChineseCharLeftAndRightSpace(0,0);
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }



//    /**
//     * ��ӡ����������С�Ӻţ�
//     * 1. �µ�ʱ�� ����+ʱ��
//     * 2. ���ţ�10000 ~ 99999��
//     */
//    public static void INFO(int num){
//        String str = "�µ�ʱ��:" +
//                DateUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss") +
//                "\n" +
//                "������:" +
//                num +
//                "\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }

//    /**
//     * ��ӡ������ˮ�ţ����ּӴ֣�
//     * 1. ������ˮ�� 0001 ~ 9999
//     */
//    public static void NUM(int num){
//        String str = "ȡ�ͺ���"+String.valueOf(num).substring(1) +
//                "\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.setLeftSpace(10,10);
//        sdk.setHorizontalAndVerticalMoveUnit(10,10);
//        sdk.setBarcodeHeight(10);
//        sdk.setBarcodeWidth(10);
////         �����С
//        sdk.setChineseCharacterModel(8);
//        sdk.selectOrCancleCustomChar(8);
//        sdk.setLeftSpace(0,0);
//        sdk.setHorizontalAndVerticalMoveUnit(0,0);
//        sdk.selectOrCancelUnderlineModel(49);
//        sdk.selectOrCancelBoldModel(1);
//        sdk.setBarcodeHeight(0);
//        sdk.setBarcodeWidth(0);
////         �����С
//        sdk.setChineseCharacterModel(8);
////        sdk.selectOrCancelDoubelPrintModel(1);
//        sdk.selectFont(1);
////        sdk.selectInternationalCharacterSets(2);
//        sdk.selectOrCancleCustomChar(8);
//        sdk.selectAlignment(0);
//        sdk.selectCharacterCodePage(255);
//        // margin-left/right
//        sdk.setChineseCharLeftAndRightSpace(3,3);
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }

//    /**
//     * ��ӡ�˵�(С�ֺ�)
//     * 1. Ʒ�� ---- ���� ---- �۸�
//     * 2. ���ѳ����� 1�� ----  18Ԫ
//     * 3. �������� - 1�� ----  18Ԫ
//     */
//    public static void MENU(List<OrderDetail> list){
//        StringBuilder str = new StringBuilder();
//        String name;
//        /* ��ͷ */
//        str.append("Ʒ��")
//                .append("\t\t\t")
//                .append("����")
//                .append("\t")
//                .append("С��")
//                .append("\n");
//        /* ���� */
//        for (OrderDetail detail : list) {
//            // ��ƴ�����ƣ���������������ö���
//            if(detail.getName2() != null && !"".equals(detail.getName2())) {
//                name = detail.getName1()+"-"+detail.getName2();
//            } else {
//                name = detail.getName1();
//            }
//            if(detail.getSize() != null && detail.getSize() != 0) {
//                if(detail.getSize() == 1) {
//                    name += "(С)";
//                } else if(detail.getSize()==2) {
//                    name += "(��)";
//                }
//            }
//            // �����ܳ���С��(3,5)��Ҫ����\t�������ܳ���[5,7]��Ҫ����\t�������ܳ���(7,
//            str.append(name);
//            if(name.length()<=2) {
//                /* С��5λ + 4���Ʊ�� | �ɰ��� */
//                str.append("\t\t\t\t");
//            } else if (name.length()<=5){
//                /* ����5λ/С�ڵ���8λ + 3���Ʊ�� | �㶹��-��˿/���Ѽ�����(С) */
//                str.append("\t\t\t");
//            }else if (name.length()<=8){
//                /* ����5λ/С�ڵ���8λ + 3���Ʊ�� | �㶹��-��˿/���Ѽ�����(С) */
//                str.append("\t\t");
//            } else if (name.length()<=10){
//                /* ����8λ/С�ڵ���10λ + 2���Ʊ�� | �㶹��-��˿/���Ѽ�����(С) */
//                str.append("\t");
//            } else {
//                /* ����10λ + 1���Ʊ�� | ���ѳ�����-������(С)*/
//                str.append("\t");
//            }
//            // �ӿո��÷�������
//            str.append(" ")
//                    .append(detail.getNum())
//                    .append("\t")
//                    .append(detail.getPrice()*detail.getNum())
//                    .append("\n");
//        }
//        /* ɾ�����һ������ */
//        str.deleteCharAt(str.length()-1);
//        System.out.println(str);
//        str.append("\n");
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
////        sdk.set
//        sdk.pioWritePort(str.toString().getBytes());
//        sdk.pioClose();
//    }

//    /**
//     * ��ӡ�۸���ϸ-��ʡ�� - С�ֺţ�
//     * 1. �۸�
//     */
//    public static void PRICE_DETAIL(){}
//
//    /**
//     * ��ӡ�۸��ܼ� - ���ֺţ�
//     * Ӧ����� xxԪ
//     */
//    public static void PRICE_TOTAL(List<OrderDetail> list){
//        int sum = 0;
//        for (OrderDetail detail : list) {
//            sum += detail.getPrice()*detail.getNum();
//        }
//        String str = "Ӧ�����:" + sum + "\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }

//    /**
//     * ��ӡ��ע
//     * @param info
//     */
//    public static void COMMENT(String info) {
//        StringBuilder str = new StringBuilder();
//        str.append("��ע:")
//                .append(info);
//        if(str.toString().endsWith("��")) {
//            str.deleteCharAt(str.length() - 1);
//        }
//        str.append("\n");
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.pioWritePort(str.toString().getBytes());
//        sdk.pioClose();
//    }


//    /**
//     * ��ӡ�ָ���
//     * --------------------------------
//     */
//    public static void LINE() {
//        String str = "--------------------------------\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }

//    /**
//     * ��ӡ�ָ���
//     * --------------------------------
//     */
//    public static void PAPER_END() {
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.pioWritePort("\n\n\n\n\n".getBytes());
//        sdk.pioClose();
//    }



}
