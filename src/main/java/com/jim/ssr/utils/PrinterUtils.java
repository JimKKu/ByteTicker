package com.jim.ssr.utils;


import com.jim.ssr.entity.OrderDetail;
import com.jim.ssr.entity.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import net.jposprinter.Sdk;
import org.springframework.util.unit.DataUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jim
 * @Description: 打印工具类
 * TODO 具体参数后面调整
 */
@Slf4j
public class PrinterUtils {


    public static void print(OrderVO vo) {
//        TITLE1();
        TITLE2();
//        NUM(vo.getNum());
//        LINE();
//        INFO(vo.getNum());
//        LINE();
//        MENU(vo.getOrderList());
//        LINE();
//        COMMENT(vo.getComment());
//        PRICE_TOTAL(vo.getOrderList());
        PAPER_END();
    }


    public static void main(String[] args)  {
        /* ------ 打印标题 ------ */
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        String str = "重庆二两面123\n";
        // 居中
        sdk.setLeftSpace(4,0);
        sdk.setHorizontalAndVerticalMoveUnit(10,10);
        // 字体大小
//        sdk.setChineseCharacterModel(8);
        // margin-left/right
        sdk.setChineseCharLeftAndRightSpace(1,0);
        sdk.selectCharacterSize(012012);
        sdk.selectOrCancelInvertPrintModel(1);
        sdk.pioWritePort(str.getBytes());
//        NUM(10023);
        /* 换行 */
        sdk.pioWritePort("\n\n\n".getBytes());

        sdk.pioClose();

    }

    /**
     * 打印标题（大字加粗）
     * 1. 店名
     */
    public static void TITLE1() {
        String str = "重庆二两面1\n";
        System.out.println(str);
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        sdk.setLeftSpace(7,0);
        sdk.setHorizontalAndVerticalMoveUnit(10,10);
        sdk.setBarcodeHeight(10);
        sdk.setBarcodeWidth(10);
        // 字体大小
        sdk.setChineseCharacterModel(8);
        // margin-left/right
        sdk.setChineseCharLeftAndRightSpace(0,0);
        sdk.pioWritePort(str.getBytes());
        sdk.pioClose();
    }

    /**
     * 副标题（小字号）
     * 1. 祝您用餐愉快
     */
    public static void TITLE2(){
        String str = "祝您用餐愉快\n";
        System.out.println(str);
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        sdk.setLeftSpace(6,0);
        sdk.setHorizontalAndVerticalMoveUnit(10,10);
        sdk.setBarcodeHeight(1);
        sdk.setBarcodeWidth(1);
        // 字体大小
        sdk.setChineseCharacterModel(1);
        // margin-left/right
        sdk.setChineseCharLeftAndRightSpace(0,0);
        sdk.pioWritePort(str.getBytes());
        sdk.pioClose();
    }



    /**
     * 打印副标题区（小子号）
     * 1. 下单时间 日期+时间
     * 2. 单号（10000 ~ 99999）
     */
    public static void INFO(int num){
        String str = "下单时间:" +
                DateUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss") +
                "\n" +
                "订单号:" +
                num +
                "\n";
        System.out.println(str);
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        sdk.pioWritePort(str.getBytes());
        sdk.pioClose();
    }

    /**
     * 打印订单流水号（大字加粗）
     * 1. 订单流水号 0001 ~ 9999
     */
    public static void NUM(int num){
        String str = "取餐号码"+String.valueOf(num).substring(1) +
                "\n";
        System.out.println(str);
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        sdk.setLeftSpace(10,10);
        sdk.setHorizontalAndVerticalMoveUnit(10,10);
        sdk.setBarcodeHeight(10);
        sdk.setBarcodeWidth(10);
//         字体大小
        sdk.setChineseCharacterModel(8);
        sdk.selectOrCancleCustomChar(8);
        sdk.setLeftSpace(0,0);
        sdk.setHorizontalAndVerticalMoveUnit(0,0);
        sdk.selectOrCancelUnderlineModel(49);
        sdk.selectOrCancelBoldModel(1);
        sdk.setBarcodeHeight(0);
        sdk.setBarcodeWidth(0);
//         字体大小
        sdk.setChineseCharacterModel(8);
//        sdk.selectOrCancelDoubelPrintModel(1);
        sdk.selectFont(1);
//        sdk.selectInternationalCharacterSets(2);
        sdk.selectOrCancleCustomChar(8);
        sdk.selectAlignment(0);
        sdk.selectCharacterCodePage(255);
        // margin-left/right
        sdk.setChineseCharLeftAndRightSpace(3,3);
        sdk.pioWritePort(str.getBytes());
        sdk.pioClose();
    }

    /**
     * 打印菜单(小字号)
     * 1. 品相 ---- 数量 ---- 价格
     * 2. 番茄炒鸡蛋 1份 ----  18元
     * 3. 油焖茄子 - 1份 ----  18元
     */
    public static void MENU(List<OrderDetail> list){
        StringBuilder str = new StringBuilder();
        String name;
        /* 表头 */
        str.append("品类")
                .append("\t\t\t")
                .append("份数")
                .append("\t")
                .append("小计")
                .append("\n");
        /* 表体 */
        for (OrderDetail detail : list) {
            // 先拼接名称，后面根据名称设置对齐
            if(detail.getName2() != null && !"".equals(detail.getName2())) {
                name = detail.getName1()+"-"+detail.getName2();
            } else {
                name = detail.getName1();
            }
            if(detail.getSize() != null && detail.getSize() != 0) {
                if(detail.getSize() == 1) {
                    name += "(小)";
                } else if(detail.getSize()==2) {
                    name += "(大)";
                }
            }
            // 名称总长度小于(3,5)需要三个\t，名称总长度[5,7]需要两个\t，名称总长度(7,
            str.append(name);
            if(name.length()<=2) {
                /* 小于5位 + 4个制表符 | 荷包蛋 */
                str.append("\t\t\t\t");
            } else if (name.length()<=5){
                /* 大于5位/小于等于8位 + 3个制表符 | 豌豆面-粉丝/番茄鸡蛋面(小) */
                str.append("\t\t\t");
            }else if (name.length()<=8){
                /* 大于5位/小于等于8位 + 3个制表符 | 豌豆面-粉丝/番茄鸡蛋面(小) */
                str.append("\t\t");
            } else if (name.length()<=10){
                /* 大于8位/小于等于10位 + 2个制表符 | 豌豆面-粉丝/番茄鸡蛋面(小) */
                str.append("\t");
            } else {
                /* 大于10位 + 1个制表符 | 番茄炒鸡蛋-刀削面(小)*/
                str.append("\t");
            }
            // 加空格让份数居中
            str.append(" ")
                    .append(detail.getNum())
                    .append("\t")
                    .append(detail.getPrice()*detail.getNum())
                    .append("\n");
        }
        /* 删除最后一个换行 */
        str.deleteCharAt(str.length()-1);
        System.out.println(str);
        str.append("\n");
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
//        sdk.set
        sdk.pioWritePort(str.toString().getBytes());
        sdk.pioClose();
    }

    /**
     * 打印价格（明细-可省略 - 小字号）
     * 1. 价格
     */
    public static void PRICE_DETAIL(){}

    /**
     * 打印价格（总价 - 大字号）
     * 应付金额 xx元
     */
    public static void PRICE_TOTAL(List<OrderDetail> list){
        int sum = 0;
        for (OrderDetail detail : list) {
            sum += detail.getPrice()*detail.getNum();
        }
        String str = "应付金额:" + sum + "\n";
        System.out.println(str);
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        sdk.pioWritePort(str.getBytes());
        sdk.pioClose();
    }

    /**
     * 打印备注
     * @param info
     */
    public static void COMMENT(String info) {
        StringBuilder str = new StringBuilder();
        str.append("备注:")
                .append(info);
        if(str.toString().endsWith("、")) {
            str.deleteCharAt(str.length() - 1);
        }
        str.append("\n");
        System.out.println(str);
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        sdk.pioWritePort(str.toString().getBytes());
        sdk.pioClose();
    }


    /**
     * 打印分割线
     * --------------------------------
     */
    public static void LINE() {
        String str = "--------------------------------\n";
        System.out.println(str);
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        sdk.pioWritePort(str.getBytes());
        sdk.pioClose();
    }

    /**
     * 打印分割线
     * --------------------------------
     */
    public static void PAPER_END() {
        Sdk sdk =new Sdk();
        sdk.pioOpen("usb","",3000);//usb
        sdk.pioWritePort("\n\n\n\n\n".getBytes());
        sdk.pioClose();
    }


}
