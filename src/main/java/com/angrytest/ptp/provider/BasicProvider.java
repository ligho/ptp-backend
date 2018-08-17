package com.angrytest.ptp.provider;

import com.angrytest.ptp.annotations.Persist;
import com.angrytest.ptp.constants.CommonConstants;
import com.angrytest.ptp.constants.DbOperation;
import com.angrytest.ptp.provider.bo.PersistBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BasicProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicProvider.class);

    /**
     * 创建插入的sql语句
     *
     * @param insertObj 待持久化的对象
     * @param tableName 表名
     * @return insert sql
     */
    public <T> String createInsertSql(T insertObj, String tableName) {
        //将待持久化对象转换为自定义PersistBean对象(含列名，参数名，参数类型，数据库类型)，方便构造sql语句
        List<PersistBean> persistBeanList = getPersistBean(insertObj);
        //构造insertSql语句
        return createInsertSql(persistBeanList, tableName);
    }

    public <T> String createSelectSql(T selectObj, String tableName) {
//将待持久化对象转换为自定义PersistBean对象(含列名，参数名，参数类型，数据库类型)，方便构造sql语句
        List<PersistBean> persistBeanList = getPersistBean(selectObj);
        return createSelectSql(persistBeanList, tableName);
    }


    /**
     * 将待持久化的值存储到PersistBean对象中
     * 只有非null的且带有@Persist注解的成员变量才会被持久化
     *
     * @param insertObj 待持久化的对象
     * @return PersistBean列表
     */
    private <T> List<PersistBean> getPersistBean(T insertObj) {
        List<PersistBean> persistBeanList = new ArrayList<>();
        PersistBean persistBean;
        try {
            for (Field field : insertObj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                //非基本类型（即为对象）且值为null则不进行insert
                if ((!field.getType().isPrimitive()) && (field.get(insertObj) == null)) {
                    continue;
                }
                //只对@Persist注解的成员变量进行持久化
                Persist persistAnnotation = field.getAnnotation(Persist.class);
                if (persistAnnotation != null) {
                    String fieldName = field.getName();
                    //设置列名，默认为成员变量名
                    String column = persistAnnotation.column();
                    if (StringUtils.isEmpty(column)) {
                        column = fieldName;
                    }
                    persistBean = new PersistBean(column, fieldName,
                            persistAnnotation.jdbcType(), persistAnnotation.javaType(),
                            persistAnnotation.typeHandler());
                    persistBeanList.add(persistBean);
                }
            }
        } catch (IllegalAccessException ex) {
            LOGGER.info("BasicProvider.getPersistBean error");
        }
        return persistBeanList;
    }


    /**
     * 创建insert sql
     *
     * @param persistBeanList 持久化的信息对象列表
     * @param tableName       表名
     * @return insert sql
     */
    private String createInsertSql(List<PersistBean> persistBeanList, String tableName) {
        StringBuffer sql = new StringBuffer();
        if (CollectionUtils.isEmpty(persistBeanList)) {
            LOGGER.info("BasicProvider.createInsertSql persistBean list is null");
        } else {
            String columnSql = createSqlOnColumn(persistBeanList);
            String valueSql = createSqlOnValue(persistBeanList);
            sql.append(DbOperation.KEY_INSERT_INTO)
                    .append(CommonConstants.SPACE)
                    .append(tableName)
                    .append(CommonConstants.LEFT_PARENTHESIS)
                    .append(columnSql)
                    .append(CommonConstants.RIGHT_PARENTHESIS)
                    .append(CommonConstants.SPACE)
                    .append(DbOperation.KEY_VALUES)
                    .append(CommonConstants.LEFT_PARENTHESIS)
                    .append(valueSql)
                    .append(CommonConstants.RIGHT_PARENTHESIS);
        }
        return sql.toString();
    }

    private String createSelectSql(List<PersistBean> persistBeanList, String tableName) {
        StringBuffer sql = new StringBuffer();
        if (CollectionUtils.isEmpty(persistBeanList)) {
            LOGGER.info("BasicProvider.createSelectSql persistBean list is null");
            sql.append(DbOperation.KET_SELECT)
                    .append(CommonConstants.SPACE)
                    .append(CommonConstants.ASTERISK)
                    .append(CommonConstants.SPACE)
                    .append(DbOperation.FROM)
                    .append(CommonConstants.SPACE)
                    .append(tableName);
        } else {
            String selectSql = createSelectSql(persistBeanList);
            sql.append(DbOperation.KET_SELECT)
                    .append(CommonConstants.SPACE)
                    .append(CommonConstants.ASTERISK)
                    .append(CommonConstants.SPACE)
                    .append(DbOperation.FROM)
                    .append(CommonConstants.SPACE)
                    .append(tableName)
                    .append(CommonConstants.SPACE)
                    .append(DbOperation.CONNECTOR_WHERE)
                    .append(CommonConstants.SPACE)
                    .append(selectSql);
        }
        return sql.toString();
    }

    private String createSelectSql(List<PersistBean> persistBeanList) {
        StringBuffer selectSql = new StringBuffer();
        for (PersistBean persistBean : persistBeanList) {
            if (!StringUtils.isEmpty(selectSql.toString())) {
                selectSql.append(CommonConstants.SPACE)
                         .append(DbOperation.CONNECTOR_AND)
                         .append(CommonConstants.SPACE);
            }
            selectSql.append(persistBean.getColumn().toUpperCase())
                    .append(CommonConstants.EQUAL)
                    .append(CommonConstants.POUND)
                    .append(CommonConstants.LEFT_BRACES)
                    .append(persistBean.getPropertyName())
                    .append(CommonConstants.RIGHT_BRACES);
        }
        return selectSql.toString();
    }

    /**
     * 创建insert sql中的列名序列
     *
     * @param persistBeanList 持久化的信息对象列表
     * @return insert sql中的列名序列
     */
    private String createSqlOnColumn(List<PersistBean> persistBeanList) {
        StringBuffer columnSql = new StringBuffer();
        for (PersistBean persistBean : persistBeanList) {
            if (!StringUtils.isEmpty(columnSql.toString())) {
                columnSql.append(CommonConstants.COMMA);
            }
            columnSql.append(persistBean.getColumn().toUpperCase());
        }
        return columnSql.toString();
    }

    /**
     * 创建insert sql中的值序列
     * 单个值格式：#{name,jdbcType=VARCHAR,javaType=String}
     * 多个值之间以逗号分隔
     * jdbcType和javaType是选填项
     *
     * @param persistBeanList 持久化的信息对象列表
     * @return insert sql中的值序列
     */
    private String createSqlOnValue(List<PersistBean> persistBeanList) {
        StringBuffer valueSql = new StringBuffer();
        for (PersistBean persistBean : persistBeanList) {
            if (!StringUtils.isEmpty(valueSql.toString())) {
                valueSql.append(CommonConstants.COMMA);
            }
            valueSql.append(CommonConstants.POUND)
                    .append(CommonConstants.LEFT_BRACES)
                    .append(persistBean.getPropertyName());
            if (!StringUtils.isEmpty(persistBean.getJdbcType())) {
                valueSql.append(CommonConstants.COMMA)
                        .append("jdbcType")
                        .append(CommonConstants.EQUAL)
                        .append(persistBean.getJdbcType().toUpperCase());
            }
            if (!StringUtils.isEmpty(persistBean.getJavaType())) {
                valueSql.append(CommonConstants.COMMA)
                        .append("javaType")
                        .append(CommonConstants.EQUAL)
                        .append(persistBean.getJavaType());
            }
            if (!Object.class.equals(persistBean.getTypeHandler())) {
                valueSql.append(CommonConstants.COMMA)
                        .append("typeHandler")
                        .append(CommonConstants.EQUAL)
                        .append(persistBean.getTypeHandler().getName());
            }
            valueSql.append(CommonConstants.RIGHT_BRACES);
        }
        return valueSql.toString();
    }

}
