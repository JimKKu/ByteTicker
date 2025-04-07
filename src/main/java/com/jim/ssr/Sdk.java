////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.jim.ssr;
//
//import java.nio.charset.Charset;
//import net.jposprinter.printerio.IOPort;
//import net.jposprinter.printerio.IOPortException;
//
//public class Sdk {
//    private IOPort mPio = null;
//
//    public Sdk() {
//    }
//
//    public void pioOpen(String paramString1, String paramString2, int paramInt) {
//        try {
//            this.mPio = IOPort.getPort(paramString1, paramString2, paramInt);
//        } catch (IOPortException var5) {
//            this.mPio = null;
//        }
//
//    }
//
//    public void pioClose() {
//        if (this.mPio != null) {
//            IOPort.releasePort(this.mPio);
//        }
//    }
//
//    public int pioWritePort(byte[] data) {
//        if (this.mPio == null) {
//            return 0;
//        } else {
//            try {
//                return this.mPio.writePort(data, 0, data.length);
//            } catch (IOPortException var3) {
//                return 0;
//            }
//        }
//    }
//
//    public int pioReadPort(byte[] data) {
//        if (this.mPio == null) {
//            return 0;
//        } else {
//            try {
//                return this.mPio.readPort(data, 0, data.length);
//            } catch (IOPortException var3) {
//                return 0;
//            }
//        }
//    }
//
//    private void charMerger(byte[] data0, int len0, byte[] data1, int len1, byte[] buffer) {
//        int index = 0;
//
//        int i;
//        for(i = 0; i < len0; ++i) {
//            buffer[index++] = data0[i];
//        }
//
//        for(i = 0; i < len1; ++i) {
//            buffer[index++] = data1[i];
//        }
//
//    }
//
//    public int horizontalPositioning() {
//        byte[] data = new byte[]{9};
//        return this.pioWritePort(data);
//    }
//
//    public int printAndFeedLine() {
//        byte[] data = new byte[]{10};
//        return this.pioWritePort(data);
//    }
//
//    public int printAndBackStandardmodel() {
//        byte[] data = new byte[]{12};
//        return this.pioWritePort(data);
//    }
//
//    public int PrintAndCarriageReturn() {
//        byte[] data = new byte[]{13};
//        return this.pioWritePort(data);
//    }
//
//    public int canclePrintDataByPagemodel() {
//        byte[] data = new byte[]{24};
//        return this.pioWritePort(data);
//    }
//
//    public int sendRealtimestatus(int n) {
//        byte[] data = new byte[]{16, 4, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int requestRealtimeForPrint(int n) {
//        byte[] data = new byte[]{16, 5, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int openCashboxRealtime(int m, int t) {
//        byte[] data = new byte[]{16, 20, 1, (byte)m, (byte)t};
//        return this.pioWritePort(data);
//    }
//
//    public int printByPagemodel() {
//        byte[] data = new byte[]{27, 12};
//        return this.pioWritePort(data);
//    }
//
//    public int setCharRightSpace(int n) {
//        byte[] data = new byte[]{27, 32, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectPrintModel(int n) {
//        byte[] data = new byte[]{27, 33, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setAbsolutePrintPosition(int m, int n) {
//        byte[] data = new byte[]{27, 36, (byte)m, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectOrCancleCustomChar(int n) {
//        byte[] data = new byte[]{27, 37, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int defineuserDefinedCharacters(int c1, int c2, byte[] b, int nlen) {
//        byte[] data = new byte[]{27, 38, 3, (byte)c1, (byte)c2};
//        byte[] data2 = new byte[data.length + nlen];
//        this.charMerger(data, data.length, b, nlen, data2);
//        return this.pioWritePort(data2);
//    }
//
//    public int selectBmpModel(int m, int nL, int nH, byte[] b) {
//        byte[] data = new byte[]{27, 42, (byte)m, (byte)nL, (byte)nH};
//        int len = false;
//        int len;
//        if (0 != m && 1 != m) {
//            if (32 != m && 33 != m) {
//                return -1;
//            }
//
//            len = (nL + nH * 256) * 3;
//        } else {
//            len = nL + nH * 256;
//        }
//
//        byte[] datadest = new byte[5 + len];
//        this.charMerger(data, data.length, b, len, datadest);
//        return this.pioWritePort(datadest);
//    }
//
//    public int selectOrCancelUnderlineModel(int n) {
//        byte[] data = new byte[]{27, 45, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setDefultLineSpacing() {
//        byte[] data = new byte[]{27, 50};
//        return this.pioWritePort(data);
//    }
//
//    public int setLineSpaceing(int n) {
//        byte[] data = new byte[]{27, 51, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectPrinter(int n) {
//        byte[] data = new byte[]{27, 61, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int cancelUserDefinedCharacters(int n) {
//        byte[] data = new byte[]{27, 63, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int initializePrinter() {
//        byte[] data = new byte[]{27, 64};
//        return this.pioWritePort(data);
//    }
//
//    public int setHorizontalmovementPosition(byte[] b, int nblen) {
//        byte[] data = new byte[]{27, 68};
//        byte[] data2 = new byte[data.length + nblen + 1];
//        this.charMerger(data, data.length, b, nblen, data2);
//        return this.pioWritePort(data2);
//    }
//
//    public int selectOrCancelBoldModel(int n) {
//        byte[] data = new byte[]{27, 69, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectOrCancelDoubelPrintModel(int n) {
//        byte[] data = new byte[]{27, 71, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int printAndFeed(int n) {
//        byte[] data = new byte[]{27, 74, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectPageModel() {
//        byte[] data = new byte[]{27, 76};
//        return this.pioWritePort(data);
//    }
//
//    public int selectFont(int n) {
//        byte[] data = new byte[]{27, 77, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectInternationalCharacterSets(int n) {
//        byte[] data = new byte[]{27, 82, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectStandardModel() {
//        byte[] data = new byte[]{27, 83};
//        return this.pioWritePort(data);
//    }
//
//    public int selectPrintDirectionUnderPageModel(int n) {
//        byte[] data = new byte[]{27, 84, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectOrCancelCW90(int n) {
//        byte[] data = new byte[]{27, 86, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setPrintAreaUnderPageModel(int xL, int xH, int yL, int yH, int dxL, int dxH, int dyL, int dyH) {
//        byte[] data = new byte[]{27, 87, (byte)xL, (byte)xH, (byte)yL, (byte)yH, (byte)dxL, (byte)dxH, (byte)dyL, (byte)dyH};
//        return this.pioWritePort(data);
//    }
//
//    public int setRelativeHorizontalPrintPosition(int nL, int nH) {
//        byte[] data = new byte[]{27, 92, (byte)nL, (byte)nH};
//        return this.pioWritePort(data);
//    }
//
//    public int selectAlignment(int n) {
//        byte[] data = new byte[]{27, 97, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectPrintTransducerOutPutPageOutSignal(int n) {
//        byte[] data = new byte[]{27, 99, 51, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectPrintTransducerStopPrint(int n) {
//        byte[] data = new byte[]{27, 99, 52, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int allowOrForbidPressButton(int n) {
//        byte[] data = new byte[]{27, 99, 53, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int printAndFeedForward(int n) {
//        byte[] data = new byte[]{27, 100, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int creatCashboxContorlPulse(int m, int t1, int t2) {
//        byte[] data = new byte[]{27, 112, (byte)m, (byte)t1, (byte)t2};
//        return this.pioWritePort(data);
//    }
//
//    public int selectCharacterCodePage(int n) {
//        byte[] data = new byte[]{27, 116, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectOrCancelConvertPrintModel(int n) {
//        byte[] data = new byte[]{27, 123, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int printBmpInFLASH(int n, int m) {
//        byte[] data = new byte[]{28, 112, (byte)n, (byte)m};
//        return this.pioWritePort(data);
//    }
//
//    public int selectCharacterSize(int n) {
//        byte[] data = new byte[]{29, 33, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setAbsolutePositionUnderPageModel(int nL, int nH) {
//        byte[] data = new byte[]{29, 36, (byte)nL, (byte)nH};
//        return this.pioWritePort(data);
//    }
//
//    public int executePrintDataSaveByTransformToHex() {
//        byte[] data = new byte[]{29, 40, 65, 2, 0, 0, 1};
//        return this.pioWritePort(data);
//    }
//
//    public int printDownLoadBmp(int m) {
//        byte[] data = new byte[]{29, 47, (byte)m};
//        return this.pioWritePort(data);
//    }
//
//    public int startOrStopMacrodeFinition() {
//        byte[] data = new byte[]{29, 58};
//        return this.pioWritePort(data);
//    }
//
//    public int selectOrCancelInvertPrintModel(int n) {
//        byte[] data = new byte[]{29, 66, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectHRICharacterPrintPosition(int n) {
//        byte[] data = new byte[]{29, 72, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setLeftSpace(int nL, int nH) {
//        byte[] data = new byte[]{29, 76, (byte)nL, (byte)nH};
//        return this.pioWritePort(data);
//    }
//
//    public int setHorizontalAndVerticalMoveUnit(int x, int y) {
//        byte[] data = new byte[]{29, 80, (byte)x, (byte)y};
//        return this.pioWritePort(data);
//    }
//
//    public int selectCutPagerModerAndCutPager(int m) {
//        byte[] data = new byte[]{29, 86, (byte)m};
//        return this.pioWritePort(data);
//    }
//
//    public int selectCutPagerModerAndCutPager2(int m, int n) {
//        byte[] data = new byte[]{29, 86, 66, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setPrintAreaWidth(int nL, int nH) {
//        byte[] data = new byte[]{29, 87, (byte)nL, (byte)nH};
//        return this.pioWritePort(data);
//    }
//
//    public int setVerticalRelativePositionUnderPageModel(int nL, int nH) {
//        byte[] data = new byte[]{29, 92, (byte)nL, (byte)nH};
//        return this.pioWritePort(data);
//    }
//
//    public int executeMacrodeCommand(int r, int t, int m) {
//        byte[] data = new byte[]{29, 94, (byte)r, (byte)t, (byte)m};
//        return this.pioWritePort(data);
//    }
//
//    public int openOrCloseAutoReturnPrintState(int n) {
//        byte[] data = new byte[]{29, 97, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectHRIFont(int n) {
//        byte[] data = new byte[]{29, 102, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setBarcodeHeight(int n) {
//        byte[] data = new byte[]{29, 104, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int returnState(int n) {
//        byte[] data = new byte[]{29, 114, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setBarcodeWidth(int n) {
//        byte[] data = new byte[]{29, 119, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setChineseCharacterModel(int n) {
//        byte[] data = new byte[]{28, 33, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int selectChineseCharModel() {
//        byte[] data = new byte[]{28, 38};
//        return this.pioWritePort(data);
//    }
//
//    public int selectOrCancelChineseCharUnderLineModel(int n) {
//        byte[] data = new byte[]{28, 45, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int CancelChineseCharModel() {
//        byte[] data = new byte[]{28, 46};
//        return this.pioWritePort(data);
//    }
//
//    public int setChineseCharLeftAndRightSpace(int n1, int n2) {
//        byte[] data = new byte[]{28, 83, (byte)n1, (byte)n2};
//        return this.pioWritePort(data);
//    }
//
//    public int selectOrCancelChineseCharDoubleWH(int n) {
//        byte[] data = new byte[]{28, 87, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int printerOrderBuzzingHint(int n, int t) {
//        byte[] data = new byte[]{27, 66, (byte)n, (byte)t};
//        return this.pioWritePort(data);
//    }
//
//    public int printerOrderBuzzingAndWarningLight(int m, int t, int n) {
//        byte[] data = new byte[]{27, 67, (byte)m, (byte)t, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setsTheNumberOfColumnsOfTheDataAreaForPDF417(int n) {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 48, 65, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setsTheNumberOfRowsOfTheDataAreaForPDF417(int n) {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 48, 66, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setsTheModuleWidthOfPDF417(int n) {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 48, 67, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setsTheModuleHeightForPDF417(int n) {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 48, 68, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setsTheErrorCorrectionLevelForPDF417(int m, int n) {
//        byte[] data = new byte[]{29, 40, 107, 4, 0, 48, 69, (byte)m, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int specifiesOrCancelsVariousPDF417SymbolOptions(int m) {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 48, 70, (byte)m};
//        return this.pioWritePort(data);
//    }
//
//    public int storesSymbolDataInThePDF417SymbolStorageArea(int pL, int pH, byte[] b, int nblen) {
//        byte[] data = new byte[]{29, 40, 107, (byte)pL, (byte)pH, 48, 80, 48};
//        byte[] data2 = new byte[data.length + nblen];
//        this.charMerger(data, data.length, b, nblen, data2);
//        return this.pioWritePort(data2);
//    }
//
//    public int printsThePDF417SymbolDataInTheSymbolStorageArea() {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 48, 81, 48};
//        return this.pioWritePort(data);
//    }
//
//    public int transmitsTheSizeOfTheSymbolDataInTheSymbolStorageAreaPDF417() {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 48, 82, 48};
//        return this.pioWritePort(data);
//    }
//
//    public int setsTheSizeOfTheQRCodeSymbolModule(int n) {
//        byte[] data = new byte[]{29, 40, 107, 48, 103, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int setsTheErrorCorrectionLevelForQRCodeSymbol(int n) {
//        byte[] data = new byte[]{29, 40, 107, 48, 105, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int transmitsTheSizeOfTheSymbolDataInTheSymbolStorageAreaQRCode() {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 49, 82, 48};
//        return this.pioWritePort(data);
//    }
//
//    public int specifiesTheModeForMaxiCodeSymbol(int n) {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 50, 65, (byte)n};
//        return this.pioWritePort(data);
//    }
//
//    public int storesSymbolDataInItheMaxiCodeSymbolStorageArea(int pL, int pH, byte[] b, int nblen) {
//        byte[] data = new byte[]{29, 40, 107, (byte)pL, (byte)pH, 50, 80, 48};
//        byte[] data2 = new byte[data.length + nblen];
//        this.charMerger(data, data.length, b, nblen, data2);
//        return this.pioWritePort(data2);
//    }
//
//    public int printsTheMaxiCodeSymbolDataInTheSymbolStorageArea() {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 50, 81, 48};
//        return this.pioWritePort(data);
//    }
//
//    public int transmitsTheSizeOfTheEncodedSymbolDataInTheSymbolStorageAreaMaxiCode() {
//        byte[] data = new byte[]{29, 40, 107, 3, 0, 50, 82, 48};
//        return this.pioWritePort(data);
//    }
//
//    public int twobarCodes(String strTrxData, Charset charset, int nZoomIn, int nErrorLevel, int bCut) {
//        byte[] cmd1 = new byte[]{27, 64, 10, 29, 40, 107, 48, 103, 1};
//        byte[] cmd2 = new byte[]{29, 40, 107, 48, 105, 72};
//        byte[] cmd3 = new byte[]{29, 40, 107, 48, -128, 1, 1, 0};
//        byte[] send1 = new byte[]{29, 40, 107, 48, -127, 27, 74, 24, 29, 86, 1};
//        byte[] send2 = new byte[]{29, 40, 107, 48, -127, 27, 74, 24};
//        cmd1[8] = (byte)nZoomIn;
//        int nsend = false;
//        int nsend = this.pioWritePort(cmd1);
//        if (nsend <= 0) {
//            return -1;
//        } else {
//            switch (nErrorLevel) {
//                case 0:
//                    cmd2[5] = 72;
//                    break;
//                case 1:
//                    cmd2[5] = 73;
//                    break;
//                case 2:
//                    cmd2[5] = 80;
//                    break;
//                case 3:
//                    cmd2[5] = 81;
//                    break;
//                default:
//                    return -100;
//            }
//
//            nsend = this.pioWritePort(cmd2);
//            if (nsend <= 0) {
//                return -1;
//            } else {
//                int WriteSize = strTrxData.length() + 1;
//                int sendlen = WriteSize + 7;
//                byte[] SendBuf = new byte[7 + WriteSize + 0];
//
//                for(int i = 0; i < cmd3.length; ++i) {
//                    SendBuf[i] = cmd3[i];
//                }
//
//                byte[] temp = strTrxData.getBytes(charset);
//
//                for(int i = 0; i < temp.length; ++i) {
//                    SendBuf[7 + i] = temp[i];
//                }
//
//                SendBuf[5] = (byte)(WriteSize % 256);
//                SendBuf[6] = (byte)(WriteSize / 256);
//                nsend = this.pioWritePort(SendBuf);
//                if (nsend <= 0) {
//                    return -1;
//                } else {
//                    if (bCut > 0) {
//                        nsend = this.pioWritePort(send1);
//                        if (nsend <= 0) {
//                            return -1;
//                        }
//                    } else {
//                        nsend = this.pioWritePort(send2);
//                        if (nsend <= 0) {
//                            return -1;
//                        }
//                    }
//
//                    return 1;
//                }
//            }
//        }
//    }
//
//    public int twobarCodes(String strTrxData, Charset charset) {
//        return this.twobarCodes(strTrxData, charset, 7, 1, 0);
//    }
//
//    public int printbarCodes(String code, String codebarText, int nCodeType, int width, int High, int align, int codeTextalign) {
////        int nResult = false;
//        byte[] defCmd = new byte[]{27, 64, 27, 97, 1, 29, 72, 0, 29, 119, 3, 29, 104, 3, 29, 107, 65, 11};
//        byte[] endbuf = new byte[]{10, 10, 27, 64, 0};
//        byte[] codeBytes = code.getBytes();
//        byte[] codebarBytes = codebarText.getBytes();
//        int codeLen = codeBytes.length;
//        int codeTextLen = codebarBytes.length;
//        byte[] SendBuf = new byte[defCmd.length + codeLen + codeTextLen + endbuf.length];
//
//        int i;
//        for(i = 0; i < defCmd.length; ++i) {
//            SendBuf[i] = defCmd[i];
//        }
//
//        SendBuf[4] = (byte)align;
//        SendBuf[7] = (byte)codeTextalign;
//        SendBuf[10] = (byte)width;
//        SendBuf[13] = (byte)High;
//        SendBuf[16] = (byte)nCodeType;
//        SendBuf[17] = (byte)codeLen;
//
//        for(i = 0; i < codeLen; ++i) {
//            SendBuf[18 + i] = codeBytes[i];
//        }
//
//        for(i = 0; i < codeTextLen; ++i) {
//            SendBuf[18 + codeLen + i] = codebarBytes[i];
//        }
//
//        for(i = 0; i < 5; ++i) {
//            SendBuf[18 + codeLen + codeTextLen + i] = endbuf[i];
//        }
//
//        int nResult = this.pioWritePort(SendBuf);
//        return nResult <= 0 ? -1 : 1;
//    }
//
//    public int printbarCodes(String code, String codebarText) {
//        return this.printbarCodes(code, codebarText, 65, 2, 162, 1, 2);
//    }
//}
