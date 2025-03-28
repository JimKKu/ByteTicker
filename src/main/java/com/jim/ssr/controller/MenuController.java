package com.jim.ssr.controller;


import com.jim.ssr.entity.Menu;
import com.jim.ssr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuMapper mm;


    @GetMapping("/list/{typeId}")
    public List<Menu> list(@PathVariable("typeId") Integer typeId) {
        return mm.getMenuList(typeId);
    }


    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("E:/zc.txt");
        FileWriter fw=new FileWriter(new File("E:/zc2.txt"));
        BufferedReader br=new BufferedReader(fr);
        String line="";
        String[] arrs=null;
        double dou = 0.00;
        int lineNum = 1;
        String rep = "";
        //写入中文字符时会出现乱码
        BufferedWriter  bw=new BufferedWriter(fw);
        //BufferedWriter  bw=new BufferedWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8")));
        while ((line=br.readLine())!=null) {
            StringBuilder sBuilder = new StringBuilder();
            System.out.println("-----第{"+lineNum+"}行");
            arrs=line.split(" ");
            lineNum++;
            for (int i = 0; i < arrs.length; i++) {
                System.out.print(arrs[i]+"\t");
                if(arrs[i] == null || "".equals(arrs[i])) {
                    System.out.println("---");
                } else if ("/".equals(arrs[i])) {
                    sBuilder.append("\n/\n");
                }else if ( arrs[i].contains("*")) {
                    // 包含*只要替换*后面的内容
                    String str1 = arrs[i].substring(0,arrs[i].indexOf('*')+1);
                    rep=arrs[i].substring(arrs[i].indexOf('*')+1);
                    if(rep.contains(".")) {
                        sBuilder.append(str1).append(replace(Double.parseDouble(rep))).append(" ");
                    } else {
                        sBuilder.append(str1).append(replace(Integer.parseInt(rep))).append(" ");
                    }
                } else {
                    // 不包含*替换全部内容
                    sBuilder.append(replace(Double.parseDouble(arrs[i]))).append(" ");
                }

            }
            sBuilder.append(" \n");
            bw.write(String.valueOf(sBuilder));
            System.out.println("---"+sBuilder);
            System.out.println("\n");
        }
        br.close();
        fr.close();
        bw.close();
        fw.close();
    }

//    private static int replace(int num) {
//        if(num < 13) {
//            System.out.println("整数"+num+"小于13");
//            return 10;
//        } else if (num <20 ) {
//            System.out.println("整数"+num+"小于20");
//            return 9;
//        } else if (num < 40) {
//            System.out.println("整数"+num+"小于40");
//            return 8;
//        } else if (num < 70) {
//            System.out.println("整数"+num+"小于70");
//            return 7;
//        } else if (num < 120) {
//            System.out.println("整数"+num+"小于120");
//            return 6;
//        } else if (num < 200) {
//            System.out.println("整数"+num+"小于200");
//            return 5;
//        } else if (num < 350) {
//            System.out.println("整数"+num+"小于350");
//            return 4;
//        } else if (num < 600) {
//            System.out.println("整数"+num+"小于600");
//            return 3;
//        } else if (num < 1000) {
//            System.out.println("整数"+num+"小于1000");
//            return 2;
//        } else {
//            System.out.println("整数"+num+"大于1000");
//            return 1;
//        }
//    }
//
//    private static int replace(double num) {
//        if(num < 13) {
//            System.out.println("小数"+num+"小于13");
//            return 10;
//        } else if (num <20 ) {
//            System.out.println("小数"+num+"小于20");
//            return 9;
//        } else if (num < 40) {
//            System.out.println("小数"+num+"小于40");
//            return 8;
//        } else if (num < 70) {
//            System.out.println("小数"+num+"小于70");
//            return 7;
//        } else if (num < 120) {
//            System.out.println("小数"+num+"小于120");
//            return 6;
//        } else if (num < 200) {
//            System.out.println("小数"+num+"小于200");
//            return 5;
//        } else if (num < 350) {
//            System.out.println("小数"+num+"小于350");
//            return 4;
//        } else if (num < 600) {
//            System.out.println("小数"+num+"小于600");
//            return 3;
//        } else if (num < 1000) {
//            System.out.println("小数"+num+"小于1000");
//            return 2;
//        } else {
//            System.out.println("小数"+num+"大于1000");
//            return 1;
//        }
//    }

    private static int replace(int num) {
        if(num < 13) {
            return 10;
        } else if (num <20 ) {
            return 9;
        } else if (num < 40) {
            return 8;
        } else if (num < 70) {
            return 7;
        } else if (num < 120) {
            return 6;
        } else if (num < 200) {
            return 5;
        } else if (num < 350) {
            return 4;
        } else if (num < 600) {
            return 3;
        } else if (num < 1000) {
            return 2;
        } else {
            return 1;
        }
    }

    private static int replace(double num) {
        if(num < 13) {
            return 10;
        } else if (num <20 ) {
            return 9;
        } else if (num < 40) {
            return 8;
        } else if (num < 70) {
            return 7;
        } else if (num < 120) {
            return 6;
        } else if (num < 200) {
            return 5;
        } else if (num < 350) {
            return 4;
        } else if (num < 600) {
            return 3;
        } else if (num < 1000) {
            return 2;
        } else {
            return 1;
        }
    }

}
