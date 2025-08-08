package com.jim.ssr;

import net.jposprinter.Sdk;

public class JposPrinterDemo {


    public static void NOTE() {

        /**
         * 空格:-:汉字 = 1:1:2
         */

        Sdk sdk = new Sdk();
        /**
         * 文字对齐方式
         * 0：居左
         * 1：居中
         * 2：居右
         */
        sdk.selectAlignment(1);
        /**
         * 设置高度宽度，范围0~255  0~3位为高度，4~6位为宽度
         */
        sdk.selectCharacterSize(030030);
        /**
         * 反显,0正常，1反显
         */
        sdk.selectOrCancelInvertPrintModel(0);
    }

}
