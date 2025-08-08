// usage instructions
// 1. compile from command line - javac -encoding utf-8 -classpath JposPrinterSDK.jar JposPrinterDemo.java
// 2. execute from command line - java -classpath .;JposPrinterSDK.jar JposPrinterDemo
========================================================================

    /**
     * pioOpen
     * 打开指定的通讯接口并建立通讯连接
     * @param ioType 接口类型：usb，com1，tcp：192.168.123.100
     * @param config 仅com时：9600，19200，38400，115200
     * @param timeOut
     * @return false,true ;*/
    public boolean pioOpen(String ioType, String config, int timeOut)
    /**
     * pioClose
     * 关闭接口，断开连接
     * @return */
    public void pioClose( )
    /**
     * pioWritePort
     * 发送数据
     * @param data
     * @return 成功返回实际的发送字节数  */
    public int pioWritePort(byte[] data)
    /**
     * pioReadPort
     * 接收数据
     * @param data
     * @return 成功返回实际的接收字节数  */
    public int pioReadPort(byte[]data)

// 以下例子以函数形式,实现打印机的指令下发，如有机型兼容性问题，以编程手册指令为准）

/**
 *
 * HT<br>
 * 水平定位指
 * @return int;
 * */
public int horizontalPositioning( )
/**
 * LF<br>
 * 打印并换行
 * @return int;
 * */
public int printAndFeedLine( )
/**
 * FF<br>
 * 打印并回到标准模式
 * @return int;
 * */
public int printAndBackStandardmodel( ){
/**
 * CR<br>
 * 打印并跳格
 * @return int
 * */
public int PrintAndCarriageReturn( ){
/**
 * CAN<br>
 * 页模式下取消打印数据
 * @return int;
 * */
public int canclePrintDataByPagemodel( ){
/**
 * DLE EOT n<br>
 * 实时状态传送
 * @param n,1<=n<=4;
* @return int;
* */
public int sendRealtimestatus(  int n){
/**
 * DLE ENQ n<br>
 * 实时对打印机请求
 * @param n,1<=n<=2
* @return int
* */
public int requestRealtimeForPrint(  int n){
/**
 * DLE DC4 n m t<br>
 * 实时产生开钱箱脉冲
 * @param m:0,1;
 * @param t,1<=t<=8;
* @return int
* */
public int openCashboxRealtime(  int m, int t){
/**
 * ESC FF<br>
 * 页模式下打印<br>
 * 该命令只在页模式下有效
 * @return int
 * */
public int printByPagemodel( ){
/**
 * 设置字符右间距<br>
 * @param n,代表间距大小的变量，范围0-255；
 * @return int
 * */
public int setCharRightSpace(  int n){
/**
 * ESC ！n<br>
 * 选择打印模式
 * @param n,代表打印模式的变量，范围0-255
 * @return int
 * */
public int selectPrintModel(  int n){
/**
 * ESC $ nL nH<br>
 * 设置绝对打印位置
 * @param m，n，m+n*256代表距离行首位置，范围0-255；
 * @return int
 * */
public int setAbsolutePrintPosition(  int m, int n){
/**
 * ESC % n<br>
 * 选择或取消用户自定义字符
 * @param n，0-255，最低位为1，使用；最低位为0，不使用；
 * @return int
 * */
public int selectOrCancleCustomChar(  int n){
/**
 * ESC $ Y c1 c2 [x1 d1...d(x1*y)]...[xk d1...d(y*xk)]<br>
 * 定义用户自定义字符
 * @param c1,c1是起始字符代码,范围32<=c1<=c2<=127
*  @param  c2, c2是终止字符代码，范围32<=c1<=c2<=127;
* @param b，字节数组b的格式为[x1 d1...d(x1*y)]...[xk d1...d(y*xk)]，为字符下载的字符的数据的集合,自定义字符的规则详情，请参考编程手册；
* @return int
* */
public int defineuserDefinedCharacters(  int c1, int c2, byte[] b, int nlen){
/**
 * ESC * m nL nH d1 d2...dk<br>
 * 选择位图模式<br>
 * 该指令详情请参考编程手册
 * @param m,范围：0,1,32，33,代表不同点的密度
 * @param nL,范围：0-255
 * @param nH,范围：0-3
 * @param b，b={d1 d2...dk}，m=0或1,k=nL+nH*256;m=32或33,k=(nL+nH*256)*3;0<=d<=255;
 * @return int
 * */
public int selectBmpModel(  int m, int nL, int nH, byte[] b){
/**
 * ESC-n<br>
 * 选择或者取消下划线模式
 * @param n:0,48 取消下划线；1,49选择下划线（1点宽）;2,50选择下划线（2点宽）;
 * @return int
 * */
public int selectOrCancelUnderlineModel(  int n){
/**
 * ESC 2<br>
 * 设置默认行间距
 * 大约3.75mm
 * @return int
 * */
public int setDefultLineSpacing( ){
/**
 * ESC 3 n<br>
 * 设置行间距
 * @param n,范围：0-255
 * */
public int setLineSpaceing(  int n){
/**
 * ESC=n<br>
 * 选择打印机
 * @param n：0或1
 * @return int
 * */
public int selectPrinter(  int n){
/**
 * ESC ? n<br>
 * 取消用户自定义字符
 * 取消用户自定义字符中代码为n的字符
 * @param n,范围:32-127
 * @return int
 * */
public int cancelUserDefinedCharacters(  int n){
/**
 * ESC @<br>
 * 初始化打印机
 * @return int
 * */
public int initializePrinter( ){
/**
 * ESC D n1...nk NUL;<br>
 * 设置横线跳格位置
 * @param b={n1...nk};k<=32;跳格距离=字符宽度*n；<br>
 * 参数b内的n值大小和个数设置请参考编程手册
 * @return int
 * */
public int setHorizontalmovementPosition(  byte[] b, int nblen){
/**
 * ESC E n<br>
 * 选择或取消加粗模式
 * @param n，0-255，最低位为1，选择加粗；最低位为0，取消加粗；
 * @return int
 * */
public int selectOrCancelBoldModel(  int n){
/**
 * ESC G n<br>
 * 选择或取消双重打印模式
 * @param n，0-255，最低位为1，选择双重打印；最低位为0，取消双重打印；
 * @return int
 * */
public int selectOrCancelDoubelPrintModel(  int n){
/**
 * ESC J n<br>
 * 打印并走纸
 * @param n,走纸距离，单位英寸，范围：0-255
 * @return int
 * */
public int printAndFeed(  int n){
/**
 * ESC L<br>
 * 选择页模式
 * @return int
 * */
public int selectPageModel( ){
/**
 * ESC M n<br>
 * 选择字体
 * @param n,范围：0，1，48，49；0，48标准字体；1，49压缩字体
 * @return int
 * */
public int selectFont(  int n){
/**
 * ESC R n<br>
 * 选择国际字符集
 * @param n：0-15；代表某一种国际字符集
 * @return int
 * */
public int selectInternationalCharacterSets(  int n){
/**
 * ESC S<br>
 * 选择标准模式
 * @return int
 * */
public int selectStandardModel( ){
/**
 * ESC T n<br>
 * 在页模式下选择打印区域方向
 * @param n：0<=n<=3,48<=n<=51;n指定打印区域的方向和起始位置
 * @return int
 * */
public int selectPrintDirectionUnderPageModel(  int n){
/**
 * ESC V n<br>
 * 选择或取消顺时针旋转90度<br>
 * 此命令只在页模式下有效
 * @param n:0<=n<=1,48<=n<=49;0,48代表取消，1,49代表选择
 * @return int
 * */
public int selectOrCancelCW90(  int n){
/**
 * ESC W  xL xH yL yH dxL dxH dyL dyH<br>
 * 页模式下设置打印区域
 * @param , 0<=xL xH yL yH dxL dxH dyL dyH<=255
* @return int
* */
public int setPrintAreaUnderPageModel(  int xL, int xH, int yL, int yH, int dxL, int dxH, int dyL, int dyH){
/**
 * ESC \ nL nH<br>
 * 设置相对横向打印位置<br>
 * 指令使用详情请参考编程手册
 * @param nL,nH范围：0-255
 * @return int
 * */
public int setRelativeHorizontalPrintPosition(  int nL, int nH){
/**
 * ESC a n<br>
 * 选择对齐方式
 * @param n:0-2或48-50；分别表示：左对齐，居中，右对齐
 * @return int
 * */
public int selectAlignment(  int n){
/**
 * ESC c 3 n<br>
 * 选择打印机纸传感器以输出缺纸信号
 * @param n：0-255
 * @return int
 * */
public int selectPrintTransducerOutPutPageOutSignal(  int n){
/**
 * ESC c 4 n<br>
 * 选择打印机传感器一停止打印
 * @param n:0-255
 * @return int
 * */
public int selectPrintTransducerStopPrint(  int n){
/**
 * ESC c 5 n<br>
 * 允许或禁止按键
 * @param n：0-255，n的最后一位为0，按键启用，为1，按键禁止；
 * @return int
 * */
public int allowOrForbidPressButton(  int n){
/**
 * ESC d n<br>
 * 打印并向前走纸n行
 * @param n:0-255；
 * @return int
 * */
public int printAndFeedForward(  int n){
/**
 * ESC p m t1 t2<br>
 * 产生钱箱控制脉冲
 * @param m ：连接引脚，范围：0,1,48,49；
 * @param t1,t2：0-255
 * @return int
 * */
public int creatCashboxContorlPulse(  int m, int t1, int t2){
/**
 * ESC t n<br>
 * 选择字符代码表
 * @param n：0<=n<=10,16<=n<=19;
 * @return int
 * */
public int selectCharacterCodePage(  int n){
/**
 * ESC { n<br>
 * 选择或取消倒置打印模式
 * @param n：最低位0取消，最低位1选择，范围：0-255；
 * @return int
 * */
public int selectOrCancelConvertPrintModel(  int n){
/**
 * FS p n m<br>
 * 打印下载到FLASH中的位图
 * @param n，表示位图，0-255
 * @param m：0-3或48-51
 * @return int
 * */
public int printBmpInFLASH(  int n, int m){

/**
 * GS ! n<br>
 * 选择字符大小
 * @param n 范围0-255；n的0到3位设定字符高度，4-7位用来设定字符宽度
 * @return int
 * */
public int selectCharacterSize(  int n){
/**
 * GS $ nL nH<br>
 * 页模式下设置绝对位置
 * @param nL,nH,nl+nh*256代表位置，单位英寸；nl和nh的范围：0-255；
 * @return int
 * */
public int setAbsolutePositionUnderPageModel(  int nL, int nH){

/**
 * GS ( A pL pH n m<br>
 * 执行打印机数据十六进制转储
 * @return int
 * */
public int executePrintDataSaveByTransformToHex( ){
/**
 * GS / m<br>
 * 打印下载位图
 * @param m，指定打印模式，范围：0-3或48-51；
 * @return int
 * */
public int printDownLoadBmp(  int m){
/**
 * GS ：<br>
 * 开始或结束宏定义
 * @return int
 * */
public int startOrStopMacrodeFinition( ){
/**
 * GS B n<br>
 * 选择或取消黑白反显打印模式
 * @param n：0-255，最低位为0，取消反显打印，最低位为1，选择反显打印
 * @return int
 * */
public int selectOrCancelInvertPrintModel(  int n){
/**
 * GS H n<br>
 * 选择HRI字符打印位置;
 * HRI是对条码内容注释的字符;
 * @param n:范围0-3或者48-51；代表字符在条码的打印位置
 * @return int
 * */
public int selectHRICharacterPrintPosition(  int n){
/**
 * GS L nL nH<br>
 * 设置左边距
 * @param nL，nH，范围0-255，（nl+nh*256）*横向移动单位，代表设置的左边距，单位：英寸
 * @return int
 * */
public int setLeftSpace(  int nL, int nH){
/**
 * GS P x y<br>
 * 设置横向和纵向移动单位<br>
 * @param x,设置横向移动单位的参数，0-255
 * @param y,设置纵向移动单位的参数，0-255
 * 当x和y为0时，xy被设置为默认值
 * @return int
 * */
public int setHorizontalAndVerticalMoveUnit(  int x, int y){
/**
 * GS V m<br>
 * 选择切纸模式并切纸
 * @param m：0，48，全切；1,49，半切
 * @return int
 * */
public int selectCutPagerModerAndCutPager(  int m){
/**
 * GS V m n<br>
 * 选择切纸模式并切纸
 * @param m：只能是66
 * @param n:进纸n，然后半切纸
 * @return int
 * */
public int selectCutPagerModerAndCutPager2(  int m, int n){
/**
 * GS W nL nH<br>
 * 设置打印区域宽度
 * @param nL,(nl+nh*256)*横向移动单位，代表打印区域宽度
 * @param nH,(nl+nh*256)*横向移动单位，代表打印区域宽度
 *
 * @return int
 * */
public int setPrintAreaWidth(  int nL, int nH){
/**
 * GS \ nL nH<br>
 * 页模式下设置相对打印位置
 * @param nL,(nl+nh*256)*纵向移动单位，表示相对当前打印位置纵向移动距离
 * @param nH,(nl+nh*256)*纵向移动单位，表示相对当前打印位置纵向移动距离
 * @return int
 * */
public int setVerticalRelativePositionUnderPageModel(  int nL, int nH){
/**
 * GS ^ r t m<br>
 * 执行宏命令
 * @param r：0-255，指定执行次数
 * @param t：0-255，执行等等时间
 * @param m：0或1，执行模式
 * @return int
 * */
public int executeMacrodeCommand(  int r, int t, int m){
/**
 * GS a n<br>
 * 打开或关闭自动状态返回功能
 * @param n，0-255，每一位代表不同的状态返回
 *	@return int
 * */
public int openOrCloseAutoReturnPrintState(  int n){
/**
 * GS f n<br>
 * 选择HRI使用字体
 * @param n ：0,48代表标准；1，49代表压缩字体；
 * @return int
 * */
public int selectHRIFont(  int n){
/**
 * GS h n<br>
 * 选择条码高度
 * @param n ：1-255；默认162
 * @return int
 * */
public int setBarcodeHeight(  int n){
/**
 * GS r n<br>
 * 返回状态
 * @param n 范围：1,2,49,50;1,49返回传感器状态,2,50返回钱箱状态;
 * @return int
 *
 * */
public int returnState(  int n){
/**
 * GS w n<br>
 * 设置条码宽度
 * @param n：2-6；默认3；
 * @return int
 * */
public int setBarcodeWidth(  int n){
/**
 * FS ! n<br>
 * 设置汉字字符模式
 * @param n:0-255；字节的不同位定义字符模式
 * @return int
 * */
public int setChineseCharacterModel(  int n){
/**
 * FS &<br>
 * 选择汉字模式
 * @return int
 * */
public int selectChineseCharModel( ){
/**
 * FS - n<br>
 * 选择或取消汉字下划线模式
 * @param n：0-2或48-50；
 * @return int
 * */
public int selectOrCancelChineseCharUnderLineModel(  int n){
/**
 * FS .<br>
 * 取消汉字模式
 * @return int
 * */
public int CancelChineseCharModel( ){

/**
 * FS S n1 n2<br>
 * 设置汉字字符左右间距
 * @param n1,设置左间距，0-255；
 * @param n2,设置右间距，0-255；
 * @return	int
 * */
public int setChineseCharLeftAndRightSpace(  int n1, int n2){
/**
 * FS W n<br>
 * 选择或取消汉字倍高倍宽
 * @param n：0-255；只有最低位有效，0，取消；1，选择
 * @return int
 * */
public int selectOrCancelChineseCharDoubleWH(  int n){
/**
 * ESC B n t<br>
 * 打印机来单打印蜂鸣提示
 * @param n 蜂鸣次数.1-9
 * @param t 每次蜂鸣时间，t*50ms,1-9
 * @return int
 * */
public int printerOrderBuzzingHint(  int n, int t){
/**
 * ESC C m t n<br>
 * 打印机来单蜂鸣提示及报警灯闪烁
 * @param m 蜂鸣次数报警灯闪烁次数.范围1-20
 * @param t 每次鸣叫或闪烁间隔时间，（t*50ms），范围1-20
 * @param n 0-3；分别表示是否鸣叫，闪烁；
 * @return int
 * */
public int printerOrderBuzzingAndWarningLight(  int m, int t, int n){

/**
 * GS ( k p L p H cn fn n (fn = 65)<br>
 * Sets the number of columns of the data area for PDF417<br>
 * (p L + p H × 256) = 3 (p L = 3, p H = 0)<br>
 * cn = 48<br>
 * fn = 65<br>
 * @param n, 0 ≤ n ≤ 30;
 * @return int
 * */
public int setsTheNumberOfColumnsOfTheDataAreaForPDF417(  int n){
/**
 * Sets the number of rows of the data area for PDF417<br>
 * GS ( k p L p H cn fn n (fn = 66)<br>
 * (p L + p H × 256) = 3 (p L = 3, p H = 0)<br>
 * cn = 48<br>
 * fn = 66<br>
 * @param n=0,3 ≤ n ≤ 90;
 * @return int
 * */
public int setsTheNumberOfRowsOfTheDataAreaForPDF417(  int n){
/**
 * Sets the module width of one PDF417 symbol to n dots.<br>
 *  GS ( k p L p H cn fn n (fn = 67)<br>
 *  [Range]  (p L + p H × 256) = 3 (p L = 3, p H = 0)<br>
 *  			cn = 48	<br>
 *  			fn = 67	<br>
 *   @param	n,	2 ≤ n ≤ 8	<br>
 * 				[Default]  n =3<br>
 * @return int
 *
 * */
public int setsTheModuleWidthOfPDF417(  int n){
/**
 *  Sets the module height to [(module width) × n].<br>
 *   GS ( k p L p H cn fn n (fn = 68)<br>
 *   [Range]  (p L + p H × 256) = 3 (p L = 3, p H = 0)<br>
 *   cn = 48<br>
 *   fn = 68<br>
 *  @param n, 2 ≤ n ≤ 8<br>
 *   [Default]  n = 3<br>
 *   @return int
 * */
public int setsTheModuleHeightForPDF417(  int n){
/**
 * Sets the error correction level for PDF417 symbols.<br>
 * GS ( k p L p H cn fn m n (fn = 69)<br>
 * [Range]  (p L + p H × 256) = 4 (p L = 4, p H = 0)<br>
 * cn = 48<br>
 * fn = 69<br>
 * @param m = 48, 49<br>
 * @param n:48 ≤ n ≤ 56 (when m = 48 is specified),1 ≤ n ≤ 40 (when m = 49 is specified)<br>
 * [Default]  m = 49, n = 1<br>
 * @return int
 * */
public int setsTheErrorCorrectionLevelForPDF417(  int m, int n){
/**
 * specifies or cancels various PDF417 symbol options<br>
 *  GS ( k p L p H cn fn m (fn = 70)<br>
 * [Range]  (p L + p H × 256) = 3 (p L = 3, p H = 0)<br>
 * cn = 48<br>
 * fn = 70<br>
 * @param m = 0 or 1<br>
 * [Default]  m = 0
 * @return int
 * */
public int specifiesOrCancelsVariousPDF417SymbolOptions(  int m){
/**
 *  Stores symbol data (d1...dk) in the PDF417 symbol storage area.<br>
 *   GS ( k p L p H cn fn m d1 … dk (fn = 80)<br>
 *   [Range]  4 ≤ (p L + p H × 256) ≤ 65535 (0 ≤ p L ≤ 255, 0 ≤ p H ≤ 255)<br>
 *   cn = 48<br>
 *   fn = 80<br>
 *   m = 48<br>
 *   @param b={d1...dk},k为b的长度<br>
 *   0 ≤ d ≤ 255<br>
 *   k = (p L + p H × 256) – 3<br>
 *   @return int
 * */
public int storesSymbolDataInThePDF417SymbolStorageArea(  int pL, int pH, byte[] b, int nblen){
/**
 * Prints the PDF417 symbol data in the symbol storage area.<br>
 * GS ( k p L p H cn fn m (fn = 81)<br>
 * [Range]  (p L + p H × 256) = 3 (p L = 3, p H = 0)<br>
 * cn = 48<br>
 * fn = 81<br>
 * m = 48<br>
 * @return int
 * */
public int printsThePDF417SymbolDataInTheSymbolStorageArea( ){
/**
 * Transmits the size of the symbol data in the symbol storage area.<br>
 *  GS ( k p L p H cn fn m (fn = 82)<br>
 *  Hex  1D  28  6B  p L p H cn  fn  m<br>
 *  [Range]  (p L + p H × 256) = 3 (p L = 3, pH = 0)<br>
 *  cn = 48<br>
 *  fn = 82<br>
 *  m = 48<br>
 *  @return int
 * */
public int transmitsTheSizeOfTheSymbolDataInTheSymbolStorageAreaPDF417( ){
/**
 * Sets the size of the QRCode symbol module to [n dots × n dots]<br>
 *  GS ( k p L p H cn fn n (fn = 67)<br>
 *  Hex  1D  28  6B  p L p H cn  fn  n<br>
 *  [Range]  p L = 3, p H = 0<br>
 *  cn = 49<br>
 *  fn = 67<br>
 * @param n 1<=n<=16
 *  [Default]  n = 3<br>
 *  @return int
 * */
public int setsTheSizeOfTheQRCodeSymbolModule(  int n){
/**
 * Sets the error correction level for QRCode symbol.<br>
 * GS ( k p L p H cn fn n (fn = 69)<br>
 * Hex  1D  28  6B  p L p H cn  fn  n<br>
 * [Range]  p L = 3, p H = 0<br>
 * cn = 49<br>
 * fn = 69<br>
 * @param n, 48 ≤ n ≤ 51
 * [Default]  n = 48<br>
 * @return int
 * */
public int setsTheErrorCorrectionLevelForQRCodeSymbol(  int n){
/**
 * Transmits the size of the symbol data in the symbol storage area<br>
 * GS ( k p L p H cn fn m (fn = 82)<br>
 * Hex  1D  28  6B  p L p H cn  fn  m<br>
 * [Range]  p L = 3, pH = 0<br>
 * cn = 49<br>
 * fn = 82<br>
 * m = 48<br>
 * @return int
 * */
public int transmitsTheSizeOfTheSymbolDataInTheSymbolStorageAreaQRCode( ){
/**
 * specifies the mode for MaxiCode symbol<br>
 *  GS ( k p L p H cn fn n (fn = 65)<br>
 *  Hex  1D  28  6B  p L p H cn  fn  n<br>
 *  [Range]  p L = 3, p H = 0<br>
 *  cn = 50<br>
 *  fn = 65<br>
 *  @param n, 50 ≤ n ≤ 54<br>
 *  [Default]  n = 50<br>
 *  @return int
 * */
public int specifiesTheModeForMaxiCodeSymbol(  int n){
/**
 * Stores symbol data (d1…dk) in the MaxiCode symbol storage area.<br>
 * GS ( k p L p H cn fn m d1…dk (fn = 80)<br>
 * Hex  1D  28  6B  p L p H cn  fn  m  d1…dk<br>
 * [Range]  4 ≤ (p L + p H × 256) ≤ 141 (0 ≤ p L ≤ 141, p H = 0)<br>
 * cn = 50<br>
 * fn = 80<br>
 * m = 48<br>
 * 1 ≤ d ≤ 255<br>
 * k = (p L + p H × 256) – 3<br>
 * @param pL :int
 * @param pH :int
 * @param b :int
 * @return int
 * */
public int storesSymbolDataInItheMaxiCodeSymbolStorageArea(  int pL, int pH, byte[] b, int nblen){
/**
 * Prints the MaxiCode symbol data in the symbol storage area<br>
 * GS ( k p L p H cn fn m (fn = 81)<br>
 * Hex  1D  28  6B  p L p H cn  fn m<br>
 * [Range]  p L = 3, p H = 0<br>
 * cn = 50<br>
 * fn = 81<br>
 * m = 48<br>
 * @return int
 * */
public int printsTheMaxiCodeSymbolDataInTheSymbolStorageArea( ){
/**
 * Transmits the size of the encoded symbol data in the symbol storage area<br>
 * ASCII  GS  (  k  p L p H cn  fn  m<br>
 * Hex  1D  28  6B  p L p H cn  fn  m<br>
 * [Range]  p L = 3, pH = 0<br>
 * cn = 50<br>
 * fn = 82<br>
 * m = 48<br>
 * @return int
 * */
public int transmitsTheSizeOfTheEncodedSymbolDataInTheSymbolStorageAreaMaxiCode( ){
/**
 * 打印制定文字的二维码
 * @fs 句柄
 * @strTrxData  文本内容,
 * @nZoomIn  放大系数 1-16
 * @nErrorLevel  错误修正级别 1=7%，2=15%，3=25%，4=30%
 * @bCut  是否切纸
 * @return >0 成功，<= 0 失败
 * */
public int twobarCodes(  String strTrxData, Charset charset ,int nZoomIn /*= 7*/, int nErrorLevel /*= 1*/, int bCut /*= 0*/)
/**
 * 打印制定文字的二维码
 * @fs 句柄
 * @nCodeType  条码类型 65 UPC_A ,66 UPC_C ,67 EN(JAN)13 ,68 EN(JAN)8 ,69 CODE39 ,70 ITF ,71 CODABAR ,72 CODE93,73 CODE128
 * @High  1<= High <= 255
        * @align 0 左对齐 1 中间对齐 2 右对齐
        * @codeTextalign n  条码字符打印位置
        0, 48  不打印
        1, 49  条码上方
        2, 50  条码下方
        3, 51  条码上、下方都打印
        * @width 宽度 根据类型而定，有范围
        * @codeText 字符根据 类型而定，可参考编程手册

        * @return >0 成功，<= 0 失败
 * */
public int printbarCodes(  String code, String codebarText, int nCodeType /*= 65*/,
                                       int width /*= 2*/, int High /*= 162*/, int align /*= 1*/, int codeTextalign /*= 2*/)

