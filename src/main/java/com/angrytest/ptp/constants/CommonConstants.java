package com.angrytest.ptp.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class CommonConstants {


    /******************************普通常量 begin*****************************/

    /**
     * UTF-8
     */
    public static final String UTF8_ENCODE = "utf-8";

    /**
     * 中文字符的unicode
     */
    public static final List<Character.UnicodeBlock> CHINESE_UNICODES =
            Collections.unmodifiableList(Arrays.asList(new Character.UnicodeBlock[]{
                    Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS,
                    Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS,
                    Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A,
                    Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B,
                    Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION,
                    Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS,
                    Character.UnicodeBlock.GENERAL_PUNCTUATION}));



    /**
     * message transfer 的TAM报警监控日志信息 前缀
     */
    public static final String MSG_TRANSFER_TAM_TAG="(MSG_TRANSFER_TAM) ";

    /**
     * 数据库文本信息最大长度
     */
    public static final int DB_TEXT_MAX_LENGTH = 4000;


    /**
     * 每个月中最多有31天
     */
    public static final int MAX_DAY_IN_MONTH = 31;

    /**
     * 24 小时
     */
    public static final int TWENTY_FOUR_CLOCK = 2400;

    /**
     * 班期最小是1
     */
    public static final int MIN_WEEKDAY = 1;

    /**
     * 班期最大是7
     */
    public static final int MAX_WEEKDAY = 7;

    /**
     * /IP报占16位 2^16最长长度为65536
     */
    public static final int IP_MSG_MAX_LENGTH = 65536;

    /**
     * 默认发送序号
     */
    public static final int DEF_SEND_SEQUENCE = -1;

    /**
     * ftp移动文件到error目录的时间戳格式
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";


    /*** 零标识*/
    public static final String ZERO_FLAG = "0";

    /**
     * 空字符
     */
    public static final String EMPTY_STRING = "";

    /**
     * 默认处理倍数
     */
    public static final int DEF_PROCESS_TIMES = 2;

    public static final String YYYYMMDDHHMMSSS = "yyyyMMddHHmmss:SSS";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String DDMMMYY = "ddMMMyy";
    public static final String OPEN_DATE = "00XXX00";
    public static final String MAX_DATE = "2099-12-31";

    /**
     * 反斜线标识
     */
    public static final String BACK_SLASH="/";

    /**
     * 行间隔标识
     */
    public static final String LINE_FLAG = "-";

    //下划线
    public static final String UNDER_LINE = "_";

    //双斜杠标识
    public static final String DOUBLE_SLASH = "\\";

    /**
     * 回车换行标识
     */
    public static final String ENTER_NEW_LINE = "\r\n";

    /**
     * 回车标识
     */
    public static final String ENTER = "\r";

    /**
     * 换行标识
     */
    public static final String NEW_LINE = "\n";

    /**
     * .分隔符
     */
    public static final String DOT = ".";

    /**
     * *星号
     */
    public static final String ASTERISK = "*";

    /**
     * #分隔符
     */
    public static final String POUND = "#";

    /**
     * 分号分隔符
     */
    public static final String SEMICOLON = ";";

    /**
     * 冒号分隔符
     */
    public static final String COLON = ":";

    /**
     * 中文冒号分隔符
     */
    public static final String COLON_CHINESE = "：";

    /**
     * 空格分隔符
     */
    public static final String SPACE = " ";

    /**
     * 逗号分隔符
     */
    public static final String COMMA = ",";

    /**
     * 等号
     */
    public static final String EQUAL = "=";

    /**
     * 左小括号
     */
    public static final String LEFT_PARENTHESIS = "(";

    /**
     * 右小括号
     */
    public static final String RIGHT_PARENTHESIS = ")";

    /**
     * 左大括号
     */
    public static final String LEFT_BRACES = "{";

    /**
     * 右大括号
     */
    public static final String RIGHT_BRACES = "}";

    /**
     * 单引号
     */
    public static final String SINGLE_QUOTE = "'";

    /**
     * 右指向符号
     */
    public static final String RIGHT_POINT = "->";

    /**
     * 百分号
     */
    public static final String PERCENT = "%";

    /***************************分隔符常量 end********************************/

    /**
     * 私有构造方法，静态类不能创建实例
     */
    private CommonConstants(){
        throw new AssertionError();
    }



}
