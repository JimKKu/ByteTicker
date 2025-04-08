package com.jim.ssr.utils;


import com.jim.ssr.entity.OrderDetail;
import com.jim.ssr.entity.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
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


    public static void print(OrderVO vo) {
        TITLE1();
        TITLE2();
        NUM(vo.getNum());
        LINE();
        INFO(vo.getNum());
        LINE();
        MENU(vo.getOrderList());
        LINE();
        COMMENT(vo.getComment());
        PRICE_TOTAL(vo.getOrderList());
    }

    /**
     * ��ӡ���⣨���ּӴ֣�
     * 1. ����
     */
    public static void TITLE1(){
        String str = "���������";
        System.out.println(str);
    }

    /**
     * �����⣨С�ֺţ�
     * 1. ף���ò����
     */
    public static void TITLE2(){
        String str = "ף���ò����";
        System.out.println(str);
    }



    /**
     * ��ӡ����������С�Ӻţ�
     * 1. �µ�ʱ�� ����+ʱ��
     * 2. ���ţ�10000 ~ 99999��
     */
    public static void INFO(int num){
        String str = "�µ�ʱ��:" +
                DateUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss") +
                "\n" +
                "������:" +
                num;
        System.out.println(str);
    }

    /**
     * ��ӡ������ˮ�ţ����ּӴ֣�
     * 1. ������ˮ�� 0001 ~ 9999
     */
    public static void NUM(int num){
        String str = "��ˮ��:"+String.valueOf(num).substring(1);
        System.out.println(str);
    }

    /**
     * ��ӡ�˵�(С�ֺ�)
     * 1. Ʒ�� ---- ���� ---- �۸�
     * 2. ���ѳ����� 1�� ----  18Ԫ
     * 3. �������� - 1�� ----  18Ԫ
     */
    public static void MENU(List<OrderDetail> list){
        StringBuilder str = new StringBuilder();
        String name;
        /* ��ͷ */
        str.append("Ʒ��")
                .append("\t\t\t\t\t")
                .append("����")
                .append("\t")
                .append("С��")
                .append("\n");
        /* ���� */
        for (OrderDetail detail : list) {
            // ��ƴ�����ƣ���������������ö���
            if(detail.getName2() != null && !"".equals(detail.getName2())) {
                name = detail.getName1()+"-"+detail.getName2();
            } else {
                name = detail.getName1();
            }
            if(detail.getSize() != null && detail.getSize() != 0) {
                if(detail.getSize() == 1) {
                    name += "(С)";
                } else if(detail.getSize()==2) {
                    name += "(��)";
                }
            }
            // �����ܳ���С��(3,5)��Ҫ����\t�������ܳ���[5,7]��Ҫ����\t�������ܳ���(7,
            str.append(name);
            if(name.length()<=2) {
                /* С��5λ + 4���Ʊ�� | �ɰ��� */
                str.append("\t\t\t\t\t");
            } else if (name.length()<=5){
                /* ����5λ/С�ڵ���8λ + 3���Ʊ�� | �㶹��-��˿/���Ѽ�����(С) */
                str.append("\t\t\t\t");
            }else if (name.length()<=8){
                /* ����5λ/С�ڵ���8λ + 3���Ʊ�� | �㶹��-��˿/���Ѽ�����(С) */
                str.append("\t\t\t");
            } else if (name.length()<=10){
                /* ����8λ/С�ڵ���10λ + 2���Ʊ�� | �㶹��-��˿/���Ѽ�����(С) */
                str.append("\t\t");
            } else {
                /* ����10λ + 1���Ʊ�� | ���ѳ�����-������(С)*/
                str.append("\t");
            }
            // �ӿո��÷�������
            str.append(" ")
                    .append(detail.getNum())
                    .append("\t")
                    .append(detail.getPrice()*detail.getNum())
                    .append("\n");
        }
        /* ɾ�����һ������ */
        str.deleteCharAt(str.length()-1);
        System.out.println(str);
    }

    /**
     * ��ӡ�۸���ϸ-��ʡ�� - С�ֺţ�
     * 1. �۸�
     */
    public static void PRICE_DETAIL(){}

    /**
     * ��ӡ�۸��ܼ� - ���ֺţ�
     * Ӧ����� xxԪ
     */
    public static void PRICE_TOTAL(List<OrderDetail> list){
        int sum = 0;
        for (OrderDetail detail : list) {
            sum += detail.getPrice()*detail.getNum();
        }
        System.out.println("Ӧ�����:"+sum);
    }

    /**
     * ��ӡ��ע
     * @param info
     */
    public static void COMMENT(String info) {
        StringBuilder str = new StringBuilder();
        str.append("��ע:")
                .append(info);
        if(str.toString().endsWith("��")) {
            str.deleteCharAt(str.length() - 1);
        }
        System.out.println(str);
    }


    /**
     * ��ӡ�ָ���
     * --------------------------------
     */
    public static void LINE() {
        String str = "--------------------------------";
        System.out.println(str);
    }
}
