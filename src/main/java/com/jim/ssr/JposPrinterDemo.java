package com.jim.ssr;

import net.jposprinter.Sdk;

public class JposPrinterDemo {


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

}
