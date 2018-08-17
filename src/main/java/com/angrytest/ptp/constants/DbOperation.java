package com.angrytest.ptp.constants;

public final class DbOperation {

    /*****************************SQL相关常量 begin**************************/

    /**
     * 连接符AND
     */
    public static final String CONNECTOR_AND = "AND";

    /**
     * 连接符OR
     */
    public static final String CONNECTOR_OR = "OR";

    /**
     * FROM
     */
    public static final String FROM = "FROM";

    /**
     * 连接符WHERE
     */
    public static final String CONNECTOR_WHERE = "WHERE";

    /**
     * 关键字ORDER BY
     */
    public static final String KEY_ORDER_BY = "ORDER BY";

    /**
     * 升序排序关键字
     */
    public static final String KEY_ASC = "ASC";

    /**
     * 降序排序关键字
     */
    public static final String KEY_DESC = "DESC";

    /**
     * 关键字INSERT INTO
     */
    public static final String KEY_INSERT_INTO = "INSERT INTO";

    /**
     * 关键字SELECT
     */
    public static final String KET_SELECT = "SELECT";

    /**
     * 关键字VALUES
     */
    public static final String KEY_VALUES = "VALUES";

    /**
     * 关键字REPLACE
     */
    public static final String KEY_REPLACE = "REPLACE";

    /**
     * NULLS
     */
    public static final String KEY_NULLS = "NULLS";

    /**
     * FIRST
     */
    public static final String KEY_FIRST = "FIRST";

    /**
     * LAST
     */
    public static final String KEY_LAST = "LAST";

    /**
     * nvl(value,0)-如果value为空则替换为0
     */
    public static final String KEY_NVL = "NVL";

    /**
     * length关键字，取字段长度
     */
    public static final String KEY_LENGTH = "LENGTH";

    /**
     * KEY_CAST 关键字，CAST('123' AS INT) 合用，将字符串转数值
     */
    public static final String KEY_CAST = "CAST";

    /**
     * AS 关键字,CAST('123' AS INT) 合用，将字符串转数值
     */
    public static final String KEY_AS = "AS";

    /**
     * INT 关键字，CAST('123' AS INT) 合用，将字符串转数值
     */
    public static final String KEY_INT = "INT";

    /**
     * TO_DATE 关键字，按照日期类型查询
     */
    public static final String KEY_TO_DATE = "TO_DATE";

    /**
     * 字符串类型的jdbc type
     */
    public static final String JDBC_TYPE_VARCHAR = "VARCHAR";

    /**
     * Number类型的jdbc type
     */
    public static final String JDBC_TYPE_NUMBER = "BIGINT";

    /**
     * Date类型的jdbc type
     */
    public static final String JDBC_TYPE_DATE = "DATE";
    /*****************************SQL相关常量 end****************************/

    /**
     * 私有构造方法，静态类不能创建实例
     */
    private DbOperation(){
        throw new AssertionError();
    }
}
