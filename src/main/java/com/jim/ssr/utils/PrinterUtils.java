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
 * @Description: 打印工具类
 * TODO 具体参数后面调整
 */
@Slf4j
public class PrinterUtils {

    private static final String TITLE="重庆二两面";

    private static final String LINE = "--------------------------------";
    /* 空格补齐 */
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

        /* 测试: 终端输出 */
        doTest(vo);

    }


    private static void doPrint(OrderVO vo) {
        log.info("--开始打印");
        Sdk sdk =new Sdk();

        /** USB 连接 */
        sdk.pioOpen("usb","",3000);

        /* 页头空行 */
        sdk.pioWritePort("\n\n\n\n".getBytes());

        /** 定义样式 */
        sdk.selectAlignment(1);
        sdk.selectCharacterSize(022022);
        sdk.selectOrCancelInvertPrintModel(0);

        /* 打印标题 */
        sdk.pioWritePort(TITLE.getBytes());

        /* 换两行 */
        sdk.printAndFeedLine();
        sdk.printAndFeedLine();

        /** 定义样式 */
        sdk.selectAlignment(1);
        sdk.selectCharacterSize(022022);
        sdk.selectOrCancelInvertPrintModel(1);
        /* 打印流水号 */
        sdk.pioWritePort(getSerialNumber(vo.getNum()).getBytes());

        /** 定义样式 */
        sdk.printAndFeedLine();
        sdk.printAndFeedLine();
        sdk.selectAlignment(0);
        sdk.selectCharacterSize(000000);
        sdk.selectOrCancelInvertPrintModel(0);


        /* 打印长流水号 */
        sdk.pioWritePort(("长订单号:"+vo.getNum()).getBytes());
        /* 换行 */
        sdk.printAndFeedLine();
        /* 时间 */
        sdk.pioWritePort(("下单时间:"+DateUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss")).getBytes());

        /* 换行 */
        sdk.printAndFeedLine();

        // 分割线
        sdk.pioWritePort(LINE.getBytes());
        sdk.printAndFeedLine();
        /* menu title */
        sdk.pioWritePort("品类                   份数 小计".getBytes());
        /* menu list */
        sdk.pioWritePort(buildMenu(vo.getOrderList()).getBytes());
        /* 换行 */
        // sdk.printAndFeedLine();
        /* 分割线 */
        sdk.pioWritePort(LINE.getBytes());
        /* 换行 */
        sdk.printAndFeedLine();
        /* 备注信息 */
        sdk.pioWritePort(("备注:"+getComment(vo.getComment())).getBytes());
        /* 换行 */
        sdk.printAndFeedLine();
        sdk.selectCharacterSize(122122);
        /* 应收金额 */
        sdk.pioWritePort(("应收金额:"+vo.getPrice()).getBytes());
        /* 换行 */
        sdk.printAndFeedLine();

        sdk.pioWritePort("\n\n\n\n\n\n".getBytes());
        sdk.selectCutPagerModerAndCutPager(0);

        sdk.pioClose();
        log.info("--结束打印");
    }

    private static void doTest(OrderVO vo) {
        log.info("--开始打印");


        System.out.println("\n\n\n");
        /* 打印标题 */
        System.out.println(TITLE);
        /* 打印流水号 */
        System.out.println(getSerialNumber(vo.getNum()));
        /* 打印长流水号 */
        System.out.println(("长订单号:"+vo.getNum()));
        /* 时间 */
        System.out.println("下单时间:"+DateUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss"));
        // 分割线
        System.out.println(LINE);
        /* menu title */
        System.out.println("品类" + b19 + "份数" + b1 + "小计");
        /* menu list */
        System.out.println(buildMenu(vo.getOrderList()));
        /* 分割线 */
        System.out.println(LINE);
        /* 备注信息 */
        System.out.println(("备注:"+getComment(vo.getComment())));
        /* 应收金额 */
        System.out.println(("应收金额:"+vo.getPrice()));
        System.out.println("\n\n\n\n\n\n");
        log.info("--结束打印");
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

    // 由于只有三个格子给价格，所以不要超过1000元/单
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
     * 份数
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
        // TODO 拼接字符串 总长度26位，末尾用空格补齐（32-3-3）
        String x = "";
        switch (size) {
            case 1:
                x = "(小)";
                break;
            case 2:
                x = "(大)";
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
        if(str.endsWith("、")) {
            return str.substring(0,str.length() - 1);
        }
        return str;
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
//
//    /**
//     * 打印标题（大字加粗）
//     * 1. 店名
//     */
//    public static void TITLE1() {
//        String str = "重庆二两面\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.setLeftSpace(7,0);
//        sdk.setHorizontalAndVerticalMoveUnit(10,10);
//        sdk.setBarcodeHeight(10);
//        sdk.setBarcodeWidth(10);
//        // 字体大小
//        sdk.setChineseCharacterModel(8);
//        // margin-left/right
//        sdk.setChineseCharLeftAndRightSpace(0,0);
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }
//
//    /**
//     * 副标题（小字号）
//     * 1. 祝您用餐愉快
//     */
//    public static void TITLE2(){
//        String str = "祝您用餐愉快\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.setLeftSpace(6,0);
//        sdk.setHorizontalAndVerticalMoveUnit(10,10);
//        sdk.setBarcodeHeight(1);
//        sdk.setBarcodeWidth(1);
//        // 字体大小
//        sdk.setChineseCharacterModel(1);
//        // margin-left/right
//        sdk.setChineseCharLeftAndRightSpace(0,0);
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }



//    /**
//     * 打印副标题区（小子号）
//     * 1. 下单时间 日期+时间
//     * 2. 单号（10000 ~ 99999）
//     */
//    public static void INFO(int num){
//        String str = "下单时间:" +
//                DateUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss") +
//                "\n" +
//                "订单号:" +
//                num +
//                "\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }

//    /**
//     * 打印订单流水号（大字加粗）
//     * 1. 订单流水号 0001 ~ 9999
//     */
//    public static void NUM(int num){
//        String str = "取餐号码"+String.valueOf(num).substring(1) +
//                "\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.setLeftSpace(10,10);
//        sdk.setHorizontalAndVerticalMoveUnit(10,10);
//        sdk.setBarcodeHeight(10);
//        sdk.setBarcodeWidth(10);
////         字体大小
//        sdk.setChineseCharacterModel(8);
//        sdk.selectOrCancleCustomChar(8);
//        sdk.setLeftSpace(0,0);
//        sdk.setHorizontalAndVerticalMoveUnit(0,0);
//        sdk.selectOrCancelUnderlineModel(49);
//        sdk.selectOrCancelBoldModel(1);
//        sdk.setBarcodeHeight(0);
//        sdk.setBarcodeWidth(0);
////         字体大小
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
//     * 打印菜单(小字号)
//     * 1. 品相 ---- 数量 ---- 价格
//     * 2. 番茄炒鸡蛋 1份 ----  18元
//     * 3. 油焖茄子 - 1份 ----  18元
//     */
//    public static void MENU(List<OrderDetail> list){
//        StringBuilder str = new StringBuilder();
//        String name;
//        /* 表头 */
//        str.append("品类")
//                .append("\t\t\t")
//                .append("份数")
//                .append("\t")
//                .append("小计")
//                .append("\n");
//        /* 表体 */
//        for (OrderDetail detail : list) {
//            // 先拼接名称，后面根据名称设置对齐
//            if(detail.getName2() != null && !"".equals(detail.getName2())) {
//                name = detail.getName1()+"-"+detail.getName2();
//            } else {
//                name = detail.getName1();
//            }
//            if(detail.getSize() != null && detail.getSize() != 0) {
//                if(detail.getSize() == 1) {
//                    name += "(小)";
//                } else if(detail.getSize()==2) {
//                    name += "(大)";
//                }
//            }
//            // 名称总长度小于(3,5)需要三个\t，名称总长度[5,7]需要两个\t，名称总长度(7,
//            str.append(name);
//            if(name.length()<=2) {
//                /* 小于5位 + 4个制表符 | 荷包蛋 */
//                str.append("\t\t\t\t");
//            } else if (name.length()<=5){
//                /* 大于5位/小于等于8位 + 3个制表符 | 豌豆面-粉丝/番茄鸡蛋面(小) */
//                str.append("\t\t\t");
//            }else if (name.length()<=8){
//                /* 大于5位/小于等于8位 + 3个制表符 | 豌豆面-粉丝/番茄鸡蛋面(小) */
//                str.append("\t\t");
//            } else if (name.length()<=10){
//                /* 大于8位/小于等于10位 + 2个制表符 | 豌豆面-粉丝/番茄鸡蛋面(小) */
//                str.append("\t");
//            } else {
//                /* 大于10位 + 1个制表符 | 番茄炒鸡蛋-刀削面(小)*/
//                str.append("\t");
//            }
//            // 加空格让份数居中
//            str.append(" ")
//                    .append(detail.getNum())
//                    .append("\t")
//                    .append(detail.getPrice()*detail.getNum())
//                    .append("\n");
//        }
//        /* 删除最后一个换行 */
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
//     * 打印价格（明细-可省略 - 小字号）
//     * 1. 价格
//     */
//    public static void PRICE_DETAIL(){}
//
//    /**
//     * 打印价格（总价 - 大字号）
//     * 应付金额 xx元
//     */
//    public static void PRICE_TOTAL(List<OrderDetail> list){
//        int sum = 0;
//        for (OrderDetail detail : list) {
//            sum += detail.getPrice()*detail.getNum();
//        }
//        String str = "应付金额:" + sum + "\n";
//        System.out.println(str);
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.pioWritePort(str.getBytes());
//        sdk.pioClose();
//    }

//    /**
//     * 打印备注
//     * @param info
//     */
//    public static void COMMENT(String info) {
//        StringBuilder str = new StringBuilder();
//        str.append("备注:")
//                .append(info);
//        if(str.toString().endsWith("、")) {
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
//     * 打印分割线
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
//     * 打印分割线
//     * --------------------------------
//     */
//    public static void PAPER_END() {
//        Sdk sdk =new Sdk();
//        sdk.pioOpen("usb","",3000);//usb
//        sdk.pioWritePort("\n\n\n\n\n".getBytes());
//        sdk.pioClose();
//    }



}
