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
        BufferedReader br=new BufferedReader(fr);
        String line="";
        String[] arrs=null;
        double dou = 0.00;
        int lineNum = 1;
        String rep = "";
        FileWriter fw=new FileWriter(new File("E:/zc2.txt"));
        //写入中文字符时会出现乱码
        BufferedWriter  bw=new BufferedWriter(fw);
        //BufferedWriter  bw=new BufferedWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8")));
        while ((line=br.readLine())!=null) {
            StringBuilder sBuilder = new StringBuilder();
            System.out.println("-----第{"+lineNum+"}行");
            arrs=line.split(" ");
            lineNum++;
            for (int i = 0; i < arrs.length; i++) {
                if(arrs[i] == null || "".equals(arrs[i])) {
                    System.out.println("---");
                } else if ( arrs[i].contains("*")) {
                    // 包含*只要替换*后面的内容
                    rep=arrs[i].substring(arrs[i].indexOf('*')+1,arrs[i].length());
                    if(rep.contains(".")) {
                        sBuilder.append(Double.valueOf(rep)).append(" ");
                    } else {
                        sBuilder.append(Integer.valueOf(rep)).append(" ");
                    }
                } else {
                    // 不包含*替换全部内容
                    sBuilder.append(Double.parseDouble(arrs[i])).append(" ");
                }
            }
            sBuilder.append(" \n");
            bw.write(String.valueOf(sBuilder));
        }
        br.close();
        fr.close();
        bw.close();
        fw.close();
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
}
